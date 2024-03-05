package com.example.apiconsumer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apiconsumer.modelo.personajeFinal;

public class MainActivity extends AppCompatActivity {
    public Button consultar;
    public EditText buscar;
    public String respuesta = "", imagen = "";
    public personajeFinal personaje = new personajeFinal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consultar = findViewById(R.id.consultar);
        buscar = findViewById(R.id.buscar);

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumir rg = new consumir();
                try {
                    rg.resultado(buscar.getText().toString());
                    muestraToast("Procesando...");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            personaje = rg.personajeFinal;
                            respuesta = "ID: " + personaje.getId() + "\n" +
                                    "Nombre: " + personaje.getSlug() + "\n" +
                                    "Nacimiento: " + personaje.getBorn() + "\n" +
                                    "Genero: " + personaje.getGender() + "\n" +
                                    "Casa: " + personaje.getHouse() + "\n";
                            if(!respuesta.equals("")){
                                Intent intent = new Intent(MainActivity.this, consultaFinal.class);
                                intent.putExtra("Información", respuesta);
                                intent.putExtra("Imagen", imagen);
                                startActivity(intent);
                            }
                        }
                    },5000);
                }catch (Exception exception){
                    muestraToast("Error " + exception);
                }
            }
        });
    }

    private void muestraToast(String mensaje) {
        Toast.makeText(this, "" +  mensaje, Toast.LENGTH_LONG).show();
    }
}