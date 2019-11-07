package com.example.mvp_sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView {

    EditText nameText;
    SharedPreferences pref;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText=findViewById(R.id.nameText);
        pref=getPreferences(MODE_PRIVATE);

        presenter=new MainPresenter(this);
    }


    public void onSave(boolean result){
        if(result)
            Toast.makeText(this, "Saved Successfullty", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    //CLICK
    public void save(View view) {
        presenter.save(nameText.getText().toString());
    }
    public void load(View view) {
        presenter.load("name");
    }

    @Override
    public void OnSave(boolean success) {

    }

    @Override
    public void OnLoad(boolean success) {

    }
}
