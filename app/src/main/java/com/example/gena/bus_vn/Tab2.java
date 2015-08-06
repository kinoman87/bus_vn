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


public class Tab2 extends Fragment implements AdapterView.OnItemClickListener
{
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    private SimpleAdapter simpleAdapter;
    private int images[] = { R.drawable.troll, R.drawable.troll, R.drawable.troll };
    private String[] texts= { "Маршрут 1", "Маршрут 2", "Маршрут 3" };

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

        gridView = (GridView) getView().findViewById(R.id.gridview);
        gridView.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) this);
        dataList=new ArrayList<Map<String,Object>>();
        dataList=getData();
        simpleAdapter=new SimpleAdapter(getActivity(), dataList, R.layout.gridview_item, new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
        gridView.setAdapter(simpleAdapter);
    }

    private List<Map<String, Object>> getData()
    {
        for(int i=0;i<images.length;i++)
        {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("text", texts[i]);
            dataList.add(map);
        }
        return dataList;
    }
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        Toast.makeText(getActivity(), texts[position], Toast.LENGTH_SHORT).show();
        view.setBackgroundResource(R.drawable.grid_fon);
        Intent intent = new Intent(getActivity(), time.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        getActivity().finish();
        //view.setBackgroundResource(R.drawable.grid_press);
    }
}
