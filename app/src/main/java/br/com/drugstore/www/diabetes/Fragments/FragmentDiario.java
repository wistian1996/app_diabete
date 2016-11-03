package br.com.drugstore.www.diabetes.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.drugstore.www.diabetes.Activitys.ActivityConfigAlarme;
import br.com.drugstore.www.diabetes.Activitys.ActivityConfigDiario;
import br.com.drugstore.www.diabetes.Activitys.MainActivity;
import br.com.drugstore.www.diabetes.R;


public class FragmentDiario extends Fragment {

    public FragmentDiario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // caso queira adicionar botao flutuante


        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent( getContext() , ActivityConfigDiario.class );
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_diario, container, false);
    }


}
