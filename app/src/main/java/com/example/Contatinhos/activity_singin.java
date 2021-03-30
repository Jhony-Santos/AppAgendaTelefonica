package com.example.Contatinhos;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logintrabalho.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class activity_singin extends AppCompatActivity {
    EditText imp_login;
    EditText imp_pwd;

    ArrayList<String> userPasswordsList=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        imp_login=findViewById(R.id.imp_login);
        imp_pwd=findViewById(R.id.imp_pwd);

    }

    public void SalvarUsuario(View view){
        try{
            OutputStream stream = activity_singin.this.openFileOutput("listUser.txt", MODE_PRIVATE);
            OutputStreamWriter writer=new OutputStreamWriter(stream);

            writer.write("admin; admin123");

            writer.flush();
            writer.close();
            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
