package com.mobileia.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileia.core.Mobileia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configurar Mobileia Lab
        Mobileia.getInstance().setAppId(4);
        // Ejemplos de RetroFit
        new RestServiceExample().getServices();
    }
}
