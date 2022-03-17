package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventosDAO;
import Modelo.UML.Eventos;
import Vista.VPrincipal;
import Vista.VentanaCancelar;
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
    public static JFrame vCancel;

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

    public static void ventanaCancelar(){
        vCancel = new JFrame("Ventana para cancelar eventos");
        vCancel.setContentPane(new VentanaCancelar().getVentanaCancelar());
        vCancel.setSize(500,500);
        vCancel.setLocationRelativeTo(null);
        vCancel.setVisible(true);
    }

    public static void insertarDatos(String nombre, String lugar, LocalDate fecha, LocalTime hIncio,LocalTime hFin,int personas) throws Exception
    {
        Modelo.UML.Eventos ev = new Eventos(nombre,lugar,fecha,hIncio,hFin,personas);
        eventos.add(ev);
        eventsoDao.insertarEvento(ev);
    }

    public static void buscarEvent(String ev) throws Exception{
        eventsoDao.buscar(ev);
    }

}
