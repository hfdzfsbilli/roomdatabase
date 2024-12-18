package com.example.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.entitas.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Insert
    void insertAll(Mahasiswa... mahasiswas);

    @Delete
    void delete(Mahasiswa mahasiswa);

    @Query("UPDATE mahasiswa SET full_name=:full_name, nim=:nim WHERE id=:id")
    void update(int id, String full_name, String nim);

    @Query("SELECT * FROM mahasiswa WHERE id=:id")
    Mahasiswa get(int id);

}
