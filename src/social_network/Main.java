package social_network;

import javax.swing.*;

public class Main {
    public static JFrame jf;

    public static void main(String[] args) {
        jf = new JFrame("Social Media");
        showGUI();
    }

    public static void showGUI() {
        GUI g = new GUI();
        Main.jf.setContentPane(g.getTopPanel());
        Main.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.jf.pack();
        Main.jf.setVisible(true);
    }
}
