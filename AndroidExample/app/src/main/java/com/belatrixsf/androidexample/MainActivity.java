package com.belatrixsf.androidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    private TextView messageTextView;
    private EditText monthYearEditText;
    private String monthEntrance;
    private int monthNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = (TextView) findViewById(R.id.messageTextView);
        final TextView exampleTextView = (TextView) findViewById(R.id.exampleTextView);
        final Button clickMeButton = (Button) findViewById(R.id.clickMeButton);

        monthYearEditText = (EditText) findViewById(R.id.editTextMesAño);
        final Button obtainMonthButton = (Button) findViewById(R.id.monthButton);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exampleTextView.setText("Counter: " + (++counter));
                updateMessage(true);
            }
        });

        obtainMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    monthNumber = Integer.parseInt(monthYearEditText.getText().toString());
                    getMonthYear(monthNumber);
            }
        });
    }

    /**
     * This method updates the text on messageTextView.
     *
     * @param switchExample
     */
    private void updateMessage(boolean switchExample) {
        if (switchExample) {
            switch (counter) {
                case 1:
                    messageTextView.setText("One");
                    break;
                case 2:
                    messageTextView.setText("Double counter!");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    messageTextView.setText("Counting...");
                case 7:
                    messageTextView.setText("Seven!!!!!");
                default:
                    messageTextView.setText("Too much!!!!");
            }
        } else {

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
                case 2:
                    monthYearEditText.setText("Febrero");
                case 3:
                    monthYearEditText.setText("Marzo");
                case 4:
                    monthYearEditText.setText("Abril");
                case 5:
                    monthYearEditText.setText("Mayo");
                case 6:
                    monthYearEditText.setText("Junio");
                case 7:
                    monthYearEditText.setText("Julio");
                case 8:
                    monthYearEditText.setText("Agosto");
                case 9:
                    monthYearEditText.setText("Septiembre");
                case 10:
                    monthYearEditText.setText("Octubre");
                case 11:
                    monthYearEditText.setText("Noviembre");
                default:
                    monthYearEditText.setText("Diciembre");
            }
        }
    }
}
