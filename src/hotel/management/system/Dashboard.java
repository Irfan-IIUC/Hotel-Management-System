
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1, i2, i3, i4;
    
    Dashboard(){
        
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("HOTEL MANGEMENT");
        m1.setForeground(Color.BLUE);
        mb.add(m1);
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setSize(1200, 30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1200, 880);
        add(l1);
        
        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setBounds(250, 0, 1200, 150);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN, 45));
        l1.add(l2);
        
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Dashboard");
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("Reception")){
            
            new Reception().setVisible(true);
            
        } else if(ae.getActionCommand().equals("Add Employee")){
            
            new AddEmployee().setVisible(true);
            
        } else if(ae.getActionCommand().equals("Add Rooms")){
            
            new AddRooms().setVisible(true);
            
        } else if(ae.getActionCommand().equals("Add Drivers")){
            
            new AddDriver().setVisible(true);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        new Dashboard().setVisible(true);
    }
}
