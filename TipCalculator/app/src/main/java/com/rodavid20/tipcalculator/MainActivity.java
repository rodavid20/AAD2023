package com.rodavid20.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etTotalBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnCalculate);
        etTotalBill = findViewById(R.id.etTotalBill);

        btnAdd.setOnClickListener(v -> {
            double result = Double.parseDouble(String.valueOf(etTotalBill.getText())) * 0.1;
            TextView tvResult = findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(result));
        });
    }
}