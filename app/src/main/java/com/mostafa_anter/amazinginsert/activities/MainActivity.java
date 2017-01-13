package com.mostafa_anter.amazinginsert.activities;

import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.mostafa_anter.amazinginsert.R;
import com.mostafa_anter.amazinginsert.model.TouchMapEvent;
import com.mostafa_anter.amazinginsert.provider.PlaceProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        LoaderManager.LoaderCallbacks<Cursor> {

    private GoogleMap mMap;

    @BindView(R.id.editText0)
    EditText editText0;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        new GetAddress().execute(getCenterLocation());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);

    }

    private void handleIntent(Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SEARCH)) {
            doSearch(intent.getStringExtra(SearchManager.QUERY));
        } else if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            getPlace(intent.getStringExtra(SearchManager.EXTRA_DATA_KEY));
        }
    }

    private void doSearch(String query) {
        Bundle data = new Bundle();
        data.putString("query", query);
        getLoaderManager().restartLoader(0, data, this);
    }

    private void getPlace(String query) {
        Bundle data = new Bundle();
        data.putString("query", query);
        getLoaderManager().restartLoader(1, data, this);
    }


    private void showLocations(Cursor c) {
        LatLng position = null;
        mMap.clear();
        while (c.moveToNext()) {
            position = new LatLng(Double.parseDouble(c.getString(1)), Double.parseDouble(c.getString(2)));

        }
        if (position != null) {
            CameraUpdate cameraPosition = CameraUpdateFactory.newLatLng(position);
            mMap.animateCamera(cameraPosition);
            updateZoom(mMap, position);
            new GetAddress().execute(getCenterLocation());
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        CursorLoader cLoader = null;
        if (i == 0)
            cLoader = new CursorLoader(getBaseContext(), PlaceProvider.SEARCH_URI, null, null, new String[]{bundle.getString("query")}, null);
        else if (i == 1)
            cLoader = new CursorLoader(getBaseContext(), PlaceProvider.DETAILS_URI, null, null, new String[]{bundle.getString("query")}, null);
        return cLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        showLocations(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    // for map
    private class GetAddress extends AsyncTask<LatLng, Void, StringBuilder> {

        @Override
        protected StringBuilder doInBackground(LatLng... latLngs) {
            Geocoder geocoder = new Geocoder(MainActivity.this, new Locale( "ar" ));
            List<Address> addresses = null; // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            try {
                addresses = geocoder.getFromLocation(latLngs[0].latitude, latLngs[0].longitude, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                StringBuilder sb = new StringBuilder();

                if (address != null)
                    sb.append(address);
                if (city != null)
                    sb.append(", " + city);
                if (state != null)
                    sb.append(", " + state);
                if (country != null)
                    sb.append(", " + country);
                if (knownName != null)
                    sb.append(", " + knownName);


                return sb;
            }
            return null;
        }

        @Override
        protected void onPostExecute(StringBuilder stringBuilder) {
            super.onPostExecute(stringBuilder);
            editText0.setText(stringBuilder);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onMessageEvent(TouchMapEvent event) {
        Log.d("handel touch", "handel touch");
        LatLng latLng = mMap.getCameraPosition().target;
        new GetAddress().execute(latLng);
    }

    private void updateZoom(GoogleMap mMap, LatLng myLatLng) {
        // Zoom to the given bounds
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 14));
    }

    @Nullable
    private LatLng getCenterLocation() {
        LatLng latLng = mMap.getCameraPosition().target;
        return latLng;
    }
}
