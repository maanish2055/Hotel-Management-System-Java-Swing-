package admin;
import dbconnection.*;
import dbconnection.conn;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fornt_desk_saff extends JFrame implements ActionListener {
    JLabel Name, Address, Gender, Job, Salarly, Contact, Citizenship, Email, text, l1,l2,usrname,pass,job1;
    JTextField Namelbl, Addresslbl, Salarlylbl, Contactlbl, Emaillbl,usrlbl;
    JPasswordField passlbl;
    JRadioButton Male, Female;
    JButton browse, save, cancel;
    JComboBox c1;
    ButtonGroup GenderGroup;
    conn c;
    ResultSet rs;

    public  Fornt_desk_saff(){
        JLabel title = new JLabel ( "ADD Staff Detail" );
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


        JLabel citizenship = new JLabel ( "Chitizenship " , JLabel.LEFT );
        citizenship.setForeground ( Color.white );
        citizenship.setBounds ( 150 , 230 , 100 , 30 );
        add ( citizenship );

        browse = new JButton ( "Browser" );
        browse.setBounds ( 300 , 230 , 100 , 30 );
        browse.setBackground ( Color.BLACK );
        browse.setForeground ( Color.WHITE );
        add ( browse );
        browse.addActionListener ( this );

        l2=new JLabel ();
        l2.setBounds ( 500,40,200,200 );
        add ( l2);

        l1=new JLabel ();
        l1.setBounds ( 500,20,200,200 );
        add(l1);

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



        Email = new JLabel ( "Email " , JLabel.LEFT );
        Email.setForeground ( Color.white );
        Email.setFont ( new Font ( "" , Font.BOLD , 17 ) );
        Email.setBounds ( 150 , 350 , 85 , 30 );
        add ( Email );

        Emaillbl = new JTextField ();
        Emaillbl.setBounds ( 300 , 350 , 180 , 30 );
        add ( Emaillbl );

        usrname=new JLabel ( "Username");
        usrname.setBounds ( 150,390,100,30 );
        usrname.setForeground ( Color.white );

        add ( usrname );

        usrlbl=new JTextField ();
        usrlbl.setBounds (300,390,180,30);
        add ( usrlbl);


        pass=new JLabel ( "Password");
        pass.setForeground ( Color.white );
        pass.setBounds ( 150,430,100,30 );

        add ( pass );

        passlbl=new JPasswordField ( );
        passlbl.setBounds (300,430,180,30);
        add ( passlbl);


        text = new JLabel ( );
        text.setForeground ( Color.white );
        text.setBounds ( 120 , 365 , 100 , 30 );
        add ( text );


        save = new JButton ( "Save" );
        save.setForeground ( Color.white );
        save.setBackground ( Color.green );
        save.setBounds ( 300 , 490 , 80 , 30 );
        add ( save );
        save.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String name = Namelbl.getText();
                String address = Addresslbl.getText();
                String salary = Salarlylbl.getText();
                String contact = Contactlbl.getText();
                String email = Emaillbl.getText();
                String username=usrlbl.getText ();
                String password=passlbl.getText ();
                String image=l2.getText ();

                String gender = null;

                if(Male.isSelected()){
                    gender = "Male";

                }else if(Female.isSelected()){
                    gender = "Female";
                }

                try {
                    conn c = new conn();
                    String str="insert  into staff values ('select max(id)+1 from staff','"+name+"', '"+address+"','"+gender+"','"+image+"','"+salary+"','"+contact+"','"+email+"','"+username+"','"+password+"')";

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
        cancel.setBounds ( 400 , 490 , 80 , 30 );
        add ( cancel );
        cancel.addActionListener ( this );

        getContentPane().setBackground(Color.decode("#2A363B"));

        setLayout ( null );
        setBounds ( 400 , 70 , 750 , 600 );
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

        new Fornt_desk_saff ();
    }
}