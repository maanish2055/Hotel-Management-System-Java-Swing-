package Reception;
import admin.Main;
import dbconnection.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.awt.Font.BOLD;

public class Receptionist_login extends JFrame implements ActionListener {


    JLabel u1, p1;
    JTextField username;
    JPasswordField  password;
    JButton login, cancel;

    public Receptionist_login() {

        setBounds(300, 200, 800, 400);

        JLabel title = new JLabel("Login");
        title.setBounds(20, 25, 100, 35);
        title.setFont(new Font("", BOLD, 20));
        title.setForeground(Color.white);
        add(title);


        u1 = new JLabel("Username");
        u1.setForeground(Color.white);
        u1.setFont(new Font("", BOLD, 20));
        u1.setBounds(40, 70, 100, 30);
        add(u1);

        username = new JTextField();
        username.setBounds(180, 70, 300, 40);
        add(username);

        p1 = new JLabel("Password");
        p1.setForeground(Color.white);
        p1.setFont(new Font("", BOLD, 20));
        p1.setBounds(40, 140, 100, 30);
        add(p1);


        password = new JPasswordField ();
        password.setBounds(180, 140, 300, 40);
        add(password);

        login = new JButton("Login");
        login.setFont(new Font("", BOLD, 15));
        login.setBackground(Color.green);
        login.setForeground(Color.white);
        login.setBounds(60, 220, 100, 30);
        login.addActionListener(this);
        add(login);


        cancel = new JButton("Cancel");
        cancel.setBackground(Color.red);
        cancel.setFont(new Font("", BOLD, 15));
        cancel.setForeground(Color.white);
        cancel.setBounds(190, 220, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon backgroung_image = new ImageIcon("C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\frontdesk.png");
        Image img = backgroung_image.getImage();
        Image temp_img = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        backgroung_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", backgroung_image, JLabel.CENTER);
        background.setBounds(500, 20, 250, 250);
        background.setForeground(Color.white);
        add(background);

        getContentPane().setBackground(Color.decode("#2A363B"));
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Receptionist_login();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try{
                conn c1 = new conn();
                String u = username.getText();
                String v = password.getText();

                String q = "select * from staff where username='"+u+"' and password='"+v+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new Receptionist_work ().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }

        }


         if (e.getSource() == cancel) {

            this.dispose();
        }

    }
}