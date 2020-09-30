import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RechnerOberflaeche extends JFrame {

    JButton knoepfle[] = new JButton[10];
    GridLayout gitterlayout = new GridLayout(0, 3);
    JPanel panel = new JPanel();
    JButton plus = new JButton("" + "+");
    JButton minus = new JButton("" + "-");
    JButton geteilt = new JButton("" + "/");
    JButton mal = new JButton("" + "*");
    JButton CE = new JButton("" + "CE");
    JButton equal = new JButton(""+"=");
    JTextField anzeige = new JTextField();
    JTextField anzeigeKomplett = new JTextField();


    Rechenlogik dieRechenLogik = new Rechenlogik(this);

    public void addComponentsToPane(final Container pane) {
        panel.setLayout(gitterlayout);

        for (int i = 0; i < knoepfle.length; i++) {
            knoepfle[i] = new JButton("" + i);
            panel.add(knoepfle[i]);
            knoepfle[i].addActionListener((ActionEvent e) -> {
                String gedrueckt = ((JButton) e.getSource()).getText();
                int zahl = Integer.valueOf(gedrueckt);
                dieRechenLogik.geklickteZahl(zahl);
                System.out.println(gedrueckt + " wurde gedrückt");
            });
        }
        plus.addActionListener((ActionEvent e) -> {
            char plus = '+';
            dieRechenLogik.geklicktesZeichen(plus);
        });
        minus.addActionListener((ActionEvent e) -> {
            char minus = '-';
            dieRechenLogik.geklicktesZeichen(minus);
        });
        mal.addActionListener((ActionEvent e) -> {
            char mal = '*';
            dieRechenLogik.geklicktesZeichen(mal);
        });
        geteilt.addActionListener((ActionEvent e) -> {
            char geteilt = '/';
            dieRechenLogik.geklicktesZeichen(geteilt);
        });
        CE.addActionListener((ActionEvent e) -> {
            System.out.println("c wurde gedrückt");
            char c = 'c';
            dieRechenLogik.geklicktesZeichen(c);
        });
        equal.addActionListener((ActionEvent e) -> {
            System.out.println("= wurde gedrückt");
            char c = '=';
            dieRechenLogik.geklicktesZeichen(c);
        });

        panel.add(plus);
        panel.add(minus);
        panel.add(mal);
        panel.add(geteilt);
        panel.add(CE);
        panel.add(equal);
        panel.add(anzeige);
        panel.add(anzeigeKomplett);
        pane.add(panel);
    }

    private static void erzeugenUndDarstellenDerOberflaeche() {
        RechnerOberflaeche gitter = new RechnerOberflaeche();
        gitter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gitter.addComponentsToPane(gitter.getContentPane());
        gitter.pack();
        gitter.setVisible(true);
    }


    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                erzeugenUndDarstellenDerOberflaeche();
            }
        });
    }

    public void setzeAnzeige(int ausgabe) {
        anzeige.setText("" + ausgabe);
    }

    public void setzeAnzeigeKomplett(String ausgabe) {
        anzeigeKomplett.setText(ausgabe);
    }

    public void error(String error){
        JOptionPane.showMessageDialog(new JFrame(), error, "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }
}
