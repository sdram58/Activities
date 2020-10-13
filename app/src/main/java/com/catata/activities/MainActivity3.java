package com.catata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText etResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etResponder = (EditText)findViewById(R.id.etRespuesta);
    }

    public void responder(View view) {
        Intent i=getIntent();
        i.putExtra("RESPUESTA", etResponder.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}