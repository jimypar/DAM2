package com.example.infoamigos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.infoamigos.bd.Database;
import com.example.infoamigos.util.Amigo;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    Button add;
    private Database db;
    ArrayList<Amigo> listaAmigos;
    ListView lvLista;
    Amigo amigoSeleccionado;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.bMainAdd);
        add.setOnClickListener(this);

        info = findViewById(R.id.tMainInfo);

        db = new Database(this);

        listaAmigos = new ArrayList<>();
        listaAmigos=db.getAmigos();

        lvLista= findViewById(R.id.lvListMain);
        lvLista.setAdapter(new ArrayAdapter<Amigo>(
                                this, android.R.layout.simple_list_item_1,listaAmigos));

        lvLista.setOnItemLongClickListener(this);
        registerForContextMenu(lvLista);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){

            case R.id.lvListMain:
                getMenuInflater().inflate(R.menu.menu_contextual,menu);
                break;
        }


        getMenuInflater().inflate(R.menu.menu_contextual,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        amigoSeleccionado = listaAmigos.get(i);
        info.setText(amigoSeleccionado.getId()+" - "+amigoSeleccionado.getNombreApellidos());


        return false;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_borrar:
                db.eliminarAmigo(amigoSeleccionado);
                onResume();
                break;
            case R.id.menu_detalle:
                break;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_config:
                break;
            case R.id.menu_about:

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}