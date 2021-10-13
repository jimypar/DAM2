package com.example.util_idades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button calculator,conversor,conecta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = findViewById(R.id.bMain1);
        calculator.setOnClickListener(this);
        conversor = findViewById(R.id.bMain2);
        conversor.setOnClickListener(this);
        conecta4 = findViewById(R.id.bMain3);
        conecta4.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent();

        switch (view.getId()){

            case(R.id.bMain1):
                i = new Intent(this, CalculadoraActivity.class);
                startActivity(i);
                break;

            case(R.id.bMain2):
                i = new Intent(this, ConversorActivity.class);
                startActivity(i);
                break;

            case(R.id.bMain3):
                i = new Intent(this, Conecta4Activity.class);
                startActivity(i);
                break;

        }

    }
}