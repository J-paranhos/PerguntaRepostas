package br.com.othonbatista.jogodeperguntas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestoesDao {

    @Query("SELECT * FROM questoes")
    List<Questoes> getAll();

    @Insert
    void insertAll(Questoes...Questoes);
}
