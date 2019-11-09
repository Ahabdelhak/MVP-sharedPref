package com.example.mvp_sharedprefrence;

import androidx.core.util.Consumer;

public interface  Presenter {

    void save(String s, Consumer<Boolean> consumer);
    void load(String s,Consumer<String> consumer);
}
