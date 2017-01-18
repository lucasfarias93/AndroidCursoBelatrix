package com.example.lucas.serviceexample;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

/**
 * Created by LUCAS on 17/01/2017.
 */

public class Cronometro extends Service {

    private Timer temporizador = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 10; // En ms
    public static MyServiceActivity UPDATE_LISTENER;
    private double cronometro = 0;
    private Handler handler;

    /**
     * Establece quien va ha recibir las actualizaciones del cronometro
     * @param myService
     */
    public static void setUpdateListener(MyServiceActivity myService) {
        UPDATE_LISTENER = myService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        iniciarCronometro();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                UPDATE_LISTENER.actualizarCronometro(cronometro);
            }
        };
    }

    @Override
    public void onDestroy() {
        pararCronometro();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    private void iniciarCronometro() {
        temporizador.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                cronometro += 0.01;
                handler.sendEmptyMessage(0);
            }
        }, 0, INTERVALO_ACTUALIZACION);
    }

    private void pararCronometro() {
        if (temporizador != null)
            temporizador.cancel();
            cronometro = 0.0;

    }

}
