package com.flintcore.tarea_2_movil.views;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flintcore.tarea_2_movil.R;

import java.util.Arrays;
import java.util.List;

public class BackgroundActivity implements View.OnClickListener {

    private final LinearLayout mainLayout;
    private final List<TextView> alternativeViews;
//    private final Color defaultColorText;

    public BackgroundActivity(LinearLayout relativeLayout, TextView[] alternativeViews) {
        this.mainLayout = relativeLayout;
        this.alternativeViews = Arrays.asList(alternativeViews);
//        int backgroundColor = Color.LTGRAY;
//        this.defaultColorText = Color.valueOf(backgroundColor);
        setOnClickChildren();
    }

    private void setOnClickChildren() {
        int childCount = this.mainLayout.getChildCount();

        for (int pos = 1; pos < childCount; pos++) {
            this.mainLayout.getChildAt(pos).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Drawable background = view.getBackground();
        View parent = (View) ((View) this.mainLayout.getParent()).getParent();
        parent.setBackground(background);

        int colorOfParent = getBackgroundColor(parent);

        switch (colorOfParent) {

            case Color.WHITE:
            default:
                colorOfParent = Color.BLACK;
                break;


            case Color.BLACK:
                colorOfParent = Color.WHITE;
                break;
        }

        for (TextView textView : this.alternativeViews) {
            textView.setTextColor(colorOfParent);

            if (textView.getId() == R.id.amountTxt) {
                Drawable border;
                if (colorOfParent == Color.BLACK) {
                    border = view.getResources().getDrawable(R.drawable.border_edit_text_default_white);
                    textView.setBackgroundColor(Color.WHITE);
                } else {
                    border = view.getResources().getDrawable(R.drawable.border_edit_text_default);
                    textView.setBackground(border);
                }
            }
        }

    }

    private int getBackgroundColor(View parent) {
        return ((ColorDrawable) parent.getBackground()).getColor();
    }
}
