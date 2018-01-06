package com.example.kora.biblioteka_filmow_i_ksiazek;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Kora on 2017-12-29.
 */

public class index extends AppCompatActivity {
    int idBiblioteki;
    private ListView mListView;
    databasehelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        idBiblioteki = intent.getIntExtra("id",0);
        setContentView(R.layout.index);
        Button buttonActivity4 = (Button)findViewById(R.id.dodajf);
        buttonActivity4.setOnClickListener(new index.StartNewActivity4());

        Button buttonActivity5 = (Button)findViewById(R.id.dodajk);
        buttonActivity5.setOnClickListener(new index.StartNewActivity5());

        mListView = (ListView) findViewById(R.id.filmList);
        mDatabaseHelper = new databasehelper(this);

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getFilmsFromLibrary(idBiblioteki);
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){

            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }




    private class StartNewActivity4 implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(index.this, dodajfilm.class);
            intent.putExtra("id",idBiblioteki);
            startActivity(intent);
        }
    }
    private class StartNewActivity5 implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(index.this, dodajksiazke.class);
            startActivity(intent);
        }
    }
}