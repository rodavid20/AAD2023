package com.rodavid20.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rodavid20.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindings;
    private EditText etNumber1;
    private EditText etNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = bindings.btnAdd;
        etNumber1 = bindings.etNumber1;
        etNumber2 = bindings.etNumber2;
        btnAdd.setOnClickListener(v -> {
            double result = Double.parseDouble(String.valueOf(etNumber1.getText()))
                    + Double.parseDouble(String.valueOf(etNumber2.getText()));
            bindings.tvResult.setText(String.valueOf(result));
        });
    }


}