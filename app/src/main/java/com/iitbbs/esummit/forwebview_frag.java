package com.iitbbs.esummit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


public class forwebview_frag extends android.app.Fragment {

    private String mURL = MainActivity.murl;
    public WebView webview;
    private ProgressBar bar;
    private FrameLayout framelayout;


    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forwebview_frag, container,false);
        framelayout = (FrameLayout)view.findViewById( R.id.framelayout);
        bar = (ProgressBar)view.findViewById(R.id.progressBar);
        bar.setMax(100);
        WebView webview = (WebView) view.findViewById(R.id.webview);
        webview.setWebViewClient(new MyWebViewClient());
        webview.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int progress){
                framelayout.setVisibility( View.VISIBLE );
                bar.setProgress( progress );

                if(progress==100)
                    framelayout.setVisibility( View.GONE );
                super.onProgressChanged( view, progress);
            }
        } );
        WebSettings webSettings = webview.getSettings();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccess(true);
        webview.setVerticalScrollBarEnabled( false );

        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.loadUrl(mURL);
        bar.setProgress( 0 );

        return view;
    }

    public  class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl( url );
            framelayout.setVisibility(View.VISIBLE );
            return true;
        }
    }

    public void reload() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                // mWebview.loadUrl("http://www.google.com");
            }
        }, 5000);
    }
}
