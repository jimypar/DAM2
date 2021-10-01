package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonPrimero;
    Button botonEmail;
    Button botonSiguiente;
    TextView texto1;
    EditText email;
    private final int ELEGIR_NUMERO=45;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ELEGIR_NUMERO && resultCode==RESULT_OK && data!=null){
            float numero=data.getExtras().getFloat("numeroElegido");
            texto1.setText(Float.toString(numero));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonPrimero = findViewById(R.id.bMainBotonPrimero);
        texto1 = findViewById(R.id.tMainEtiqueta);
        botonEmail = findViewById(R.id.bMainMail);
        email=findViewById(R.id.tMainEmail);
        botonSiguiente=findViewById(R.id.bMainSiguiente);
        botonPrimero.setOnClickListener(this);
        botonEmail.setOnClickListener(this);
        botonSiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bMainBotonPrimero:
                texto1.setText("Has pulsado algo");
                break;
            case R.id.bMainMail:
                texto1.setText(email.getText());
                break;
            case R.id.bMainSiguiente:
                Intent intent=new Intent(this,SecondActivity.class);
                startActivityForResult(intent,ELEGIR_NUMERO);
                break;
        }

    }
    /**
    @Override
    protected void onResume() {
        super.onResume();
        texto1.setText("Has Vuelto");
    }
    **/
}