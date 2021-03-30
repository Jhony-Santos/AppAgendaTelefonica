package com.example.Contatinhos;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logintrabalho.R;

public class ListItens extends AppCompatActivity {
    ListView listView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_itens);

        listView=findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Singleton.getInstance().itemIndex=position;
                Intent intent=new Intent(ListItens.this, activity_data_item.class);
                startActivity(intent);

            }
        });

        updateList();
    }

    protected void updateList(){
        ArrayAdapter<Item> adapter=new ArrayAdapter<>(
                ListItens.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                Singleton.getInstance().getListItens()

        );
        listView.setAdapter(adapter);
    }

    protected void onRestart(){
        super.onRestart();
        updateList();
    }

    public void buttonAddClicked(View view){
        Singleton.getInstance().itemIndex=-1;
        Intent intent= new Intent(ListItens.this, activity_data_item.class);
        startActivity(intent);
    }

}
