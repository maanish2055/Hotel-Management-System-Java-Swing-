package Reception;

import dbconnection.*;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_room extends JFrame implements ActionListener {

    JTable table;
    JButton load, back;
    JComboBox c1;
    JCheckBox c2;

    public Search_room ( ) {
        super ( "room Searching" );

        JLabel search = new JLabel ( "Search room" );
        search.setForeground ( Color.white );
        search.setFont ( new Font ( "" , Font.BOLD , 15 ) );
        search.setBounds ( 200 , 50 , 150 , 30 );
        add ( search );


        JLabel bed = new JLabel ( "Bed Type" );
        bed.setForeground ( Color.white );
        bed.setBounds ( 50 , 100 , 100 , 30 );
        add ( bed );

        String s[] = {"Single" , "Double"};
        c1 = new JComboBox ( s );
        c1.setBackground ( Color.decode ( "#2A3B36" ) );
        c1.setForeground ( Color.white );
        c1.setBounds ( 120 , 100 , 100 , 30 );
        add ( c1 );


        c2 = new JCheckBox ( "Only Available Room" );
        c2.setForeground ( Color.white );
        c2.setBackground ( Color.decode ( "#2A3B36" ) );
        c2.setBounds ( 370 , 100 , 200 , 30 );
        add ( c2 );

        //table adding
        JLabel l1 = new JLabel ( "Room Number" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 30 , 150 , 100 , 20 );
        add ( l1 );

        JLabel l2 = new JLabel ( "Room Availablity" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 140 , 150 , 100 , 20 );
        add ( l2 );

        JLabel l3 = new JLabel ( "Room Status" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 280 , 150 , 100 , 20 );
        add ( l3 );

        JLabel l4 = new JLabel ( "Room Price" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 420 , 150 , 100 , 20 );
        add ( l4 );

        JLabel l5 = new JLabel ( "Room Type" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 540 , 150 , 100 , 20 );
        add ( l5 );

        table = new JTable ( );
        table.setBounds ( 50 , 170 , 600 , 300 );
        table.setBackground ( Color.decode ( "#2A3B36" ) );
        table.setForeground ( Color.white );
        add ( table );
        try {
            conn c = new conn ( );
            ResultSet rs = c.s.executeQuery ( "SELECT * from  room" );
            table.setModel ( DbUtils.resultSetToTableModel ( rs ) );
        } catch (Exception e) {
            e.printStackTrace ( );
        }

        load = new JButton ( "Load" );
        load.setBounds ( 150 , 500 , 100 , 30 );
        load.setBackground ( Color.green );
        load.setForeground ( Color.white );
        load.addActionListener ( this );
        add ( load );

        back = new JButton ( "Back" );
        back.setBounds ( 300 , 500 , 100 , 30 );
        back.setBackground ( Color.red );
        back.setForeground ( Color.white );
        back.addActionListener ( this );
        add ( back );


        setLayout ( null );
        setBounds ( 200 , 50 , 660 , 600 );
        getContentPane ( ).setBackground ( Color.decode ( "#2A3B36" ) );
        setVisible ( true );


    }

    @Override
    public void actionPerformed ( ActionEvent e ) {

        if (e.getSource ()==load){
           try{
               conn c=new conn ();
               String query1="Select * from room where bed_type ='"+c1.getSelectedItem ()+"'";
               String query2="SELECT * from  room where available='Available'AND bed_type ='"+c1.getSelectedItem ()+"'";
               ResultSet rs;
               if (c2.isSelected ()){
              rs=c.s.executeQuery ( query2 );
               }
               else {
                   rs = c.s.executeQuery ( query1 );
               }
               table.setModel ( DbUtils.resultSetToTableModel ( rs ) );


           }
           catch (Exception e1){
               e1.printStackTrace ();
           }
        }


        if(e.getSource ()==back){
            Receptionist_work rw=new Receptionist_work ();
            this.dispose ();
        }

    }
    public static void main ( String[] args ) {

        new Search_room ( );
    }

}