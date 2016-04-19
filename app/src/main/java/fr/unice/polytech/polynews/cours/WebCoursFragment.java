package fr.unice.polytech.polynews.cours;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import fr.unice.polytech.polynews.R;

/**
 * Created by chronos on 4/1/16.
 */
public class WebCoursFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public WebCoursFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static WebCoursFragment newInstance(int sectionNumber) {
        WebCoursFragment fragment = new WebCoursFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cours_list, container, false);
        WebView web = (WebView) rootView.findViewById(R.id.webview);
        //web.loadUrl("http://users.polytech.unice.fr/~pfz/COURS_SSHOW/finalWord.html");
        web.loadUrl("file:///android_asset/LesCoursSI.html");
      //  webView.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "UTF-8", null);
      //  htmlData = "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />" + htmlData;
// lets assume we have /assets/style.css file
      //  web.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "UTF-8", null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
