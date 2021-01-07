package com.example.roomprototype.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String occupation;

    public Contact() {
    }

    //As id is a PK, it will be automatically generate, therefore, it doesn't need to go into the constructor.
    public Contact(@NonNull String name, @NonNull String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public int getId() { return id; }
    public String getName() {
        return name;
    }
    public String getOccupation() {
        return occupation;
    }

    //I don't think these need to be here. The documentation mentions nothing about having setters. If I don't place them here, the code won't compile and is throwing the error:
    //error: Cannot find setter for field. private String name;
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
