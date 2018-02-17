package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.helpers.DecodeItemHelper;

import com.example.antonio.doctab.models.Doctores;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class DoctoresAdapter extends RecyclerView.Adapter<DoctoresAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Doctores> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombres;
        TextView txtEspecialidad;
        TextView txtTelefono;
        TextView txtCedula;
        TextView txtSexo;


        public ViewHolder(View itemView) {
            super(itemView);

            txtNombres = (TextView) itemView.findViewById(R.id.item_doctor_nombres);
            txtEspecialidad= (TextView) itemView.findViewById(R.id.item_doctor_especialidad);
            txtCedula = (TextView) itemView.findViewById(R.id.item_doctor_cedula);
            txtSexo = (TextView) itemView.findViewById(R.id.item_doctor_sexo);
            txtTelefono = (TextView) itemView.findViewById(R.id.item_doctor_telefono);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Doctores getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Doctores> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_doctor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctoresAdapter.ViewHolder holder, int position) {
        final Doctores item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtNombres.setText(item.getNombreCompleto());
        //holder.txtApellidos.setText(item.getApeliidos());
        holder.txtCedula.setText(item.getCedulaProfesional());
        holder.txtEspecialidad.setText(item.getEspecialidad());
        holder.txtSexo.setText(item.getSexo());
        holder.txtTelefono.setText(item.getTelefono());

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
