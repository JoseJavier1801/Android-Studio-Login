package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        // Obtener el nombre de usuario de los extras del intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USERNAME")) {
            String username = intent.getStringExtra("USERNAME");

            TextView welcomeTextView = findViewById(R.id.textViewWelcome);
            welcomeTextView.setText(R.string.welcome+ username + "!");
        }

        Toast.makeText(this, getString(R.string.welcome_to_home), Toast.LENGTH_SHORT).show();

    }

    protected void onStart() {
        super.onStart();
    }

    // Método para cerrar sesión
    public void INICIO(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}