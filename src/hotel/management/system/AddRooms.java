package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
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

public class AddRooms extends JFrame implements ActionListener{

    JTextField t1, t2, t3, t4, t5;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    AddRooms() {

        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setBounds(150, 20, 100, 20);
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("serif", Font.PLAIN, 17));
        room.setBounds(60, 80, 120, 30);
        add(room);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("serif", Font.PLAIN, 17));
        available.setBounds(60, 130, 120, 30);
        add(available);

        c1 = new JComboBox(new String[]{"Avaiable", "Occupied"});
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(200, 130, 150, 30);
        add(c1);

        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("serif", Font.PLAIN, 17));
        status.setBounds(60, 180, 120, 30);
        add(status);

        c2 = new JComboBox(new String[]{"Clean", "Dirty"});
        c2.setFont(new Font("serif", Font.PLAIN, 17));
        c2.setBounds(200, 180, 150, 30);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("serif", Font.PLAIN, 17));
        price.setBounds(60, 230, 120, 30);
        add(price);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(200, 230, 150, 30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("serif", Font.PLAIN, 17));
        type.setBounds(60, 280, 120, 30);
        add(type);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c3.setFont(new Font("serif", Font.PLAIN, 17));
        c3.setBounds(200, 280, 150, 30);
        add(c3);
        
        b1 = new JButton("Add Room");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(60, 350, 130, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(220, 350, 130, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        JLabel l5 = new JLabel(i1);
        l5.setBounds(400, 30, 500, 350);
        add(l5);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(950, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Rooms");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            String room = t1.getText();
            String avaiable = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();
            
            Conn c = new Conn();
            
            try{
                
                String str = "insert into room values('"+room+"', '"+avaiable+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Added Successfuly");
                this.setVisible(false);
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2){
            
            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new AddRooms().setVisible(true);
    }
}
