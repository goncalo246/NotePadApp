package com.example.goncalopinto.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void guardar_nota(View view){
        String titulo = ((EditText)findViewById(R.id.titulo)).getText().toString();
        String corpo = ((EditText)findViewById(R.id.corpo)).getText().toString();
        Intent i = new Intent();
        i.putExtra("titulo", titulo);
        i.putExtra("corpo",corpo);
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    public void cancelar_nota(View view){
        Intent i = new Intent();
        setResult(Activity.RESULT_CANCELED,i);
        finish();
    }
}
