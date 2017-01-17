package com.example.lucas.androidfundamentalslesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson2ExcersiceAcrivity extends AppCompatActivity {

    private ImageView imagen1;
    private ImageView imagen2;
    private ImageView imagen3;
    private ImageView imagen4;
    private ImageView imagen5;
    private ImageView imagen6;
    private ImageView imagen8;
    private ImageView imagen9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_excersice_acrivity);

        imagen1 = (ImageView) findViewById(R.id.imageView);
        imagen2 = (ImageView) findViewById(R.id.imageView2);
        imagen3 = (ImageView) findViewById(R.id.imageView3);
        imagen4 = (ImageView) findViewById(R.id.imageView4);
        imagen5 = (ImageView) findViewById(R.id.imageView5);
        imagen6 = (ImageView) findViewById(R.id.imageView6);
        imagen8 = (ImageView) findViewById(R.id.imageView8);
        imagen9 = (ImageView) findViewById(R.id.imageView9);

    }
    public void clickNew(View v){
        Intent i = new Intent(Lesson2ExcersiceAcrivity.this, Excersive2Activity.class);
        startActivity(i);
    }
}
