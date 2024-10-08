package com.example.lr_4_melkov_andrey;

public class MainActivitySingleton {
    private static MainActivity mainActivity;

    public static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }
}
