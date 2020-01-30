package com.iitbbs.esummit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static androidx.core.content.ContextCompat.checkSelfPermission;


public class BlankFragment extends android.app.Fragment {

    private int navLayout;
    private MapView mapView = null;
    private GoogleMap googleMap = null;
    LocationRequest locationRequest;
    Location lastLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    public GoogleMap getGoogleMap() {
        return googleMap;
    }
    public void setNewLayout(int navLayout) {
        this.navLayout = navLayout;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        final int[] i = {0};
        final View rootView = layoutInflater.inflate(R.layout.fragment_blank, container, false);

        //Populate the spinner in the fragment
        /*Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Spinner spinner1 = (Spinner) rootView.findViewById(R.id.spinner1);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.array,
                android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selected = parentView.getItemAtPosition(position).toString();
                Context context = parentView.getContext();
                CharSequence text = selected;
                int duration = Toast.LENGTH_SHORT;
                i[0] = position;
               *//* Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                switch (position){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        break;
                }
*//*

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });*/
/*
        Spinner spinner = (Spinner)rootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Spinner spinner1 = (Spinner)rootView.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

      spinner.setOnItemClickListener( {

          public void onItemSelected(AdapterView<?> adapterView, View view,
                                     int position, long id) {
              Object item = adapterView.getItemAtPosition(position);


          }

          public void onNothingSelected(AdapterView<?> adapterView) {


          }
      });*/


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        mapView = (MapView) rootView.findViewById(R.id.map_layout);
        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        mapView.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint({"MissingPermission", "RestrictedApi"})
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                LatLng iitbbs = new LatLng(20.148352, 85.671158);
                CameraPosition cameraPosition = new CameraPosition.Builder().target(iitbbs).zoom(18).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                //bounding the area
                LatLngBounds iitbbs_campus = new LatLngBounds(new LatLng(20.138375, 85.656087),
                        new LatLng(20.156808, 85.684665));
                mMap.setLatLngBoundsForCameraTarget(iitbbs_campus);

                LatLng cc = new LatLng(20.152844, 85.660502);
                final Marker mcc = googleMap.addMarker(new MarkerOptions().position(cc).title("Community center IIT Bhubaneshwar"));
                mcc.setFlat(true);

                final LatLng mhr = new LatLng(20.149411, 85.665213);
                final Marker mmhr = googleMap.addMarker(new MarkerOptions().position(mhr).title("Mahanadi Hall of Residence, Boys' hostel, IIT Bhubaneswar"));
                mcc.setFlat(true);

                final LatLng shr = new LatLng(20.153403, 85.666106);
                final Marker sshr = googleMap.addMarker(new MarkerOptions().position(shr).title("Subarnarekha Hall of Residence, Boy's  Hostel, IIT Bhubaneswar"));
                mcc.setFlat(true);


                LatLng sc = new LatLng(20.154713, 85.663613);
                final Marker ssc = googleMap.addMarker(new MarkerOptions().position(sc).title("Shopping Complex,IIT Bhubaneswar"));
                mcc.setFlat(true);

                LatLng mb = new LatLng(20.148307, 85.671152);
                final Marker mmb = googleMap.addMarker(new MarkerOptions().position(mb).title("Main Building,IIT Bhubaneswar"));
                mcc.setFlat(true);


                LatLng ses = new LatLng(20.149759, 85.674082);
                final Marker mses = googleMap.addMarker(new MarkerOptions().position(ses).title("SES-School of Electrical Sciences,IIT Bhubaneswar"));
                mcc.setFlat(true);

                LatLng lbc = new LatLng(20.148160, 85.677557);
                final Marker mlbc = googleMap.addMarker(new MarkerOptions().position(lbc).title("LBC-Lab Complex,IIT Bhubaneswar"));
                mcc.setFlat(true);


                LatLng fc = new LatLng(  20.149364, 85.669391);
                final Marker mfc = googleMap.addMarker(new MarkerOptions().position(fc).title("Food Canteen"));
                mcc.setFlat(true);

                LatLng ghr = new LatLng(  20.152490, 85.667285);
                final Marker mghr = googleMap.addMarker(new MarkerOptions().position(ghr).title("Ganga Hall of Residence, Girl's hostel, IIT Bhubaneswar"));
                mcc.setFlat(true);

                LatLng bhr = new LatLng(  20.149173, 85.663501);
                final Marker mbhr = googleMap.addMarker(new MarkerOptions().position(bhr).title("Brahmaputra Hall of Residence, Boy's hostel, IIT Bhubaneswar"));
                mcc.setFlat(true);

                LatLng ghh = new LatLng(  20.152003, 85.662640);
                final Marker mghh = googleMap.addMarker(new MarkerOptions().position(ghh).title("Guest House, IIT Bhubaneswar"));
                mcc.setFlat(true);

                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if (marker.equals(mcc)) {
                            mcc.setTitle("Community center IIT Bhubaneshwar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mcc.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


                        } else if (marker.equals(mmhr)) {
                            mmhr.setTitle("Mahanadi Hall of Residence, Boy's hostel, IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mmhr.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(sshr)) {
                            sshr.setTitle("Subarnarekha Hall of Residence, Boy's Hostel, IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sshr.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(ssc)) {
                            ssc.setTitle("Shopping Complex,IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(ssc.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mmb)) {
                            mmb.setTitle("Main Building,IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mmb.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mses)) {
                            mses.setTitle("SES-School of Electrical Sciences,IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mses.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mlbc)) {
                            mlbc.setTitle("LBC-Lab Complex,IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mlbc.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mfc)) {
                            mfc.setTitle("Food Canteen");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mfc.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mghr)) {
                            mghr.setTitle("Ganga Hall of Residence, Girl's hostel, IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mghr.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mbhr)) {
                            mbhr.setTitle("Brahmaputra Hall of Residence, Boy's hostel, IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mbhr.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }else if (marker.equals(mghh)) {
                            mghh.setTitle("Guest House, IIT Bhubaneswar");
                            marker.showInfoWindow();
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(mghh.getPosition()).zoom(20).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }

                        return true;
                    }
                });

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.setBuildingsEnabled(true);
                googleMap.setMinZoomPreference(12);
                googleMap.setMaxZoomPreference(18);
                googleMap.setTrafficEnabled(true);

                UiSettings uiSettings = googleMap.getUiSettings();
                uiSettings.setZoomControlsEnabled(true);
                uiSettings.setAllGesturesEnabled(true);
                uiSettings.setMyLocationButtonEnabled(true);

                locationRequest = new LocationRequest();
                locationRequest.setInterval(120000); // two minute interval
                locationRequest.setFastestInterval(120000);
                locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED &&
                            checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                    == PackageManager.PERMISSION_GRANTED) {
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                        googleMap.setMyLocationEnabled(true);
                    } else {
                        checkLocationPermission();
                    }
                } else {
                    fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                    googleMap.setMyLocationEnabled(true);
                }

                googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {
                        LocationManager locationManager = null;
                        boolean gps_enabled = false, network_enabled = false;

                        if (locationManager == null)
                            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                        try {
                            gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                        } catch (Exception ex) {
                        }

                        try {
                            network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                        } catch (Exception ex) {
                        }

                        if (!gps_enabled)
                            Snackbar.make(getView(), "Enable Location Services", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
//                                Toast.makeText(getActivity(), "Enable Location Services", Toast.LENGTH_LONG).show();
                        else if (!network_enabled)
                            Snackbar.make(getView(), "Enable Network Services", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();

                        return false;
                    }
                });
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    public void onPause() {
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
        if (mapView != null) {
            mapView.onPause();
        }

        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
        if (mapView != null) {
            mapView.onDestroy();
        }

        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }



    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locationList = locationResult.getLocations();
            if (locationList.size() > 0) {
                Location location = locationList.get(locationList.size() - 1);
                Log.i("MapsActivity", "Location: " + location.getLatitude() + " " + location.getLongitude());
                lastLocation = location;

                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(16).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        }
    };

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Location Permission Needed")
                        .setMessage("getContext() app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions((Activity) getActivity(),
                                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                ActivityCompat.requestPermissions((Activity) getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                        googleMap.setMyLocationEnabled(true);
                    }

                } else {
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    protected Bitmap adjustImage(Bitmap image) {
        int mDpi = image.getDensity();
        int width = 5;
        int height = 5;
        Bitmap adjustedImage = Bitmap.createScaledBitmap(image, width, height, true);
        adjustedImage.setDensity(mDpi);
        return adjustedImage;
    }

  /*  private GeoApiContext getGeoContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext.setQueryRateLimit(3)
                .setApiKey(getString(R.string.google_maps_key))
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }
*/
   /* public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            String item = parent.getItemAtPosition(pos).toString();
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    }*/
   /*public static class PlaceholderFragment extends Fragment {

       public PlaceholderFragment() {
       }

       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {

           return rootView;
       }
   }*/

}
