package com.example.personnecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailPerson extends AppCompatActivity {

    private String telephone;
    private EditText tel;
    private EditText nom;
    private EditText prenoms;
    private EditText age;
    private Button btnUpdates;
    private Button btnDeletes;
    private Helper h = new Helper(DetailPerson.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);


        nom = (EditText) findViewById(R.id.nomId);
        tel = (EditText) findViewById(R.id.telId);
        prenoms = (EditText) findViewById(R.id.prenomId);
        age = (EditText) findViewById(R.id.ageId);
        btnUpdates = (Button) findViewById(R.id.btnUpdate);
        btnDeletes = (Button) findViewById(R.id.btnDelete);
        telephone = getIntent().getStringExtra("tel");
        Person p = h.getPerson(telephone);
        nom.setText(p.getNom());
        prenoms.setText(p.getPrenom());
        age.setText(String.valueOf(p.getAge()));
        tel.setText(p.getTel());

         btnUpdates.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Person p = new Person(tel.getText().toString(), nom.getText().toString(),prenoms.getText().toString(),Integer.parseInt(age.getText().toString()));
                 h.updatePerson(p);
                 Intent i = new Intent(DetailPerson.this,ListPersons.class);
                 startActivity(i);
             }
         });

        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Person p = new Person(tel.getText().toString(), nom.getText().toString(),prenoms.getText().toString(),Integer.parseInt(age.getText().toString()));
                h.deletePerson(telephone);
                Intent i = new Intent(DetailPerson.this,ListPersons.class);
                startActivity(i);
            }

    });
    }
}