package com.example.lucas.androidfundamentalslesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import org.w3c.dom.Text;

public class Excersive2Activity extends AppCompatActivity {

    private TextView text1;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xcersive2);

        text1 = (TextView) findViewById(R.id.textView);
        text1.setText("Este es un mensaje de prueba para el ejercicio de la leccion 2 de Android");

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
    }

    public void methodClassC(View view) {
        Intent i = new Intent(this, Excersive2ActivityC.class);
        startActivity(i);
    }

    public void methodClassD(View view) {
        Intent i = new Intent(this, Excersive2ActivityD.class);
        startActivity(i);
    }

    public void methodClassE(View view) {
        Intent i = new Intent(this, Excersive2ActivityE.class);
        startActivity(i);
    }
}


