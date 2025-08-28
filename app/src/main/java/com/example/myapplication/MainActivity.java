package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText etUsername = findViewById(R.id.edUsuario);
        EditText etPassword = findViewById(R.id.edPassword);
        Button boton = findViewById(R.id.bIngresar);
        Button abrirActivity = findViewById(R.id.btnAbrirActivity);

        abrirActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MainActivity.this, MainActivity4.class);
                pantalla.putExtra("nombre","Harold");
                pantalla.putExtra("edad",29);
                startActivity(pantalla);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                } else if (user.equals("admin") && pass.equals("1234")) {
                    Toast.makeText(MainActivity.this, "✅ Login exitoso", Toast.LENGTH_SHORT).show();
                    Intent pantalla = new Intent(MainActivity.this, MainActivity2.class);
                    pantalla.putExtra("user",user);
                    startActivity(pantalla);
                } else {
                    Toast.makeText(MainActivity.this, "❌ Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Intent pantalla = new Intent(MainActivity.this, MainActivity3.class);
                    pantalla.putExtra("user",user);
                    startActivity(pantalla);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}