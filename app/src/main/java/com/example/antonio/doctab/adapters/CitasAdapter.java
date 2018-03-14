package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Citas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class CitasAdapter extends RecyclerView.Adapter<CitasAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Citas> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtFecha;
        TextView txtHora;
        TextView txtAsunto;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView) itemView.findViewById(R.id.item_citas_nombre);
            txtFecha = (TextView) itemView.findViewById(R.id.item_citas_fecha);
            txtHora = (TextView) itemView.findViewById(R.id.item_citas_horario);
            txtAsunto = (TextView) itemView.findViewById(R.id.item_citas_asunto);

        }

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Citas getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Citas> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_citas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Citas item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtNombre.setText(item.getNombre());
        holder.txtFecha.setText(item.getFecha());
        holder.txtHora.setText(item.getHora());
        holder.txtAsunto.setText(item.getAsunto());


    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

}
