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

import java.util.ArrayList;
import java.util.List;
//Adaptador creado para que el paciente vea los datos del doctor
/**
 * Created by Ricardo on 13/02/2018.
 */

public class DoctoresAdapterVP extends RecyclerView.Adapter<DoctoresAdapterVP.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Doctores> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**Declara los elementos*/
        TextView txtNombres;
        TextView txtEspecialidad;
        TextView txtTelefono;
        TextView txtCedula;
        TextView txtSexo;

        public ViewHolder(View itemView) {
            super(itemView);
            /**Inicializa los elementos de la vista del item*/
            txtNombres = (TextView) itemView.findViewById(R.id.item_doctores_nombres_nobtn);
            txtEspecialidad= (TextView) itemView.findViewById(R.id.item_doctores_especialidad_nobtn);
            txtCedula = (TextView) itemView.findViewById(R.id.item_doctores_cedula_nobtn);
            txtSexo = (TextView) itemView.findViewById(R.id.item_doctores_sexo_nobtn);
            txtTelefono = (TextView) itemView.findViewById(R.id.item_doctores_telefono_nobtn);

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
        /**Manda a llamar la vista del item*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_doctores_nobtn, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctoresAdapterVP.ViewHolder holder, int position) {
        final Doctores item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtNombres.setText(item.getNombreCompleto());
        holder.txtCedula.setText(item.getCedulaProfesional());
        holder.txtEspecialidad.setText(item.getEspecialidad());
        holder.txtSexo.setText(item.getSexo());
        holder.txtTelefono.setText(item.getTelefono());

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
