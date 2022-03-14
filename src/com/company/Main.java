package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventosDAO;
import Modelo.UML.Eventos;
import Vista.VPrincipal;
import Vista.ventanaDatos;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

public static BaseDatos bd;
public static EventosDAO eventsoDao;

public static JFrame vp;
public static JFrame vDatos;

public static ArrayList<Modelo.UML.Eventos> eventos = new ArrayList<>();


    public static void main(String[] args) {

        try{
            bd = new BaseDatos();
            eventsoDao = new EventosDAO(bd.getConnection());
            crearVentanaPrincipal();
        }catch(Exception e){
            System.out.println("error " + e.getMessage());
        }
    }

    public static void crearVentanaPrincipal(){
        vp = new JFrame("ventana principal");
        vp.setContentPane(new VPrincipal().getVentanaPrincipal());
        vp.setSize(500,500);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    public static void ventanaInsertar(){
//        vp.dispose();
        vDatos = new JFrame("Ventana para insertar datos");
        vDatos.setContentPane(new ventanaDatos().getVentanaDatos());
        vDatos.setSize(500,500);
        vDatos.setLocationRelativeTo(null);
        vDatos.setVisible(true);
    }

    public static void insertarDatos(String nombre, String lugar, LocalDate fecha, LocalTime hIncio,LocalTime hFin,int personas) throws Exception
    {
        Modelo.UML.Eventos ev = new Eventos(nombre,lugar,fecha,hIncio,hFin,personas);
        eventos.add(ev);
        eventsoDao.insertarEvento(ev);
    }

}
