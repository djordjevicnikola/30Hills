package social_network;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class GUI {
    private JButton button;
    private JRadioButton idRadio;
    private JRadioButton nameRadio;
    private JPanel topPanel;

    public GUI() {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean idSelected = idRadio.isSelected();
                boolean nameSelected = nameRadio.isSelected();
                if (idSelected && nameSelected) {
                    JOptionPane.showMessageDialog(Main.jf, "Please select only one option.");
                } else if (idSelected) {
                    showGUIById();
                } else if (nameSelected) {
                    showGUIByName();
                } else {
                    JOptionPane.showMessageDialog(Main.jf, "Please select first.");
                }
            }
        });

    }

    public void showGUIById() {
        GUIChoiceById GUIId = new GUIChoiceById();
        Main.jf.setContentPane(GUIId.getTopPanel());
        Main.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.jf.pack();
        Main.jf.setVisible(true);
    }

    public void showGUIByName() {
        GUIChoiceByName GUIName = new GUIChoiceByName();
        Main.jf.setContentPane(GUIName.getTopPanel());
        Main.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.jf.pack();
        Main.jf.setVisible(true);
    }

    public static void printInformation(long num) {
        StringBuilder sb = new StringBuilder();
        sb.append("Chosen person:\n");
        sb.append(ReadingJson.jsonToString(num));
        sb.append("\n\nFriends:\n");
        long[] arrayFriends = ReadingJson.friends(num, num);
        assert arrayFriends != null;
        for (int i = 0; i < arrayFriends.length; i++) {
            sb.append(ReadingJson.jsonToString(arrayFriends[i]));
        }
        sb.append("\n\nFriends of friends:\n");
        sb.append(ReadingJson.friendsOfFriendsString(arrayFriends, num));
        HashMap<Long, Integer> hm = ReadingJson.friendsOfFriends(arrayFriends, num);
        sb.append("\n\nSuggested friends:\n");
        sb.append(ReadingJson.sugestedFriends(hm));
        JOptionPane.showMessageDialog(Main.jf, sb.toString());
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

}
