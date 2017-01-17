package com.example.lucas.androidfundamentalslesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Excersive2ActivityC extends AppCompatActivity {

    private TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersive2_activity_c);

        text2 = (TextView)findViewById(R.id.textView2);
        text2.setText("Ejemplo de la actividad lanzada por el boton de activity C");
    }
}
