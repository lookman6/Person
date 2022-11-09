package com.example.personnecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListPersons extends AppCompatActivity {

    private ListView lst;
    private Helper h = new Helper(ListPersons.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persons);

        lst = (ListView) findViewById(R.id.lst);
        Cursor c = h.getAllPersons();
        SimpleCursorAdapter adaptor = new SimpleCursorAdapter(ListPersons.this,R.layout.item,c, new String[]{c.getColumnName(1),c.getColumnName(2),c.getColumnName(3),c.getColumnName(4)},new int[]{R.id.text8,R.id.text5,R.id.text6,R.id.text7},1);
        lst.setAdapter(adaptor);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                TextView t = view.findViewById(R.id.text8);
                Intent x = new Intent(ListPersons.this, DetailPerson.class);
                x.putExtra("tel", t.getText().toString());
                startActivity(x);
            }
        });
    }
}