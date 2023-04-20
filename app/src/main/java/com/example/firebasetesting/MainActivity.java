package com.example.firebasetesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public DatabaseReference usuariosBanco = reference.child("Usuario");
    public DatabaseReference GuardaID = reference.child("GuardaID").child("IdAlto");
    public EditText InputNome, InputLogin, InputSenha;
    public Button CadastrarBtn;
    String idAltoString = "";
    Integer idAlto = 0;
    Integer id = 0;
    //public ListView ListaUsu;
    //public List<Usuarios> ListaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputLogin = (EditText) findViewById(R.id.InputLogin);
        InputNome = (EditText) findViewById(R.id.InputNome);
        InputSenha = (EditText) findViewById(R.id.InputSenha);
        CadastrarBtn = (Button) findViewById(R.id.CadastrarBtn);
        //ListaUsu = (ListView) findViewById(R.id.ListaUsu);

        GuardaID.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot.getValue().toString());
                idAltoString = snapshot.getValue().toString();
                idAlto = Integer.parseInt(idAltoString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        CadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar();
            }
        });
    }

    public void Cadastrar() {
        id = ++idAlto;
        GuardaID.setValue(id);
        Usuarios usuarios = new Usuarios();
        usuarios.setLogin(InputLogin.getText().toString());
        usuarios.setNome(InputNome.getText().toString());
        usuarios.setSenha(InputSenha.getText().toString());
        usuariosBanco.child(id.toString()).setValue(usuarios);
    }
}