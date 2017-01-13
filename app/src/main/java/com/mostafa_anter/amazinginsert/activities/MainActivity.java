package com.mostafa_anter.amazinginsert.activities;

import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Color;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mostafa_anter.amazinginsert.R;
import com.mostafa_anter.amazinginsert.app.AppController;
import com.mostafa_anter.amazinginsert.model.SearchBuyModel;
import com.mostafa_anter.amazinginsert.model.SearchMaintenanceModel;
import com.mostafa_anter.amazinginsert.model.SearchSparePartModel;
import com.mostafa_anter.amazinginsert.model.SearchTradeShowModel;
import com.mostafa_anter.amazinginsert.model.ServiceFireBasePOJO;
import com.mostafa_anter.amazinginsert.model.TouchMapEvent;
import com.mostafa_anter.amazinginsert.parsers.JsonParser;
import com.mostafa_anter.amazinginsert.provider.PlaceProvider;
import com.mostafa_anter.amazinginsert.util.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    private static final String TAG = "MainActivity";

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

        button1.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if (isValide()) {

//            rent---> 2
//            maintenance--->3
//            sparepart--->4
//            clean--->5
//            accessory-->6
//            tradeshow--->7

            switch (editText2.getText().toString().trim()) {
                case "2":
                    fetchRent();
                    break;
                case "3":
                    fetchMaintenance();
                    break;
                case "4":
                    fetchSpareParts();
                    break;
                case "5":
                    fetchCleanCenter();
                    break;
                case "6":
                    fetchAccessories();
                    break;
                case "7":
                    fetchTradShow();
                    break;
            }
        }
    }

    private boolean isValide() {
        if (editText0.getText().toString().trim().isEmpty()) {
            return false;
        }
        if (editText1.getText().toString().trim().isEmpty()) {
            return false;
        }
        if (editText2.getText().toString().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    // for map
    private class GetAddress extends AsyncTask<LatLng, Void, StringBuilder> {

        @Override
        protected StringBuilder doInBackground(LatLng... latLngs) {
            Geocoder geocoder = new Geocoder(MainActivity.this, new Locale("ar"));
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


    // fetch data
    private void fetchRent() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/RentAdvertising/GetRentAdvertising/" +
                editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseBuyDetail(response), 2);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();

                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void fetchMaintenance() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/AdvertisingMaintenanceCenter/GetAdvertisingMaintenanceCenter/"
                + editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());

                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseMaintenanceDetail(response), 3);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void fetchSpareParts() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/AdvertisingSpareParts/GetAdvertisingSparePart/"
                + editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseSparePartsDetail(response), 4);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void fetchCleanCenter() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/AdvertisingCleanCareCenter/GetAdvertisingCleanCareCenter/"
                + editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseMaintenanceDetail(response), 5);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void fetchAccessories() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/AdvertisingAccessory/GetAdvertisingAccessories/"
                + editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseSparePartsDetail(response), 6);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void fetchTradShow() {
        String tag_string_req = "string_req";
        String url = "http://makonway.com/MOW.Service/api/customaction/AdvertisingTradeShow/GetAdvertisingTradeShow/" +
                editText1.getText().toString().trim();

        // show dialog
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                pDialog.dismissWithAnimation();
                writeDataOnFirbase(JsonParser.parseTradeShowDetails(response), 7);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.dismissWithAnimation();
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Error")
                        .setContentText("plz, check ad id and type ;)")
                        .setConfirmText("Ok")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                        .show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void writeDataOnFirbase(SearchBuyModel s, int categories) {
        LatLng latLng = getCenterLocation();
        if (latLng != null) {
            ServiceFireBasePOJO service = new ServiceFireBasePOJO(s.getDescription(),
                    editText0.getText().toString().trim(), s.getPhone1(), categories);
            // save service and its location
            String serviceId = editText1.getText().toString().trim();
            DatabaseReference serviceLocation = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.FIREBASE_URL_SERVICES);
            serviceLocation.child(serviceId).setValue(service);
            // finally save service location
            String mainPath;
            if (s.isCar()) {
                mainPath = Constants.FIREBASE_URL_CARS_SERVICES_GEOFIRE;
            } else {
                mainPath = Constants.FIREBASE_URL_MOTORCYCLES_SERVICES_GEOFIRE;
            }
            DatabaseReference geoLocationRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(mainPath);
            GeoFire geoFire = new GeoFire(geoLocationRef);

            geoFire.setLocation(serviceId, new GeoLocation(latLng.latitude
                    , latLng.longitude));

            // show success dialog
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Yahhh")
                    .setContentText("This ad successfully updated")
                    .setConfirmText("Peace man")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();

        } else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Error")
                    .setContentText("There is no location selected")
                    .setConfirmText("plz, select another location")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    sDialog.cancel();
                }
            })
                    .show();
        }
    }

    private void writeDataOnFirbase(SearchMaintenanceModel s, int categories) {
        LatLng latLng = getCenterLocation();
        if (latLng != null) {
            ServiceFireBasePOJO service = new ServiceFireBasePOJO(s.getDescription(),
                    editText0.getText().toString().trim(), s.getPhone1(), categories);
            // save service and its location
            String serviceId = editText1.getText().toString().trim();
            DatabaseReference serviceLocation = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.FIREBASE_URL_SERVICES);
            serviceLocation.child(serviceId).setValue(service);
            // finally save service location
            String mainPath;
            if (s.getIsCar().equalsIgnoreCase("true")) {
                mainPath = Constants.FIREBASE_URL_CARS_SERVICES_GEOFIRE;
            } else {
                mainPath = Constants.FIREBASE_URL_MOTORCYCLES_SERVICES_GEOFIRE;
            }
            DatabaseReference geoLocationRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(mainPath);
            GeoFire geoFire = new GeoFire(geoLocationRef);

            geoFire.setLocation(serviceId, new GeoLocation(latLng.latitude
                    , latLng.longitude));
            // show success dialog
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Yahhh")
                    .setContentText("This ad successfully updated")
                    .setConfirmText("Peace man")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Error")
                    .setContentText("There is no location selected")
                    .setConfirmText("plz, select another location")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    sDialog.cancel();
                }
            })
                    .show();
        }
    }

    private void writeDataOnFirbase(SearchSparePartModel s, int categories) {
        LatLng latLng = getCenterLocation();
        if (latLng != null) {
            ServiceFireBasePOJO service = new ServiceFireBasePOJO(s.getDescription(),
                    editText0.getText().toString().trim(), s.getPhone1(), categories);
            // save service and its location
            String serviceId = editText1.getText().toString().trim();
            DatabaseReference serviceLocation = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.FIREBASE_URL_SERVICES);
            serviceLocation.child(serviceId).setValue(service);
            // finally save service location
            String mainPath;
            if (s.getIsCar().equalsIgnoreCase("true")) {
                mainPath = Constants.FIREBASE_URL_CARS_SERVICES_GEOFIRE;
            } else {
                mainPath = Constants.FIREBASE_URL_MOTORCYCLES_SERVICES_GEOFIRE;
            }
            DatabaseReference geoLocationRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(mainPath);
            GeoFire geoFire = new GeoFire(geoLocationRef);

            geoFire.setLocation(serviceId, new GeoLocation(latLng.latitude
                    , latLng.longitude));
            // show success dialog
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Yahhh")
                    .setContentText("This ad successfully updated")
                    .setConfirmText("Peace man")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Error")
                    .setContentText("There is no location selected")
                    .setConfirmText("plz, select another location")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    sDialog.cancel();
                }
            })
                    .show();
        }
    }

    private void writeDataOnFirbase(SearchTradeShowModel s, int categories) {
        LatLng latLng = getCenterLocation();
        if (latLng != null) {
            ServiceFireBasePOJO service = new ServiceFireBasePOJO(s.getDescription(),
                    editText0.getText().toString().trim(), s.getPhone1(), categories);
            // save service and its location
            String serviceId = editText1.getText().toString().trim();
            DatabaseReference serviceLocation = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(Constants.FIREBASE_URL_SERVICES);
            serviceLocation.child(serviceId).setValue(service);
            // finally save service location
            String mainPath;
            if (s.getIsCar().equalsIgnoreCase("true")) {
                mainPath = Constants.FIREBASE_URL_CARS_SERVICES_GEOFIRE;
            } else {
                mainPath = Constants.FIREBASE_URL_MOTORCYCLES_SERVICES_GEOFIRE;
            }
            DatabaseReference geoLocationRef = FirebaseDatabase.getInstance()
                    .getReferenceFromUrl(mainPath);
            GeoFire geoFire = new GeoFire(geoLocationRef);

            geoFire.setLocation(serviceId, new GeoLocation(latLng.latitude
                    , latLng.longitude));
            // show success dialog
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Yahhh")
                    .setContentText("This ad successfully updated")
                    .setConfirmText("Peace man")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Error")
                    .setContentText("There is no location selected")
                    .setConfirmText("plz, select another location")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    }).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    sDialog.cancel();
                }
            })
                    .show();
        }
    }
}
