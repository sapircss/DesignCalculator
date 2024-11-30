package com.example.designcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1, num2;
    String operator ="";

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
        result = findViewById(R.id.viewResult);
        result.setText("");
    }
    public void numbersFunc(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void operationFunc(View view) {
        Button btn = (Button) view;
        String op = btn.getText().toString();
        switch (op){
            case "AC":
                    String str;
                    str = result.getText().toString();
                    if(str.length() > 0)
                    {
                        str = str.substring(0, str.length()-1);
                        result.setText(str);
                    }
                        break;
            case "c":
                result.setText("");
                num1=0;
                num2=0;
                operator ="";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = op;
                num1 = Double.parseDouble(result.getText().toString());
                result.setText("");
                break;

            case "=":
                if(!operator.isEmpty())
                {
                    num2 = Double.parseDouble(result.getText().toString());
                    double res = calculate(num1, num2, operator);
                    result.setText(String.valueOf(res));
                    num1 = res;
                }
                break;


            default:
               result.append(op);
        }

    }
    double calculate (double num1, double num2, String op)
    {
        switch (op)
        {
            case "+" : return (num1 + num2);
            case "-" : return (num1 - num2);
            case "*" : return (num1 * num2);
            case "/": return (num2 != 0) ? num1 / num2 : 0;
            default: return 0;

        }
    }

}