package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.HorariosServicio;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 24/02/2018.
 */

public class HorariosServicioAdapter extends RecyclerView.Adapter<HorariosServicioAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<HorariosServicio> dataList = new ArrayList<>();


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtDia;
        TextView txtHorainicio;
        TextView txtHorafin;
        TextView txtCitasporhora;


        public ViewHolder(View itemView) {
            super(itemView);

            /**
             *
             txtDia = (TextView)itemView.findViewById(R.id.item_horarios_servicio_dia);
             txtHorainicio = (TextView)itemView.findViewById(R.id.item_horarios_servicio_hora_inicio);
             txtHorafin = (TextView)itemView.findViewById(R.id.item_horarios_servicio_hora_fin);
             txtCitasporhora = (TextView)itemView.findViewById(R.id.item_horarios_servicio_citas_por_hora);
             *
             */



        }
    }

    public void setOnClickListener (View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }


    public HorariosServicio getItemByPosition(int position){return dataList.get(position);}

    public void addAll(List<HorariosServicio> _data){this.dataList.addAll(_data);}

    public void remove(int position){this.dataList.remove(position);}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_horario_servicio,parent, false);
        //return new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HorariosServicio item = dataList.get(position);

        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);
        holder.txtDia.setText(item.getDia());
        holder.txtHorainicio.setText(item.getHorainicio());
        holder.txtHorafin.setText(item.getHorafin());
        holder.txtCitasporhora.setText(item.getCitasPorHora());

    }

    @Override
    public int getItemCount() {
        return 0;
    }






}
