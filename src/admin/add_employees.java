package admin;
import dbconnection.*;
import dbconnection.conn;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class add_employees extends JFrame implements ActionListener {
    JLabel Name, Address, Gender, Job, Salarly, Contact, Citizenship, Email, text, l1,l2;
    JTextField Namelbl, Addresslbl, Salarlylbl, Contactlbl, Emaillbl;
    JRadioButton Male, Female;
    JButton browse, save, cancel;
    JComboBox c1;
    ButtonGroup GenderGroup;

    public add_employees ( ) {
        super("Add Employee");

        JLabel title = new JLabel ( "ADD Employee Detail" );
        title.setFont ( new Font ( "Tahoma" , Font.BOLD , 20 ) );
        title.setForeground ( Color.BLUE );
        title.setBounds ( 100 , 50 , 250 , 30 );
        add ( title );

        Name = new JLabel ( "Name" );

        Name.setForeground ( Color.white );
        Name.setBounds ( 150 , 100 , 100 , 30 );
        add ( Name );
        Namelbl = new JTextField ( );
        Namelbl.setBounds ( 300 , 100 , 180 , 30 );
        add ( Namelbl );

        Address = new JLabel ( "Address" );

        Address.setForeground ( Color.white );
        Address.setBounds ( 150 , 150 , 100 , 30 );
        add ( Address );
        Addresslbl = new JTextField ( );
        Addresslbl.setBounds ( 300 , 150 , 180 , 30 );
        add ( Addresslbl );

        Gender = new JLabel ( "Gender" );

        Gender.setForeground ( Color.white );
        Gender.setBounds ( 150 , 190 , 70 , 30 );
        add ( Gender );

        Male = new JRadioButton ( "Male" );
        Male.setForeground ( Color.white );
        Male.setFont ( new Font ( "",Font.BOLD,15 ) );
        Male.setBackground ( Color.decode("#2A363B"));
        Male.setBounds ( 300 , 190 , 70 , 30 );
        add ( Male );

        Female = new JRadioButton ( "Female" );
        Female.setForeground ( Color.white );
        Female.setFont ( new Font ( "",Font.BOLD,15 ) );
        Female.setBackground ( Color.decode("#2A363B"));
        Female.setBounds ( 400 , 190 , 100 , 30 );
        add ( Female );
        ButtonGroup bg = new ButtonGroup ( );
        bg.add ( Male );
        bg.add ( Female );


        Job = new JLabel ( "JOB" );
        Job.setForeground ( Color.white );

        Job.setBounds ( 150 , 230 , 50 , 30 );
        add ( Job );
        String course[] = {"Waiter" , "Manager" , "Accountant" , "Housekeeping" , "Kitchen Staff" , "Room Service" , "Chef" , "Cleaner" , "Porters"};
        c1 = new JComboBox ( course );
        c1.setBackground ( Color.decode ("#2A363B") );
        c1.setForeground ( Color.white );
        c1.setBounds ( 300 , 230 , 180 , 30 );
        add ( c1 );

        Salarly = new JLabel ( "Salary" );
        Salarly.setForeground ( Color.white );

        Salarly.setBounds ( 150 , 270 , 50 , 30 );
        add ( Salarly );

        Salarlylbl = new JTextField ( );
        Salarlylbl.setBounds ( 300 , 270 , 180 , 30 );
        add ( Salarlylbl );

        Contact = new JLabel ( "Contact" );
        Contact.setForeground ( Color.white );

        Contact.setBounds ( 150 , 310 , 80 , 30 );
        add ( Contact );

        Contactlbl = new JTextField ( );
        Contactlbl.setBounds ( 300 , 310 , 180 , 30 );
        add ( Contactlbl );

        JLabel citizenship = new JLabel ( "Image " , JLabel.LEFT );
        citizenship.setForeground ( Color.white );

        citizenship.setBounds ( 150 , 350 , 100 , 30 );
        add ( citizenship );

        browse = new JButton ( "Browser" );
        browse.setBounds ( 300 , 350 , 100 , 30 );
        browse.setBackground ( Color.BLACK );
        browse.setForeground ( Color.WHITE );
        add ( browse );
        browse.addActionListener ( this );

        l2=new JLabel ();
        l2.setBounds ( 350,40,300,200 );
        add ( l2);

        l1=new JLabel ();
        l1.setBounds ( 300,20,200,200 );
        add(l1);

        Email = new JLabel ( "Email " , JLabel.LEFT );
        Email.setForeground ( Color.white );
        Email.setFont ( new Font ( "" , Font.BOLD , 17 ) );
        Email.setBounds ( 150 , 390 , 85 , 30 );
        add ( Email );

        Emaillbl = new JTextField ( );
        Emaillbl.setBounds ( 300 , 390 , 180 , 30 );
        add ( Emaillbl );
        text = new JLabel ( );
        text.setForeground ( Color.white );
        text.setBounds ( 120 , 365 , 100 , 30 );
        add ( text );

        l2 = new JLabel ( );
        l2.setBounds ( 500 , 60 , 150 , 170 );
        add ( l2 );
        save = new JButton ( "Save" );
        save.setForeground ( Color.white );
        save.setBackground ( Color.green );
        save.setBounds ( 250 , 450 , 80 , 30 );
        add ( save );
        save.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String name = Namelbl.getText();
                String address = Addresslbl.getText();
                String salary = Salarlylbl.getText();
                String contact = Contactlbl.getText();
                String image = l2.getText();
                String email = Emaillbl.getText();

                String gender = null;

                if(Male.isSelected()){
                    gender = "Male";

                }else if(Female.isSelected()){
                    gender = "Female";
                }
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
                if(image.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Add Image");
                    return;
                }
                if(email.equals("")){
                    JOptionPane.showMessageDialog(null,"Please add Email");
                    return;
                }
                if(salary.equals("")){
                    JOptionPane.showMessageDialog(null,"Please add Salarly");
                    return;
                }


                String s6 = (String)c1.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( 'select max(id)+1 from employee','"+name+"', '"+address+"', '"+gender+"','"+s6+"', '"+salary+"', '"+contact+"', '"+image+"','"+email+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    admin_work a=new admin_work ();
                    setVisible(false);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } );

        cancel = new JButton ( "Cancel" );
        cancel.setForeground ( Color.white );
        cancel.setBackground ( Color.red );
        cancel.setBounds ( 400 , 450 , 80 , 30 );
        add ( cancel );
        cancel.addActionListener ( this );

        getContentPane().setBackground(Color.decode("#2A363B"));

        setLayout ( null );
        setBounds ( 300 , 70 , 700 , 600 );
        setVisible ( true );

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
//            if (Name1.hashCode ( ) == 0 || Address1.hashCode ( ) == 0 || gender.hashCode ( ) == 0 || job1.hashCode ( ) == 0 || salarly1.hashCode ( ) == 0 || Contact1.hashCode ( ) == 0 || Citizenship1.hashCode ( ) == 0 || email1.hashCode ( ) == 0) {
//                JOptionPane.showMessageDialog ( this , "You have to fill all value " , "Apocalyptic message" , JOptionPane.WARNING_MESSAGE );
//            }
            if (e.getSource ( ) == cancel) {
                new admin_work ( );
                this.dispose ( );
            }
        }

    public static void main ( String[] args ) {
        new add_employees ( );
    }
}