package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.HorariosDeAtencionFragment;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.HorariosDeAtencion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 24/02/2018.
 */

public class HorariosDeAtencionAdapter extends RecyclerView.Adapter<HorariosDeAtencionAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<HorariosDeAtencion> dataList = new ArrayList<>();


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtDia;
        TextView txtHoraInicio;
        TextView txtHoraFin;
        TextView txtDuracionDeCita;/**Duracion de la cita*/
        Button btnEditar;
        Button btnEliminar;

        public ViewHolder(View itemView) {
            super(itemView);


             txtDia = (TextView)itemView.findViewById(R.id.item_horarios_de_atencion_dia);
             txtHoraInicio = (TextView)itemView.findViewById(R.id.item_horarios_de_atencion_hora_inicio);
             txtHoraFin = (TextView)itemView.findViewById(R.id.item_horarios_de_atencion_hora_fin);
        }
    }

    public void setOnClickListener (View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }


    public HorariosDeAtencion getItemByPosition(int position){return dataList.get(position);}

    public void addAll(List<HorariosDeAtencion> _data){this.dataList.addAll(_data);}

    public void remove(int position){this.dataList.remove(position);}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_horarios_de_atencion,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HorariosDeAtencion item = dataList.get(position);

        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtDia.setText(item.getDia());
        holder.txtHoraInicio.setText(item.getHoraInicio());
        holder.txtHoraFin.setText(item.getHoraFin());
        holder.txtDuracionDeCita.setText(item.getDuracionDeCita());

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                HorariosDeAtencionFragment.onListenerAction(decodeItem);
            }
        });
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                HorariosDeAtencionFragment.onListenerAction(decodeItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList== null ? 0 : dataList.size();
    }






}
