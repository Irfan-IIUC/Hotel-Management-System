
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5;
    JComboBox c1, c2;
    JButton b1, b2;
    
    AddDriver(){
        
        JLabel title = new JLabel("Add Drivers");
        title.setFont(new Font("serif", Font.PLAIN, 20));
        title.setBounds(150, 10, 150, 30);
        add(title);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("serif", Font.PLAIN, 17));
        name.setBounds(60, 70, 100, 30);
        add(name);
        
        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(200, 70, 150, 30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("serif", Font.PLAIN, 17));
        age.setBounds(60, 110, 100, 30);
        add(age);
        
        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(200, 110, 150, 30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        gender.setBounds(60, 150, 100, 30);
        add(gender);
        
        c1 = new JComboBox(new String[] {"Male", "Female"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 150, 150, 30);
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        add(c1);
        
        JLabel carcompany = new JLabel("Car Company");
        carcompany.setFont(new Font("serif", Font.PLAIN, 17));
        carcompany.setBounds(60, 190, 100, 30);
        add(carcompany);
        
        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(200, 190, 150, 30);
        add(t3);
        
        JLabel carmodel = new JLabel("Car Model");
        carmodel.setFont(new Font("serif", Font.PLAIN, 17));
        carmodel.setBounds(60, 230, 100, 30);
        add(carmodel);
        
        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setBounds(200, 230, 150, 30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("serif", Font.PLAIN, 17));
        available.setBounds(60, 270, 100, 30);
        add(available);
        
        c2 = new JComboBox(new String[] {"Available", "Busy"});
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 270, 150, 30);
        c2.setFont(new Font("serif", Font.PLAIN, 17));
        add(c2);
        
        JLabel location = new JLabel("Location");
        location.setFont(new Font("serif", Font.PLAIN, 17));
        location.setBounds(60, 310, 100, 30);
        add(location);
        
        t5 = new JTextField();
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setBounds(200, 310, 150, 30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(60, 380, 130, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(220, 380, 130, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(400, 70, 500, 300);
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setSize(950, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Drivers");
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company = t3.getText();
            String available = (String) c2.getSelectedItem();
            String model = t4.getText();
            String location = t5.getText();
            
            Conn c = new Conn();
            
            String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+available+"', '"+model+"', '"+location+"')";
            
            try{
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2){
            
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new AddDriver().setVisible(true);
    }
}
