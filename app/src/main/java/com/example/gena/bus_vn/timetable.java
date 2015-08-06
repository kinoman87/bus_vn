package com.example.gena.bus_vn;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.melnykov.fab.FloatingActionButton;

public class timetable extends ActionBarActivity
{
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter2 adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Рабочие дни","Выходные"};
    int Numboftabs =2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new ViewPagerAdapter2(getSupportFragmentManager(),Titles,Numboftabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });
        tabs.setViewPager(pager);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
          case android.R.id.home:
              finish();
                this.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
             return true;
       }
        return super.onOptionsItemSelected(item);
    }


}