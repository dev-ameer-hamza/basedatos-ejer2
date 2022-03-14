package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ventanaDatos {
    private JPanel ventanaDatos;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraIncio;
    private JTextField tfHoraFin;
    private JTextField tfPersonas;
    private JButton guardarButton;

    public ventanaDatos() {
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarDatosString(tfNombre.getText());
            }
        });
        tfLugar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfFecha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfHoraIncio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfHoraFin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfPersonas.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Main.insertarDatos(tfNombre.getText(),tfLugar.getText(), LocalDate.parse(tfFecha.getText()), LocalTime.parse(tfHoraIncio.getText()),LocalTime.parse(tfHoraFin.getText()),Integer.parseInt(tfPersonas.getText()));

                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public boolean validarDatosString(String tf){
        try{
            if (tf.isEmpty()){
                throw new Exception("Nombre no puede ser vacio");
            }
            Pattern pString = Pattern.compile("^[A-Z][a-z]+([ ][A-Za-z]+)*$");
            Matcher mat = pString.matcher(tf);
            if (! mat.matches()){
                throw new Exception("El formato del campo no es valido");
            }
        return true;
        }catch(Exception e){
            mostrarError(e.getMessage());
            return false;
        }

    }

    public void mostrarError(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }

    public JPanel getVentanaDatos() {
        return ventanaDatos;
    }
}
