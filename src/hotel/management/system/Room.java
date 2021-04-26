
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    
    Room(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430, 520, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(530, 25, 430, 520);
        add(l1);
        
        JLabel l2 = new JLabel("Room No.");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(10, 10, 100, 25);
        add(l2);
        
        JLabel l3 = new JLabel("Availability");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(112, 10, 100, 25);
        add(l3);
        
        JLabel l4 = new JLabel("Status");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(230, 10, 100, 25);
        add(l4);
        
        JLabel l5 = new JLabel("Price");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(330, 10, 100, 25);
        add(l5);
        
        JLabel l6 = new JLabel("Bed Type");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(413, 10, 100, 25);
        add(l6);
        
        t1 = new JTable();
        t1.setBounds(0, 55, 500, 400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100, 510, 120, 30);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(250, 510, 120, 30);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(995, 595);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Room");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            try{
                
                Conn c = new Conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if(ae.getSource() == b2){
            
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new Room().setVisible(true);
    }
}
