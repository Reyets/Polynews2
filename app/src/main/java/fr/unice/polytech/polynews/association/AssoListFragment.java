package fr.unice.polytech.polynews.association;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.unice.polytech.polynews.R;



public class AssoListFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public AssoListFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AssoListFragment newInstance(int sectionNumber) {
        AssoListFragment fragment = new AssoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_asso_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AssoDBHelper database = new AssoDBHelper(getActivity());
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
        List<Assos> listAsso = new ArrayList<>(database.getAssoList());

        AssoCustomAdapter assoCustomAdapter = new AssoCustomAdapter(getActivity(), listAsso);

        GridView grid = (GridView) getView().findViewById(R.id.asso);
        grid.setAdapter(assoCustomAdapter);


    }
}

