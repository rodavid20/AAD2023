package com.rodavid20.httpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = findViewById(R.id.btnSend);
        queue = Volley.newRequestQueue(this);
        TextView tvMessage = findViewById(R.id.tvMessage);
        btnSend.setOnClickListener(v ->{
            String url = "https://rodavid2012.pythonanywhere.com/add?a=10&b=2";
            StringRequest request = new StringRequest(Request.Method.GET,
                    url,
                    (response) -> {
                        tvMessage.setText(response);
                     },
                    (error) -> {
                        tvMessage.setText(error.getMessage());
                    });

            queue.add(request);
        });
    }
}