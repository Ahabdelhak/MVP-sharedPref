package com.example.mvp_sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.core.util.Consumer;

public class MainPresenter implements Presenter {

    MainActivity mainActivity;
    SharedPreferences pref;

    Model model;

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        pref=mainActivity.getPreferences(Context.MODE_PRIVATE);
        model= new Model(pref,this);
    }

    @Override
    public void save(String s, Consumer<Boolean> consumer) {

        model.ModelSave(s,consumer);

    }

    @Override
    public void load(String s,Consumer<String> consumer) {
        model.modelLoad(s,consumer);

    }
}
