package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
Button botonSalir;
EditText txtNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        botonSalir=findViewById(R.id.bSecondSalir);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSecondSalir:
                float numero=Float.valueOf(txtNumero.getText().toString());
                Intent intent=getIntent();
                intent.putExtra("numeroElegido",numero);
                this.setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}