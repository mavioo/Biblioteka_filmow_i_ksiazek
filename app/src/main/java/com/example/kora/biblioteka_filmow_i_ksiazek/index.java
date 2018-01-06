package com.example.kora.biblioteka_filmow_i_ksiazek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by Kora on 2017-12-29.
 */

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Button buttonActivity4 = (Button)findViewById(R.id.dodajf);
        buttonActivity4.setOnClickListener(new index.StartNewActivity4());

        Button buttonActivity5 = (Button)findViewById(R.id.dodajk);
        buttonActivity5.setOnClickListener(new index.StartNewActivity5());
    }
    private class StartNewActivity4 implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(index.this, dodajfilm.class);
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