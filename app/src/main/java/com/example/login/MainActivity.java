package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REGISTER_REQUEST_CODE = 1;
    public EditText usernameEditText, passwordEditText;
    private String registeredUsername, registeredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);


    }

    protected void onStart() {
        super.onStart();
    }

    public void IniciarSesion(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            Intent intent = new Intent(this, HomeView.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        }else{
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    public void Registrarse(View view) {
        // Lógica para el clic del botón de registro
        startActivityForResult(new Intent(this, RegisterView.class), REGISTER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_REQUEST_CODE && resultCode == RESULT_OK) {
            // Obtener la información de registro del intent de retorno
            registeredUsername = data.getStringExtra("USERNAME");
            registeredPassword = data.getStringExtra("PASSWORD");

            // Realizar acciones con la información de registro
            // Por ejemplo, mostrar un mensaje o actualizar las vistas
        }
    }
}
