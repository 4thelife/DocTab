package com.example.antonio.doctab.fragments.interfaces;

import com.example.antonio.doctab.helpers.ConsultoriosHelper;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.helpers.DoctoresHelper;

/**
 * Created by jvier on 03/10/2017.
 */

public interface MainRegisterInterface {

    void openExternalActivity(int action, Class<?> externalActivity);

    void showQuestion(String titulo, String mensage);

    void setDecodeItem(DecodeItemHelper decodeItem);

    void registrarDoctor(DoctoresHelper helper);

    void editarDoctor(DoctoresHelper helper);

    void registrarPaciente(ConsultoriosHelper helper);

    void editarPaciente(ConsultoriosHelper helper);

    void registrarConsultorio(ConsultoriosHelper helper);

    void editarConsultorio(ConsultoriosHelper helper);
}
