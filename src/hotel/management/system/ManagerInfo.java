
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    
    ManagerInfo(){
        
        t1 = new JTable();
        t1.setBounds(0, 50, 1000, 500);
        add(t1);
        
        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(40, 10, 70, 25);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(170, 10, 70, 25);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(285, 10, 70, 25);
        add(l3);
        
          JLabel l4 = new JLabel("Department");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(400, 10, 85, 25);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(540, 10, 70, 25);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(665, 10, 70, 25);
        add(l6);
        
        JLabel l7 = new JLabel("Aadhar");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(785, 10, 70, 25);
        add(l7);
        
        JLabel l8 = new JLabel("E-mail");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(910, 10, 70, 25);
        add(l8);
        
        b1 = new JButton("Load Data");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(350, 565, 120, 35);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530, 565, 120, 35);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Add Employee");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            try{
                
                Conn c = new Conn();
                String str = "select * from employee where job = 'Manager'";
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e){
                
                System.out.println(e);
            }
        } else if(ae.getSource() == b2){
            
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new ManagerInfo().setVisible(true);
    }
}
