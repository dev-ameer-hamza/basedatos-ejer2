package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class VentanaModificar {
    private JPanel comboPanel;
    private JComboBox cbEventos;
    private JPanel actualizar;
    private JPanel panelDatos;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraI;
    private JTextField tfHoraF;
    private JButton actualizarEventoButton;
    private JTextField tfAforo;

    public VentanaModificar() {

        try{
            ResultSet set = Main.eventos();
            cbEventos.addItem("---selecciona un evento---");
            while(set.next()){
                cbEventos.addItem(set.getString("nombre"));
            }
        }catch(Exception e){}



        cbEventos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    ResultSet s = Main.buscarEvt(cbEventos.getSelectedItem().toString());
                    while(s.next()){
                        panelDatos.setVisible(true);
                        panelDatos.setSize(300,300);
                        tfLugar.setText(s.getString("lugar"));
                        tfFecha.setText(s.getDate("fecha").toString());
                        tfHoraI.setText(s.getTime("hora_incio").toString());
                        tfHoraF.setText(s.getTime("hora_fin").toString());
                        tfAforo.setText(String.valueOf(s.getInt("no_personas")));
                    }
                    System.out.println(cbEventos.getSelectedItem().toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"no ha encontrado ningun eventos con nombre " + cbEventos.getSelectedItem().toString());
                }
            }
        });
        actualizarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Main.actualizarDatos(cbEventos.getSelectedItem().toString(),tfLugar.getText(), LocalDate.parse(tfFecha.getText()), LocalTime.parse(tfHoraI.getText()),LocalTime.parse(tfHoraF.getText()),Integer.parseInt(tfAforo.getText()));

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public JPanel getActualizarPanel() {
        return actualizar;
    }
}
