package com.example.appagenda;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class atividade_dados_contato extends AppCompatActivity {

    EditText nome_contato;
    EditText endereco_contato;
    EditText telefone_contato;
    Spinner spinnerDados;

    Button btn_salvar_dados;

    boolean isUpdate;
    int positionToUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_dados_contato);

        btn_salvar_dados = findViewById(R.id.btn_salvar_dados);

        nome_contato = findViewById(R.id.nome_contato);
        endereco_contato = findViewById(R.id.endereco_contato);
        telefone_contato = findViewById(R.id.telefone_contato);
        spinnerDados = findViewById(R.id.spinnerDados);

        if (ContatoSingleton.getInstance().itemIndex != -1) {
            isUpdate = true;
            positionToUpdate = ContatoSingleton.getInstance().itemIndex;
            Contato item = ContatoSingleton.getInstance().listItems.get(positionToUpdate);
            fillFieldsUpdate(item);
        }
    }


    public void btnSalveInfoClick(View view) {
        Contato newItem = newItem();
        if (isUpdate) ContatoSingleton.getInstance().updateItem(newItem);
        else ContatoSingleton.getInstance().createItem(newItem);

        saveItemToFile();

        Toast.makeText(atividade_dados_contato.this, R.string.alert_success_item_created_updated, Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }


    public void saveItemToFile() {
        try {
            OutputStream stream = atividade_dados_contato.this.openFileOutput("listItems.txt", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(stream);

            for (int i = 0; i < ContatoSingleton.getInstance().listItems.size(); i++) {
                writer.write(ContatoSingleton.getInstance().listItems.get(i).toString());
                writer.write("\n");
            }

            writer.flush();
            writer.close();

            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Contato newItem() {
        Contato item = new Contato();
        item.setIdUser(UsuarioSingleton.getInstance().userIndex);
        item.setName(nome_contato.getText().toString());
        item.setAddress(endereco_contato.getText().toString());
        item.setPhone(telefone_contato.getText().toString());
        item.setType(spinnerDados.getSelectedItem().toString());
        return item;
    }


    public void fillFieldsUpdate(Contato item) {
        nome_contato.setText(item.getName());
        endereco_contato.setText(item.getAddress());
        telefone_contato.setText(item.getPhone());

        String spinnerValue = item.getType();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDados.setAdapter(adapter);

        int spinnerPosition = adapter.getPosition(spinnerValue);
        spinnerDados.setSelection(spinnerPosition);
    }

}