package com.rodavid20.spinnerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.etInput);

        Spinner spOptions = findViewById(R.id.spOptions);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.app_list,
                        android.R.layout.simple_spinner_item);
        /*String[] languages = new String[3];
        languages[0] = "Kannada";
        languages[1] ="English";
        languages[2] ="Hindi";*/

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOptions.setAdapter(adapter);

        spOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String input = "";
                switch (i){
                    case 0:
                        input = "https://";
                        //www.google.com
                        break;
                    case 1:
                        input = "geo:";
                        //37,48
                        break;
                    case 2:
                        input = "tel:";
                        //92342424
                        break;
                }
                input += etInput.getText().toString();
                Uri data = Uri.parse(input);
                Intent intent = new Intent(Intent.ACTION_VIEW, data);
                //startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.new_page) {
            Toast.makeText(this, "New", Toast.LENGTH_SHORT).show();
            return true;
        } else if(item.getItemId() ==  R.id.edit_page) {
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}