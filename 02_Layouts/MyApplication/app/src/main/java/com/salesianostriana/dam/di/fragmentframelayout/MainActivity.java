package com.salesianostriana.dam.di.fragmentframelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout contenedor;
    Button btnCambio;
    boolean cargoUsuarios = false;
    UsuariosFragment usuariosFragment;
    GraficaFragment graficaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedor = (FrameLayout)findViewById(R.id.contenedor_fragment);
        btnCambio = (Button)findViewById(R.id.buttonCambiarFragment);

        // Instancio Usuarios Fragment y Graficas Fragment
        usuariosFragment = new UsuariosFragment();
         graficaFragment = new GraficaFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor_fragment, usuariosFragment).commit();


        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cargoUsuarios) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor_fragment,usuariosFragment).commit();
                    cargoUsuarios = false;

                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor_fragment,graficaFragment).commit();
                    cargoUsuarios = true;
                }


            }
        });
    }
}
