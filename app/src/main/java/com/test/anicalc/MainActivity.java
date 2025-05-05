package com.test.anicalc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char addition = '+';
    private static final char substraction = '-';
    private static final char multiplication = '*';
    private static final char division = '/';
    private static final char percentage = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputdisplay, outputdisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private MaterialButton buttonAdd, buttonSubs, buttonMul, buttonDiv, buttonDot, buttonPercent, buttonClear, buttonAC, buttonEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        decimalFormat = new DecimalFormat("#.####");

        inputdisplay = findViewById(R.id.inputDisplay);
        outputdisplay = findViewById(R.id.outputDisplay);

        button0 = findViewById(R.id.Number_0);
        button1 = findViewById(R.id.Number_1);
        button2 = findViewById(R.id.Number_2);
        button3 = findViewById(R.id.Number_3);
        button4 = findViewById(R.id.Number_4);
        button5 = findViewById(R.id.Number_5);
        button6 = findViewById(R.id.Number_6);
        button7 = findViewById(R.id.Number_7);
        button8 = findViewById(R.id.Number_8);
        button9 = findViewById(R.id.Number_9);

        buttonAdd = findViewById(R.id.Plus);
        buttonSubs = findViewById(R.id.Minus);
        buttonMul = findViewById(R.id.multiply);
        buttonDiv = findViewById(R.id.Divide);
        buttonDot = findViewById(R.id.Dot);
        buttonPercent = findViewById(R.id.percent);
        buttonAC = findViewById(R.id.ac);
        buttonClear = findViewById(R.id.clear);
        buttonEqual = findViewById(R.id.Equals_To);


        private void allCalculations(){
            if(!Double.isNaN(firstValue)){
            secondValue = Double.parseDouble(inputdisplay.getText().toString());
            inputdisplay.setText(null);
            }

            if (currentSymbol == addition) {
                firstValue = this.firstValue + secondValue;
                // a+b
            } else if (currentSymbol == substraction) {
                firstValue = this.firstValue - secondValue;
                // a-b
            }else if (currentSymbol == multiplication) {
                firstValue = this.firstValue * secondValue;
                // a*b
            }else if (currentSymbol == division) {
                // a/b
                firstValue = this.firstValue / secondValue;
            }else if (currentSymbol == percentage) {
                // (a/100)*b
                firstValue = (this.firstValue/100)*secondValue;
            }else {
                try {
                    firstValue = Double.parseDouble(inputdisplay.getText().toString());
                }catch (Exception e) {

                }
                }
            }
        }


    }
}