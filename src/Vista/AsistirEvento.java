package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;

public class AsistirEvento {
    private JPanel asistirPanel;
    private JTextField tfNombre;
    private JTextField tfDni;
    private JTextField tfTel;
    private JTextField tfEmpresa;
    private JComboBox cbEvento;
    private JButton apuntarmeButton;
    private JButton cancelButton;

    public AsistirEvento() {
        try{
            ResultSet set = Main.eventosLibres();
            while(set.next()){
                cbEvento.addItem(set.getString("nombre"));
            }
        }catch(Exception e){}

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                boolean correcto = validarDatos("Nombre",tfNombre.getText());
            }
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                boolean correcto = validarDatos("DNI",tfDni.getText());
            }
        });
        tfTel.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                boolean correcto = validarDatos("Telefono",tfTel.getText());
            }
        });
        tfEmpresa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                boolean correcto = validarDatos("Empresa",tfEmpresa.getText());
            }
        });
        apuntarmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.apuntarPersona(tfNombre.getText(),tfDni.getText(), tfTel.getText(),tfEmpresa.getText(),cbEvento.getSelectedItem().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentanaApuntar();
            }
        });
    }

    public JPanel getAsistirPanel() {
        return asistirPanel;
    }

    public boolean validarDatos(String campo,String texto){
        try{
            if (texto.isEmpty()){
                throw new Exception("El campo " + campo + " no puede ser vacio");
            }

            if (campo.equalsIgnoreCase("dni")){}
            if (campo.equalsIgnoreCase("telefono")){}
            if (campo.equalsIgnoreCase("empresa") || campo.equalsIgnoreCase("nombre")){}
            return true;
        }
        catch(Exception e){
            mostrarError(e.getMessage());
            return false;
        }

    }

    public void mostrarError(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
}
