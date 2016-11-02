package br.com.drugstore.www.diabetes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.R;


/**
 * Created by wisti on 01/11/2016.
 */
public class MedicamentosAdapter extends RecyclerView.Adapter<MedicamentosAdapter.MyViewHolder> {

    private List<Alarme> alarmList;
    private LayoutInflater mLayoutInflater;

    public MedicamentosAdapter(Context c , List<Alarme> l){
        alarmList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_medicamento, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_view_medicamento.setText(alarmList.get(position).getMedicamento());
        holder.text_view_dosagem.setText(String.valueOf(alarmList.get(position).getDosagem()));
      }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_view_medicamento;
        public TextView text_view_dosagem;

        public MyViewHolder(View itemView) {

            super(itemView);
            text_view_medicamento = (TextView) itemView.findViewById(R.id.text_view_medicamento);
            text_view_dosagem = (TextView) itemView.findViewById(R.id.text_view_dosagem);

        }
    }
}
