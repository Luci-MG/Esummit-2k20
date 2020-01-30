package com.iitbbs.esummit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class events_frag extends android.app.Fragment {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    Integer[] image = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_frag,container,false);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.competition, "Competitions", "Experience the most stimulating competitions of E-Summit'20. Outplay your competitors and win exciting prizes and goodies"));
        models.add(new Model(R.drawable.workshop, "Workshops", "Explore and develop latest entrepreneurial and technology skills to excel in this competitive world through our Workshops"));
        models.add(new Model(R.drawable.guesttalk, "Guest Talks", "Hear from the experienced!! Learn what the industry experts want to say. Dive into the entrepreneurial world with our 'Guest Talks'"));
        models.add(new Model(R.drawable.investorsdrive, "Investors Drive", "E-Summit ‘20, IIT Bhubaneswar provides a one stop solution to all start-ups that are in need of funding, mentoring, Incubation space especially for early stage start-ups by bringing Investors, mentor & institutions together. "));
        models.add(new Model(R.drawable.expo, "Innovation Expo", "An event in which you can showcase your innovative project or ideas as exhibit and win exciting prizes From a Project to a StartUp,the journey begins here!! "));
        models.add(new Model(R.drawable.fair, "Internship Fair", "Team E-Summit aims to connect startups with students through internships. Working in a startup is a unique experience. We provide you such an opportunity to explore work experience in a startup through this Startup Internship Fair.\n"));

        adapter = new Adapter(getActivity().toString(),models, view.getContext());

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6)
        };

        Integer[] images_temp = {
                R.drawable.competition,
                R.drawable.guesttalk,
                R.drawable.workshop,
                R.drawable.investorsdrive,
                R.drawable.expo,
                R.drawable.fair
        };

        image = images_temp;

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }



            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }
}