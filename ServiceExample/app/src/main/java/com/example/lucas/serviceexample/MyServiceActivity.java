package com.example.lucas.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyServiceActivity extends AppCompatActivity {

    private TextView textCronometro;
    private Button buttonStart;
    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        textCronometro = (TextView)findViewById(R.id.textView);

        buttonStart = (Button) findViewById(R.id.button);
        buttonStart.setText("Iniciar Cronometro");
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                iniciarCronometro();
            }
        });

        buttonStop = (Button) findViewById(R.id.button2);
        buttonStop.setText("Reiniciar Cronometro");
        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pararCronometro();
            }
        });

        Cronometro.setUpdateListener(this);

    }

    @Override
    protected void onDestroy() {
        // Antes de cerrar la aplicacion se para el servicio (el cronometro)
        pararCronometro();
        super.onDestroy();
    }

    /**
     * Inicia el servicio
     */
    private void iniciarCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        startService(service);
    }

    /**
     * Finaliza el servicio
     */
    private void pararCronometro() {
        Intent i = new Intent();
        i.setAction("com.example.lucas.serviceexample.BUTTON_STOP");
        sendBroadcast(i);
        Intent service = new Intent(this, Cronometro.class);
        stopService(service);
    }

    /**
     * Actualiza en la interfaz de usuario el tiempo cronometrado
     *
     * @param tiempo
     */
    public void actualizarCronometro(double tiempo) {
        textCronometro.setText(String.format("%.2f", tiempo) + "s");
    }
}
