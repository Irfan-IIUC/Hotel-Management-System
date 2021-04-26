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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CheckOut extends JFrame implements ActionListener{

    Choice c1;
    JButton b1, b2, b3;
    JTextField t1;

    CheckOut() {

        JLabel l1 = new JLabel("Check Out");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 20, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(30, 80, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(30, 130, 150, 30);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(150, 130, 150, 30);
        add(t1);

        c1 = new Choice();

        try {

            Conn c = new Conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {

                c1.add(rs.getString("number"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(150, 80, 150, 30);
        add(c1);

        b1 = new JButton("Check Out");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(30, 200, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(180, 200, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(315, 85, 20, 20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350, 15, 400, 250);
        add(l4);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(770, 307);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Check Out");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            String id = c1.getSelectedItem();
            String room = t1.getText();
            
            String str = "delete from customer where number = '"+id+"'";
            String str2 = "update room set available = 'Available' where room_number = '"+room+"'";
            
            Conn c = new Conn();
            
            try{
                
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                
                JOptionPane.showMessageDialog(null, "Checkout Done Successfuly");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2){
            
            new Reception().setVisible(true);
            this.setVisible(false);
            
        } else if(ae.getSource() == b3){
            
            Conn c = new Conn();
            String id = c1.getSelectedItem();
            
            try{
                
                String str = "select * from customer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                
                while(rs.next()){
                    
                    t1.setText(rs.getString("room"));
                }
                
            } catch(Exception e){
                
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new CheckOut().setVisible(true);
    }
}
