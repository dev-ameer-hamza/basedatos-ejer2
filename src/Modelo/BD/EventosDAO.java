package Modelo.BD;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventosDAO {
    private Connection connection;

    public EventosDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarEvento(Modelo.UML.Eventos e) throws Exception
    {
        String query = "INSERT INTO EVENTOS(nombre,lugar,fecha,hora_incio,hora_fin,no_personas) VALUES(?,?,?,?,?,?)";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1,e.getNombre());
        st.setString(2,e.getLugar());
        st.setDate(3,Date.valueOf(e.getFecha()));
        st.setTime(4,Time.valueOf(e.getHora_incio()));
        st.setTime(5,Time.valueOf(e.getHora_fin()));
        st.setInt(6,e.getnPersonas());
        int n = st.executeUpdate();

        if (n != 1){
            throw new Exception("El número de filas actualizadas no es uno");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"una fila insertada");
        }
    }
}
