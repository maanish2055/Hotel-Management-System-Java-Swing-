package Reception;

import dbconnection.conn;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class Costumer_list extends JFrame implements ActionListener {
    JTable table;
    JButton load, back;

    public Costumer_list ( ) {
        super("Guest List");

        JLabel l0=new JLabel ( "S.No." );
        l0.setForeground ( Color.white );
        l0.setBounds ( 40,10,100,20 );
        add ( l0 );

        JLabel l1 = new JLabel ( "ID" );
        l1.setForeground ( Color.white );
        l1.setBounds ( 150 , 10 , 100 , 20 );
        add ( l1 );

        JLabel l2 = new JLabel ( "Identity" );
        l2.setForeground ( Color.white );
        l2.setBounds ( 230 , 10 , 100 , 20 );
        add ( l2 );

        JLabel l3 = new JLabel ( "Name" );
        l3.setForeground ( Color.white );
        l3.setBounds ( 340 , 10 , 100 , 20 );
        add ( l3 );

        JLabel l4 = new JLabel ( "Gender" );
        l4.setForeground ( Color.white );
        l4.setBounds ( 450 , 10 , 100 , 20 );
        add ( l4 );

        JLabel l5 = new JLabel ( "Contact" );
        l5.setForeground ( Color.white );
        l5.setBounds ( 560 , 10 , 100 , 20 );
        add ( l5 );
        JLabel l6 = new JLabel ( "Address" );
        l6.setForeground ( Color.white );
        l6.setBounds ( 670 , 10 , 100 , 20 );
        add ( l6 );

        JLabel l10 = new JLabel ( "Room No." );
        l10.setForeground ( Color.white );
        l10.setBounds ( 760 , 10 , 100 , 20 );
        add ( l10 );


        JLabel l7 = new JLabel ( "Time" );
        l7.setForeground ( Color.white );
        l7.setBounds ( 880 , 10 , 100 , 20 );
        add ( l7 );


        JLabel l8 = new JLabel ( "Deposite" );
        l8.setForeground ( Color.white );
        l8.setBounds ( 950 , 10 , 100 , 20 );
        add ( l8 );

        JLabel l9 = new JLabel ( "Status" );
        l9.setForeground ( Color.white );
        l9.setBounds ( 1080 , 10 , 100 , 20 );
        add ( l9 );
        table = new JTable ( );
        table.setBounds(10,40,1150,400 );


        table.setBackground ( Color.decode ( "#2A363B" ) );
        table.addMouseListener ( new MouseListener ( ) {
            @Override
            public void mouseClicked ( MouseEvent e ) {
                int i=table.getSelectedRow ();
                TableModel model=table.getModel ();

            }

            @Override
            public void mousePressed ( MouseEvent e ) {

            }

            @Override
            public void mouseReleased ( MouseEvent e ) {

            }

            @Override
            public void mouseEntered ( MouseEvent e ) {

            }

            @Override
            public void mouseExited ( MouseEvent e ) {

            }
        } );
        table.setForeground ( Color.white );

        load = new JButton ( "load" );
        load.setBackground ( Color.green );
        load.setForeground ( Color.white );
        load.setBounds ( 450 , 450 , 100 , 30 );
        add ( load );
        load.addActionListener ( this );

        add ( table );
//        try {
//            conn c = new conn ( );
//            ResultSet rs = c.s.executeQuery ( "SELECT * FROM guest" );
//            table.setModel ( DbUtils.resultSetToTableModel ( rs ) );
//        } catch (Exception e) {
//            e.printStackTrace ( );
//        }


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);

        back = new JButton ( "Back" );
        back.setBackground ( Color.red );
        back.setForeground ( Color.white );
        back.setBounds ( 580 , 450 , 100 , 30 );
        back.addActionListener ( this );
        add ( back );



        getContentPane ( ).setBackground ( Color.decode ( "#2A363B" ) );
        setBounds ( 100 , 100 , 1200 , 600 );
        setLayout ( null );
        setVisible ( true );
    }

    public static void main ( String[] args ) {
        new Costumer_list ( );
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ( ) == load) {
            try {
                conn c = new conn ( );
                String displayCustomersql = "select * from guest";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery ( displayCustomersql );
                table.setModel ( DbUtils.resultSetToTableModel ( rs ) );
            } catch (Exception e1) {
                e1.printStackTrace ( );
            }
        }
        if (e.getSource ()==back){
            Receptionist_work rw=new Receptionist_work ();
            this.dispose ();
        }
    }
}
