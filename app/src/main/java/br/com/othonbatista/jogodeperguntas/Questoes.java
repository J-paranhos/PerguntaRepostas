package br.com.othonbatista.jogodeperguntas;

import android.text.Editable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Tabela
public class Questoes {
    //primary id
    @PrimaryKey(autoGenerate = true)
    private int id;


    public String pergunta;

    public String resposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }


}
