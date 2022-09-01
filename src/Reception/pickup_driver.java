package Reception;

import dbconnection.*;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickup_driver extends JFrame implements ActionListener {

    JTable table;
    JButton load, back;
    JComboBox c1;


    public pickup_driver ( ) {
        super ( "Pickup Driver" );

        JLabel search = new JLabel ( "Search Driver" );
        search.setForeground ( Color.white );
        search.setFont ( new Font ( "" , Font.BOLD , 17 ) );
        search.setBounds ( 350 , 50 , 200 , 30 );
        add ( search );


        JLabel bed = new JLabel ( "Shift" );
        bed.setForeground ( Color.white );
        bed.setBounds ( 50 , 100 , 100 , 30 );
        add ( bed );

        String s[] = {"Morning", "Day", "Night"};
        c1 = new JComboBox ( s );
        c1.setBackground ( Color.decode ( "#2A3B36" ) );
        c1.setForeground ( Color.white );
        c1.setBounds ( 120 , 100 , 100 , 30 );
        add ( c1 );


        //table adding
        JLabel l1 = new JLabel ( "S.No." );
        l1.setForeground ( Color.white );
        l1.setBounds ( 20 , 150 , 100 , 20 );
        add ( l1 );

        JLabel l2 = new JLabel ( "Name" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 140 , 150 , 100 , 20 );
        add ( l2 );

        JLabel l3 = new JLabel ( "Address" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 250 , 150 , 100 , 20 );
        add ( l3 );

        JLabel l4 = new JLabel ( "Gender" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 360 , 150 , 100 , 20 );
        add ( l4 );

        JLabel l5 = new JLabel ( "Images" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 450 , 150 , 100 , 20 );
        add ( l5 );


        JLabel l6 = new JLabel ( "Number plate" );
        l6.setForeground ( Color.white );
        l6.setBounds ( 560 , 150 , 100 , 20 );
        add ( l6 );

        JLabel l7 = new JLabel ( "Contact" );
        l7.setForeground ( Color.white );
        l7.setBounds ( 660 , 150 , 100 , 20 );
        add ( l7 );


        JLabel l8 = new JLabel ( "Shift" );
        l8.setForeground ( Color.white );
        l8.setBounds ( 760 , 150 , 100 , 20 );
        add ( l8 );




        table = new JTable ( );
        table.setBounds ( 20 , 170 , 850 , 300 );
        table.setBackground ( Color.decode ( "#2A3B36" ) );
        table.setForeground ( Color.white );
        add ( table );
        try {
            conn c = new conn ( );
            ResultSet rs = c.s.executeQuery ( "SELECT * from  driver" );
            table.setModel ( DbUtils.resultSetToTableModel ( rs ) );
        } catch (Exception e) {
            e.printStackTrace ( );
        }

        load = new JButton ( "Load" );
        load.setBounds ( 300 , 500 , 100 , 30 );
        load.setBackground ( Color.green );
        load.setForeground ( Color.white );
        load.addActionListener ( this );
        add ( load );

        back = new JButton ( "Back" );
        back.setBounds ( 430 , 500 , 100 , 30 );
        back.setBackground ( Color.red );
        back.setForeground ( Color.white );
        back.addActionListener ( this );
        add ( back );


        setLayout ( null );
        setBounds ( 20 , 50 , 900 , 600 );
        getContentPane ( ).setBackground ( Color.decode ( "#2A3B36" ) );
        setVisible ( true );


    }

    @Override
    public void actionPerformed ( ActionEvent e ) {

        if (e.getSource ( ) == load) {
            try {
                conn c = new conn ( );
                String query1 = "Select * from driver where shift ='" + c1.getSelectedItem ( ) + "'";

                ResultSet rs;
                    rs = c.s.executeQuery ( query1 );

                table.setModel ( DbUtils.resultSetToTableModel ( rs ) );


            } catch (Exception e1) {
                e1.printStackTrace ( );
            }
        }


        if (e.getSource ( ) == back) {
            Receptionist_work rw = new Receptionist_work ( );
            this.dispose ( );
        }

    }

    public static void main ( String[] args ) {

        new pickup_driver ( );
    }
}