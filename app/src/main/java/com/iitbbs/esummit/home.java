package com.iitbbs.esummit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import androidx.fragment.app.FragmentManager;



public class home extends android.app.Fragment{



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = (TabLayout)root.findViewById(R.id.tabs);
        tabLayout.setTabTextColors(Color.parseColor("#000000"),Color.parseColor("#88ccdf"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#88ccdf"));
        seupTabLayout(tabLayout);
        android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.add(R.id.fragment1,new eventsml());
        fr.commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment1,new aboutus());
                    fr.commit();
                }else if(tab.getPosition() == 1){
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment1,new theme());
                    fr.commit();
                }else if(tab.getPosition() == 2){
                    android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment1,new eventsml());
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
        //Animation shake = AnimationUtils.loadAnimation(getContext(), R.anim.shake);
        ImageView imgBell= (ImageView)root.findViewById(R.id.hey);
        Animation scaledown = AnimationUtils.loadAnimation(getContext(),R.anim.scaledown);
        Animation scaleup = AnimationUtils.loadAnimation(getContext(),R.anim.scaleup);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(scaledown);
        set.addAnimation(scaleup);
        imgBell.startAnimation(set);

        return root;

    }

    private void seupTabLayout(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("About us"));
        tabLayout.addTab(tabLayout.newTab().setText("Theme"));
        tabLayout.addTab(tabLayout.newTab().setText("Events"), true);
    }


}