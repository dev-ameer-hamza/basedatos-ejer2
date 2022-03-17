package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaCancelar {
    private JPanel ventanaCancelar;
    private JTextField tfEvent;
    private JPanel panelBusqueda;
    private JButton buscarButton;
    private JPanel eventPanel;
    private JLabel eventName;
    private JLabel eventLugar;
    private JLabel eventFecha;
    private JButton borrarButton;
    private boolean valorCorrecto;
    public VentanaCancelar() {
        tfEvent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                valorCorrecto = validarEvent(tfEvent.getText());
                if (valorCorrecto){
                    try{
                        Main.buscarEvent(tfEvent.getText());
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }

                }
            }
        });
    }

    public JPanel getVentanaCancelar() {
        return ventanaCancelar;
    }

    public boolean validarEvent(String event){
        try{
            if (event.isEmpty()){
                throw new Exception("El campo no puede ser vacio");
            }
            Pattern p = Pattern.compile("^[A-Z][a-z]+([ ][A-Za-z]+)*$");
            Matcher m = p.matcher(tfEvent.getText());
            if (!m.matches()){
                throw new Exception("el fromato no es valido");
            }
            return true;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            tfEvent.setText("");
            tfEvent.requestFocus();
            return false;
        }

    }
}
