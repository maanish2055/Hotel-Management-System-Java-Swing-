package admin;

import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class admin_login extends JFrame implements ActionListener {

    JLabel u1, p1;
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    public admin_login ( ) {

        setBounds ( 400 , 250 , 800 , 400 );
        u1 = new JLabel ( "Username" );
        u1.setForeground ( Color.white );
        u1.setFont ( new Font ( "" , Font.BOLD , 20 ) );
        u1.setBounds ( 40 , 50 , 100 , 30 );
        add ( u1 );

        username = new JTextField ( );
        username.setBounds ( 180 , 50 , 300 , 40 );
        add ( username );

        p1 = new JLabel ( "Password" );
        p1.setForeground ( Color.white );
        p1.setFont ( new Font ( "" , Font.BOLD , 20 ) );
        p1.setBounds ( 40 , 120 , 100 , 30 );
        add ( p1 );


        password = new JPasswordField ( );
        password.setBounds ( 180 , 120 , 300 , 40 );
        add ( password );

        login = new JButton ( "Login" );
        login.setFont ( new Font ( "" , Font.BOLD , 15 ) );
        login.setBackground ( Color.BLACK );
        login.setForeground ( Color.white );
        login.setBounds ( 60 , 200 , 100 , 40 );
        login.addActionListener ( this );
        add ( login );


        cancel = new JButton ( "Cancel" );
        cancel.setBackground ( Color.BLACK );
        cancel.setFont ( new Font ( "" , Font.BOLD , 15 ) );
        cancel.setForeground ( Color.white );
        cancel.setBounds ( 190 , 200 , 100 , 40 );
        cancel.addActionListener ( this );
        add ( cancel );

        ImageIcon backgroung_image = new ImageIcon ( "C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\admin1.png" );
        Image img = backgroung_image.getImage ( );
        Image temp_img = img.getScaledInstance ( 200 , 200 , Image.SCALE_SMOOTH );
        backgroung_image = new ImageIcon ( temp_img );

        JLabel background = new JLabel ( "" , backgroung_image , JLabel.CENTER );
        background.setBounds ( 550 , 20 , 200 , 200 );
        add ( background );

        getContentPane ( ).setBackground ( Color.decode ( "#2A363B" ) );
        setLayout ( null );
        setVisible ( true );
    }

    public static void main ( String[] args ) {
        new admin_login ( );
    }


    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ( ) == login) {
            try {
                conn c1 = new conn ( );
                String u = username.getText ( );
                String v = password.getText ( );

                String q = "select * from adminlogin where username='" + u + "' and password='" + v + "'";

                ResultSet rs = c1.s.executeQuery ( q );
                if (rs.next ( )) {
                    new admin_work ( ).setVisible ( true );
                    setVisible ( false );
                } else {
                    JOptionPane.showMessageDialog ( null , "Invalid login" );
                    setVisible ( false );
                }
            } catch (Exception e1) {
                e1.printStackTrace ( );
            }
        }
        if (e.getSource ( ) == cancel) {
            setVisible ( false );
        }
    }}

