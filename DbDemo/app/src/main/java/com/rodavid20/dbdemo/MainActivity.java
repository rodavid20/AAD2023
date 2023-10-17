package com.rodavid20.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rodavid20.dbdemo.helper.CollegeDbAdapter;

public class MainActivity extends AppCompatActivity {
    CollegeDbAdapter collegeDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collegeDbAdapter = new CollegeDbAdapter(this);
        collegeDbAdapter.open();
        Button btnSave = findViewById(R.id.btnSave);
        EditText etName = findViewById(R.id.etName);
        EditText etRegNo = findViewById(R.id.etRegNo);
        EditText etDeptName = findViewById(R.id.etDeptName);
        btnSave.setOnClickListener(v -> {
            collegeDbAdapter.insertStudent(etName.getText().toString(),
                    etRegNo.getText().toString(), etDeptName.getText().toString());
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        collegeDbAdapter.close();
    }
}