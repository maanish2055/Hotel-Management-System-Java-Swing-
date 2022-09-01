package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class splash extends JFrame  {
    public splash() {

        //adding button
        JButton Next=new JButton("Next");
        Next.setBounds(900,600,120,40);
        Next.setBackground(Color.white);
        Next.setForeground(Color.black);
        Next.setFont(new Font("Times Roman",Font.PLAIN,30));
        Next.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Main a=new Main ();
                a.setVisible ( true );
                setVisible ( false );
            }
        } );

        //adding text on background
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 600, 500, 30);
        text.setFont(new Font("Times Roman", Font.PLAIN, 30));
        text.setForeground(Color.white);

        //background Image
        ImageIcon background_image = new ImageIcon("C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\pexels-pixabay-258154.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1350, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 700);
        add(background);
        background.add(text);
        background.add(Next);
        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }


            setSize(1350, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(0, 10);

        }
    }
    public static void main(String[] args) {

        new splash();
    }

}
