package com.example.antonio.doctab.fragments.interfaces;

import com.example.antonio.doctab.helpers.ConsultoriosHelper;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.helpers.DoctoresHelper;
import com.example.antonio.doctab.helpers.PacientesHelper;

/**
 * Created by jvier on 03/10/2017.
 */

public interface MainRegisterInterface {

    void openExternalActivity(int action, Class<?> externalActivity);

    void showQuestion(String titulo, String mensage);

    void setDecodeItem(DecodeItemHelper decodeItem);

    void registrarDoctor(DoctoresHelper helper);

    void editarDoctor(DoctoresHelper helper);

    void registrarPaciente(PacientesHelper helper);

    void editarPaciente(PacientesHelper helper);

    void registrarConsultorio(ConsultoriosHelper helper);

    void editarConsultorio(ConsultoriosHelper helper);
}
