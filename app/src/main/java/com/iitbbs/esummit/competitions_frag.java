package com.iitbbs.esummit;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;
import com.ramotion.foldingcell.FoldingCell;


public class competitions_frag extends android.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competitions_frag,container,false);
        final FoldingCell cell = view.findViewById(R.id.folding_cell);
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell.toggle(false);
            }
        });
        final FoldingCell cell1 = view.findViewById(R.id.folding_cell1);
        cell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell1.toggle(false);
            }
        });
        final FoldingCell cell2 = view.findViewById(R.id.folding_cell2);
        cell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell2.toggle(false);
            }
        });
        final FoldingCell cell3 = view.findViewById(R.id.folding_cell3);
        cell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell3.toggle(false);
            }
        });
        final FoldingCell cell4 = view.findViewById(R.id.folding_cell4);
        cell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell4.toggle(false);
            }
        });
        final FoldingCell cell5 = view.findViewById(R.id.folding_cell5);
        cell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell5.toggle(false);
            }
        });
        final FoldingCell cell6 = view.findViewById(R.id.folding_cell6);
        cell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell6.toggle(false);
            }
        });
        final FoldingCell cell7 = view.findViewById(R.id.folding_cell7);
        cell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell7.toggle(false);
            }
        });
        final FoldingCell cell8 = view.findViewById(R.id.folding_cell8);
        cell8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell8.toggle(false);
            }
        });
        final FoldingCell cell9 = view.findViewById(R.id.folding_cell9);
        cell9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cell9.toggle(false);
            }
        });
        return view;
    }



}
