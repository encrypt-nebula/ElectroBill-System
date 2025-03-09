package electricity.billing.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;

public class newCustomer extends JFrame implements ActionListener {
    JLabel heading, costumerName, meterNum, meterNumText, address, city, state, phoneNum, email;
    JTextField cosNameText, addressText, cityText, stateText, phoneText, emailText;
    JButton next, cancel;

    newCustomer(){
        super("New Costumer");
        setSize(700,500);
        setLocation(350,100);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245,245,245));
        add(panel);

        heading = new JLabel("New Costumer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        costumerName = new JLabel("New Costumer");
        costumerName.setBounds(40,80,100,20);
        costumerName.setFont(new Font("Tahoma",Font.BOLD,14));
        costumerName.setForeground(new Color(44,62,80));
        panel.add(costumerName);

        cosNameText = new JTextField();
        cosNameText.setBounds(180,80,150,23);
        cosNameText.setBorder(BorderFactory.createLineBorder(new Color(188,188,188), 3,true));
        panel.add(cosNameText);

        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(40,120,100,20);
        meterNum.setFont(new Font("Tahoma",Font.BOLD,14));
        meterNum.setForeground(new Color(44,62,80));
        panel.add(meterNum);

        meterNumText = new JLabel("");
        meterNumText.setBounds(180,120,150,20);
        meterNumText.setFont(new Font("Tahoma",Font.BOLD,14));
        meterNumText.setForeground(new Color(44,62,80));
        panel.add(meterNumText);

        city = new JLabel("City");
        city.setBounds(40,200,100,20);
        city.setFont(new Font("Tahoma",Font.BOLD,14));
        city.setForeground(new Color(44,62,80));
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(180,200,150,23);
        cityText.setBorder(BorderFactory.createLineBorder(new Color(188,188,188), 3,true));
        panel.add(cityText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterNumText.setText(""+Math.abs(number));

        address = new JLabel("Address");
        address.setBounds(40,160,100,20);
        address.setFont(new Font("Tahoma",Font.BOLD,14));
        address.setForeground(new Color(44,62,80));
        panel.add(address);

        addressText = new JTextField();
        addressText.setBounds(180,160,150,23);
        addressText.setBorder(BorderFactory.createLineBorder(new Color(188,188,188), 3,true));
        panel.add(addressText);

        state = new JLabel("State");
        state.setBounds(40,240,100,20);
        state.setFont(new Font("Tahoma",Font.BOLD,14));
        state.setForeground(new Color(44,62,80));
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(180,240,150,23);
        stateText.setBorder(BorderFactory.createLineBorder(new Color(188,188,188), 3,true));
        panel.add(stateText);

        phoneNum = new JLabel("Phone Number");
        phoneNum.setBounds(40,280,100,20);
        phoneNum.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneNum.setForeground(new Color(44,62,80));
        panel.add(phoneNum);

        phoneText = new JTextField();
        phoneText.setBounds(180,280,150,23);
        phoneText.setBorder(BorderFactory.createLineBorder(new Color(188,188,188), 3,true));
        panel.add(phoneText);

        email = new JLabel("Email ID");
        email.setBounds(40,320,100,20);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        email.setForeground(new Color(44,62,80));
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(180,320,150,23);
        emailText.setBackground(new Color(255,255,255));
        emailText.setBorder(BorderFactory.createLineBorder(new Color(188, 188, 188), 3,true));
        panel.add(emailText);

        next = new JButton("Next");
        next.setBounds(100,380,100,30);
        next.setBackground(new Color(85,107,47));
        next.setForeground(new Color(255,255,255));
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(230,380,100,30);
        cancel.setBackground(new Color(85,107,47));
        cancel.setForeground(new Color(255,255,255));
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon boy = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/boy.png"));
        Image boyImage = boy.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon boyIcon = new ImageIcon(boyImage);
        JLabel boyLabel = new JLabel(boyIcon);
        add(boyLabel,"East");

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String sname = cosNameText.getText();
            String smeter = meterNumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String sphone = phoneText.getText();
            String semail = emailText.getText();

            String query_costumer = "insert into NewCustomer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+sphone+"','"+semail+"')";
            String query_SignUp = "insert into SignUp values('"+smeter+"','','"+sname+"','','')";

            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate(query_costumer);
                c.statement.executeUpdate(query_SignUp);

                JOptionPane.showMessageDialog(null, "Customer details added successfully!");
                setVisible(false);
                new meterInfo(smeter);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
