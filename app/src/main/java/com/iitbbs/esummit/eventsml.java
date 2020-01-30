package com.iitbbs.esummit;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class eventsml extends android.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventsml, container, false);

        android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment3,new events_frag());
        fr.commit();

        return view;
    }
}

