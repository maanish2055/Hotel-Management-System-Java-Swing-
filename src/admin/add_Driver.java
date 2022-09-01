package admin;

import dbconnection.conn;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_Driver extends JFrame implements ActionListener {
    public JTextField name2, address2, company2,  contact2;
    JRadioButton male, female;
    JComboBox c2;
    JButton Add, cancel,driving;
    JLabel l1,l2;


    public add_Driver() {
        JLabel title = new JLabel("Add Driver");
        title.setForeground(Color.BLUE);
        title.setBounds(40, 20, 150, 30);
        title.setFont(new Font("Times Roman", Font.BOLD, 20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setForeground(Color.white);
        name.setBounds(30, 60, 120, 30);
        add(name);

        JTextField name2 = new JTextField();
        name2.setBounds(140, 60, 150, 30);
        add(name2);

        JLabel address1 = new JLabel("Address");
        address1.setForeground(Color.white);
        address1.setBounds(30, 100, 120, 30);
        add(address1);

        JTextField address2 = new JTextField();
        address2.setBounds(140, 100, 150, 30);
        add(address2);

        JLabel gender = new JLabel("Gender");
        gender.setForeground(Color.white);
        gender.setBounds(30, 140, 120, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setForeground(Color.black);
        male.setBounds(140, 140, 70, 30);
        add(male);
        JRadioButton female = new JRadioButton("Female");
//        female.setFont(new Font("Tahoma", Font.PLAIN, 17));
        female.setForeground(Color.black);
        female.setBounds(210, 140, 70, 30);
        add(female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel driving1 = new JLabel("driving licence");
        driving1.setForeground(Color.white);
        driving1.setBounds(30, 180, 120, 30);
        add(driving1);

        driving = new JButton ("browse");
        driving.setBounds(140, 180, 100, 30);
        add(driving);
        driving.addActionListener ( this );

        l2=new JLabel ();
        l2.setBounds ( 350,40,300,200 );
        add ( l2);

        l1=new JLabel ();
        l1.setBounds ( 300,20,200,200 );
        add(l1);


        JLabel numberpalte = new JLabel("Number plate");
        numberpalte.setForeground(Color.white);
        numberpalte.setBounds(30, 220, 120, 30);
        add(numberpalte);
        JTextField brand2 = new JTextField();
        brand2.setBounds(140, 220, 150, 30);
        add(brand2);

        JLabel contact1 = new JLabel("Contact");
        contact1.setForeground(Color.white);
        contact1.setBounds(30, 260, 120, 30);
        add(contact1);

        JTextField contact2 = new JTextField();
        contact2.setBounds(140, 260, 150, 30);
        add(contact2);


        JLabel shift = new JLabel("Shift");
        shift.setForeground(Color.white);
        shift.setBounds(30, 300, 120, 30);
        add(shift);

        String courses[] = {"Morning", "Day", "Night"};
        JComboBox c2 = new JComboBox(courses);
        c2.setBackground(Color.white);
        c2.setBounds(140, 300, 150, 30);
        add(c2);


        JButton save = new JButton("Save");
        save.setForeground(Color.white);
        save.setBackground(Color.green);
        save.setBounds(120, 430, 80, 30);

        add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.red );
        cancel.setBounds(230, 430, 80, 30);
        add(cancel);
        cancel.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                admin_work a=new admin_work ();
                a.setVisible ( true );
                setVisible ( false );
            }
        } );


        getContentPane().setBackground(Color.decode("#2A363B"));

        setSize(700, 500);
        setLocation(450, 100);
        setLayout(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name2.getText();
                String  address = address2.getText();
                String driving2 = l2.getText();
                String numberplate = brand2.getText();
                String contact = contact2.getText();
                String gender = null;
                if (male.isSelected()) {
                    gender = "male";

                } else if (female.isSelected()) {
                    gender = "female";
                }
                String shift = (String) c2.getSelectedItem();
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter name");
                    return;
                }
                if(address.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter address");
                    return;
                }
                if(contact.equals("")){
                    JOptionPane.showMessageDialog(null,"Please insert  contact detail");
                    return;
                }
                if(numberplate.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter numberplate");
                    return;
                }
                if(driving.equals("")){
                    JOptionPane.showMessageDialog(null,"Please add photo");
                    return;
                }
                try {
                    conn c = new conn();
                    String str = "INSERT INTO driver values('select max(id)+1 from driver', '" + name + "', '" + address + "', '" + gender + "','" + driving2 + "', '" + numberplate + "', '" + contact + "','" + shift + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    setVisible(false);

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        });
    }


    public static void main(String[] args) {
        new add_Driver().setVisible(true);

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
        if(e.getSource ()==driving){
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

