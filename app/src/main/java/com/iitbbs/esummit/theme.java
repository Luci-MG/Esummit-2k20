package com.iitbbs.esummit;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class theme extends android.app.Fragment{
    public YouTubePlayerView youTubePlayerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme, container, false);


        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "gPwWMUREHH0";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }

    @Override
    public void onStop() {
        super.onStop();
        youTubePlayerView.release();
    }

    @Override
    public void onPause() {
        super.onPause();
        youTubePlayerView.release();
    }

    @Override
    public void onResume() {
        super.onResume();
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "gPwWMUREHH0";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        youTubePlayerView.release();
    }


}