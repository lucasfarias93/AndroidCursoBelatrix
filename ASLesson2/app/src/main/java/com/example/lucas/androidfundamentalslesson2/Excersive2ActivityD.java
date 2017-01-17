package com.example.lucas.androidfundamentalslesson2;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Excersive2ActivityD extends AppCompatActivity {

    private TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersive2_activity_d);

        text3 = (TextView)findViewById(R.id.textView3);
        text3.setText("Ejemplo de la actividad lanzada por el boton de activity D");
    }
}
