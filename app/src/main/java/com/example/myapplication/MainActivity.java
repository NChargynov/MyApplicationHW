package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine, subtraction, addition,
            divide, multiply, equal, dot;

    TextView resultTV;

    String rawOperand = "";
    Double firstOperand;
    Double secondOperand;
    String operation;
    Double result;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            zero = findViewById(R.id.btn_zero);
            one = findViewById(R.id.btn_one);
            two = findViewById(R.id.btn_two);
            three = findViewById(R.id.btn_three);
            four = findViewById(R.id.btn_four);
            five = findViewById(R.id.btn_five);
            six = findViewById(R.id.btn_six);
            seven = findViewById(R.id.btn_seven);
            eight = findViewById(R.id.btn_eight);
            nine = findViewById(R.id.btn_nine);
            subtraction = findViewById(R.id.btn_subtraction);
            addition = findViewById(R.id.btn_addition);
            divide = findViewById(R.id.btn_divide);
            multiply = findViewById(R.id.btn_multiply);
            equal = findViewById(R.id.btn_equal);
            dot = findViewById(R.id.btn_dot);
            resultTV = findViewById(R.id.resultTV);

            if (savedInstanceState != null) {
                firstOperand = savedInstanceState.getDouble("first");
                secondOperand = savedInstanceState.getDouble("second");
                operation = savedInstanceState.getString("oper");
                rawOperand = savedInstanceState.getString("rawOper");
                result = savedInstanceState.getDouble("result");
            }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (firstOperand != null){
            outState.putDouble("first", firstOperand);
        } if (secondOperand != null){
            outState.putDouble("second", secondOperand);
        } if (rawOperand != null){
            outState.putString("rawOper", rawOperand);
        } if (operation != null){
            outState.putString("oper", operation);
        } if (result != null ){
            outState.putDouble("result", result);
        }
    }

    public void onNumberClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zero:
                enterNumber("0");
                break;
            case R.id.btn_one:
                enterNumber("1");
                break;
            case R.id.btn_two:
                enterNumber("2");
                break;
            case R.id.btn_three:
                enterNumber("3");
                break;
            case R.id.btn_four:
                enterNumber("4");
                break;
            case R.id.btn_five:
                enterNumber("5");
                break;
            case R.id.btn_six:
                enterNumber("6");
                break;
            case R.id.btn_seven:
                enterNumber("7");
                break;
            case R.id.btn_eight:
                enterNumber("8");
                break;
            case R.id.btn_nine:
                enterNumber("9");
                break;
            case R.id.btn_dot:
                enterNumber(".");
                break;
            default:
                break;

        }
    }

    public void enterNumber(String number) {
        resultTV.append(number);
        rawOperand += number;
    }

    public void onOperationClick(View v) {
        try {
            if (firstOperand == null) {
                firstOperand = Double.parseDouble(rawOperand);
            } else {
                secondOperand = Double.parseDouble(rawOperand);
            }
            rawOperand = "";
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (v.getId()) {
            case R.id.btn_addition:
                enterOperation("+");
                break;
            case R.id.btn_multiply:
                enterOperation("*");
                break;
            case R.id.btn_divide:
                enterOperation("/");
                break;
            case R.id.btn_subtraction:
                enterOperation("-");
                break;
            case R.id.btn_equal:
                if (operation != null) {
                    switch (operation) {
                        case "+":
                            result = firstOperand + secondOperand;
                            resultTV.append("=" + result);
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            resultTV.append("=" + result);
                            break;
                        case "/":
                            result = firstOperand / secondOperand;
                            resultTV.append("=" + result);
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            resultTV.append("=" + result);
                            break;
                            default:
                                break;
                    }
                }
            default:
                break;
        }

    }

    public void enterOperation(String operation) {
        resultTV.append(operation);
        this.operation = operation;
    }
}
