package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1200, 565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 5, 1000, 90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN, 60));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setFont(new Font("serif", Font.PLAIN, 35));
        b1.setBounds(500, 450, 150, 50);
        b1.addActionListener(this);
        l1.add(b1);
        
        setSize(1200, 565);
        setTitle("Hotel Management System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        while (true) {

            l2.setVisible(false);

            try {
                Thread.sleep(500);

            } catch (Exception e) {}

            
            
            l2.setVisible(true);

            try {
                Thread.sleep(500);

            } catch (Exception e) {}
        }
    }
         
        
    public void actionPerformed(ActionEvent ae){
        
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        new HotelManagementSystem();
    }

}
