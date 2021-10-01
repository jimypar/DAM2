package com.example.infoamigos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
ImageView iv;
final int CARGA_IMAGEN = 42;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        iv = findViewById(R.id.iAdd);
        iv.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case (R.id.ivImage1):
                Intent intent = new Intent(this, ImageActivity.class);
                startActivityForResult(intent, CARGA_IMAGEN);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK && requestCode==CARGA_IMAGEN && data!=null){
            int resultado = data.getExtras().getInt("Imagen_selecionada");
            switch (resultado){
                case 1: iv.setImageDrawable(getResources().getDrawable(R.drawable.d));
                break;
                case 2: iv.setImageDrawable(getResources().getDrawable(R.drawable.d1));
                    break;
                case 3: iv.setImageDrawable(getResources().getDrawable(R.drawable.d2));
                    break;
                case 4: iv.setImageDrawable(getResources().getDrawable(R.drawable.d3));
                    break;
                case 5: iv.setImageDrawable(getResources().getDrawable(R.drawable.d4));
                    break;
                case 6: iv.setImageDrawable(getResources().getDrawable(R.drawable.d5));
                    break;
            }
        }

    }
}