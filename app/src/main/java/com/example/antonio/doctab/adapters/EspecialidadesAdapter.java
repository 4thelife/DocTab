package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Especialidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class EspecialidadesAdapter extends RecyclerView.Adapter<EspecialidadesAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Especialidades> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView txtEspecialidad;
        TextView txtSubespecialidad;
        TextView txtUniverisdad;
        TextView txtAnoEgreso;

        public ViewHolder(View itemView) {
            super(itemView);

            txtEspecialidad = (TextView) itemView.findViewById(R.id.item_especialidad_nombre);
            txtSubespecialidad = (TextView) itemView.findViewById(R.id.item_subespecialidad_nombre);
            txtUniverisdad = (TextView) itemView.findViewById(R.id.item_universidad);
            txtAnoEgreso= (TextView) itemView.findViewById(R.id.item_ano_egreso);


        }

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Especialidades getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Especialidades> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_especialidades, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EspecialidadesAdapter.ViewHolder holder, int position) {
        final Especialidades item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);


        holder.txtEspecialidad.setText(item.getEspecialidad());
        holder.txtSubespecialidad.setText(item.getSubespecialidad());
        holder.txtUniverisdad.setText(item.getUniverisdad());
        holder.txtAnoEgreso.setText(item.getAnoEgreso());



    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
