package Reception;
import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Room_detail extends JFrame implements ActionListener {
  JTable table;
  JButton load,back;

    public Room_detail(){
        JLabel l0=new JLabel ( "S.No." );
        l0.setForeground ( Color.white );
        l0.setBounds ( 40,10,100,20 );
        add ( l0 );

        JLabel l1=new JLabel ( "Room Number" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 260,10,100,20 );
        add ( l1 );

        JLabel l2=new JLabel ( "Room Availablity" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 420,10,100,20 );
        add ( l2 );

        JLabel l3=new JLabel ( "Room Status" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 600,10,100,20 );
        add ( l3 );

        JLabel l4=new JLabel ( "Room Price" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 820,10,100,20 );
        add ( l4 );

        JLabel l5=new JLabel ( "Room Type" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 1000,10,100,20 );
        add ( l5 );





        table=new JTable (  );
        table.setBounds(10,40,1150,400 );
        table.setBackground ( Color.decode ( "#2A363B" ) );
        table.setForeground ( Color.white );

        load=new JButton ( "load" );
        load.setBackground ( Color.green );
        load.setForeground ( Color.white );
        load.setBounds ( 450,450,100,30 );
        add ( load );
        load.addActionListener ( this );


        add ( table );
//        try{
//            conn c=new conn ();
//            ResultSet rs=c.s.executeQuery ( "SELECT * FROM room" );
//            table.setModel ( DbUtils.resultSetToTableModel ( rs ) );
//        }
//        catch (Exception e){
//            e.printStackTrace ();
//        }



        back=new JButton ( "Back" );
        back.setBackground ( Color.red );
        back.setForeground ( Color.white );
        back.setBounds ( 590,450,100,30 );
        back.addActionListener ( this );
        add ( back );


        getContentPane ( ).setBackground ( Color.decode ( "#2A363B" ) );
        setBounds ( 100 , 100 , 1200 , 600 );
        setLayout ( null );
        setVisible ( true );
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ( ) == load){
            try{
                conn c = new conn();
                String displayCustomersql = "select * from Room";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(displayCustomersql);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        if(e.getSource ()==back){
            Receptionist_work rw=new Receptionist_work ();
            this.dispose ();
        }
        }


    public static void main ( String[] args ) {

        new Room_detail ();
    }
}
