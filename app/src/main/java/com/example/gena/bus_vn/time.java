package com.example.gena.bus_vn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

//Класс для работы с активити со списком остановок (активити с кружочками)
public class time extends Activity  implements View.OnClickListener
{
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.time);
        // находим список
        ListView lvMain = (ListView) findViewById(R.id.listView1);
        lvMain.setDivider(null);//убираем рамку вокруг элемента ListView
        //массив остановок
        String[] values = new String[] { "Лодочная станция отпр.", "Б.Московская стадион", "НГТРК Славия",
                "ул.Советской Армии", "Сметанинская Мыза приб.", "Сметанинская Мыза отпр.", "ул.Советской Армии", "Б. Московская ТЦ Антоново",
                "Лодочная станция приб." };
        //Создаем custom adapter для listview
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
        //подключаем наш адаптер к  listview
        lvMain.setAdapter(adapter);

        //Устанавливаем ClickListener для listview
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            //обработка нажатия
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                //создаем  intent для перехода на активити с временем остановок
               Intent intent = new Intent(getBaseContext(), timetable.class);
                //запускаем активити  с временем остановок
               startActivity(intent);
                //делаем анимацию при переходе между активити
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
        });
        //Находим нашу Float Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //Устанавливаем ClickListener для Float Action Button
        fab.setOnClickListener(this);
    }
    //обработка нажатия на FloatingActionButton (т.е. на кнопку "назад")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.fab:
                try
                {
                    //создаем  intent для перехода на предыдущую активити
                    Intent intent = new Intent(this, bus_schedule.class);
                    //запускаем активити со списком
                    startActivity(intent);
                    //делаем анимацию при переходе между активити
                    this.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
                    //закрываем текущую активити
                    finish();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }

}
