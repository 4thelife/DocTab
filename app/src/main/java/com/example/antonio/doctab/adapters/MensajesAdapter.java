package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Mensajes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 15/02/2018.
 */

public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.ViewHolder> {


    View.OnClickListener onClickListener;
    List<Mensajes> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtRemitente;
        TextView txtDestinatario;
        TextView txtAsunto;
        TextView txtContenido;

        public ViewHolder(View itemView){
            super(itemView);
            txtRemitente = itemView.findViewById(R.id.item_mensaje_remitente);
            /**txtDestinatario = itemView.findViewById(R.id.);*/
            txtAsunto = itemView.findViewById(R.id.item_mensaje_asunto);
            txtContenido = itemView.findViewById(R.id.item_mensaje_contenido);

        }
    }


    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Mensajes getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Mensajes> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_mensajes, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(MensajesAdapter.ViewHolder holder, int position) {
        final Mensajes item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);



        holder.txtRemitente.setText(item.getRemitente());
        holder.txtDestinatario.setText(item.getDestinatario());
        holder.txtAsunto.setText(item.getAsunto());
        holder.txtContenido.setText(item.getContenido());

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
