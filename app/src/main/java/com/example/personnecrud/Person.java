package com.example.personnecrud;

public class Person {

    int _id;
    String _tel;
    String nom;
    String prenom;
    int age;

    public Person(int id,String tel, String nom, String prenom, int age) {
        this._tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Person(int id,String tel, String nom, String prenom) {
        this._tel = tel;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Person(String tel, String nom, String prenom, int age) {
        this._tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Person(String tel, String nom, String prenom) {
        this._tel = tel;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Person() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTel() {
        return _tel;
    }

    public void setTel(String tel) {
        this._tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
