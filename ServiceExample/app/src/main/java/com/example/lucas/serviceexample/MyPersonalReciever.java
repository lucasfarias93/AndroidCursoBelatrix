package com.example.lucas.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by LUCAS on 17/01/2017.
 */
public class MyPersonalReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Se ha reiniciado el cronometro", Toast.LENGTH_SHORT).show();
    }
}
