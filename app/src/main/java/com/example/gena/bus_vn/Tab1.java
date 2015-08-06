package com.example.gena.bus_vn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//класс для работы с фрагментом где содержатся все маршруты автобусов
public class Tab1 extends Fragment  implements AdapterView.OnItemClickListener
{
    private GridView gridView;
    //массив данных картинка автобуса+номер маршрута
    private List<Map<String,Object>> dataList;
    private SimpleAdapter simpleAdapter;
    //массив с маршрутами
    private String[] texts= { "Маршрут 1", "Маршрут 1а", "Маршрут 2", "Маршрут 2к", "Маршрут 4", "Маршрут 5", "Маршрут 6","Маршрут 7", "Маршрут 7а", "Маршрут 8", "Маршрут 8а", "Маршрут 9","Маршрут 9а", "Маршрут 10", "Маршрут 11",
            "Маршрут 12", "Маршрут 13", "Маршрут 14", "Маршрут 15ац", "Маршрут 16", "Маршрут 17", "Маршрут 17а","Маршрут 18",
            "Маршрут 19", "Маршрут 20", "Маршрут 21", "Маршрут 22", "Маршрут 24", "Маршрут 26", "Маршрут 27а","Маршрут 32",
            "Маршрут 35", "Маршрут 35а", "Маршрут 36", "Маршрут 101" };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        // находим список
        gridView = (GridView) getView().findViewById(R.id.gridview);
        //Устанавливаем ClickListener для listview
        gridView.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) this);
        dataList=new ArrayList<Map<String,Object>>();
        dataList=getData();
        //Устанавливаем ClickListener для gridView
        simpleAdapter=new SimpleAdapter(getActivity(), dataList, R.layout.gridview_item, new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
        //подключаем наш адаптер к  listview
        gridView.setAdapter(simpleAdapter);
    }
    //заполняем массив данными
    private List<Map<String, Object>> getData()
    {
        for(int i=0;i<texts.length;i++)
        {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image",R.drawable.bus);//картинка автобуса
            map.put("text", texts[i]);      //номер маршрута
            dataList.add(map);              //добавляем в массив
        }
        return dataList;
    }
    //обработчик нажатия на элемент gridView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        Toast.makeText(getActivity(), texts[position], Toast.LENGTH_SHORT).show();
        //меняем фон выделеного элемента gridView
        view.setBackgroundResource(R.drawable.grid_fon);
        //создаем  intent для перехода на активити с остановками данного маршрута
        Intent intent = new Intent(getActivity(), time.class);
        //запускаем активити с остановками данного маршрута
        startActivity(intent);
        //делаем анимацию при переходе между активити
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        //закрываем текущую активити
        getActivity().finish();
    }
}
