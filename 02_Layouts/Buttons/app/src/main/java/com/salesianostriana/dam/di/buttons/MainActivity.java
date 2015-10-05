package com.salesianostriana.dam.di.buttons;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnHello, btnBye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Rescato el botón con id buttonHello
        btnHello = (Button) findViewById(R.id.buttonHello);
        // Le asocio el evento onClick al buttonHello
        btnHello.setOnClickListener(this);

        // Rescato el botón con id buttonBye
        btnBye = (Button) findViewById(R.id.buttonBye);
        // Le asocio el evento onClick al buttonBye
        btnBye.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonHello: Log.i("HOLA","Hola weiiiiiiiii!");
                break;
            case R.id.buttonBye: Log.i("ADIOS","Adiós weiiiiiiiiii!");
                break;
        }
    }
}
