package com.example.mvp_sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    Presenter preseneter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        preseneter=new MainPresenter(this);
    }

    public void save(View view) {
        preseneter.save(nameText.getText().toString(),(b)->{
            if (b)
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        });

    }

    public void load(View view) {

        preseneter.load("name",(s)->{
            nameText.setText(s);
        });

    }
}
