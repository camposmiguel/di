package com.salesianostriana.dam.di.miprimermenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String mensaje = "";
        switch(id) {
            case R.id.action_search: mensaje = "Buscar...";
                break;
            case R.id.action_configuration: mensaje = "Configuración...";
                break;
            case R.id.action_logout: mensaje = "Salir...";
                break;
        }

        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
