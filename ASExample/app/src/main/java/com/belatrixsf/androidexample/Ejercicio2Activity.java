package com.belatrixsf.androidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio2Activity extends AppCompatActivity {

    private EditText cdadLineasEditText;
    private EditText cdadLineasImpresasEditText;
    private TextView lineasImpresasTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        cdadLineasEditText = (EditText) findViewById(R.id.editTextLineas);
        lineasImpresasTextView = (TextView) findViewById(R.id.textViewLineas);
        final Button botonLineas = (Button)findViewById(R.id.buttonLineas);

        botonLineas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                 int numeroLineas = Integer.parseInt(cdadLineasEditText.getText().toString());
                for(int i = 1; i <= numeroLineas; i++){
                    lineasImpresasTextView.setText(lineasImpresasTextView.getText().toString() + "\n" + " Linea numero " + i);
                }
            }

        });
    }


}
