package fr.unice.polytech.polynews.tutoriel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.polynews.R;

public class NewsListFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public NewsListFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsListFragment newInstance(int sectionNumber) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        NewsDBHelper database = new NewsDBHelper(getActivity());
        try {
            database.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            database.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<News> listNews = new ArrayList<>(database.getNewsList());

        News first = listNews.get(0);
        listNews.remove(0);
        List<News> onenew = new ArrayList<>(1);
        onenew.add(first);
        NewsCustomAdapter firstAdapter = new NewsCustomAdapter(getActivity(), onenew);
        NewsCustomAdapter newsAdapter = new NewsCustomAdapter(getActivity(), listNews);

        GridView grid = (GridView) getView().findViewById(R.id.grid) ;
        RelativeLayout postcard = (RelativeLayout) getView().findViewById(R.id.onecard);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CardView firstView = (CardView) firstAdapter.getView(0, inflater.inflate(R.layout.fragment_news_element, null), postcard);
        firstView.bringToFront();
        firstView.setCardElevation(13.5f);
        firstView.setRadius(13.5f);
        firstView.setPadding(0,50, 0, 50);
        firstView.setShadowPadding(10, 10, 20, 20);
        postcard.addView(firstView);
        grid.setAdapter(newsAdapter);


    }
}
