package com.example.appagenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nome_usuario;
    EditText senha_usuario;

    Button btn_entrar;
    Button btn_cadastrar;

    String nome;
    String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_principal);

        nome_usuario = findViewById(R.id.nome_usuario);
        senha_usuario = findViewById(R.id.senha_usuario);

        btn_entrar = findViewById(R.id.btn_entrar);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        carregarArquivoUsuario();
    }


    public void btn_entrarAcionado(View view) {
        if (autenticacao()) {
            redirecionarParaLista(view);
        } else {
            showAlertNotAuthSuccess();
        }
    }


    public void btn_cadastrarAcionado(View view) {
        Intent intent = new Intent(MainActivity.this, atividade_cadastrar.class);
        startActivity(intent);
    }


    public void redirecionarParaLista(View view) {
        Intent intent = new Intent(com.example.appagenda.MainActivity.this, atividade_adicionar_contato.class);
        startActivity(intent);
    }


    public boolean autenticacao() {

        boolean autenticao = false;
        nome = nome_usuario.getText().toString();
        senha = senha_usuario.getText().toString();

        try {

            InputStream stream = openFileInput("listUser.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            String[] aux;

            int cont = -1;
            while ((line = reader.readLine()) != null) {
                cont++;
                aux = line.split(";");
                if (aux[0].equals(nome) && aux[1].equals(senha)) {
                    autenticao = true;
                    UsuarioSingleton.getInstance().userIndex = cont;
                }
            }

            reader.close();
            streamReader.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return autenticao;
        }

    }


    public void carregarArquivoUsuario() {

        try {
            InputStream stream = openFileInput("listUser.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;

            ArrayList<Usuario> usuarioList = new ArrayList<>();
            String[] aux;

            while((line = reader.readLine()) != null) {
                aux = line.split(";");
                usuarioList.add(new Usuario(aux[0], aux[1]));
            }

            UsuarioSingleton.getInstance().usuarioList = usuarioList;

            reader.close();
            streamReader.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showAlertNotAuthSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(android.R.string.dialog_alert_title);
        builder.setMessage(R.string.alert_error_auth);
        builder.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nome_usuario.setText("");
                        senha_usuario.setText("");
                    }
                }
        );

        builder.create().show();
    }
}