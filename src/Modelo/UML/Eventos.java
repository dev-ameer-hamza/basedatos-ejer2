package Modelo.UML;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Eventos {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime hora_incio;
    private LocalTime hora_fin;
    private int nPersonas;
    private ArrayList<Persona> personas;


    public Eventos(String nombre, String lugar, LocalDate fecha, LocalTime hora_incio, LocalTime hora_fin, int nPersonas) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora_incio = hora_incio;
        this.hora_fin = hora_fin;
        this.nPersonas = nPersonas;
        personas = new ArrayList<>();
    }

    public Eventos() {
        personas = new ArrayList<>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Persona persona) {
        this.personas.add(persona);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_incio() {
        return hora_incio;
    }

    public void setHora_incio(LocalTime hora_incio) {
        this.hora_incio = hora_incio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getnPersonas() {
        return nPersonas;
    }

    public void setnPersonas(int nPersonas) {
        this.nPersonas = nPersonas;
    }
}
