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
                        System.out.println("si hay mas personas");
                        asistentes.next();
                        nombre.setText(asistentes.getString("nombre"));
                        dni.setText(asistentes.getString("dni"));
                        empresa.setText(asistentes.getString("emp"));
                        telefono.setText(asistentes.getString("tel"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getVentanaConsultar() {
        return ventanaConsultar;
    }
}
