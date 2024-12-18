package com.example.roomdatabase.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nim;

    @ColumnInfo(name = "full_name")
    public String fullname;
}
