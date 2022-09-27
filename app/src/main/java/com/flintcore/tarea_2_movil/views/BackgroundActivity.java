package com.flintcore.tarea_2_movil.views;

import android.view.View;
import android.widget.LinearLayout;

import com.flintcore.tarea_2_movil.R;

public class BackgroundActivity implements View.OnClickListener {

    private LinearLayout mainLayout;

    public BackgroundActivity(LinearLayout relativeLayout) {
        this.mainLayout = relativeLayout;
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
        ((View) this.mainLayout.getParent()).setBackground(view.getBackground());
    }
}
