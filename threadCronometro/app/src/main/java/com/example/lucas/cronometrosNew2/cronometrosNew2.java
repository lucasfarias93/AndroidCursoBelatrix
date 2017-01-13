package com.example.lucas.cronometrosNew2;

import android.os.Handler;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class cronometrosNew2 extends AppCompatActivity {
    Button b1;
    Button b2;
    TextView tiempo;
    TextView horaTotal;
    long h = 00, m = 00, s = 00;
    boolean bandera = true;
    boolean banderaStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro_new2);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        horaTotal = (TextView) findViewById(R.id.textViewHoraTotal);
        tiempo = (TextView) findViewById(R.id.txtReloj);


        b1.setOnClickListener(empieza);
        b2.setOnClickListener(para);

    }

    Handler handler = new Handler();

    public void hilador(boolean banderaStop) {
        Thread cronometro = new Thread() {
            public void run() {
                try {
                    while (bandera == true) {
                        handler.post(proceso);
                        Thread.sleep(1000);
                        Log.d("thread 1 continue","El Thread 1 aun no termina");
                    }
                } catch (Exception e) {
                    Toast b = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
                    b.show();
                }
            }
        };
        if(!banderaStop) {
            cronometro.start();
        } else {
            cronometro.interrupt();
            Log.d("thread stop","El Thread termino");
        }
    }
    Runnable proceso = new Runnable() {
        public void run() {
            try {
                tiempo.setText(" " + h + " : " + m + " : " + s);
                s++;
                if (s == 59) {
                    m++;
                    s = 00;
                }
                if (m == 59) {
                    h++;
                    m = 00;
                }
                Log.d("thread 2 continue","El Thread 2 aun no termina");
            } catch (Exception e) {
                Toast b = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
                b.show();
            }
        }
    };
    OnClickListener empieza = new OnClickListener() {
        public void onClick(View v) {
            bandera = true;
            banderaStop = false;
            hilador(banderaStop);
            b1.setOnClickListener(pausa);
            b1.setText("Pausa");
        }
    };
    OnClickListener pausa = new OnClickListener() {
        public void onClick(View v) {
            bandera = false;
            hilador(banderaStop);
            tiempo.setText("--> " + h  + " : " + m + " : " + s);
            b1.setText("Continuar");
            b1.setOnClickListener(continua);
        }
    };
    OnClickListener continua = new OnClickListener() {
        public void onClick(View v) {
            bandera = true;
            hilador(banderaStop);
            tiempo.setText("" + h + " : " + m + " : " + s);
            b1.setText("Pausa");
            b1.setOnClickListener(pausa);
        }
    };
    OnClickListener para = new OnClickListener() {
        public void onClick(View v) {
            bandera = false;
            banderaStop = true;
            hilador(banderaStop);
            tiempo.setText("Haga click en Iniciar Cronometro para volver a arrancar el cronometro");
            String horaString = "Tiempo Total = "+ h + ":" + m + ":" + s;
            horaTotal.setText(horaString);
            m = 00;
            s = m;
            h = m;
            b1.setText("Iniciar Cronometro");
            b1.setOnClickListener(empieza);
            b2.setText("Detenido");

        }



    };


}



