package com.example.gena.bus_vn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import fragment.MainFragment;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (savedInstanceState == null)
        {
            loadFragment(new MainFragment());
        }
    }
    public void loadFragment(final Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commit();

    }

}