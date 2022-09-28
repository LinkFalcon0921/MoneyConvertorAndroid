package com.flintcore.tarea_2_movil;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.flintcore.tarea_2_movil.events.ClearNCloseTouchEvent;
import com.flintcore.tarea_2_movil.events.ExternalDoAction;
import com.flintcore.tarea_2_movil.events.VolumeCalculatorEvent;
import com.flintcore.tarea_2_movil.views.BackgroundActivity;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private LinearLayout listBackgrounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.relativeLayout = findViewById(R.id.main_layout);
        listBackgrounds = findViewById(R.id.list_bg);

        EditText amountTxtGetter = findViewById(R.id.amountTxt);
        amountTxtGetter.setSingleLine(true);

        TextView[] alternativeViewsOpposite = {
                findViewById(R.id.info_amount),
                amountTxtGetter,
                findViewById(R.id.clear_info),
                findViewById(R.id.close_info)
        };

        BackgroundActivity backgroundActivity = new BackgroundActivity(listBackgrounds, alternativeViewsOpposite);
        ExternalDoAction cleanAction = () -> {
            amountTxtGetter.setText("");
        };

        WindowManager managerScreen = getWindowManager();
        this.relativeLayout.setOnTouchListener(new ClearNCloseTouchEvent(cleanAction, managerScreen));

        TextView[] resultsMoneyViews = {
            findViewById(R.id.hundred_coin),
                findViewById(R.id.fifty_coin),
                findViewById(R.id.twenty_coin),
                findViewById(R.id.ten_cents_coin),
                findViewById(R.id.five_cents_coin)
        };

//        On key listener
        amountTxtGetter.setOnKeyListener(new VolumeCalculatorEvent(amountTxtGetter, resultsMoneyViews));

    }
}