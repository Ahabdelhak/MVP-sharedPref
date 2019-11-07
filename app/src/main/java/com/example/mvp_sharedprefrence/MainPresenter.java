package com.example.mvp_sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPresenter implements Presenter{


    //1:07 Video

    private MainView mainView;
    SharedPreferences pref;
    ExecutorService pool;


    public MainPresenter(MainView activity){
        this.mainView =(MainActivity) activity;
        pref=((MainActivity)mainView).getPreferences(Context.MODE_PRIVATE);

        pool = Executors.newFixedThreadPool(2);
    }


    public void save(String name){
        //Don't Forget to make project support Lambda exce

        //threading to make fun on save call after shared pref commit finished
        pool.execute(()->{
            SharedPreferences.Editor editor=pref.edit();
            editor.putString("name",name);
            editor.commit();

            mainView.OnSave(true);

        });

    }

    public void load(String name){

    }
}
