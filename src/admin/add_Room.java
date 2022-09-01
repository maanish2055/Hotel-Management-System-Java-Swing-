package admin;
import dbconnection.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_Room extends JFrame implements ActionListener {

    JButton save, cancel;
    JComboBox c1, c2, c3;
    JTextField room, prices;

    public add_Room ( ) {

        JLabel title = new JLabel ( "Add Room" );
        title.setForeground ( Color.white );
        title.setBounds ( 40 , 20 , 80 , 30 );
        title.setFont ( new Font ( "Times Roman" , Font.BOLD , 15 ) );
        add ( title );

        JLabel roomno = new JLabel ( "Room Number" );
        roomno.setForeground ( Color.white );
        roomno.setBounds ( 30 , 60 , 120 , 30 );
        add ( roomno );

        room = new JTextField ( );
        room.setBounds ( 140 , 60 , 150 , 30 );
        add ( room );

        JLabel availability = new JLabel ( "Room Availability" );
        availability.setForeground ( Color.white );
        availability.setBounds ( 30 , 100 , 120 , 30 );
        add ( availability );

        String course[] = {"Available" , "Unavailable"};
        c1 = new JComboBox ( course );
        c1.setBackground ( Color.white );
        c1.setBounds ( 140 , 100 , 150 , 30 );
        add ( c1 );

        JLabel status = new JLabel ( "Room Status" );
        status.setForeground ( Color.white );
        status.setBounds ( 30 , 140 , 120 , 30 );
        add ( status );

        String courses[] = {"Clean" , "Dirty"};
        c2 = new JComboBox ( courses );
        c2.setBackground ( Color.white );
        c2.setBounds ( 140 , 140 , 150 , 30 );
        add ( c2 );

        JLabel price1 = new JLabel ( "Room Price" );
        price1.setForeground ( Color.white );
        price1.setBounds ( 30 , 180 , 120 , 30 );
        add ( price1 );

        prices = new JTextField ( );
        prices.setBounds ( 140 , 180 , 150 , 30 );
        add ( prices );

        JLabel bedtype1 = new JLabel ( "Bed Type" );
        bedtype1.setForeground ( Color.white );
        bedtype1.setBounds ( 30 , 220 , 120 , 30 );
        add ( bedtype1 );

        String bed[] = {"Single " , "Double"};
        c3 = new JComboBox ( bed );
        c3.setBackground ( Color.white );
        c3.setBounds ( 140 , 220 , 150 , 30 );
        add ( c3 );

        save = new JButton ( "Save" );
        save.setForeground ( Color.white );
        save.setBackground ( Color.green );
        save.setBounds ( 120 , 300 , 80 , 30 );
        save.addActionListener ( this );
        add ( save );

        cancel = new JButton ( "Cancel" );
        cancel.setForeground ( Color.white );
        cancel.setBackground ( Color.red );
        cancel.addActionListener ( this );
        cancel.setBounds ( 230 , 300 , 80 , 30 );
        add ( cancel );
        cancel.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                admin_work a = new admin_work ( );
                a.setVisible ( true );
                setVisible ( false );
            }
        } );


        ImageIcon background_image = new ImageIcon ( "C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\vojtech-bruzek-Yrxr3bsPdS0-unsplash.jpg" );
        Image img = background_image.getImage ( );
        Image temp_img = img.getScaledInstance ( 220 , 300 , Image.SCALE_SMOOTH );
        background_image = new ImageIcon ( temp_img );
        JLabel background = new JLabel ( "" , background_image , JLabel.CENTER );
        background.setBounds ( 350 , 30 , 220 , 300 );
        add ( background );

        getContentPane ( ).setBackground ( Color.decode ( "#2A363B" ) );

        setSize ( 600 , 400 );
        setLocation ( 450 , 170 );
        setLayout ( null );


        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        try {

            if (e.getSource ( ) == save) {
                try {
                    conn c = new conn ( );
                    String roomNumber = room.getText ( );
                    String available = (String) c1.getSelectedItem ( );
                    String status = (String) c2.getSelectedItem ( );
                    String price = prices.getText ( );
                    String type = (String) c3.getSelectedItem ( );
                    String str = "INSERT INTO room values( 'select max(id)+1 from room','" + roomNumber + "', '" + available + "', '" + status + "','" + price + "', '" + type + "' )";


                    c.s.executeUpdate ( str );
                    JOptionPane.showMessageDialog ( null , "Room Successfully Added" );
                    admin_work aw=new admin_work ();
                    this.dispose ();

                } catch (Exception ee) {
                    System.out.println ( ee );
                }
            } else if (e.getSource ( ) == cancel) {
                this.setVisible ( false );
            }
        } catch (Exception eee) {

        }
    }

    public static void main ( String[] args ) {
        new add_Room ( ).setVisible ( true );

    }

}







