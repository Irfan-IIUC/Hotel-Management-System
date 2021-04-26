package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UpdateCheck extends JFrame implements ActionListener{

    JButton b1, b2, b3;
    Choice c1;
    JTextField t1, t2, t3, t4, t5;

    UpdateCheck() {

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90, 20, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Customer-ID");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(30, 80, 100, 25);
        add(l2);

        c1 = new Choice();
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                
                c1.add(rs.getString("number"));
            }
            
        } catch(Exception e){
            
            System.out.println(e);
        }
        
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(200, 80, 150, 25);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(30, 120, 150, 25);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(200, 120, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(30, 160, 100, 25);
        add(l4);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(200, 160, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Check-IN");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(30, 200, 100, 25);
        add(l5);

        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(200, 200, 150, 25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(30, 240, 100, 25);
        add(l6);

        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setBounds(200, 240, 150, 25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(30, 280, 150, 25);
        add(l7);

        t5 = new JTextField();
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setBounds(200, 280, 150, 25);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(30, 340, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(150, 340, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(270, 340, 100, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel l8 = new JLabel(i1);
        l8.setBounds(400, 50, 500, 300);
        add(l8);
        
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(950, 425);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Update Check");
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            try{
                
                Conn c = new Conn();
                String s1 = c1.getSelectedItem();
                
                String Room = null;
                String deposit = null;
                int amountToBePaid;
                String price = null;
                
                String str = "select * from customer where number = '"+s1+"'";
                ResultSet rs = c.s.executeQuery(str);
                
                while(rs.next()){
                    
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    
                    Room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+Room+"'");
                
                while(rs2.next()){
                    
                    price = rs2.getString("price");
                    amountToBePaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountToBePaid));
                }
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2){
            
            
        } else if(ae.getSource() == b3){
            
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new UpdateCheck().setVisible(true);
    }
}
