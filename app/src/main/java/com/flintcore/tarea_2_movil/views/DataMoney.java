package com.flintcore.tarea_2_movil.views;

import static com.flintcore.tarea_2_movil.views.AppPrimitiveResources.*;

import android.widget.EditText;

public class DataMoney {

    private final EditText amount;

    public DataMoney(EditText amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount.getText().toString();
    }

    public void clearAmount(){
        this.amount.setText(EMPTY);
    }

}
