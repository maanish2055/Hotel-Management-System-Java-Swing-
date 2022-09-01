package admin;

import Reception.Receptionist_login;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Main extends JFrame {
    JMenuBar mb;
    JMenu m1,m2;

    public Main() {
        super("Hotel Management System");
        JLabel t1 = new JLabel("Welcome to the Home Page");
        t1.setBounds(400, 80, 500, 30);
        t1.setFont(new Font("", Font.BOLD, 30));
        t1.setForeground(Color.white);
        ImageIcon background_image = new ImageIcon("C:\\Users\\Shadow\\Desktop\\hotel\\icons\\pexels-pixabay-258154.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1350, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 700);
        add(background);
        background.add(t1);




        //Menubar created
        mb = new JMenuBar();
        add(mb);
        mb.setForeground(Color.cyan);

        m1 = new JMenu("STAFF");
        mb.add(m1);
        m1.setForeground(Color.GREEN);
        m1.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                Receptionist_login a = new Receptionist_login ( );
            }
            @Override
            public void menuDeselected(MenuEvent e) {
            }
            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        m2 = new JMenu("ADMIN");
        mb.add(m2);
        m2.setForeground(Color.blue);
        m2.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                admin_login a=new admin_login ();
            }
            @Override
            public void menuDeselected(MenuEvent e) {
            }
            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        mb.add(m1);
        mb.add(m2);
        setJMenuBar(mb);

        //image

        setSize(1350, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 10);

        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }




}


