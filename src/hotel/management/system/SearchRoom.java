package hotel.management.system;

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

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1, b2;
    JTable t1;

    SearchRoom() {

        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("serif", Font.PLAIN, 25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(350, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Room Bed Type");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(45, 100, 150, 25);
        add(l2);

        c1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBackground(Color.WHITE);
        c1.setBounds(175, 100, 150, 25);
        add(c1);

        c2 = new JCheckBox("Only Display Available");
        c2.setFont(new Font("serif", Font.PLAIN, 17));
        c2.setBackground(Color.WHITE);
        c2.setBounds(650, 100, 200, 25);
        add(c2);

        t1 = new JTable();
        t1.setBounds(0, 200, 900, 300);
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

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(45, 160, 110, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(230, 160, 150, 25);
        add(l4);

        JLabel l5 = new JLabel("Cleaning Status");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(405, 160, 150, 25);
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(620, 160, 150, 25);
        add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(760, 160, 150, 25);
        add(l7);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(890, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Search Room");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                String str = "select * from room where bed_type = '" + c1.getSelectedItem() + "'";
                String str2 = "select * from room where available = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'";

                Conn c = new Conn();

                if (c2.isSelected()) {

                    ResultSet rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } else {

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

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

        new SearchRoom().setVisible(true);
    }
}
