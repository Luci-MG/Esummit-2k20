package com.iitbbs.esummit;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import com.iitbbs.esummit.R;
import com.infideap.drawerbehavior.Advance3DDrawerLayout;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Advance3DDrawerLayout drawer;
    public static String murl = "http://www.e-summit-iitbbs.com/";
    public android.app.FragmentManager fragmentManager = getFragmentManager();
    public  FragmentTransaction ft = fragmentManager.beginTransaction();
    public static String FACEBOOK_URL = "https://www.facebook.com/centrepreneurship/";
    public static String FACEBOOK_PAGE_ID = "centrepreneurship";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment, new home());
        ft.addToBackStack("E-SUMMIT");
        setTitle("E-SUMMIT");
        ft.commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorBlack));
        setSupportActionBar(toolbar);
       // changeToolbarFont((Toolbar) findViewById(R.id.toolbar), this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (Advance3DDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 20);

        drawer.setViewElevation(Gravity.START, 100);
        drawer.setViewRotation(Gravity.START, 5);

        drawer.setViewScale(Gravity.END, 0.9f);
        drawer.setRadius(Gravity.END, 35);
        drawer.setViewElevation(Gravity.END, 20);


    }




    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (drawer.isDrawerOpen(GravityCompat.END)){
                drawer.closeDrawer(GravityCompat.END);
            } else {
                super.onBackPressed();
            }
        }



        int index = this.getFragmentManager().getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(index);
        String tag = backEntry.getName();
        setTitle(tag);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            /*TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            tabLayout.setVisibility(View.GONE);*/

            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment());
            //if(getTitle() != "MAPS"){
                ft.addToBackStack("MAPS");
            //}
            ft.commit();
            setTitle("MAPS");
            /* getSupportFragmentManager().beginTransaction().replace(R.id.fragment,(Fragment)( new BlankFragment())).addToBackStack(null).commit();*/
        }else if(id == R.id.nav_events){


            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new events_frag());
            //if(getTitle() != "EVENTS"){
                ft.addToBackStack("EVENTS");
            //}
            ft.commit();
            setTitle("EVENTS");
        }else if(id == R.id.nav_speakers){

            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new speakers());
            //if(getTitle() != "SPEAKERS"){
                ft.addToBackStack("SPEAKERS");
            //}
            ft.commit();
            setTitle("SPEAKERS");
        }else if(id == R.id.nav_home){
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new home());
            ft.addToBackStack("E-SUMMIT");
            ft.commit();
        }else if(id == R.id.nav_Schedule){

            //murl = "http://quiz.e-summit-iitbbs.com/schedule_app.php";
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment,new shedule());
            //if(getTitle() != "SCHEDULE"){
                ft.addToBackStack("SCHEDULE");
            //}
            ft.commit();
            setTitle("SCHEDULE");
        }else if ((id== R.id.nav_team)){

            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new teampage());
            //if(getTitle() != "TEAM"){
                ft.addToBackStack("TEAM");
            //}
            ft.commit();
            setTitle("TEAM");
        }else if(id==R.id.nav_sponsers){

            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new sponser());
            //if(getTitle() != "SPONSORS"){
                ft.addToBackStack("SPONSORS");
            //}
            ft.commit();
            setTitle("SPONSORS");
        }else if (id==R.id.regist){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.thecollegefever.com/events/e-summit-20"));
            Intent choser = Intent.createChooser(intent,"Choose Your Browser");
            startActivity(choser);
        }else if(id == R.id.nav_update){
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new updatesfest());
            //if(getTitle() != "SPONSORS"){
            ft.addToBackStack("LATEST UPDATES");
            //}
            ft.commit();
            setTitle("LATEST UPDATES");
        }else if(id == R.id.nav_results){
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new results());
            //if(getTitle() != "SPONSORS"){
            ft.addToBackStack("RESULTS");
            //}
            ft.commit();
            setTitle("RESULTS");
        }else if(id == R.id.nav_game){
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new password_game());
            //if(getTitle() != "SPONSORS"){
            ft.addToBackStack("UNAUTHORIZED");
            //}
            ft.commit();
            setTitle("UNAUTHORIZED");
        }else if(id == R.id.nav_qrcode){
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new qrcode());
            //if(getTitle() != "SPONSORS"){
            ft.addToBackStack("QR-CODE-GAME");
            //}
            ft.commit();
            setTitle("QR-CODE_GAME");
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_right_drawer:
                drawer.openDrawer(Gravity.END);
                //getWindow().setStatusBarColor((ContextCompat.getColor(this,R.color.color3)));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickwebsitee(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.e-summit-iitbbs.com/"));
        Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        startActivity(choser);
    }

    public void onClickregister(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.thecollegefever.com/events/e-summit-20"));
        Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        startActivity(choser);
    }

    public void onClickreg_wtf(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.instamojo.com/whataftercollege/wac-2020-workshop-series-at-iit-bhubaneswar-/?ref=store"));
        Intent choser = Intent.createChooser(intent,"Choose Ypur Browser");
        startActivity(choser);
    }

    public void onClickcomp0(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fiplauction.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        //ft.addToBackStack(null);
        ft.commit();
    }

    public void onClickcomp1(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fenigma.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("ENIGMA");
        ft.commit();
    }

    public void onClickcomp2(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fbplan.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("B-PLAN");
        ft.commit();
    }

    public void onClickcomp3(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Finnovationexpo.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("INNOVATION EXPO");
        ft.commit();
    }

    public void onClickcomp4(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fadvertorial.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("ADVERTORIAL");
        ft.commit();
    }

    public void onClickcomp5(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fkreo.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("KREO");
        ft.commit();
    }

    public void onClickcomp6(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Finsignia.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("INSIGNIA");
        ft.commit();
    }

    public void onClickcomp7(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fepigramma.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("EPIGRAMMA");
        ft.commit();
    }

    public void onClickcomp8(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fbizquiz.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("BIZ QUIZ");
        ft.commit();
    }

    public void onClickcomp9(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2Fstockwars.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("STOCK WARS");
        ft.commit();
    }

    public void onClickcompinvest(View view){
        murl = "https://docs.google.com/viewer?url=http%3A%2F%2Fwww.e-summit-iitbbs.com%2Fpdf%2FInvestors_Drive.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        ft.addToBackStack("INVESTORS DRIVE");
        ft.commit();
    }

    public void onClickregisterinvest(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdocply5APJa_x3sI0vyk5ZIdg3BjHvHbNtoFG5KoJSOvlJFA/viewform"));
        Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        startActivity(choser);
    }

    public void onClickcompbovs(View view){
        drawer.closeDrawer(GravityCompat.END);
        murl = "https://docs.google.com/viewer?url=https%3A%2F%2Fwww.iitbbs.ac.in%2Ftransportation-fle%2Ftransport_1563724431.pdf&pdf=true";
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment,new forwebview_frag());
        //ft.addToBackStack(null);
        ft.commit();
    }

    public String getFacebookPageURL() {
        PackageManager packageManager = getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    public void onClickfb(View view){
        drawer.closeDrawer(GravityCompat.END);
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL();
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);


//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://www.facebook.com/centrepreneurship/"));
//        Intent choser = Intent.createChooser(intent,"Choose Your Browser");
//        startActivity(choser);



//        murl = "https://www.facebook.com/centrepreneurship/";
//        ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.fragment,new forwebview_frag());
//        ft.addToBackStack(null);
//        ft.commit();
    }



    public void onClickinsta(View view){
        drawer.closeDrawer(GravityCompat.END);
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("https://www.instagram.com/centrepreneurship/"));
        //Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        //startActivity(choser);

//        murl = "https://www.instagram.com/centrepreneurship/";
//        ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.fragment,new forwebview_frag());
//        ft.addToBackStack(null);
//        ft.commit();


        Uri uri = Uri.parse("https://www.instagram.com/centrepreneurship/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/centrepreneurship/")));
        }
    }

    public void onClickyoutube(View view){
        drawer.closeDrawer(GravityCompat.END);
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("https://www.youtube.com/channel/UC3gKo28mm66VcJs-vsFggZg"));
        //Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        //startActivity(choser);

//        murl = "https://www.youtube.com/channel/UC3gKo28mm66VcJs-vsFggZg";
//        ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.fragment,new forwebview_frag());
//        ft.addToBackStack(null);
//        ft.commit();


        Intent intent=null;
        try {
            intent =new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse("https://www.youtube.com/channel/UC3gKo28mm66VcJs-vsFggZg"));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/channel/UC3gKo28mm66VcJs-vsFggZg"));
            startActivity(intent);
        }
    }

    public void onClicklinkedin(View view){
        drawer.closeDrawer(GravityCompat.END);
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("https://www.linkedin.com/company/e-summit-iit-bhubaneswar/"));
        //Intent choser = Intent.createChooser(intent,"Choose Your Browser");
        //startActivity(choser);


//        murl = "https://www.linkedin.com/company/e-summit-iit-bhubaneswar/";
//        ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.fragment,new forwebview_frag());
//        ft.addToBackStack(null);
//        ft.commit();


        Intent intent=null;
        try {
            intent =new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.linkedin.android");
            intent.setData(Uri.parse("https://www.linkedin.com/company/centre-for-entrepreneurship-iit-bhubaneswar/"));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.linkedin.com/company/centre-for-entrepreneurship-iit-bhubaneswar/"));
            startActivity(intent);
        }
    }


    public void onClickpass(View view){
        EditText editText = findViewById(R.id.password_edit);
        String string = editText.getText().toString();
        if(string.equals("entrepreneurialideation")){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://e-summit-iitbbs.com/4cd5bde6768e4d61434da27a2c8247e2youaremakingprogress_whatsappmeon8688066345foryournextchall"));
            Intent choser = Intent.createChooser(intent,"Choose Your Browser");
            startActivity(choser);
        }else{
            Toast.makeText(this,"Password is Wrong Try again",Toast.LENGTH_LONG).show();

        }
    }


    public void heyyclear(View view) {
        EditText ed = (EditText) findViewById(R.id.password_pass);
        EditText ed1 = (EditText) findViewById(R.id.password_score);
        String sop = ed.getText().toString();
        if(sop.equals("456456123")){
            String huh = ed1.getText().toString();




            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String restoredText =  sharedPreferences.getString("idName", null);
            if(restoredText.equals(null)){
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("idName", huh);
                editor.apply();
                TextView textViewop = findViewById(R.id.points_present);
                textViewop.setText(restoredText);
            }else{
                TextView textViewop = findViewById(R.id.points_present);
                textViewop.setText(restoredText);
            }


        }else{
            Toast.makeText(this,"Password is Wrong",Toast.LENGTH_LONG);
        }
    }
}
