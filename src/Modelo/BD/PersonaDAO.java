package Modelo.BD;

import Modelo.UML.Persona;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    private Connection connection;

    public PersonaDAO(Connection connection) {
        this.connection = connection;
    }

    public void apuntarPersona(Persona p, int id) throws Exception{
        String query = "insert into personas(nombre,dni,tel,emp,event_id) values(?,?,?,?,?)";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1,p.getNombre());
        st.setString(2,p.getDni());
        st.setString(3,p.getTel());
        st.setString(4,p.getEmpresa());
        st.setInt(5,id);

        int res = st.executeUpdate();

        if (res != 0){
            JOptionPane.showMessageDialog(null,p.getNombre() + " ha apuntado en evento con exito");
        }
    }

    public ResultSet obtenerAsistentes(String event,int id) throws SQLException {
        String query = "select * from personas where event_id=?";
        PreparedStatement st = connection.prepareStatement(query ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.setInt(1,id);
        return st.executeQuery();
    }

    public void cerrarConexion() throws Exception {
        this.connection.close();
    }
}
