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

public class CitasDoctorAdapter extends RecyclerView.Adapter<CitasDoctorAdapter.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Citas> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDoctor;
        TextView txtConsultorio;
        TextView txtPaciente;
        TextView txtFecha;
        TextView txtHora;
        TextView txtEstadoCita;
        TextView txtRetroalimentacionCita;
        TextView txtComentarioPaciente;
        TextView txtAsunto;

        public ViewHolder(View itemView) {
            super(itemView);

            txtDoctor = (TextView) itemView.findViewById(R.id.item_citas_doctor);
            txtConsultorio = (TextView) itemView.findViewById(R.id.item_citas_consultorio);
            txtPaciente = (TextView) itemView.findViewById(R.id.item_citas_paciente);
            txtFecha = (TextView) itemView.findViewById(R.id.item_citas_fecha);
            txtHora = (TextView) itemView.findViewById(R.id.item_citas_horario);
            txtEstadoCita = (TextView) itemView.findViewById(R.id.item_citas_estado_cita);
            txtComentarioPaciente = (TextView) itemView.findViewById(R.id.item_citas_comentario);
            txtAsunto = (TextView) itemView.findViewById(R.id.item_citas_asunto);
            txtRetroalimentacionCita = (TextView) itemView.findViewById(R.id.item_citas_retroalimentacion);

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_citas_doctor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CitasDoctorAdapter.ViewHolder holder, int position) {
        final Citas item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);

        holder.txtDoctor.setText(item.getDoctor());
        holder.txtConsultorio.setText(item.getConsultorio());
        holder.txtPaciente.setText(item.getPaciente());
        holder.txtFecha.setText(item.getFecha());
        holder.txtHora.setText(item.getHora());
        holder.txtEstadoCita.setText(item.getEstadoCita());
        holder.txtComentarioPaciente.setText(item.getComentarioPaciente());
        holder.txtAsunto.setText(item.getAsunto());
        holder.txtRetroalimentacionCita.setText(item.getRetroalimentacionCita());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
