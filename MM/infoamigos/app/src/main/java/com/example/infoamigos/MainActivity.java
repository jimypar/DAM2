package com.example.infoamigos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.infoamigos.bd.Database;
import com.example.infoamigos.util.Amigo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button add;
    private Database db;
    ArrayList<Amigo> listaAmigos;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.bMainAdd);
        add.setOnClickListener(this);



        db = new Database(this);

        listaAmigos = new ArrayList<>();
        listaAmigos=db.getAmigos();

        lvLista= findViewById(R.id.lvListMain);
        lvLista.setAdapter(new ArrayAdapter<Amigo>(
                                this, android.R.layout.simple_list_item_1,listaAmigos));

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bMainAdd:
                Intent i = new Intent(this, AddActivity.class);
                startActivity(i);
                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAmigos=db.getAmigos();
        lvLista.setAdapter(new ArrayAdapter<Amigo>(
                this, android.R.layout.simple_list_item_1,listaAmigos));
    }
}