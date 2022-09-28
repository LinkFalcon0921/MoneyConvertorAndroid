package com.flintcore.tarea_2_movil.views;

import android.widget.EditText;
import android.widget.GridLayout;

public class MoneyActivity {

    private GridLayout moneyActivity;
    private DataMoney dataMoney;

    public MoneyActivity(GridLayout moneyActivity, EditText amountText) {
        this.moneyActivity = moneyActivity;
        this.dataMoney = new DataMoney(amountText);
    }


}
