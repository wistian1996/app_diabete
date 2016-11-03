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
import br.com.drugstore.www.diabetes.Adapters.MedicamentosAdapterTb;
import br.com.drugstore.www.diabetes.DAO.DAOAlarme;
import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.Domain.Artigo;
import br.com.drugstore.www.diabetes.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMedicamentos extends Fragment {

    private RecyclerView recyclerView;
    private List<Alarme> listAlarme;
    private DAOAlarme daoAlarme;

    public FragmentMedicamentos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_medicamentos, container, false);

        daoAlarme = new DAOAlarme(getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        listAlarme = daoAlarme.getTodosAlarmes();

        MedicamentosAdapter medAdapter = new MedicamentosAdapter(getActivity(), listAlarme);
        MedicamentosAdapterTb medAdapterTb = new MedicamentosAdapterTb(getActivity(), listAlarme);

//        recyclerView.setAdapter(medAdapter);
        recyclerView.setAdapter(medAdapterTb);

        return view;

    }


}
