package com.example.firebasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public DatabaseReference usuarios = reference.child("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.child("003").child("login").setValue("DnlBoga");
        usuarios.child("003").child("nome").setValue("Daniel Lima");
        usuarios.child("003").child("senha").setValue("SenhaSegura");
    }
}