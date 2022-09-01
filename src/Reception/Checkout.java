package Reception;

import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {
    JLabel name,roomno,checkintime,id,checkouttime,Checkoutime,ID,Roomno,Chtime;
    JButton checkout, cancel,Fetch;
    Choice c1;
    public Checkout(){
        super(" Guest Checkout ");

        setBounds ( 300,200,800,400 );
        setVisible ( true );
        setLayout ( null );

        JLabel lblCheckOut = new JLabel("Check Out ");
        lblCheckOut.setFont(new Font("", Font.BOLD, 20));
        lblCheckOut.setForeground ( Color.white );
        lblCheckOut.setBounds(150, 20, 140, 35);
       add(lblCheckOut);

        name=new JLabel ( "Name" );
        name.setBounds ( 20,60,100,30 );
        name.setForeground ( Color.white );
        add ( name );

        c1=new Choice ();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from guest");
            while(rs.next()){
                c1.add(rs.getString("Name"));
            }
        }catch(Exception e){ }


        c1.setBounds ( 180,60,200,30 );
        c1.setBackground ( Color.decode ( "#2A363B" ) );
        c1.setForeground ( Color.white );
        add ( c1 );



        ImageIcon tickimg = new ImageIcon("C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\tick.png");
        Image img = tickimg.getImage();
        Image temp_img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        tickimg = new ImageIcon(temp_img);
        JLabel tick = new JLabel("", tickimg, JLabel.CENTER);
        tick.setBounds(390, 60, 20, 20);
        tick.setForeground(Color.white);
        add(tick);


        id=new JLabel ( "Identity" );
        id.setBounds ( 20,100,100,30 );
        id.setForeground ( Color.white );
        add ( id );

        ID=new JLabel ();
        ID.setBounds ( 180,100,200,30 );
        ID.setForeground ( Color.white );
        add ( ID );

        roomno=new JLabel ( "Room Number" );
        roomno.setBounds ( 20,140,100,30 );
        roomno.setForeground ( Color.white );
        add ( roomno );


        Roomno=new JLabel ();
        Roomno.setBounds ( 180,140,100,30 );
        Roomno.setForeground ( Color.white );
        add ( Roomno );

        checkintime=new JLabel ( "Checkin Time " );
        checkintime.setBounds ( 20,180,100,30 );
        checkintime.setForeground ( Color.white );
        add ( checkintime );

        Chtime=new JLabel ();
        Chtime.setBounds ( 180,180,200,30 );
        Chtime.setForeground ( Color.white );
        add ( Chtime );



        checkouttime=new JLabel ( "Checkout Time " );
        checkouttime.setBounds ( 20,220 ,100,30 );
        checkouttime.setForeground ( Color.white );
        add ( checkouttime );

        Date date=new Date ();
        Checkoutime=new JLabel ( ""+date );
        Checkoutime.setBounds ( 180,220,200,30 );
        Checkoutime.setForeground ( Color.white );
        add ( Checkoutime );


        Fetch=new JButton ( "Fetch Data" );
        Fetch.setBounds ( 70,270,150,30 );
        Fetch.setBackground ( Color.BLACK );
        Fetch.setForeground ( Color.white );
        Fetch.addActionListener ( this );
        add ( Fetch );


        checkout=new JButton("Checkout");
        checkout.setBackground ( Color.green );
        checkout.setForeground ( Color.white );
        checkout.setBounds ( 30,310,100,30 );
        checkout.addActionListener ( this );
        add (checkout);


        cancel=new JButton("Cancel");
        cancel.setBackground ( Color.red );
        cancel.setForeground ( Color.white );
        cancel.setBounds ( 150,310,100,30 );
        cancel.addActionListener ( this );
        add (cancel);












        ImageIcon backgroung_image = new ImageIcon("C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\checkout2.jpeg");
        Image img2 = backgroung_image.getImage();
        Image temp_img2 = img2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        backgroung_image = new ImageIcon(temp_img2);
        JLabel background = new JLabel("", backgroung_image, JLabel.CENTER);
        background.setBounds(450, 20, 300, 300);
        background.setForeground(Color.white);
        add(background);



        getContentPane().setBackground(Color.decode("#2A363B"));




    }
    @Override
    public void actionPerformed ( ActionEvent e ) {
     if(e.getSource ()==Fetch) {
         conn c = new conn ( );
         String query1 = "Select * from guest where  Name ='" + c1.getSelectedItem ( ) + "'";

         try {
             ResultSet rs = c.s.executeQuery ( query1 );
             while (rs.next ( )) {
                 ID.setText ( rs.getString ( "identity" ) );
                 Roomno.setText ( rs.getString ( "RoomAllocation" ) );
                 Chtime.setText ( rs.getString ( "Time" ) );

             }

         } catch (SQLException e1) {
             e1.printStackTrace ( );
         }
     }

         if (e.getSource ( ) == checkout) {
             String id = c1.getSelectedItem ( );
             String s1 = Roomno.getText ( );
             String q2 = "update room set available = 'Available' where roomNumber = " + s1;
             String q1 = "update guest set status = '0'";



             try {
                 conn c=new conn ();
                 c.s.executeUpdate ( q2 );
                 c.s.executeUpdate ( q1 );
                 JOptionPane.showMessageDialog ( null , "Check Out Successful" );
                 new Receptionist_work ( ).setVisible ( true );
                 setVisible ( false );
             } catch (SQLException e1) {
                 System.out.println ( e1.getMessage ( ) );
             }

         }

         if (e.getSource ( ) == cancel) {
             Receptionist_work rw = new Receptionist_work ( );
             this.dispose ( );

         }

     }



    public static void main ( String[] args ) {
        new Checkout ();

    }

}
