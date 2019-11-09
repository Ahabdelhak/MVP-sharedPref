package com.example.mvp_sharedprefrence;

import android.content.SharedPreferences;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import androidx.core.util.Consumer;

public class Model {


    ExecutorService pool;
    private SharedPreferences preferences;
    private Presenter presenter;

    public Model(SharedPreferences preferences, Presenter presenter) {
        this.preferences = preferences;
        this.presenter = presenter;
        pool = Executors.newFixedThreadPool(2);
    }
    public void ModelSave(String name, Consumer<Boolean> consumer) {


        Future<Boolean> future = pool.submit(() -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", name);
            boolean commit = editor.commit();

            return commit;
//            consumer.accept(commit);
//            presenter.onSave(true);

//            consumer.accept(true);


        });

        Boolean aBoolean = null;
        try {
            aBoolean = future.get();
            consumer.accept(aBoolean);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void modelLoad(String s, Consumer<String> consumer) {

        String string = preferences.getString(s, "");
        consumer.accept(string);
    }
}