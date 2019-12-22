package social_network;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIChoiceByName {
    private JButton button;
    private JFormattedTextField selectedName;
    private JPanel topPanel;
    private JButton backButton;

    public GUIChoiceByName() {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String name = selectedName.getText();
                int num = ReadingJson.readingJson(name);
                if (num == 0) {
                    JOptionPane.showMessageDialog(Main.jf, "Incorrect entry or person does not exist, please try again.");
                } else {
                    GUI.printInformation(num);
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
