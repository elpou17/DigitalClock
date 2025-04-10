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

public class RelojDigital extends JFrame {
    private JLabel labelHora;
    private JLabel labelNombre;
    private JCheckBox formato12h;
    private boolean usarFormato12 = false;

    public RelojDigital() {
        setTitle("Reloj Digital");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.RED);

        labelHora = new JLabel("", SwingConstants.CENTER);
        labelHora.setFont(new Font("Arial", Font.BOLD, 20));
        labelHora.setForeground(Color.WHITE);

        labelNombre = new JLabel("Ing. Miguel Pou", SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNombre.setForeground(Color.WHITE);

        formato12h = new JCheckBox("Formato 12 horas");
        formato12h.setForeground(Color.WHITE);
        formato12h.setBackground(Color.RED);
        formato12h.setHorizontalAlignment(SwingConstants.CENTER);
        formato12h.addActionListener(e -> usarFormato12 = formato12h.isSelected());

        JPanel panelCentro = new JPanel(new GridLayout(3, 1));
        panelCentro.setBackground(Color.RED);
        panelCentro.add(labelHora);
        panelCentro.add(labelNombre);
        panelCentro.add(formato12h);

        add(panelCentro, BorderLayout.CENTER);

        actualizarHora();
    }

    private void actualizarHora() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat(usarFormato12 ? "hh:mm:ss a" : "HH:mm:ss");
            labelHora.setText(sdf.format(new Date()));
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RelojDigital reloj = new RelojDigital();
            reloj.setLocationRelativeTo(null);
            reloj.setVisible(true);
        });
    }
}
