package ui;

import modelo.*;
import adopcion.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Menu extends JFrame {
    private JTextArea display;
    private AdopcionManager manager = AdopcionManager.getInstance();

    public Menu() {
        setTitle("Adopta con Cuidado");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("img/fondo.png"));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        display = new JTextArea();
        display.setFont(new Font("Arial", Font.PLAIN, 16));
        display.setOpaque(false);
        display.setEditable(false);
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        display.setAlignmentY(Component.CENTER_ALIGNMENT);
        display.setWrapStyleWord(true);
        display.setLineWrap(true);
        display.setPreferredSize(new Dimension(400, 100));

        // Envolver el área en un panel para centrarla
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(display);

        // Scroll y agregado al fondo
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JButton verMascotas = new JButton("Ver Mascotas");
        JButton adoptar = new JButton("Adoptar");
        JButton historial = new JButton("Historial");

        verMascotas.setFont(new Font("Arial", Font.BOLD, 14));
        adoptar.setFont(new Font("Arial", Font.BOLD, 14));
        historial.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(verMascotas);
        panel.add(adoptar);
        panel.add(historial);

        background.add(panel, BorderLayout.SOUTH);

        verMascotas.addActionListener(e -> mostrarMascotas());
        adoptar.addActionListener(e -> adoptarMascota());
        historial.addActionListener(e -> mostrarHistorial());

        setVisible(true);
    }

    private void mostrarMascotas() {
        display.setText("Mascotas buscando familia:\n");
        for (Mascota m : manager.obtenerMascotas()) {
            display.append(m.getDescripcion() + "\n");
        }
    }

    private void adoptarMascota() {
        JTextField nombreField = new JTextField();
        JTextField tipoField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Tu nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Tipo de mascota (Perro/Gato):"));
        panel.add(tipoField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adopción Responsable", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            String tipo = tipoField.getText();
            Mascota mascota = MascotaFactory.crearMascota(tipo);
            if (mascota != null) {
                manager.registrarAdopcion(new Solicitud(nombre, mascota));
                display.setText("\n¡Gracias por adoptar, " + nombre + "!\nComprométete a cuidarla responsablemente.");
            } else {
                display.setText("\nTipo de mascota no válido.");
            }
        }
    }

    private void mostrarHistorial() {
        display.setText("Historial de adopciones:\n" + manager.verHistorial());
    }
}
