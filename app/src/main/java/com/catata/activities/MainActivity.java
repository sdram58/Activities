package com.catata.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String SALUDO = "SALUDO";
    final String TEXTO = "TEXTO";
    EditText etSaludo;
    TextView tvTextoRestaurado;
    final int RESPUESTA= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSaludo = (EditText)findViewById(R.id.etSaludo);

        tvTextoRestaurado = (TextView) findViewById(R.id.tvTextoRestore);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESPUESTA && resultCode == RESULT_OK){
            etSaludo.setText(data.getExtras().getString("RESPUESTA"));
            tvTextoRestaurado.setText(data.getExtras().getString("RESPUESTA"));
        }
    }

    public void irActividad3(View view) {
        Intent i = new Intent(this, MainActivity3.class);
        startActivityForResult(i, RESPUESTA);
    }

    public void irActividad2(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        Bundle extras = new Bundle();
        extras.putString(SALUDO,etSaludo.getText().toString());
        i.putExtras(extras);
        startActivity(i);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        String texto = tvTextoRestaurado.getText().toString();
        savedInstanceState.putString(TEXTO, texto);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String texto = savedInstanceState.getString(TEXTO);
        tvTextoRestaurado.setText(texto);
    }
}