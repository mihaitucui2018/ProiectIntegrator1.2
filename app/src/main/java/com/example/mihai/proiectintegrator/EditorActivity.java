package com.example.mihai.proiectintegrator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mihai.proiectintegrator.database.MyInventoryDBHelper;

public class EditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        TextView buttonSave = (TextView) findViewById(R.id.save_button_produs);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numeProdus=(EditText) findViewById(R.id.Camp_nume);
                EditText codProdus=(EditText) findViewById(R.id.Camp_COD);
                String stringNume = numeProdus.getText().toString();
                int intCod = Integer.parseInt(codProdus.getText().toString());

                MyInventoryDBHelper mHelper = new MyInventoryDBHelper(getApplicationContext());
                SQLiteDatabase myData = mHelper.getWritableDatabase();
                mHelper.insertEntry(stringNume, intCod);
                startActivity(new Intent(EditorActivity.this, ListaProduseActivity.class));
            }
        });
    }
}
