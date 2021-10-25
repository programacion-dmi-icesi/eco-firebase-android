package com.example.eco_semana_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private EditText usernameTE, nombreTE, edadTE, passTE;
    private Button regBtn, verBtn;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTE = findViewById(R.id.usernameTE);
        nombreTE = findViewById(R.id.nombreTE);
        edadTE = findViewById(R.id.edadTE);
        passTE = findViewById(R.id.passTE);

        regBtn = findViewById(R.id.regBtn);
        verBtn = findViewById(R.id.verBtn);

        db = FirebaseDatabase.getInstance();

        regBtn.setOnClickListener((view)->{
            // Obtener referencia
            DatabaseReference users = db.getReference("users");
            DatabaseReference newUser = users.push();


            User user = new User(
                usernameTE.getText().toString(),
                nombreTE.getText().toString(),
                edadTE.getText().toString(),
                passTE.getText().toString(), newUser.getKey()
            );

            newUser.setValue(user);
        });

        verBtn.setOnClickListener((view) -> {
            // ir a Actividad Detalle
            Intent listado = new Intent(this, ListadoActivity.class);
            startActivity(listado);
        });
    }
}