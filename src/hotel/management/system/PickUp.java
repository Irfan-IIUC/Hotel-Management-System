package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

    Choice c1;
    JButton b1, b2;
    JTable t1;

    PickUp() {

        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("serif", Font.PLAIN, 25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(350, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(45, 100, 90, 25);
        add(l2);

        c1 = new Choice();
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            
            while(rs.next()){
                
                c1.add(rs.getString("brand"));
            }
            
        } catch(Exception e){
            
            System.out.println(e);
        }
        
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(150, 100, 200, 25);
        add(c1);

        t1 = new JTable();
        t1.setBounds(0, 210, 900, 300);
        add(t1);

        b1 = new JButton("Submit");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(260, 520, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(500, 520, 120, 30);
        b2.addActionListener(this);
        add(b2);

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(40, 160, 110, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(180, 160, 150, 25);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(295, 160, 150, 25);
        add(l5);

        JLabel l6 = new JLabel("Company");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(420, 160, 150, 25);
        add(l6);

        JLabel l7 = new JLabel("Brand");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(560, 160, 150, 25);
        add(l7);
        
        JLabel l8 = new JLabel("Availabiliy");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(670, 160, 150, 25);
        add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        l9.setBounds(790, 160, 150, 25);
        add(l9);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(890, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Pick Up");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                String str = "select * from driver where brand = '" + c1.getSelectedItem() + "'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

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

        new PickUp().setVisible(true);
    }
}
