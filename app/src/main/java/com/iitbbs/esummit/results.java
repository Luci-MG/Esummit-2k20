package com.iitbbs.esummit;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class results extends android.app.Fragment{

    private RecyclerView mRecyclerview;
    private result_adapter mAdapter;
    private ProgressBar progressBar;

    private DatabaseReference mDatabaseref;
    private List<Upload> mUploads;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_results, container, false);
        //
        progressBar = root.findViewById(R.id.hey4);


        mRecyclerview = root.findViewById(R.id.recycle4);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));


        mUploads = new ArrayList<>();

        mDatabaseref = FirebaseDatabase.getInstance().getReference("results");

        mDatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postsnpashot : dataSnapshot.getChildren()){
                    Upload upload = postsnpashot.getValue(Upload.class);
                    mUploads.add(upload);
                }

                mAdapter = new result_adapter(getContext(),mUploads);
                mRecyclerview.setAdapter(mAdapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


        //
        return root;
    }
}