package com.rodavid20.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences
                = getSharedPreferences("SharedPreferencesDemo", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        etName.setText(name);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", etName.getText().toString());
        editor.apply();
    }
}