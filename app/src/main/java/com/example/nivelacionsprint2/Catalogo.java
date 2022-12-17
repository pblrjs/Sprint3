package com.example.nivelacionsprint2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.nivelacionsprint2.Adaptadores.ProductoAdapter;
import com.example.nivelacionsprint2.Entidades.Producto;

import java.util.ArrayList;

import com.example.nivelacionsprint2.DB.DBFirebase;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        dbFirebase = new DBFirebase();
        arrayProducts = new ArrayList<>();
        /*// *** Creacion de productos
        Producto producto1 = new Producto("Bajo electrico", "Instrumento de cuerda", 860, R.drawable.bajo_electrico);
        Producto producto2 = new Producto("Bajo sexto", "Instrumento de cuerda", 550, R.drawable.bajo_sexto);
        Producto producto3 = new Producto("Guitarra electrica", "Instrumento de cuerda", 450, R.drawable.guitarra_electrica);
        Producto producto4 = new Producto("Guitarra acustica", "Instrumento de cuerda", 350, R.drawable.guitarra_acustica);
        Producto producto5 = new Producto("Piano de cola", "Instrumento de cuerda percutida", 2500, R.drawable.piano_cola);
        Producto producto6 = new Producto("Saxofon", "Instrumento de viento", 1200, R.drawable.saxo);
        Producto producto7 = new Producto("Viola", "Instrumento de cuerda frotada", 760, R.drawable.viola);
        Producto producto8 = new Producto("Violin", "Instrumento de cuerda frotada", 630, R.drawable.violin);
        Producto producto9 = new Producto("Violonchelo", "Instrumento de cuerda frotada", 780, R.drawable.ic_launcher_foreground);

        dbFirebase.insertData(producto1);
        dbFirebase.insertData(producto2);
        dbFirebase.insertData(producto3);
        dbFirebase.insertData(producto4);
        dbFirebase.insertData(producto5);
        dbFirebase.insertData(producto6);
        dbFirebase.insertData(producto7);
        dbFirebase.insertData(producto8);
        dbFirebase.insertData(producto9);
        */
        /*
        arrayProducts.add(producto1);
        arrayProducts.add(producto2);
        arrayProducts.add(producto3);
        arrayProducts.add(producto4);
        arrayProducts.add(producto5);
        arrayProducts.add(producto6);
        arrayProducts.add(producto7);
        arrayProducts.add(producto8);
        arrayProducts.add(producto9);
        */
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        productoAdapter = new ProductoAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productoAdapter);

        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.additem:
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}