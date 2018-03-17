package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.PacientesFragment;
import com.example.antonio.doctab.helpers.DecodeItemHelper;

import com.example.antonio.doctab.models.Pacientes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class PacientesAdapter extends RecyclerView.Adapter<PacientesAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Pacientes> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnEditar,btnEliminar;
        TextView txtNombres;
        TextView txtTelefono;
        TextView txtEdad;
        TextView txtSexo;


        public ViewHolder(View itemView) {
            super(itemView);

            txtNombres = (TextView) itemView.findViewById(R.id.item_pacientes_nombres);
            txtEdad = (TextView) itemView.findViewById(R.id.item_pacientes_edad);
            txtSexo = (TextView) itemView.findViewById(R.id.item_pacientes_sexo);
            txtTelefono = (TextView) itemView.findViewById(R.id.item_pacientes_telefono);
            btnEditar = (Button)itemView.findViewById(R.id.item_btn_editar_paciente);
            btnEliminar = (Button)itemView.findViewById(R.id.item_btn_eliminar_paciente);

        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Pacientes getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Pacientes> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_pacientes,
                parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Pacientes item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtNombres.setText(item.getNombreCompleto());
        holder.txtEdad.setText(item.getEdad());
        holder.txtSexo.setText(item.getSexo());
        holder.txtTelefono.setText(item.getTelefono());

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                PacientesFragment.onListenerAction(decodeItem);
            }
        });
        /*holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeItem.setIdView(v.getId());
                //PromotoresFragment.onListenerAction(decodeItem);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


}
