package com.yudiz.slidingdrawer.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by yudiz on 26/07/17.
 */

public class Prefrences {

    private static Prefrences mPrefrences;
    private SharedPreferences mSharedPreferences;

    private Prefrences(Context context) {
        mSharedPreferences =
                context.getSharedPreferences(context.getApplicationInfo().name, context.MODE_PRIVATE);
    }

    public static Prefrences getPrefrenceInstance(@NonNull Context context) {
        if (mPrefrences == null) {
            mPrefrences = new Prefrences(context);
        }

        return mPrefrences;
    }

    public void putData(Keys keys, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(keys.toString(), value);
        editor.apply();
        editor.commit();
    }

    public String getName() {
        return mSharedPreferences.getString(Keys.NAME.toString(), "Guest User!!");
    }

    enum Keys {NAME}
}
