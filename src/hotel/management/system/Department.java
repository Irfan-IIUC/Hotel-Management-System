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

public class Department extends JFrame implements ActionListener {

    JButton b1, b2;
    JTable t1;

    Department() {

        t1 = new JTable();
        t1.setBounds(0, 50, 700, 350);
        add(t1);

        b1 = new JButton("Submit");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(180, 400, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(380, 400, 120, 30);
        b2.addActionListener(this);
        add(b2);

        JLabel l3 = new JLabel("Department");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(130, 10, 110, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(500, 10, 150, 25);
        add(l4);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(700, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Search Room");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                String str = "select * from department";

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

        new Department().setVisible(true);
    }
}
