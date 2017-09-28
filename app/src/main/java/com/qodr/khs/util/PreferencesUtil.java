package com.qodr.khs.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kodeartisan on 19/09/17.
 */

public class PreferencesUtil {

    public static final String TAG = PreferencesUtil.class.getSimpleName();

    private static PreferencesUtil mInstance;

    private static final String SETTING = "setting";

    private static SharedPreferences sharedPreferences;

    private PreferencesUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private PreferencesUtil(Context context) {
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE);
        }


    }

    public static PreferencesUtil newInstance(Context context) {
        if(mInstance == null) {
            return new PreferencesUtil(context);
        }

        return mInstance;

    }

    public  String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public boolean putString(String key, String value) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);

        return editor.commit();
    }
}
