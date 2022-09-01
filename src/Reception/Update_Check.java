package Reception;

import dbconnection.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Check extends JFrame implements ActionListener{
    JLabel name,id,roomno,checkintime,paidamt,remainingamt;
    Choice c1;
    JTextField ID ,Roomno,CheckinTime,Paidamt,Remainingamt;
JButton check, update, back;


    public Update_Check(){
        super("Update Custumer Inforamtion");

        name=new JLabel ( "Name" );
        name.setBounds ( 20,60,100,30 );
        name.setForeground ( Color.white );
        add ( name );

        c1=new Choice ();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from guest");
            while(rs.next()){
                c1.add(rs.getString("Name"));
            }
        }catch(Exception e){ }

        c1.setBounds ( 180,60,200,30 );
        c1.setBackground ( Color.decode ( "#2A363B" ) );
        c1.setForeground ( Color.white );
        add ( c1 );


        id=new JLabel ( "Identity" );
        id.setBounds ( 20,100,100,30 );
        id.setForeground ( Color.white );
        add ( id );

        ID=new JTextField ( );
        ID.setBounds ( 180 ,100,200,30);
        add ( ID );



        roomno=new JLabel ( "Room Number" );
        roomno.setBounds ( 20,140,100,30 );
        roomno.setForeground ( Color.white );
        add ( roomno );

        Roomno=new JTextField ( );
        Roomno.setBounds ( 180 ,140,200,30);
        add ( Roomno );


        checkintime=new JLabel ( "Checkin Time " );
        checkintime.setBounds ( 20,180,100,30 );
        checkintime.setForeground ( Color.white );
        add ( checkintime );

        CheckinTime=new JTextField ( );
        CheckinTime.setBounds ( 180 ,180,200,30);
        add ( CheckinTime );


        paidamt=new JLabel ( "Paid Amount  " );
        paidamt.setBounds ( 20,220,100,30 );
        paidamt.setForeground ( Color.white );
        add ( paidamt );

        Paidamt=new JTextField ( );
        Paidamt.setBounds ( 180 ,220,200,30);
        add ( Paidamt );


        remainingamt=new JLabel ( "Remaining Amount" );
        remainingamt.setBounds ( 20,260,150,30 );
        remainingamt.setForeground ( Color.white );
        add ( remainingamt );

        Remainingamt=new JTextField ( );
        Remainingamt.setBounds ( 180 ,260,200,30);
        add ( Remainingamt );

        check=new JButton ( "Check");
        check.setBackground ( Color.blue );
        check.setForeground ( Color.white );
        check.setBounds ( 40,310,70,30 );
        check.addActionListener ( this );
        add ( check );


        update=new JButton ( "Update");
        update.setBackground ( Color.green );
        update.setForeground ( Color.white );
        update.setBounds ( 120,310,80,30 );
        update.addActionListener ( this );
        add ( update );


        back=new JButton ( "Back");
        back.setBackground ( Color.red );
        back.setForeground ( Color.white );
        back.addActionListener ( this );
        back.setBounds ( 210,310,70,30 );
        add ( back );

        setLayout ( null );
        setBounds ( 300,50,500,500 );
        getContentPane ().setBackground ( Color.decode ( "#2A363B" ) );
        setVisible ( true );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );


    }

    public static void main ( String[] args ) {
         new Update_Check();
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        if (e.getSource ()==back){
            Receptionist_work rc=new Receptionist_work ();
            this.dispose ();
        }
        if(e.getSource ()==check){
            conn c=new conn ();
            String  names=c1.getSelectedItem ();
            String query="SELECT * from  guest where name='"+names+"'";
            try {
                ResultSet rs=c.s.executeQuery ( query );
                while (rs.next ()){
                    ID.setText ( rs.getString("identity") );
                    Roomno.setText ( rs.getString("RoomAllocation") );
                    CheckinTime.setText ( rs.getString("Time") );
                    Paidamt.setText ( rs.getString("Deposite") );
                }

                ResultSet rs2=c.s.executeQuery ( "SELECT  * from room where roomNumber='"+Roomno.getText ()+"'" );
                while (rs2.next ()) {
                    String price = rs2.getString ( "price" );

                    int pending = Integer.parseInt ( price ) - Integer.parseInt ( Paidamt.getText ( ) );

                    Remainingamt.setText( ""+pending );
                }

            }
            catch (Exception e1){
                e1.printStackTrace ();
            }


        }
        if (e.getSource ()==update){
            String names=c1.getSelectedItem ();
            String id=ID.getText ();
            String roomno=Roomno.getText ();
            String checkin=CheckinTime.getText ();
            String deposite=Paidamt.getText ();
            try{
                conn c=new conn ();
                c.s.executeUpdate ( "update  guest set RoomAllocation='"+roomno+"',Deposite='"+deposite+"'where name='"+names+"'" );
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Receptionist_work ().setVisible(true);
                this.dispose ();
            }
            catch (Exception e1){
                e1.printStackTrace ();
            }
        }

    }
}