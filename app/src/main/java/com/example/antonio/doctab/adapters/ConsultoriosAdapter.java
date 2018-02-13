package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Consultorios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvier on 21/12/2017.
 */

public class ConsultoriosAdapter extends RecyclerView.Adapter<ConsultoriosAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Consultorios> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtDireccion;
        TextView txtTelefono;
        Button btnEditar;
        Button btnEliminar;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.item_nombre_consultorio);
            txtDireccion = itemView.findViewById(R.id.item_direccion_consultorio);
            txtTelefono = itemView.findViewById(R.id.item_telefono_consultorio);
            btnEditar = itemView.findViewById(R.id.item_btn_editar_consultorio);
            btnEliminar = itemView.findViewById(R.id.item_btn_eliminar_consultorio);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Consultorios getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Consultorios> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_consultorios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Consultorios item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtNombre.setText(item.getNombreConsultorio());


        holder.txtDireccion.setText(item.getCalle() + " " + item.getColonia() + " " + item.getCodPostal()
                + " " + item.getCiudad() + " " + item.getEstado());
        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
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
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
