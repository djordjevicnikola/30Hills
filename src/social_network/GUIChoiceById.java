package social_network;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIChoiceById {
    private JButton button;
    private JFormattedTextField selectedId;
    private JPanel topPanel;
    private JButton backButton;

    public GUIChoiceById() {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String num1 = selectedId.getText();
                try {
                    long num = Integer.parseInt(num1);
                    if (num < 1 || num > 20) {
                        JOptionPane.showMessageDialog(Main.jf, "Wrong entry, re-enter.");
                    } else {
                        GUI.printInformation(num);
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(Main.jf, "You did not enter the number, re-enter.");
                }

            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Main.showGUI();
            }
        });
    }

    public JPanel getTopPanel() {
        return topPanel;
    }
}
