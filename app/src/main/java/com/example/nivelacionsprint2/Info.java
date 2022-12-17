package com.example.nivelacionsprint2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nivelacionsprint2.DB.DBFirebase;
import com.example.nivelacionsprint2.Entidades.Producto;

public class Info extends AppCompatActivity {
    private EditText ditTextPersonName, editTextDescriptionInfo, editTextPriceInfo;
    private Button btnInfo;
    private DBFirebase dbFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ditTextPersonName= (EditText) findViewById(R.id.editTextPersonName);
        editTextDescriptionInfo = (EditText) findViewById(R.id.editTextDescriptionInfo);
        editTextPriceInfo= (EditText) findViewById(R.id.editTextPriceInfo);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        dbFirebase = new DBFirebase();

        Intent intentIN = getIntent();
        ditTextPersonName.setText(intentIN.getStringExtra("Name"));
        editTextDescriptionInfo.setText(intentIN.getStringExtra("description"));
        editTextPriceInfo.setText(String.valueOf(intentIN.getIntExtra("price",0)));


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto(
                        ditTextPersonName.getText().toString(),
                        editTextDescriptionInfo.getText().toString(),
                        Integer.parseInt(editTextPriceInfo.getText().toString()),
                        R.drawable.clave_sol

                );
                dbFirebase.insertData(producto);
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}