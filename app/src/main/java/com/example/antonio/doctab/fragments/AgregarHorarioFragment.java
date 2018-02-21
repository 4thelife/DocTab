package com.example.antonio.doctab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.fragments.interfaces.MainRegisterInterface;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Usuarios;

import com.example.antonio.doctab.R;

/**
 * Created by Ricardo on 21/02/2018.
 */

public class AgregarHorarioFragment extends Fragment{

    Spinner spnr_horas_entrada;
    Spinner spnr_horas_salida;
    Spinner spnr_citas_por_hora;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agregar_horario, container,
                false);


        spnr_horas_entrada = (Spinner) view.findViewById(R.id.spnr_horas_entrada);
        ArrayAdapter adapterEntrada = ArrayAdapter.createFromResource(container.getContext(),
                R.array.lista_horas,R.layout.fragment_agregar_horario);
        spnr_horas_entrada.setAdapter(adapterEntrada);

        spnr_horas_salida = (Spinner) view.findViewById(R.id.spnr_horas_salida);
        ArrayAdapter adapterSalida = ArrayAdapter.createFromResource(container.getContext(),
                R.array.lista_horas,R.layout.fragment_agregar_horario);
        spnr_horas_entrada.setAdapter(adapterSalida);

        spnr_citas_por_hora = (Spinner) view.findViewById(R.id.spnr_citas_por_hora);
        ArrayAdapter adapterCantidad = ArrayAdapter.createFromResource(container.getContext(),
                R.array.cantidad_citas,R.layout.fragment_agregar_horario);
        spnr_horas_entrada.setAdapter(adapterCantidad);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
