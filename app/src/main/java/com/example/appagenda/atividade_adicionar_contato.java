package com.example.appagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class atividade_adicionar_contato extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_adicionar_contato);

        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContatoSingleton.getInstance().itemIndex = ContatoSingleton.getInstance().getPositionUpdate(position);
                Intent intent = new Intent(atividade_adicionar_contato.this, atividade_dados_contato.class);
                startActivity(intent);
            }
        });

        atualizarContatos();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        atualizarContatos();
    }


    public void btn_adicionar_contato(View view) {
        ContatoSingleton.getInstance().itemIndex = -1;
        Intent intent = new Intent(atividade_adicionar_contato.this, atividade_dados_contato.class);
        startActivity(intent);
    }


    public void atualizarContatos() {
        carregarDados();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                atividade_adicionar_contato.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                ContatoSingleton.getInstance().getFilteredListItem()
        );

        listView.setAdapter(adapter);
    }


    public void carregarDados() {
        try {
            InputStream stream = openFileInput("listItems.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);

            BufferedReader reader = new BufferedReader(streamReader);
            String line;

            ArrayList<Contato> item = new ArrayList<>();
            String[] aux;

            while((line = reader.readLine()) != null) {
                aux = line.split(";");
                item.add(new Contato(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4]));
            }

            ContatoSingleton.getInstance().listItems = item;

            reader.close();
            streamReader.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}