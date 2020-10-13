package com.catata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvSaludo = (TextView)findViewById(R.id.tvSaludo);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String s = getIntent().getExtras().getString("SALUDO");
            tvSaludo.setText(s);
        }else{
            tvSaludo.setText("No hay saludo");
        }





    }

    public void volver(View view) {
        this.finish();
    }
}