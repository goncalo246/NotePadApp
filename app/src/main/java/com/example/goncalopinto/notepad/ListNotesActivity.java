package com.example.goncalopinto.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNotesActivity extends AppCompatActivity {

    private static int RESULT_ACTIVITY = 1;
    private ArrayAdapter<String> arrayAdapter ;
    private ArrayList<Nota> notas = new ArrayList<Nota>();
    private ArrayList<String> titulos = new ArrayList<String>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulos);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent novo = new Intent(getApplicationContext(),ReadNoteActivity.class);
                novo.putExtra("tituloNota", notas.get(i).getTitulo());
                novo.putExtra("corpoNota", notas.get(i).getCorpo());
                startActivity(novo);
            }
        });
    }

    public void addNote(View view){
        Intent i = new Intent(this,CreateNoteActivity.class);
        startActivityForResult(i, RESULT_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RESULT_ACTIVITY){
            if(resultCode==RESULT_OK){
                Nota nota = new Nota(data.getStringExtra("titulo"),data.getStringExtra("corpo"));
                adicionarNotas(nota);
                Toast.makeText(this,""+titulos.size()+"   "+data.getStringExtra("titulo"),Toast.LENGTH_LONG).show();
                arrayAdapter.notifyDataSetChanged();
            }else if(resultCode==RESULT_CANCELED){

            }
        }
    }


    private void adicionarNotas (Nota nota){
        notas.add(nota);
        titulos.add(nota.getTitulo());
    }
}
