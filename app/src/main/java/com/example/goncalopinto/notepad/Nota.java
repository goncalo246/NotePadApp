package com.example.goncalopinto.notepad;

/**
 * Created by Goncalo Pinto on 10/03/2016.
 */
public class Nota {

    private String titulo;
    private String corpo;

    public Nota (String titulo, String corpo){
        this.titulo=titulo;
        this.corpo=corpo;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
