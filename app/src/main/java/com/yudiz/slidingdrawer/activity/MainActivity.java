package com.yudiz.slidingdrawer.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.yudiz.slidingdrawer.R;
import com.yudiz.slidingdrawer.adapter.DrawerMenuItem;
import com.yudiz.slidingdrawer.databinding.ActivityMainBinding;
import com.yudiz.slidingdrawer.fragment.HomeFragment;

import static com.yudiz.slidingdrawer.pref.Prefrences.getPrefrenceInstance;


public class MainActivity extends BaseHomeActivity {

    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setDrawerLayout();
        showDefaultFragment();
        setToolbar(mActivityMainBinding.activityMainToolbar);
    }

    private void showDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, new HomeFragment());
        fragmentTransaction.commit();
    }

    private void setDrawerLayout() {
        mActivityMainBinding.activityDrawerLayout.drawerTvProfileName.setText(
                getPrefrenceInstance(this).getName());

        DrawerMenuItem drawerMenuItem = new DrawerMenuItem(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mActivityMainBinding.activityDrawerLayout.drawerMenuItem.setLayoutManager(linearLayoutManager);
        mActivityMainBinding.activityDrawerLayout.drawerMenuItem.setAdapter(drawerMenuItem);
    }

    public DrawerLayout getDrawerlayout() {
        return mActivityMainBinding.activityMain;
    }

    protected void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        ActionBarDrawerToggle toolbarDrawerToggle = new ActionBarDrawerToggle(
                this,
                getDrawerlayout(),
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
            }
        };
        getDrawerlayout().setDrawerListener(toolbarDrawerToggle);
        toolbarDrawerToggle.syncState();
    }
}
