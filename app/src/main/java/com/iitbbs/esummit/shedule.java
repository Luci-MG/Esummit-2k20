package com.iitbbs.esummit;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class shedule extends android.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shedule, container, false);

        TabLayout tabLayout = (TabLayout)root.findViewById(R.id.tabs1);
        tabLayout.setTabTextColors(Color.parseColor("#000000"),Color.parseColor("#88ccdf"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#88ccdf"));
        seupTabLayout1(tabLayout);
        MainActivity.murl = "http://quiz.e-summit-iitbbs.com/schedule_app1.php";
        android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.add(R.id.fragment2,new forwebview_frag());
        fr.commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){
                    MainActivity.murl = "http://quiz.e-summit-iitbbs.com/schedule_app1.php";
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment2,new forwebview_frag());
                    fr.commit();
                }else if(tab.getPosition() == 1){
                    MainActivity.murl = "http://quiz.e-summit-iitbbs.com/schedule_app2.php";
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment2,new forwebview_frag());
                    fr.commit();
                }else if(tab.getPosition() == 2){
                    MainActivity.murl = "http://quiz.e-summit-iitbbs.com/schedule_app3.php";
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment2,new forwebview_frag());
                    fr.commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    private void seupTabLayout1(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("Day-1"), true);
        tabLayout.addTab(tabLayout.newTab().setText("Day-2"));
        tabLayout.addTab(tabLayout.newTab().setText("Day-3"));
    }
}
