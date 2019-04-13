package otes06.br.example.udesc.roomteste;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    private int id;

    private String name;
    private String pass;

    public User(int id, String name, String pass){
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static User[] populateUsers(){
        User[] users = {
                new User(1, "root", "ROOT"),
                new User(2, "test", "TEST123")
        };
        return users;
    }

    @Override
    public String toString() {

        return this.name;
    }
}
