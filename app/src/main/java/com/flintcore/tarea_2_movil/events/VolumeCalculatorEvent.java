package com.flintcore.tarea_2_movil.events;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.flintcore.tarea_2_movil.utils.MoneyCalculator;
import com.flintcore.tarea_2_movil.utils.StringMapper;

public class VolumeCalculatorEvent implements View.OnKeyListener {

    private final TextView[] views;
    private final MoneyCalculator calculator;
    private final TextView amountValues;
    private final StringMapper mapper;

    public VolumeCalculatorEvent(TextView textView, TextView[] orderedViews) {
        this.calculator = MoneyCalculator.getInstance();
        this.amountValues = textView;
        this.views = orderedViews;
        this.mapper = StringMapper.getInstance();
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            this.hideBoard();
            String data = this.amountValues.getText().toString();
            long longData = Long.parseLong(data.isEmpty() ? "0" : data);

            String[] convertedValues = this.calculator.getAmounts(longData);

            for (int i = 0; i < convertedValues.length; i++) {
                CharSequence label = this.views[i].getText();
                label = this.mapper.getSubSequenceOf(label, ":");

                String result = String.join(" ", label, convertedValues[i]);

                this.views[i].setText(result);
            }

            return true;
        }

        return false;
    }

    public void hideBoard() {
        InputMethodManager imm = (InputMethodManager) this.amountValues.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.amountValues.getWindowToken(), 0);
    }
}
