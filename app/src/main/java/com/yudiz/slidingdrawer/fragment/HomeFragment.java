package com.yudiz.slidingdrawer.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yudiz.slidingdrawer.R;
import com.yudiz.slidingdrawer.databinding.FragmentHomeBinding;


/**
 * Created by yudiz on 26/07/17.
 */

public class HomeFragment extends BaseHomeFragment {

    private FragmentHomeBinding mHomeBindng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mHomeBindng = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        return mHomeBindng.getRoot();
    }

}
