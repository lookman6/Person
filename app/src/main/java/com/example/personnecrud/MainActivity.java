package com.example.personnecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tel;
    private EditText nom;
    private EditText prenom;
    private EditText age;
    private Button btnAdd;
    private Helper h = new Helper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.nomId);
        prenom=(EditText) findViewById(R.id.prenomId);
        tel =(EditText) findViewById(R.id.telId);
        age =(EditText) findViewById(R.id.ageId);
        btnAdd =(Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p = new Person(tel.getText().toString(),nom.getText().toString(),prenom.getText().toString(),Integer.parseInt(age.getText().toString()));
                h.insertPerson(p);
                Intent i = new Intent(MainActivity.this, ListPersons.class);
                startActivity(i);
            }
        });
    }
}