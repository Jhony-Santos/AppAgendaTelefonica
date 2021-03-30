package com.example.Contatinhos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.logintrabalho.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText imp_login;
    EditText imp_pwd;

    Button btn_login;
    Button btn_singin;

    String name;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imp_login=findViewById(R.id.imp_login);
        imp_pwd=findViewById(R.id.imp_pwd);

        btn_login=findViewById(R.id.btn_login);
        btn_singin=findViewById(R.id.btn_singin);

    }

    public void buttonLogInClicked(View view){
        if(isValidAcess()){
            redirectToList(view);
        }else{
            showAlertNotAuthSucess();
        }
    }

    public void buttonSignInClicked(View view){
        Intent intent=new Intent(MainActivity.this, activity_singin.class);
        startActivity(intent);
    }
    public void redirectToList(View view){
        Intent intent=new Intent(MainActivity.this, ListItens.class);
        startActivity(intent);
    }


    public boolean isValidAcess()  {
        boolean isValidAcess = false;
        name = imp_login.getText().toString();
        password = imp_pwd.getText().toString();

        try {


            InputStream stream = openFileInput("listUser.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            String[] aux;

            while ((line = reader.readLine()) != null) {
                aux = line.split(";");
                if (aux[0].equals(name) && aux[1].equals(password)) {
                    isValidAcess = true;
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
            return isValidAcess;
        }
    }


    public void showAlertNotAuthSucess(){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(android.R.string.dialog_alert_title);
        builder.setMessage("Usuário ou senha inválidos");
        builder.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        imp_login.setText("");
                        imp_pwd.setText("");
                    }
                }

                );


         builder.create().show();



    }


}