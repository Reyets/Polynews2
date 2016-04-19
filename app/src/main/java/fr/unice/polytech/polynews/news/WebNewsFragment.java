package fr.unice.polytech.polynews.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import fr.unice.polytech.polynews.R;

/**
 * Created by Antoine on 18/04/2016.
 */
public class WebNewsFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public WebNewsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static WebNewsFragment newInstance(int sectionNumber) {
        WebNewsFragment fragment = new WebNewsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newsweb_list, container, false);
        WebView web = (WebView) rootView.findViewById(R.id.webnewsview);
        
        web.loadUrl("file:///android_asset/communication.html");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
