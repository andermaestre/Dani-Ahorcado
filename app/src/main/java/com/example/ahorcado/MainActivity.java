package com.example.ahorcado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout lv;
    VistaJuego vista;
    String []palabras;
    EditText txtletra;
    Button btnIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.layoutVista);
        vista=new VistaJuego(this);
        lv.addView(vista);
        palabras=getResources().getStringArray(R.array.palabras);
        btnIntro=findViewById(R.id.button);
        txtletra=findViewById(R.id.txtLetra);
        btnIntro.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     if (item.getItemId()==R.id.mnuNuevo)
     {
        vista.nuevaPalabra(palabras);
     }
     else
     {
         finish();
     }
     return true;
    }

    @Override
    public void onClick(View v) {
        if(v==btnIntro)
        {
            vista.introducirLetra(txtletra.getText().charAt(0));
        }
    }
}
