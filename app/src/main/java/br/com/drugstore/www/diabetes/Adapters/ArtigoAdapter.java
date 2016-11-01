package br.com.drugstore.www.diabetes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.drugstore.www.diabetes.Domain.Artigo;
import br.com.drugstore.www.diabetes.R;


/**
 * Created by wisti on 28/10/2016.
 */
public class ArtigoAdapter extends RecyclerView.Adapter<ArtigoAdapter.MyViewHolder> {
    private List<Artigo> artigoList;
    private LayoutInflater mLayoutInflater;

    public ArtigoAdapter(Context c, List<Artigo> l) {
        artigoList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_artigo, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_view_titulo.setText(artigoList.get(position).getTitulo());
        holder.text_view_texto.setText(artigoList.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return artigoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_view_texto;
        public TextView text_view_titulo;

        public MyViewHolder(View itemView) {

            super(itemView);
            text_view_texto = (TextView) itemView.findViewById(R.id.text_view_texto);
            text_view_titulo = (TextView) itemView.findViewById(R.id.text_view_nome_medicamento);

        }
    }

}
