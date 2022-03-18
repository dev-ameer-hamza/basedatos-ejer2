package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VPrincipal {
    private JButton guardarEventosButton;
    private JPanel ventanaPrincipal;
    private JButton cancelarEventosButton;
    private JButton actualizarButton;

    public VPrincipal() {
        guardarEventosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaInsertar();
            }
        });
        cancelarEventosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaCancelar();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaActualizar();
            }
        });
    }

    public JPanel getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
