package com.example.reham.task2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.example.reham.task2.R;

/**
 * Created by reham on 1/17/2019.
 */

public class WebFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.web_view, container, false);
        WebView webView = (WebView) rootView.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://termsfeed.com/blog/sample-terms-and-conditions-template/");

        return rootView;
    }


}
