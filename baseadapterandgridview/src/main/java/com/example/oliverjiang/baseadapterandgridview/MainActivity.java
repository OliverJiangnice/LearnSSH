package com.example.oliverjiang.baseadapterandgridview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ImageView imageView;
    private int[] imageids = new int[]{R.drawable.girl,R.drawable.girla,R.drawable.girlb,
    R.drawable.girlc,R.drawable.girld,R.drawable.girle,R.drawable.girlf,R.drawable.girlg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0;i <imageids.length;i++){
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("image",imageids[i]);
            list.add(listItem);

        }
        imageView = (ImageView)findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.cell,new String[]{"image"},
                new int[]{R.id.imageViewCell});
        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageids[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageids[position]);
            }
        });
    }
}
