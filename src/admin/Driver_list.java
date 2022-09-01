package admin;
import Reception.Receptionist_work;
import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Driver_list extends JFrame implements ActionListener {
    JTable table;
    JButton load,back;

    public Driver_list(){

        super("Driver List");

        JLabel l0=new JLabel ( "S.No." );
        l0.setForeground ( Color.white );
        l0.setBounds ( 40,10,100,20 );
        add ( l0 );


        JLabel l1=new JLabel ( "Full Name" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 200,10,100,20 );
        add ( l1 );

        JLabel l2=new JLabel ( "Address" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 350,10,100,20 );
        add ( l2 );

        JLabel l3=new JLabel ( "Gender" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 480,10,100,20 );
        add ( l3 );

        JLabel l4=new JLabel ( "Image" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 610,10,100,20 );
        add ( l4 );

        JLabel l5=new JLabel ( "number plate" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 740,10,100,20 );
        add ( l5 );


        JLabel l6=new JLabel ( "Contact" );
        l6.setForeground ( Color.white );
        l6.setBounds ( 890,10,100,20 );
        add ( l6 );


        JLabel l7=new JLabel ( "Shift" );
        l7.setForeground ( Color.white );
        l7.setBounds ( 1050,10,100,20 );
        add ( l7 );



        table=new JTable ();
        table.setBounds(10,40,1150,400 );
        table.setBackground ( Color.decode ( "#2A363B" ) );
        table.setForeground ( Color.white );

        load=new JButton ( "load" );
        load.setBackground ( Color.green );
        load.setForeground ( Color.white );
        load.setBounds  ( 450,450,100,30 );
        add ( load );
        load.addActionListener ( this );


        add ( table );
//        try{
//            conn c=new conn ();
//            ResultSet rs=c.s.executeQuery ( "SELECT * FROM driver" );
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
                String displayCustomersql = "select * from driver";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(displayCustomersql);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        if(e.getSource ()==back){
            admin_work rw=new admin_work ();
            this.dispose ();
        }
    }


    public static void main ( String[] args ) {
        new Driver_list ();
    }
}
