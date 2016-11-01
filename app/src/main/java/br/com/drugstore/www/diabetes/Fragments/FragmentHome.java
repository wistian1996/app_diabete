package br.com.drugstore.www.diabetes.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.drugstore.www.diabetes.Adapters.ArtigoAdapter;
import br.com.drugstore.www.diabetes.Domain.Artigo;
import br.com.drugstore.www.diabetes.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {
    private RecyclerView recyclerView;
    private List<Artigo> listArtigo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);



        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        Artigo a1 = new Artigo("Exemplo 1", "Quando se tem diabetes significa que você precisa ajudar o seu organismo a controlar o nível de açúcar no sangue. Antes de desenvolver o diabetes, o pâncreas desempenhava o seu papel, mantinha o nível normal de açúcar no seu sangue, produzindo a quantidade certa de insulina.");
        Artigo a2 = new Artigo("Exemplo 2" , "Agora é você e o seu médico que, juntos, vão gerenciar isso, para que seu organismo funcione corretamente. Não é tão difícil quanto parece. Você conhece melhor que ninguém seu corpo e vai aprender os momentos exatos que seu organismo precisará de ajuda.");
        Artigo a3 = new Artigo("Teste o açucar no sangue" , "Testar o nível de açúcar no sangue é muito importante, pois com o resultado do teste você poderá controlar melhor seu diabetes. Faça-o de acordo com a orientação do seu médico, sendo uma boa atitude a averiguação frequente ao longo do seu dia, para ajustar corretamente a sua dose de insulina. Anote todos os resultados no diário de glicemia.\n" +
                "Um bom controle do nível de açúcar no seu sangue ajudará  você a se sentir melhor no seu dia a dia.");

        Artigo a4 = new Artigo("HbA1C","A HbA1c é um índice de controle de glicemia, também chamada de hemoglobina glicada. Ela indica o controle do açúcar no sangue de um paciente nos últimos 2 a 3 meses. É formada quando a glicose no sangue se liga irreversivelmente à hemoglobina que está presente no interior das células vermelhas do sangue, para formar um complexo estável de hemoglobina glicada. Como a duração  normal de vida das células vermelhas no sangue é de 90 a 120 dias, a HbA1c somente será eliminada quando as células vermelhas forem substituídas.");
        ArrayList<Artigo> lArtigo = new ArrayList<>();
        lArtigo.add(a1);
        lArtigo.add(a2);
        lArtigo.add(a3);
        lArtigo.add(a4);



        listArtigo = lArtigo;

        ArtigoAdapter artigoAdapter = new ArtigoAdapter(getActivity(), listArtigo);
        recyclerView.setAdapter(artigoAdapter);
        return view;
    }
}
