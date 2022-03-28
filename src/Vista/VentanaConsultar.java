package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentanaConsultar {
    private JComboBox cbEventos;
    private JPanel ventanaConsultar;
    private JLabel nombre;
    private JLabel dni;
    private JLabel empresa;
    private JLabel telefono;
    private JPanel panelPersona;
    private JButton atrasButton;
    private JButton nextButton;
    private ResultSet asistentes;


    public VentanaConsultar() throws Exception {
        ResultSet evnts = Main.eventos();

        cbEventos.addItem("--- selecciona un evento ---");
        while(evnts.next()){
            cbEventos.addItem(evnts.getString("nombre"));
        }
        cbEventos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                        asistentes = Main.obtenerAsistentes(cbEventos.getSelectedItem().toString());
                        asistentes.next();
                        nombre.setText(asistentes.getString("nombre"));
                        dni.setText(asistentes.getString("dni"));
                        empresa.setText(asistentes.getString("emp"));
                        telefono.setText(asistentes.getString("tel"));

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (asistentes.next()){
                        nombre.setText(asistentes.getString("nombre"));
                        dni.setText(asistentes.getString("dni"));
                        empresa.setText(asistentes.getString("emp"));
                        telefono.setText(asistentes.getString("tel"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No hay mas personas");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (asistentes.previous()){
                        nombre.setText(asistentes.getString("nombre"));
                        dni.setText(asistentes.getString("dni"));
                        empresa.setText(asistentes.getString("emp"));
                        telefono.setText(asistentes.getString("tel"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No hay mas personas");
                    }
                }
                catch(SQLException sqe){
                    System.out.println(sqe.getMessage());
                }
            }
        });
    }

    public JPanel getVentanaConsultar() {
        return ventanaConsultar;
    }
}
