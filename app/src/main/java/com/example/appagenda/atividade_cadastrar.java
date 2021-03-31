package com.example.appagenda;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class atividade_cadastrar extends AppCompatActivity {

    EditText nome_usuario_cadastro;
    EditText senha_usuario_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_cadastrar);

        nome_usuario_cadastro = findViewById(R.id.nome_usuario_cadastro);
        senha_usuario_cadastro = findViewById(R.id.senha_usuario_cadastro);
    }

    public void salvarUsuario(View view) {
        try {
            OutputStream stream = atividade_cadastrar.this.openFileOutput("listUser.txt", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(stream);

            String name = nome_usuario_cadastro.getText().toString();
            String password = senha_usuario_cadastro.getText().toString();

            for(int i = UsuarioSingleton.getInstance().usuarioList.size(); i>0; i--) {
                writer.write(UsuarioSingleton.getInstance().usuarioList.get(i-1).toString());
                writer.write("\n");
            }

            writer.write(name + ";" + password);
            writer.write("\n");

            UsuarioSingleton.getInstance().addUserList(new Usuario(name, password));

            writer.flush();
            writer.close();
            writer.close();

            Toast.makeText(atividade_cadastrar.this, R.string.alert_success_user_created, Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}