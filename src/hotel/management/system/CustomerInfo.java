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

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    CustomerInfo() {

        t1 = new JTable();
        t1.setBounds(0, 55, 1000, 500);
        add(t1);

        JLabel l1 = new JLabel("Document Type");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(7, 10, 150, 25);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(160, 10, 70, 25);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(285, 10, 70, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(405, 10, 85, 25);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(537, 10, 70, 25);
        add(l5);

        JLabel l6 = new JLabel("Room No.");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(655, 10, 80, 20);
        add(l6);

        JLabel l7 = new JLabel("Status");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(785, 10, 70, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(907, 10, 70, 20);
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

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                Conn c = new Conn();
                String str = "select * from customer";
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
        new CustomerInfo().setVisible(true);
    }
}
