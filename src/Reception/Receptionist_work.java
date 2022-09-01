package Reception;

import admin.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receptionist_work extends JFrame implements ActionListener {

    JButton addGuest, rooms, guest_info, driver_info, search_room, Logout,UpdateCheck,Driverpickup,checkout;

    public Receptionist_work ( ) {
        addGuest = new JButton ( "Add Guest" );
        addGuest.setBounds ( 10 , 30 , 150 , 30 );
        addGuest.setBackground ( Color.BLACK );
        addGuest.setForeground ( Color.white );
        add ( addGuest );
        addGuest.addActionListener ( this );

        rooms = new JButton ( "Room Detail" );
        rooms.setBounds ( 10 , 70 , 150 , 30 );
        rooms.setBackground ( Color.BLACK );
        rooms.setForeground ( Color.white );
        rooms.addActionListener ( this );
        rooms.addActionListener ( this );
        add ( rooms );

        guest_info = new JButton ( "Guest Detail" );
        guest_info.setBounds ( 10 , 110 , 150 , 30 );
        guest_info.setBackground ( Color.BLACK );
        guest_info.setForeground ( Color.white );
        guest_info.addActionListener ( this );
        add ( guest_info );

        driver_info = new JButton ( "Driver Detail" );
        driver_info.setBounds ( 10 , 150 , 150 , 30 );
        driver_info.setBackground ( Color.BLACK );
        driver_info.setForeground ( Color.white );
        driver_info.addActionListener ( this );
        add ( driver_info );

        search_room = new JButton ( "Search Room " );
        search_room.setBounds ( 10 , 190 , 150 , 30 );
        search_room.setBackground ( Color.BLACK );
        search_room.setForeground ( Color.white );
        search_room.addActionListener ( this );
        add ( search_room );


        UpdateCheck = new JButton ( "Check Update " );
        UpdateCheck.setBounds ( 10 , 230 , 150 , 30 );
        UpdateCheck.setBackground ( Color.BLACK );
        UpdateCheck.setForeground ( Color.white );
        UpdateCheck.addActionListener ( this );
        add ( UpdateCheck );

        Driverpickup = new JButton ( "Diver Pick " );
        Driverpickup.setBounds ( 10 , 270 , 150 , 30 );
        Driverpickup.setBackground ( Color.BLACK );
        Driverpickup.setForeground ( Color.white );
        Driverpickup.addActionListener ( this );
        add ( Driverpickup );

        checkout = new JButton ( " Guest Checkout" );
        checkout.setBounds ( 10 , 310 , 150 , 30 );
        checkout.setBackground ( Color.BLACK );
        checkout.setForeground ( Color.white );
        checkout.addActionListener ( this );
        add ( checkout );

        ImageIcon background_image = new ImageIcon ( "C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\fourth.jpg" );
        Image img = background_image.getImage ( );
        Image temp_img = img.getScaledInstance ( 460 , 400 , Image.SCALE_SMOOTH );
        background_image = new ImageIcon ( temp_img );
        JLabel background = new JLabel ( "" , background_image , JLabel.CENTER );
        background.setBounds ( 170 , 0 , 460 , 400 );
        add ( background );
        Logout = new JButton ( "Logout" );
        Logout.setBounds ( 30 , 350 , 80 , 20 );
        Logout.setBackground ( Color.BLACK );
        Logout.setForeground ( Color.white );
        add ( Logout );
        Logout.addActionListener ( this );

        setBounds ( 350 , 200 , 650 , 450 );
        setLayout ( null );
        setVisible ( true );

        getContentPane ( ).setBackground ( Color.white );
    }

    public static void main ( String[] args ) {
        new Receptionist_work ( );
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ( ) == addGuest) {
            add_customer ac = new add_customer ( );
            this.dispose ( );
        }
        if (e.getSource ( ) == rooms) {
            Room_detail rd = new Room_detail ( );
            this.dispose ( );
        }
        if (e.getSource ( ) == guest_info) {
            Costumer_list cl = new Costumer_list ( );
            this.dispose ( );
        }
        if (e.getSource ( ) == driver_info) {
            Driver_detail dl = new Driver_detail ( );
            this.dispose ( );
        }
        if (e.getSource ( ) == search_room) {
            Search_room rc = new Search_room ( );
            this.dispose ( );
        }
        if (e.getSource ( ) == Logout) {
            Main m = new Main ( );
            this.dispose ( );
        }
        if (e.getSource ()==UpdateCheck){
            Update_Check uc=new Update_Check ();
            this.dispose ();
        }
        if (e.getSource ()==Driverpickup){
            pickup_driver uc=new pickup_driver ();
            this.dispose ();
        }

        if (e.getSource ()==checkout){
            Checkout uc=new Checkout ();
            this.dispose ();
        }
    }
}
