package com.mcdoodle.checkvirtualenv;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    public static final String PREFS_NAME = "DUMMY";

    public static String savePreferences(Context context, String key, String value) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        try {
            settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            editor = settings.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static String loadPreferences(Context context, String key) {
        SharedPreferences settings;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String value = settings.getString(key, "");
        return value;

    }

    public static boolean logout(Context context){
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.clear();
        editor.commit();
        return true;
    }
}