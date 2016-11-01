package br.com.drugstore.www.diabetes.Fragments;


import android.app.NotificationManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.drugstore.www.diabetes.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMedicamentos extends Fragment {


    public FragmentMedicamentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_medicamentos, container, false);

    }


}
