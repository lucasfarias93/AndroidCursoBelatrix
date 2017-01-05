package com.belatrixsf.androidexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;
    private EditText monthYearEditText;
    private int monthNumber;
    private EditText primerOperando;
    private EditText segundoOperando;
    private EditText tercerOperando;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = (TextView) findViewById(R.id.messageTextView);
        final TextView exampleTextView = (TextView) findViewById(R.id.exampleTextView);
        final Button clickMeButton = (Button) findViewById(R.id.clickMeButton);

        monthYearEditText = (EditText) findViewById(R.id.editTextMesAño);
        final Button obtainMonthButton = (Button) findViewById(R.id.monthButton);

        primerOperando = (EditText) findViewById(R.id.editTextPrimOp);
        segundoOperando = (EditText) findViewById(R.id.editTextSegOp);
        tercerOperando = (EditText) findViewById(R.id.editTextTercOp);
        result = (TextView) findViewById(R.id.textViewResultado);
        final Button operacionButton = (Button) findViewById(R.id.operacionButton);

        final Button nextActivity = (Button) findViewById(R.id.clickMeButton);


        obtainMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    monthNumber = Integer.parseInt(monthYearEditText.getText().toString());
                    getMonthYear(monthNumber);
            }
        });

        operacionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    getOperationResult(primerOperando, segundoOperando, tercerOperando);
            }
        });
    }


    public void launchActivity(View v){
        Intent i = new Intent(this, Ejercicio2Activity.class);
        startActivity(i);
    }


    //Metodo para realizar la operacion de dos numeros, mas las operaciones de +, -, * o / segun se introduzca
    private void getOperationResult(EditText primOp, EditText segunOp, EditText tercOp) {
        String suma = "+";
        Double resultOperacion;
        Double numero1 = Double.parseDouble(primOp.getText().toString());
        Double numero2 = Double.parseDouble(tercOp.getText().toString());
        if (segunOp.getText().toString() == suma) {
            resultOperacion = numero1 + numero2;
            result.setText(resultOperacion.toString());
        } else {
            if (segunOp.getText().toString() == "-") {
                resultOperacion = numero1 - numero2;
                result.setText(resultOperacion.toString());
            } else {
                if (segunOp.getText().toString() == "*") {
                    resultOperacion = numero1 * numero2;
                    result.setText(resultOperacion.toString());
                } else {
                    if (segunOp.getText().toString() == "/") {
                        resultOperacion = numero1 / numero2;
                        result.setText(resultOperacion.toString());
                    } else {
                        Toast m1 = Toast.makeText(this, "Ingrese un operando valido de operacion", Toast.LENGTH_SHORT);
                        m1.show();
                        ;
                    }
                }
            }
        }
    }

    //Metodo para variar desde 1 a 12 y mostrar el mes correspondiente
    private void getMonthYear(int monthNumber) {
        if (monthNumber < 1 && monthNumber > 12) {
            Toast floatText = Toast.makeText(this, "Ingrese un numero de mes valido", Toast.LENGTH_SHORT);
            floatText.show();
        } else {

            switch (monthNumber) {
                case 1:
                    monthYearEditText.setText("Enero");
                    break;
                case 2:
                    monthYearEditText.setText("Febrero");
                    break;
                case 3:
                    monthYearEditText.setText("Marzo");
                    break;
                case 4:
                    monthYearEditText.setText("Abril");
                    break;
                case 5:
                    monthYearEditText.setText("Mayo");
                    break;
                case 6:
                    monthYearEditText.setText("Junio");
                case 7:
                    monthYearEditText.setText("Julio");
                    break;
                case 8:
                    monthYearEditText.setText("Agosto");
                    break;
                case 9:
                    monthYearEditText.setText("Septiembre");
                    break;
                case 10:
                    monthYearEditText.setText("Octubre");
                    break;
                case 11:
                    monthYearEditText.setText("Noviembre");
                    break;
                case 12:
                    monthYearEditText.setText("Diciembre");
                    break;
            }
        }
    }
}
