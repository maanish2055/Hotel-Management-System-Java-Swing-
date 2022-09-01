package admin;
import Reception.Receptionist_work;
import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Employee_list extends JFrame implements ActionListener {
    JTable table;
    JButton load,back;

    public Employee_list(){
        super("Employee List");

        JLabel l0=new JLabel ( "S.No." );
        l0.setForeground ( Color.white );
        l0.setBounds ( 40,10,100,20 );
        add ( l0 );

        JLabel l1=new JLabel ( "Full Name" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 170,10,100,20 );
        add ( l1 );

        JLabel l2=new JLabel ( "Address" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 300,10,100,20 );
        add ( l2 );

        JLabel l3=new JLabel ( "Gender" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 450,10,100,20 );
        add ( l3 );

        JLabel l4=new JLabel ( "Job" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 570,10,100,20 );
        add ( l4 );

        JLabel l5=new JLabel ( "Salarly" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 690,10,100,20 );
        add ( l5 );


        JLabel l6=new JLabel ( "Contact" );
        l6.setForeground ( Color.white );
        l6.setBounds ( 820,10,100,20 );
        add ( l6 );

        JLabel l8=new JLabel ( "Image" );
        l8.setForeground ( Color.white );
        l8.setBounds ( 960,10,100,20 );
        add ( l8 );

        JLabel l7=new JLabel ( "Email" );
        l7.setForeground ( Color.white );
        l7.setBounds ( 1060,10,100,20 );
        add ( l7 );

        table=new JTable ();
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
//            ResultSet rs=c.s.executeQuery ( "SELECT * FROM employee" );
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
                String displayCustomersql = "select * from employee";
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

        new Employee_list ();
    }
}
