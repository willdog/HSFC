package uk.ac.hereford.djw9349.ui.users;

import lombok.SneakyThrows;
import uk.ac.hereford.djw9349.IMS;
import uk.ac.hereford.djw9349.objects.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUser implements ActionListener {
    private JFrame frame = new JFrame("Remove User");
    private JPanel panel = new JPanel();
    private JLabel userLabel;
    private JTextField userField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel roleLabel;
    private JComboBox roleSelector;
    private JButton button;
    private JLabel label;

    public RemoveUser() {
        Dimension size = new Dimension(300, 100);
        panel.setSize(size);
        panel.setPreferredSize(size);
        panel.setBackground(new Color(247, 247, 247));
        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        userLabel.setForeground(new Color(0, 0, 0));
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        roleSelector = new JComboBox();
        for (User user : IMS.userManager.users) roleSelector.addItem(user.getUsername());
        roleSelector.setBounds(100, 20, 165, 25);
        panel.add(roleSelector);

        button = new JButton("Remove User");
        button.setBounds(10, 50, 150, 25);
        button.addActionListener(this);
        panel.add(button);

        label = new JLabel("");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        label.setForeground(new Color(0, 0, 0));
        label.setBounds(10, 80, 300, 25);
        panel.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @SneakyThrows
    public void actionPerformed(ActionEvent event) {
        Object role = roleSelector.getSelectedItem();
        if (role == null) {
            label.setText("Please select a user.");
            return;
        }

        IMS.userManager.removeUser(role.toString());
        frame.setVisible(false);
        UserManagement.main(null);
    }
}