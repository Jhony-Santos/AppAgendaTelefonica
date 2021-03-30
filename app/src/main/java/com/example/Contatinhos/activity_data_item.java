package com.example.Contatinhos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.logintrabalho.R;

public class activity_data_item extends AppCompatActivity {

    EditText editTextName;
    EditText editTextAddress;
    EditText editTextPhone;
    Spinner spinner;

    Button btnSaveInfo;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_item);

        btnSaveInfo=findViewById(R.id.btnSaveInfo);

        editTextName=findViewById(R.id.editTextNameInfo);
        editTextAddress=findViewById(R.id.editTextAddressInfo);
        editTextPhone=findViewById(R.id.editTextPhoneInfo);
        spinner=findViewById(R.id.spinnerInfo);

    }
    public void btnSaveInfoClick(View view){
        Item newItem = newItem();
        Singleton.getInstance().CreatedItem(newItem);
        Toast.makeText(this, R.string.alert_success_item_created, Toast.LENGTH_SHORT).show();
        super.onBackPressed();

    }

    public Item newItem(){
        Item item=new Item();
        item.setName(editTextName.getText().toString());
        item.setAddress(editTextAddress.getText().toString());
        item.setPhone(editTextPhone.getText().toString());
        item.setType(spinner.getSelectedItem().toString());
        return item;


    }

}
