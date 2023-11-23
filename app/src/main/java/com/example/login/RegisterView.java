package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterView extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    public String FIXED_USERNAME;
    public  String FIXED_PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        usernameEditText = findViewById(R.id.editTextRegisterUsername);
        passwordEditText = findViewById(R.id.editTextRegisterPassword);
        Toast.makeText(this, R.string.welcome_to_registration, Toast.LENGTH_SHORT).show();

    }

    protected void onStart(){
        super.onStart();
    }

    public boolean isValidRegistration(String username, String password) {
        FIXED_USERNAME=username;
        FIXED_PASSWORD=password;
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Método para el botón de registro
    public void onRegisterUserClick(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (isValidRegistration(username, password)) {
            showToast(getString(R.string.registration_successful));

            // Crear un intent de retorno con la información de registro
            Intent returnIntent = new Intent();
            returnIntent.putExtra("USERNAME", username);
            returnIntent.putExtra("PASSWORD", password);
            setResult(RESULT_OK, returnIntent);

            finish(); // Cierra la actividad después del registro
        } else {
            showToast(getString(R.string.registration_error));
        }
    }


    // Método para el botón de volver a iniciar sesión
    public void ATRAS(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}