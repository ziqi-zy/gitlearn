package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_text;
    Button btn_num0;
    Button btn_num1;
    Button btn_num2;
    Button btn_num3;
    Button btn_num4;
    Button btn_num5;
    Button btn_num6;
    Button btn_num7;
    Button btn_num8;
    Button btn_num9;
    Button btn_equal;
    Button btn_point;
    Button btn_clean;
    Button btn_del;
    Button btn_clear;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button Leftparenthesis;
    Button Rightparenthesis;
    String etinput;
    boolean clear_flag;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text = findViewById(R.id.edit_text);
        btn_num0 = findViewById(R.id.btn_0);
        btn_num1 = findViewById(R.id.btn_1);
        btn_num2 = findViewById(R.id.btn_2);
        btn_num3 = findViewById(R.id.btn_3);
        btn_num4 = findViewById(R.id.btn_4);
        btn_num5 = findViewById(R.id.btn_5);
        btn_num6 = findViewById(R.id.btn_6);
        btn_num7 = findViewById(R.id.btn_7);
        btn_num8 = findViewById(R.id.btn_8);
        btn_num9 = findViewById(R.id.btn_9);
        Button btn_point= findViewById(R.id.btn_point);
        Button Leftparenthesis= findViewById(R.id.btn_left);
        Button Rightparenthesis= findViewById(R.id.btn_right);
        Button btn_clear=findViewById(R.id.btn_clear);
        Button btn_del= findViewById(R.id.btn_del);
        Button btn_plus= findViewById(R.id.btn_plus);
        Button btn_multiply= findViewById(R.id.btn_multiply);
        Button btn_divide= findViewById(R.id.btn_divide);
        Button btn_minus=findViewById(R.id.btn_minus);
        btn_equal= findViewById(R.id.btn_equal);

        btn_num0.setOnClickListener(this);
        btn_num1.setOnClickListener(this);
        btn_num2.setOnClickListener(this);
        btn_num3.setOnClickListener(this);
        btn_num4.setOnClickListener(this);
        btn_num5.setOnClickListener(this);
        btn_num6.setOnClickListener(this);
        btn_num7.setOnClickListener(this);
        btn_num8.setOnClickListener(this);
        btn_num9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        Leftparenthesis.setOnClickListener(this);
        Rightparenthesis.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);


    }
    public void onClick(View view) {
        etinput = edit_text.getText().toString();
        String etTemp="";
        switch (view.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag) { etClear(); }
                etTemp = etinput + ((Button)view).getText();
                showText(etTemp);
                break;

            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag) { etClear(); }
                etTemp = etinput + " " + ((Button)view).getText() + " ";
                showText(etTemp);
                break;
            case R.id.btn_clear:
                etClear();
                break;
            case R.id.btn_del:
                if (clear_flag) {
                    etClear();
                } else if (etinput != null && !etinput.equals(" ")) {
                    etTemp = etinput.substring(0, etinput.length() - 1);
                    showText(etTemp);
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
            default:
                break;
        }
    }

    private void etClear() {
        clear_flag = false;
        etinput = "";
        edit_text.setText("");
    }

    private void showText(String etTemp) {
        edit_text.setText(etTemp);
        edit_text.setSelection(etTemp.length());
    }

    private void getResult() {
        String dataIn = etinput;
        double result = 0;

        if (dataIn == null || dataIn.equals("")) {
            return;
        }
        if (!dataIn.contains(" ")) {
            return;
        }

        String str1 = dataIn.substring(0, dataIn.indexOf(" "));
        String operator = dataIn.substring(dataIn.indexOf(" ") + 1, dataIn.indexOf(" ") + 2);
        String str2 = dataIn.substring(dataIn.indexOf(" ") + 3);

        double data1 = Double.parseDouble(str1);
        double data2 = Double.parseDouble(str2);

        switch (operator) {
            case "+":
                result = data1 + data2;
                break;
            case "-":
                result = data1 - data2;
                break;
            case "*":
                result = data1 * data2;
                break;
            case "/":
                if (data2 == 0) {
                    etClear();
                    break;
                }
                result = data1 / data2;
                break;
        }

        if (!str1.contains(".") && !str2.contains(".") && !operator.equals("/")) {
            edit_text.setText(dataIn + "=" + (int)result);
            return;
        }
        edit_text.setText(dataIn + "=" + result);
    }
}