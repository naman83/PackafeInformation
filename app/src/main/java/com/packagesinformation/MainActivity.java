package com.packagesinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.packageinfo.controller.AppInfo;
import com.packageinfo.model.App;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView ;
    private ArrayList<App> mList ;
    private MyAdapter myAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppInfo appInfo = AppInfo.getAppInfo(this) ;

        mList = new ArrayList<>() ;
        mList = appInfo.getAllApps();
        Log.v("finalSize",appInfo.getAllApps().size()+"");


            mRecyclerView = (RecyclerView)findViewById(R.id.rv_apps) ;

           mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(appInfo.getAllApps()) ;


        mRecyclerView.setAdapter(myAdapter);


        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position)
            {
                Intent i = new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("positionSelected",position) ;
                startActivity(i);
            }
        });


    }
}
