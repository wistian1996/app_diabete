package br.com.drugstore.www.diabetes.Fragments;


import android.app.NotificationManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.drugstore.www.diabetes.Adapters.ArtigoAdapter;
import br.com.drugstore.www.diabetes.Adapters.MedicamentosAdapter;
import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.Domain.Artigo;
import br.com.drugstore.www.diabetes.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMedicamentos extends Fragment {
    private RecyclerView recyclerView;
    private List<Alarme> listAlarme;

    public FragmentMedicamentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_medicamentos, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        ArrayList<Alarme> lAlarmes = new ArrayList<>();

        Alarme alarme1 = new Alarme(1, "Dorflex", 10, false, false, false, false, false, false, false, false);
        Alarme alarme2 = new Alarme(2, "Neosaldina", 12, false, false, false, false, false, false, false, false);
        Alarme alarme3 = new Alarme(3, "Dramim", 20.5, false, false, false, false, false, false, false, false);
        Alarme alarme4 = new Alarme(4, "Paracetamol", 25.3, false, false, false, false, false, false, false, false);

        lAlarmes.add(alarme1);
        lAlarmes.add(alarme2);
        lAlarmes.add(alarme3);
        lAlarmes.add(alarme4);

        listAlarme = lAlarmes;

        MedicamentosAdapter medAdapter = new MedicamentosAdapter(getActivity(), listAlarme);
        recyclerView.setAdapter(medAdapter);
        return view;

    }


}
