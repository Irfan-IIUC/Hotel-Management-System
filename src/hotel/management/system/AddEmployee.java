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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddEmployee extends JFrame implements ActionListener{

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton b1, b2;
    JComboBox c1;
    JButton b3;

    AddEmployee() {

        JLabel name = new JLabel("Name");
        name.setFont(new Font("serif", Font.PLAIN, 17));
        name.setBounds(60, 30, 120, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("serif", Font.PLAIN, 17));
        age.setBounds(60, 80, 120, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        gender.setBounds(60, 130, 120, 30);
        add(gender);

        b1 = new JRadioButton("Male");
        b1.setFont(new Font("serif", Font.PLAIN, 16));
        b1.setBackground(Color.WHITE);
        b1.setBounds(200, 130, 70, 30);
        add(b1);

        b2 = new JRadioButton("Female");
        b2.setFont(new Font("serif", Font.PLAIN, 16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(280, 130, 75, 30);
        add(b2);

        JLabel job = new JLabel("Job");
        job.setFont(new Font("serif", Font.PLAIN, 17));
        job.setBounds(60, 180, 120, 30);
        add(job);
        
        String str[] = {"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 180, 150, 30);
        add(c1);
        
        

        JLabel salary = new JLabel("Salary");
        salary.setFont(new Font("serif", Font.PLAIN, 17));
        salary.setBounds(60, 230, 120, 30);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("serif", Font.PLAIN, 17));
        phone.setBounds(60, 280, 120, 30);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(200, 280, 150, 30);
        add(t4);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("serif", Font.PLAIN, 17));
        aadhar.setBounds(60, 330, 120, 30);
        add(aadhar);

        t5 = new JTextField();
        t5.setBounds(200, 330, 150, 30);
        add(t5);

        JLabel email = new JLabel("E-mail");
        email.setFont(new Font("serif", Font.PLAIN, 17));
        email.setBounds(60, 380, 120, 30);
        add(email);

        t6 = new JTextField();
        t6.setBounds(200, 380, 150, 30);
        add(t6);
        
        b3 = new JButton("Submit");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(200, 430, 150, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(380, 60, 450, 450);
        add(l1);
        
        JLabel l2 = new JLabel("Add Employee Details");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("serif", Font.PLAIN, 25));
        l2.setBounds(470, 30, 400, 30);
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 530);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Add Employee");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
        
        String gender = null;
        
        if(b1.isSelected()){
            
            gender = "Male";
            
        } else if(b2.isSelected()){
            
            gender = "Female";
        }
        
        String job = (String) c1.getSelectedItem();
        
        Conn c = new Conn();
        
        String str = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+aadhar+"', '"+email+"')";
        
        try{
            
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Employee Added Successfuly");
            this.setVisible(false);
            
        } catch(Exception e){
            
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new AddEmployee().setVisible(true);
    }
}
