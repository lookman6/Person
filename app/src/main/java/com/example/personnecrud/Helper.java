package com.example.personnecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable Context context) {
        super(context, "personManager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Person(_id INTEGER PRIMARY KEY, _tel TEXT UNIQUE , nom TEXT, prenom TEXT, age INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Person");
        onCreate(db);

    }

    public void insertPerson(Person p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_tel",p.getTel());
        cv.put("nom",p.getNom());
        cv.put("prenom",p.getPrenom());
        cv.put("age",p.getAge());
        db.insert("Person", null,  cv);
        db.close();
    }

    public void updatePersonId(Person p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_tel", p.getTel());
        cv.put("nom",p.getNom());
        cv.put("prenom",p.getPrenom());
        cv.put("age",p.getAge());
        db.update("Person",cv,"_id=?",new String[]{String.valueOf(p.get_id())});
        db.close();
    }

    public void updatePerson(Person p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_tel", p.getTel());
        cv.put("nom",p.getNom());
        cv.put("prenom",p.getPrenom());
        cv.put("age",p.getAge());
        db.update("Person",cv,"_tel=?",new String[]{p.getTel()});
        db.close();
    }

    public void deletePersonId(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete("Person","_id=?",new String[]{String.valueOf(id)});
         db.close();
    }

    public void deletePerson(String tel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Person","_tel=?",new String[]{tel});
        db.close();
    }

    public Cursor getAllPersons()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Person", null);
        return c;
    }

    public Person getPersonId(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("Person",new String[]{"_tel","nom","prenom","age"},"_id=?",new String[]{String.valueOf(id)},null,null,null);
        c.moveToFirst();
        Person p = new Person(c.getString(0),c.getString(1),c.getString(2),c.getInt(3));
        return p;
    }

    public Person getPerson(String tel)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("Person",new String[]{"_tel","nom","prenom","age"},"_tel=?",new String[]{tel},null,null,null);
        c.moveToFirst();
        Person p = new Person(c.getString(0),c.getString(1),c.getString(2),c.getInt(3));
        return p;
    }
}
