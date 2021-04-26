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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1, r2;

    AddCustomer() {

        JLabel l1 = new JLabel("New Customer Form");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 20, 300, 30);
        add(l1);

        JLabel id = new JLabel("ID");
        id.setFont(new Font("serif", Font.PLAIN, 17));
        id.setBounds(35, 33, 100, 120);
        add(id);

        c1 = new JComboBox(new String[]{"Passport", "Voter-ID card", "Aadhar Card", "Driving License"});
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(200, 80, 150, 25);
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(35, 73, 100, 120);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(200, 120, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(35, 113, 100, 120);
        add(l4);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(200, 160, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(35, 153, 100, 120);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("serif", Font.PLAIN, 17));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200, 200, 70, 25);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("serif", Font.PLAIN, 17));
        r2.setBounds(270, 200, 160, 25);
        add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(35, 193, 100, 120);
        add(l6);

        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(200, 240, 150, 25);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room No.");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(35, 233, 150, 120);
        add(l7);

        c2 = new Choice();

        try {

            Conn c = new Conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {

                c2.add(rs.getString("room_number"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        c2.setFont(new Font("serif", Font.PLAIN, 17));
        c2.setBounds(200, 280, 150, 25);
        add(c2);

        JLabel l8 = new JLabel("Checked In");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(35, 273, 100, 120);
        add(l8);

        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setBounds(200, 320, 150, 25);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        l9.setBounds(35, 313, 100, 120);
        add(l9);

        t5 = new JTextField();
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setBounds(200, 360, 150, 25);
        add(t5);

        b1 = new JButton("Add Customer");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(35, 420, 130, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(230, 420, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(380, 50, 300, 400);
        add(l10);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("New Customer Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();

            String gender = null;

            if (r1.isSelected()) {

                gender = "Male";

            } else if (r2.isSelected()) {

                gender = "Female";
            }

            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            String str = "insert into customer values('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + status + "', '" + deposit + "')";
            String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
            
            try {

                Conn c = new Conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {

                System.out.println(e);
            }
            
        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new AddCustomer().setVisible(true);
    }

}
