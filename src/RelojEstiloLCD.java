import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name Reloj Digital
 * @author Miguel Pou
 * @prueba
 * @date 09-04-2025
 */


public class RelojEstiloLCD extends JFrame {
    private JLabel horaLabel, tempLabel, humedadLabel, fechaLabel, diaLabel, nombreLabel, ampmLabel;

    public RelojEstiloLCD() {
        setTitle("Reloj Estilo LCD");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Panel superior: Hora
        JPanel panelHora = new JPanel(new BorderLayout());
        panelHora.setBackground(Color.BLACK);

        ampmLabel = new JLabel("AM", SwingConstants.LEFT);
        ampmLabel.setForeground(Color.BLACK);
        ampmLabel.setFont(new Font("Digital-7", Font.BOLD, 18));
        ampmLabel.setOpaque(true);
        ampmLabel.setBackground(Color.WHITE);
        panelHora.add(ampmLabel, BorderLayout.WEST);

        horaLabel = new JLabel("", SwingConstants.CENTER);
        horaLabel.setFont(new Font("Digital-7", Font.BOLD, 80));
        horaLabel.setForeground(Color.BLACK);
        horaLabel.setOpaque(true);
        horaLabel.setBackground(Color.WHITE);
        panelHora.add(horaLabel, BorderLayout.CENTER);

        // Panel central: Datos extra
        JPanel panelCentro = new JPanel(new GridLayout(2, 3));
        panelCentro.setBackground(Color.BLACK);

        tempLabel = new JLabel("78.1°F", SwingConstants.CENTER);
        humedadLabel = new JLabel("50%", SwingConstants.CENTER);
        fechaLabel = new JLabel("16/10", SwingConstants.CENTER);
        diaLabel = new JLabel("TUE", SwingConstants.CENTER);

        for (JLabel label : new JLabel[]{tempLabel, humedadLabel, fechaLabel, diaLabel}) {
            label.setForeground(Color.BLACK);
            label.setBackground(Color.WHITE);
            label.setFont(new Font("Digital-7", Font.BOLD, 32));
            label.setOpaque(true);
            panelCentro.add(label);
        }

        nombreLabel = new JLabel("Ing. Miguel Pou", SwingConstants.CENTER);
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        panelCentro.add(nombreLabel);

        // Panel inferior: Botones decorativos
        JPanel panelBotones = new JPanel(new GridLayout(1, 5));
        panelBotones.setBackground(Color.BLACK);
        String[] botones = {"SET", "UP", "DOWN", "ALARM", "SNZ/LG"};
        for (String texto : botones) {
            JButton b = new JButton(texto);
            b.setFont(new Font("Arial", Font.BOLD, 12));
            panelBotones.add(b);
        }

        add(panelHora, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarReloj();
    }

    private void actualizarReloj() {
        Timer timer = new Timer(1000, e -> {
            Date ahora = new Date();
            SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat formatoAMPM = new SimpleDateFormat("a");
            horaLabel.setText(formatoHora.format(ahora));
            ampmLabel.setText(formatoAMPM.format(ahora));

            // Fecha y día
            fechaLabel.setText(new SimpleDateFormat("dd/MM").format(ahora));
            diaLabel.setText(new SimpleDateFormat("EEE").format(ahora).toUpperCase());

            // Datos estáticos por ahora
            tempLabel.setText("78.1°F");
            humedadLabel.setText("50%");
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RelojEstiloLCD app = new RelojEstiloLCD();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });
    }
}
