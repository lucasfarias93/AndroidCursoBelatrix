package com.example.lucas.androidfundamentalslesson2;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Excersive2ActivityE extends AppCompatActivity {

    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersive2_activity_e);

        text4 = (TextView)findViewById(R.id.textView4);
        text4.setText("Ejemplo de la actividad lanzada por el boton de activity E");
    }
}
