package com.rodavid20.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.rodavid20.firebasedemo.model.Student;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        TextView tvMessage = findViewById(R.id.tvMessage);
        Student student = new Student("ABC","CSE");
        tvMessage.setText("Started");
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            db.collection("students")
                    .add(student)
                    .addOnCompleteListener(task -> {
                        tvMessage.setText("Complete " + task.isSuccessful());
                    }).addOnFailureListener(e -> {
                        tvMessage.setText("Failure " + e.getMessage());
                    });
        });

        Button btnRetrieve =  findViewById(R.id.btnRetrieve);
        btnRetrieve.setOnClickListener(v -> {
            db.collection("students")
                    .whereEqualTo("deptName", "CSE")
                    .get()
                    .addOnCompleteListener(task -> {
                       if(task.isSuccessful()){
                           for(QueryDocumentSnapshot document: task.getResult()){
                               Student s = document.toObject(Student.class);
                               tvMessage.setText(s.getName());
                           }
                       }
                    });
        });

    }
}