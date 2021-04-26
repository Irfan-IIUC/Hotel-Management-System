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

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

    UpdateRoom() {

        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30, 20, 250, 30);
        add(l1);

        JLabel l2 = new JLabel("Guest ID");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(30, 80, 120, 20);
        add(l2);

        c1 = new Choice();

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {

                c1.add(rs.getString("number"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        c1.setBounds(200, 80, 150, 25);
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(30, 130, 120, 20);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(200, 130, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(30, 180, 120, 20);
        add(l4);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(200, 180, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(30, 230, 120, 20);
        add(l5);

        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(200, 230, 150, 25);
        add(t3);

        b1 = new JButton("Check");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(130, 300, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(40, 350, 120, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(220, 350, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(400, 60, 500, 300);
        add(l6);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(950, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Update Room");
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String room = null;
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();

            try {

                ResultSet rs = c.s.executeQuery("select * from customer where number = '" + s1 + "'");

                while (rs.next()) {

                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                
                 ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + room + "'");
                 
                 while(rs2.next()){
                     
                     t2.setText(rs2.getString("available"));
                     t3.setText(rs2.getString("status"));
                 }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            try{
                
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                
                Conn c = new Conn();
                String str = "update room set available = '"+available+"', status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "Room Updated Successfuly");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if (ae.getSource() == b3) {

            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new UpdateRoom().setVisible(true);
    }
}
