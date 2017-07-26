package com.yudiz.slidingdrawer.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;

import com.yudiz.slidingdrawer.activity.MainActivity;


/**
 * Created by yudiz on 26/07/17.
 */

public  class BaseHomeFragment extends Fragment {

    private MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    protected void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) mainActivity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (canHideKeyboard()) {
            inputManager.hideSoftInputFromWindow(mainActivity.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private boolean canHideKeyboard() {
        return mainActivity.getCurrentFocus() != null;
    }


}
