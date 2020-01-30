package com.iitbbs.esummit;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;

import static android.widget.Toast.LENGTH_LONG;


public class qrcode extends android.app.Fragment implements QRCodeReaderView.OnQRCodeReadListener {



    // UI
    private TextView textView;
    private QRCodeReaderView qrCodeReaderView;
    // QREader
    private SurfaceView mySurfaceView;
    private QREader qrEader;

    boolean hasCameraPermission = false;
    private SharedPreferences sharedPreferences;
    private String pointss = "0";
    private int ppy = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_qrcode, container, false);

        textView = root.findViewById(R.id.points);
        textView.setText(String.format("%08d", LoadInt("pointyy")));

        if(ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            checkcameraPermission();
            if(ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getActivity(), "permission accpeted", Toast.LENGTH_LONG).show();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, new qrcode());
                //if(getTitle() != "SPONSORS"){
                ft.addToBackStack("QR-CODE-GAME");
                //}
                ft.commit();
            }else{
                checkcameraPermission();
            }

        }


        qrCodeReaderView = (QRCodeReaderView) root.findViewById(R.id.qrdecoderview);
        qrCodeReaderView.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
        qrCodeReaderView.setTorchEnabled(true);

        // Use this function to set front camera preview
        qrCodeReaderView.setFrontCamera();

        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera();



        return root;
    }


//    void setupQREader() {
//        // Init QREader
//        // ------------
//        qrEader = new QREader.Builder(getContext(), mySurfaceView, new QRDataListener() {
//            @Override
//            public void onDetected(final String data) {
//                //Log.d("QREader", "Value : " + data);
//                text.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        text.setText(data);
//                    }
//                });
//            }
//        }).facing(QREader.BACK_CAM)
//                .enableAutofocus(true)
//                .height(mySurfaceView.getHeight())
//                .width(mySurfaceView.getWidth())
//                .build();
//    }

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 99;

    private void checkcameraPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getActivity(),
                    android.Manifest.permission.CAMERA)) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Camera Permission Needed")
                        .setMessage("getContext() app needs the Camera permission, please accept to use Camera ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions((Activity) getActivity(),
                                        new String[]{android.Manifest.permission.CAMERA},
                                        MY_PERMISSIONS_REQUEST_CAMERA);

                            }
                        })
                        .create()
                        .show();


            } else {
                ActivityCompat.requestPermissions((Activity) getActivity(),
                        new String[]{android.Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }
        }



    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        hasCameraPermission = true;
                    }

                } else {
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }


    public void SaveBool(String key, boolean value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public boolean LoadBool(String key){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
         return sharedPreferences.getBoolean(key, false);
    }
    public void SaveInt(String key, int value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public int LoadInt(String key){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        return sharedPreferences.getInt(key, 0);
    }
    @Override
    public void onQRCodeRead(String text, PointF[] points) {

        String[] arr  = new String[] {"123123123"," 456456456","789789789","147258369","147147147","258258258","369369369","159159159","357357357","852852852","172312312","456645646","781789789","147258369","147147147","258925825","369469369","159659159","357757357","852452852","1723123121","4566456464","7817897897","1472583695","1471471475","2589258257","3694693697","1596591597","3577573577","8524528525","17231231218","45664564648","78178978978","14725836955","14714714755","25892582574","36946936975","15965915976","35775735775","85245285254","789485456","125635896"};

        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals(text) && !LoadBool(text)){
                    Toast.makeText(getContext(), "Congrats!! You have increased your score", Toast.LENGTH_LONG).show();
                    SaveBool(text,true);
                    ppy = LoadInt("pointyy");
                    ppy = ppy+10;
                    pointss = String.format("%08d", ppy);
                    textView.setText(pointss);
                    SaveInt("pointyy",ppy);

            }else{
                Toast.makeText(getContext(), "You scanned the wrong QR-Code or Scanned The Same QR-Code Again Try finding More QR-Codes around", Toast.LENGTH_LONG).show();
//                ppy = Integer.parseInt(pointss);
//                ppy = ppy+10;
//                pointss = String.format("%08d", ppy);
//                textView.setText(pointss);
            }
        }



    }



    @Override
    public void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();


    }

    @Override
    public void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }
}
