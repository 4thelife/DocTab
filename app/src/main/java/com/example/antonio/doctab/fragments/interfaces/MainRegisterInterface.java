package com.example.antonio.doctab.fragments.interfaces;

import com.example.antonio.doctab.helpers.DecodeItemHelper;

/**
 * Created by jvier on 03/10/2017.
 */

public interface MainRegisterInterface {

    void openExternalActivity(int action, Class<?> externalActivity);

    void showQuestion(String titulo, String mensage);

    void setDecodeItem(DecodeItemHelper decodeItem);

    //void registrarPromotor(PromotoresHelper promotoresHelper);

    //void editarPromotor(PromotoresHelper promotoresHelper);
}
