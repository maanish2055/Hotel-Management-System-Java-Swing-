package Reception;

import dbconnection.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class add_customer extends JFrame implements ActionListener {
    JTextField name, phone, address, Depositeamt;
    JComboBox c1;
    JRadioButton male, female;
    Choice croom;
    JLabel Checkintime, Status,l1,l2;
    JButton save, cancel, browse;

    ButtonGroup bg;

    public add_customer ( ) {
        super("Add Guest");
        JLabel title = new JLabel ( "Add Guest" );
        title.setBounds ( 20 , 10 , 150 , 30 );
        title.setForeground ( Color.blue );

        title.setFont ( new Font ( "Times Roman" , Font.BOLD , 20 ) );
        add ( title );

        JLabel id = new JLabel ( "ID type" );
        id.setForeground ( Color.white );
        id.setBounds ( 20 , 50 , 80 , 30 );
        add ( id );

        String idtype[] = {"Passport" , "Citizenship" , "Driving License"};
        c1 = new JComboBox ( idtype );
        c1.setBackground ( Color.white );
        c1.setBounds ( 140 , 50 , 150 , 30 );
        add ( c1 );

        JLabel idimage1 = new JLabel ( "Identity" );
        idimage1.setForeground ( Color.white );
        idimage1.setBounds ( 20 , 100 , 120 , 30 );
        add ( idimage1 );

        browse = new JButton ("Browse" );
        browse.setBounds ( 140 , 100 , 150 , 30 );
        browse.setBackground ( Color.BLACK );
        browse.setForeground ( Color.white );
        browse.addActionListener ( this );
        add ( browse );


        JLabel name1 = new JLabel ( "Name" );
        name1.setForeground ( Color.white );
        name1.setBounds ( 20 , 150 , 80 , 30 );
        add ( name1 );

        name = new JTextField ( );
        name.setBounds ( 140 , 150 , 150 , 30 );
        add ( name );

        JLabel gender = new JLabel ( "Gender" );
        gender.setForeground ( Color.white );
        gender.setBounds ( 20 , 190 , 120 , 30 );
        add ( gender );

        male = new JRadioButton ( "Male" );
        male.setForeground ( Color.black );
//        male.setFont(new Font("Tahoma", Font.PLAIN, 17));
        male.setBounds ( 140 , 190 , 70 , 30 );
        add ( male );
        female = new JRadioButton ( "Female" );
//        female.setFont(new Font("Tahoma", Font.PLAIN, 17));
        female.setForeground ( Color.black );
        female.setBounds ( 210 , 190 , 80 , 30 );
        add ( female );
        bg = new ButtonGroup ( );
        bg.add ( male );
        bg.add ( female );

        JLabel contact1 = new JLabel ( "Contact" );
        contact1.setForeground ( Color.white );
        contact1.setBounds ( 20 , 240 , 120 , 30 );
        add ( contact1 );

        phone = new JTextField ( );
        phone.setBounds ( 140 , 240 , 150 , 30 );
        add ( phone );

        JLabel address1 = new JLabel ( "Address" );
        address1.setForeground ( Color.white );
        address1.setBounds ( 20 , 280 , 120 , 30 );
        add ( address1 );

        address = new JTextField ( );
        address.setBounds ( 140 , 280 , 150 , 30 );
        add ( address );

        JLabel RoomAllocation = new JLabel ( "Allocate Room" );
        RoomAllocation.setForeground ( Color.white );
        RoomAllocation.setBounds ( 20 , 320 , 120 , 30 );
        add ( RoomAllocation );

        croom = new Choice ( );
        try {
            conn c = new conn ( );
            String query = "select * from room where available='available'";
            ResultSet rs = c.s.executeQuery ( query );

            while ((rs.next ( ))) {
                croom.add ( rs.getString ( "roomNumber" ) );
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        croom.setBounds ( 140 , 320 , 150 , 40 );
        add ( croom );

        JLabel Checkin = new JLabel ( "Check-In Time" );
        Checkin.setForeground ( Color.white );
        Checkin.setBounds ( 20 , 370 , 120 , 30 );
        Component add = add ( Checkin );

        Date date = new Date ( );

        Checkintime = new JLabel ( "" + date );
        Checkintime.setForeground ( Color.white );
        Checkintime.setBounds ( 140 , 370 , 200 , 30 );
        add ( Checkintime );

        JLabel Deposite = new JLabel ( "Deposite" );
        Deposite.setForeground ( Color.white );
        Deposite.setBounds ( 20 , 410 , 120 , 30 );
        add ( Deposite );

        Depositeamt = new JTextField ( );
        Depositeamt.setBounds ( 140 , 410 , 150 , 30 );
        add ( Depositeamt );


        JButton save = new JButton ( "Save" );
        save.setForeground ( Color.white );
        save.setBackground ( Color.green );
        save.setBounds ( 120 , 500 , 100 , 30 );
        add ( save );
        save.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                conn c = new conn ( );
                String radio = null;

                if (male.isSelected ( )) {
                    radio = "Male";
                } else if (female.isSelected ( )) {
                    radio = "Female";
                }


                try {

                    String s1 = (String) c1.getSelectedItem ( );
                    String s2 = l2.getText ( );
                    String s3 = name.getText ( );
                    String s4 = radio;
                    String s5 = phone.getText ( );
                    String s6 = address.getText ( );
                    String s7 = croom.getSelectedItem ( );
                    String s8 = Checkintime.getText ( );
                    String s9 = Depositeamt.getText ( );

                    String q1 = "insert into guest values('select max(id)+1 from guest','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + s9 + "',1 )";

                    String q2 = "update room set available = 'Occupied' where roomNumber = " + s7;
                    c.s.executeUpdate ( q1 );
                    c.s.executeUpdate ( q2 );


                    JOptionPane.showMessageDialog ( null , "Data Inserted Successfully" );
                    new Receptionist_work ( ).setVisible ( true );
                    setVisible ( false );
                } catch (Exception e1) {
                    System.out.println ( e1 );
                }
            }
        } );
        cancel = new JButton ( "Cancel" );
        cancel.setForeground ( Color.white );
        cancel.setBackground ( Color.red );
        cancel.addActionListener ( this );
        cancel.setBounds ( 240 , 500 , 100 , 30 );
        add ( cancel );

        l2=new JLabel ();
        l2.setBounds ( 350,40,300,200 );
        add ( l2);

        l1=new JLabel ();
        l1.setBounds ( 300,20,200,200 );
        add(l1);


        getContentPane ( ).setBackground ( Color.decode ( "#2A363B" ) );

        setLayout ( null );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo ( null );
        setVisible ( true );
        setBounds ( 350 , 50 , 750 , 600 );

    }

    public static void main ( String[] args ) {
        new add_customer ( );
    }
    public ImageIcon resize ( String imgPath ) {
        ImageIcon path = new ImageIcon ( imgPath );
        Image img = path.getImage ( );
        Image newImg = img.getScaledInstance ( l2.getWidth ( ) , l2.getHeight ( ) , Image.SCALE_SMOOTH );
        Image newImg2=img.getScaledInstance ( l1.getWidth (),l1.getHeight (),Image.SCALE_SMOOTH );
        ImageIcon image = new ImageIcon ( newImg );
        ImageIcon image2=new ImageIcon ( newImg2 );
        return image;
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ( ) == cancel) {
            new Receptionist_work ( );
            this.dispose ( );
        }
        if(e.getSource ()==browse){
            JFileChooser choose = new JFileChooser ( );
            choose.setCurrentDirectory ( new File ( System.getProperty ( "user.home" ) ) );
            //filtering files
            FileNameExtensionFilter filter = new FileNameExtensionFilter ( "*.Images" , "jpg" , "png" );
            choose.addChoosableFileFilter ( filter );
            int res = choose.showSaveDialog ( null );
            if (res == JFileChooser.APPROVE_OPTION) {
                File selFile = choose.getSelectedFile ( );
                String path = selFile.getAbsolutePath ( );
                l2.setIcon ( resize ( path ) );
                l2.setText ( choose.getSelectedFile ( ).getAbsolutePath ( ) );
            }

        }
    }
    }

