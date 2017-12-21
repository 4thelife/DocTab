package com.example.antonio.doctab.helpers;

import java.io.Serializable;

/**
 * Created by jvier on 05/09/2017.
 */

public class DecodeItemHelper implements Serializable {

    private int position;
    private Object itemModel;
    private int idView;

    public DecodeItemHelper() {
        itemModel = new Object();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Object getItemModel() {
        return itemModel;
    }

    public void setItemModel(Object itemModel) {
        this.itemModel = itemModel;
    }

    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }
}
