package admin;
import Reception.Receptionist_work;
import dbconnection.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class stafflist extends JFrame implements ActionListener {
    JTable table;
    JButton load,back;

    public stafflist(){
        super("Staff List");

        JLabel l0=new JLabel ( "S.No." );
        l0.setForeground ( Color.white );
        l0.setBounds ( 40,10,100,20 );
        add ( l0 );

        JLabel l1=new JLabel ( "Full Name" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 150,10,100,20 );
        add ( l1 );

        JLabel l2=new JLabel ( "Address" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 270,10,100,20 );
        add ( l2 );

        JLabel l3=new JLabel ( "Gender" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 400,10,100,20 );
        add ( l3 );

        JLabel l4=new JLabel ( "Image" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 500,10,100,20 );
        add ( l4 );

        JLabel l5=new JLabel ( "Salarly" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 620,10,100,20 );
        add ( l5 );


        JLabel l6=new JLabel ( "Contact" );
        l6.setForeground ( Color.white );
        l6.setBounds ( 720,10,100,20 );
        add ( l6 );

        JLabel l8=new JLabel ( "Email" );
        l8.setForeground ( Color.white );
        l8.setBounds ( 830,10,100,20 );
        add ( l8 );

        JLabel l7=new JLabel ( "Username" );
        l7.setForeground ( Color.white );
        l7.setBounds ( 950,10,100,20 );
        add ( l7 );


        JLabel l9=new JLabel ( "Password" );
        l9.setForeground ( Color.white );
        l9.setBounds ( 1060,10,100,20 );
        add ( l9 );

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
//            ResultSet rs=c.s.executeQuery ( "SELECT * FROM staff" );
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
                String displayCustomersql = "select * from staff";
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

        new stafflist ();
    }
}
