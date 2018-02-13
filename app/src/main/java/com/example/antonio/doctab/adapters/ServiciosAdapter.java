package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Servicios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class ServiciosAdapter extends RecyclerView.Adapter<ServiciosAdapter.ViewHolder>  {

    View.OnClickListener onClickListener;
    List<Servicios> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtServicio;
        TextView txtCosto;



        public ViewHolder(View itemView) {
            super(itemView);

            txtServicio = itemView.findViewById(R.id.item_servicios);
            txtCosto = itemView.findViewById(R.id.item_costo_servicio);

        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Servicios getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Servicios> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_servicios, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ServiciosAdapter.ViewHolder holder, int position) {
        final Servicios item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);


        holder.txtServicio.setText(item.getServicio());
        holder.txtCosto.setText(item.getCosto());

        /*holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                //PromotoresFragment.onListenerAction(decodeItem);
            }
        });
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                //PromotoresFragment.onListenerAction(decodeItem);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
