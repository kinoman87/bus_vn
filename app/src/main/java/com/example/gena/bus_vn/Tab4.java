package com.example.gena.bus_vn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

//класс для работы с фрагментом где содержатся все маршруты автобусов
public class Tab4 extends Fragment implements AdapterView.OnItemClickListener
{
    static final String[] Hours =
            new String[] { "5", "6", "7", "8","9", "10", "11", "12","13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    static final String[] Minutes =
            new String[] { "5", "6", "7", "8","9", "10", "11", "12",};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.tab_4,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) getView().findViewById(R.id.lv);
        listView.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) this);
        CustomArrayAdapter caa;
        caa = new CustomArrayAdapter(getActivity(), Hours,Minutes);
        listView.setAdapter(caa);
    }

    //обработчик нажатия на элемент gridView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        // Toast.makeText(getActivity(), texts[position], Toast.LENGTH_SHORT).show();
        //меняем фон выделеного элемента gridView
        //    view.setBackgroundResource(R.drawable.grid_fon);
        //создаем  intent для перехода на активити с остановками данного маршрута
        ///    Intent intent = new Intent(getActivity(), time.class);
        //запускаем активити с остановками данного маршрута
        //    startActivity(intent);
        //делаем анимацию при переходе между активити
        //     getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        //закрываем текущую активити
        //    getActivity().finish();
    }
}
