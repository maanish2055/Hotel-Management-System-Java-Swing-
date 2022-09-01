package admin;


import  Reception.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_work extends JFrame {
    admin_work ( ) {
        super ( "admin_workspace" );

        JButton addemployee = new JButton ( "Add Employee" );
        addemployee.setBounds ( 10 , 50 , 150 , 30 );
        addemployee.setBackground ( Color.BLACK );
        addemployee.setForeground ( Color.white );
        add ( addemployee );
        addemployee.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                           add_employees emp= new add_employees ();
emp.setVisible ( true );
setVisible ( false );
            }
        });
                JButton addrooms = new JButton ( " Add Rooms" );
        addrooms.setBounds ( 10 , 90 , 150 , 30 );
        addrooms.setBackground ( Color.BLACK );
        addrooms.setForeground ( Color.white );
        add ( addrooms );

        addrooms.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                add_Room rooms= new add_Room ();
                rooms.setVisible ( true );
                setVisible ( false );
            }
        });
        JButton adddriver = new JButton ( "Add Driver" );
        adddriver.setBounds ( 10 , 130 , 150 , 30 );
        adddriver.setBackground ( Color.BLACK );
        adddriver.setForeground ( Color.white );
        add ( adddriver );
        adddriver.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                add_Driver drivers= new add_Driver ();
                drivers.setVisible ( true );
                setVisible ( false );
            }
        });
        JButton employeelist = new JButton ( "Employee list" );
        employeelist.setBounds ( 10 , 170 , 150 , 30 );
        employeelist.setBackground ( Color.BLACK );
        employeelist.setForeground ( Color.white );
        add ( employeelist );
        employeelist.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Employee_list employeeList= new Employee_list ();
                employeeList.setVisible ( true );
                setVisible ( false );
            }
        });
        JButton driverlist = new JButton ( "Driver list" );
        driverlist.setBounds ( 10 , 210 , 150 , 30 );
        driverlist.setBackground ( Color.BLACK );
        driverlist.setForeground ( Color.white );
        add ( driverlist );
        driverlist.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Driver_list driverList= new Driver_list ();
                setVisible ( false );
            }
        });

        JButton roomlist = new JButton ( "Room list" );
        roomlist.setBounds ( 10 , 210 , 150 , 30 );
        roomlist.setBackground ( Color.BLACK );
        roomlist.setForeground ( Color.white );
        add ( roomlist );
        roomlist.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Room_detail driverList= new Room_detail ();

                setVisible ( false );
            }
        });
        JButton addstaff = new JButton ( " Add Staff" );
        addstaff.setBounds ( 10 , 250 , 150 , 30 );
        addstaff.setBackground ( Color.BLACK );
        addstaff.setForeground ( Color.white );
        add ( addstaff );
        addstaff.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Fornt_desk_saff fds= new Fornt_desk_saff ();

                setVisible ( false );
            }
        });

        JButton stafflist = new JButton ( "  Staff List" );
        stafflist.setBounds ( 10 , 290 , 150 , 30 );
        stafflist.setBackground ( Color.BLACK );
        stafflist.setForeground ( Color.white );
        add ( stafflist );
        stafflist.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                stafflist sls= new stafflist ();

                setVisible ( false );
            }
        });


        ImageIcon background_image = new ImageIcon ( "C:\\Users\\Shadow\\IntelliJIDEAProjects\\HotelManagementSystem\\src\\icons\\admin_workspace.png" );
        Image img = background_image.getImage ( );
        Image temp_img = img.getScaledInstance ( 460 , 400 , Image.SCALE_SMOOTH );
        background_image = new ImageIcon ( temp_img );
        JLabel background = new JLabel ( "" , background_image , JLabel.CENTER );
        background.setBounds ( 170 , 0 , 460 , 400 );
        add ( background );
        JButton Logout = new JButton ( "Logout" );
        Logout.setBounds ( 30 , 350 , 80 , 20 );
        Logout.setBackground ( Color.BLACK );
        Logout.setForeground ( Color.white );
        add ( Logout );
        Logout.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Main main=new Main ();
                main.setVisible ( true );
                setVisible ( false );
            }
        } );

        setBounds ( 350 , 200 , 650 , 450 );
        setLayout ( null );
        setVisible ( true );
        getContentPane ( ).setBackground ( Color.decode ( "#E5E4E2" ) );
    }

    public static void main ( String[] args ) {
        new admin_work ( );
    }
}



