package com.example.eco_semana_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Edits;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListadoActivity extends AppCompatActivity {

    private TextView listadoTV;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listadoTV = findViewById(R.id.listadoTV);
        db = FirebaseDatabase.getInstance();

        obtenerUsuarios();
    }

    public void obtenerUsuarios(){
        DatabaseReference usersRef = db.getReference("users");
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot users) {
                listadoTV.setText("");
                for (DataSnapshot userSnapshot: users.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    listadoTV.append( user.getNombre() + " : "+user.getEdad() + "\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("FirebaseError", error.getDetails());
            }
        });
    }
}