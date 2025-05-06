package com.test.anicalc;

import android.os.Bundle;
import android.view.View;
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


        // to set the plus,minus on the set on click listener

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputdisplay.length() > 0) {
                    allCalculations();
                    currentSymbol = addition;
                    outputdisplay.setText(decimalFormat.format(firstValue) + "+");
                    inputdisplay.setText(inputdisplay.getText() + "+");
                }
            }
        });

        buttonSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputdisplay.length() > 0) {
                    allCalculations();
                    currentSymbol = substraction;
                    outputdisplay.setText(decimalFormat.format(firstValue) + "-");
                    inputdisplay.setText("-");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputdisplay.length() > 0) {
                    allCalculations();
                    currentSymbol = multiplication;
                    outputdisplay.setText(decimalFormat.format(firstValue) + "*");
                    inputdisplay.setText("*");
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = division;
                outputdisplay.setText(decimalFormat.format(firstValue)+ "/");
                inputdisplay.setText("/");
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = percentage;
                outputdisplay.setText(decimalFormat.format(firstValue)+ "% of ");
                inputdisplay.setText(inputdisplay.getText() + "% of ");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputdisplay.setText(inputdisplay.getText() + ".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputdisplay.getText().length()>0){
                    CharSequence cuurentText = inputdisplay.getText();
                    inputdisplay.setText(cuurentText.subSequence(0,cuurentText.length()-1));
                }else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputdisplay.setText("");
                    outputdisplay.setText("");
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEqual.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputdisplay.setText(decimalFormat.format(firstValue));

            }
        }));

    }
//        private void allCalculations(){
//            if(!Double.isNaN(firstValue)){

//            secondValue = Double.parseDouble(inputdisplay.getText().toString());
//            inputdisplay.setText(null);
//            }
//
//            if (currentSymbol == addition) {
//                firstValue = this.firstValue + secondValue;
//                // a+b
//            } else if (currentSymbol == substraction) {
//                firstValue = this.firstValue - secondValue;
//                // a-b
//            }else if (currentSymbol == multiplication) {
//                firstValue = this.firstValue * secondValue;
//                // a*b
//            }else if (currentSymbol == division) {
//                // a/b
//                firstValue = this.firstValue / secondValue;
//            }else if (currentSymbol == percentage) {
//                // (a/100)*b
//                firstValue = (this.firstValue/100)*secondValue;
//            }else {
//                try {
//                    firstValue = Double.parseDouble(inputdisplay.getText().toString());
//                }catch (Exception e) {
//
//                }
//
//
//                }
//            }

    private void allCalculations() {
        try {
            // Get the current value from the display
            secondValue = Double.parseDouble(inputdisplay.getText().toString());

            if (!Double.isNaN(firstValue)) {
                // Perform operation based on currentSymbol
                switch (currentSymbol) {
                    case addition:
                        firstValue = firstValue + secondValue;
                        break;
                    case substraction:
                        firstValue = firstValue - secondValue;
                        break;
                    case multiplication:
                        firstValue = firstValue * secondValue;
                        break;
                    case division:
                        firstValue = firstValue / secondValue;
                        break;
                    case percentage:
                        firstValue = (firstValue / 100) * secondValue;
                        break;
                }
            } else {
                // If firstValue is NaN (i.e., it's the first input), assign it
                firstValue = secondValue;
            }

            inputdisplay.setText(""); // Clear the display after operation

        } catch (NumberFormatException e) {
            // Handle case when input is empty or invalid

        }
    }
}