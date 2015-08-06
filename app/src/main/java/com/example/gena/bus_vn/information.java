package com.example.gena.bus_vn;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

public class information extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.fab:
                try
                {
                   finish();
                   this.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
}