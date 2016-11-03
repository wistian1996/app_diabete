package br.com.drugstore.www.diabetes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.R;


/**
 * Created by wisti on 01/11/2016.
 */
public class MedicamentosAdapterTb extends RecyclerView.Adapter<MedicamentosAdapterTb.MyViewHolder> {

    private List<Alarme> alarmList;
    private LayoutInflater mLayoutInflater;

    public MedicamentosAdapterTb(Context c , List<Alarme> l){
        alarmList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_medicamento_tb, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_view_medicamento.setText(alarmList.get(position).getMedicamento());
        holder.text_view_dosagem.setText(String.valueOf(alarmList.get(position).getDosagem()));
        holder.checkDom.setChecked(alarmList.get(position).isDomingo());
        holder.checkSeg.setChecked(alarmList.get(position).isSegunda());
        holder.checkTer.setChecked(alarmList.get(position).isTerca());
        holder.checkQua.setChecked(alarmList.get(position).isQuarta());
        holder.checkQui.setChecked(alarmList.get(position).isQuinta());
        holder.checkSex.setChecked(alarmList.get(position).isSexta());
        holder.checkSab.setChecked(alarmList.get(position).isSabado());
      }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_view_medicamento;
        public TextView text_view_dosagem;
        public ToggleButton checkDom;
        public ToggleButton checkSeg;
        public ToggleButton checkTer;
        public ToggleButton checkQua;
        public ToggleButton checkQui;
        public ToggleButton checkSex;
        public ToggleButton checkSab;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_view_medicamento = (TextView) itemView.findViewById(R.id.text_view_medicamento);
            text_view_dosagem = (TextView) itemView.findViewById(R.id.text_view_dosagem);
            checkDom = (ToggleButton) itemView.findViewById(R.id.tb_dom);
            checkSeg = (ToggleButton) itemView.findViewById(R.id.tb_seg);
            checkTer = (ToggleButton) itemView.findViewById(R.id.tb_ter);
            checkQua = (ToggleButton) itemView.findViewById(R.id.tb_qua);
            checkQui = (ToggleButton) itemView.findViewById(R.id.tb_qui);
            checkSex = (ToggleButton) itemView.findViewById(R.id.tb_sex);
            checkSab = (ToggleButton) itemView.findViewById(R.id.tb_sab);
        }
    }
}
