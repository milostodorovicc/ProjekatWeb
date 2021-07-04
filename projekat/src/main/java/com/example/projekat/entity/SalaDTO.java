package com.example.projekat.entity;

public class SalaDTO {

    private int kapacitet;
    private int oznaka;


    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getOznaka() {
        return oznaka;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }


    public SalaDTO(int kapacitet, int oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public SalaDTO() {
    }
}
