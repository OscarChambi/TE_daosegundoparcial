package com.emergentes.modelo;

public class Participantes {
    private int id;
    private String nombres;
    private String apellidos;
    private int id_sem;
    private int confirmado;
    private String ti_sem;
    
    public Participantes() {
        id = 0;
        nombres = "";
        apellidos = "";
        id_sem= 0;
        confirmado = 0;
        ti_sem = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdSeminario() {
        return id_sem;
    }

    public void setIdSeminario(int id_seminario) {
        this.id_sem = id_sem;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }
    
    public String getTituloSeminario() {
        return ti_sem;
    }

    public void setTituloSeminario(String titulo_seminario) {
        this.ti_sem = ti_sem;
    }
}
