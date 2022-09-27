package com.flintcore.tarea_2_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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

        BackgroundActivity backgroundActivity = new BackgroundActivity(listBackgrounds);

    }
}