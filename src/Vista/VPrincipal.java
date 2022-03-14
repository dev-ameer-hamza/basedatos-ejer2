package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VPrincipal {
    private JButton guardarEventosButton;
    private JPanel ventanaPrincipal;

    public VPrincipal() {
        guardarEventosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaInsertar();
            }
        });
    }

    public JPanel getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
