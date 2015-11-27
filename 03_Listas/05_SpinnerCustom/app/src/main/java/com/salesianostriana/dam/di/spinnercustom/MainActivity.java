package com.salesianostriana.dam.di.spinnercustom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerAvatars;
    private ArrayList<ItemAvatar> avatares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAvatars = (Spinner)findViewById(R.id.spinnerAvatars);
        avatares = new ArrayList<ItemAvatar>();
        avatares.add(new ItemAvatar("Agent Coulson",1));
        avatares.add(new ItemAvatar("Black Widow",2));
        avatares.add(new ItemAvatar("Captain America",3));
        avatares.add(new ItemAvatar("Giant Man",4));
        avatares.add(new ItemAvatar("Hawkeye",5));
        
        AvatarSpinnerAdapter adapter = new AvatarSpinnerAdapter(this,R.layout.spinner_item_avatar,avatares);
        adapter.setDropDownViewResource(R.layout.spinner_item_avatar);
        spinnerAvatars.setAdapter(adapter);
    }
}
