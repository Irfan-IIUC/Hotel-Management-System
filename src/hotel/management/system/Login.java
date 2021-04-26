package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends JFrame implements ActionListener{

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {

        l1 = new JLabel("Username");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 20));
        t1.setBounds(150, 25, 150, 25);
        add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("serif", Font.PLAIN, 20));
        t2.setBounds(150, 75, 150, 25);
        add(t2);
       
        b1 = new JButton("Login");
        b1.setFont(new Font("serif", Font.PLAIN, 20));
        b1.setBounds(40, 150, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("serif", Font.PLAIN, 20));
        b2.setBounds(180, 150, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(300, 10, 200, 200);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 250);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            String username = t1.getText();
            String password = t2.getText();
            
            Conn c = new Conn();
            
            String str = "select * from login where username = '"+username+"' and password = '"+password+"'"; 
            
            try{
                
                ResultSet rs = c.s.executeQuery(str);
                
                if(rs.next()){
                    
                   new Dashboard().setVisible(true);
                   this.setVisible(false);
                   
                } else{
                    
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    this.setVisible(false);
                }
                
            } catch(Exception e){
                
            }
            
        } else if(ae.getSource() == b2){
            
            System.exit(0);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Login();
    }
}
