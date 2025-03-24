package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewInformation extends JFrame implements ActionListener {
    String view;
    JButton cancelButton;

    viewInformation(String view){
        this.view = view;
        setBounds(300,90,570,480);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading =new JLabel("View Information");
        heading.setBounds(160,25,300,30);
        heading.setFont(new Font("Poppins",Font.BOLD,20));
        add(heading);

        JLabel nameLabel =new JLabel("Name");
        nameLabel.setBounds(60,80,100,20);
        add(nameLabel);

        JLabel nameLabelText =new JLabel();
        nameLabelText.setBounds(170,80,100,20);
        add(nameLabelText);

        JLabel meter_no =new JLabel("Meter Number");
        meter_no.setBounds(60,120,100,20);
        add(meter_no);

        JLabel meter_noText =new JLabel();
        meter_noText.setBounds(170,120,100,20);
        add(meter_noText);

        JLabel address =new JLabel("Address");
        address.setBounds(60,160,100,20);
        add(address);

        JLabel addresText =new JLabel();
        addresText.setBounds(170,160,100,20);
        add(addresText);

        JLabel city =new JLabel("City");
        city.setBounds(60,200,100,20);
        add(city);

        JLabel cityText =new JLabel();
        cityText.setBounds(170,200,100,20);
        add(cityText);

        JLabel state =new JLabel("State");
        state.setBounds(320,80,100,20);
        add(state);

        JLabel stateText =new JLabel();
        stateText.setBounds(430,80,100,20);
        add(stateText);

        JLabel email =new JLabel("Email");
        email.setBounds(320,120,100,20);
        add(email);

        JLabel emailText =new JLabel();
        emailText.setBounds(430,120,100,20);
        add(emailText);

        JLabel phone =new JLabel("Phone");
        phone.setBounds(320,160,100,20);
        add(phone);

        JLabel phoneText =new JLabel();
        phoneText.setBounds(430,160,100,20);
        add(phoneText);

        try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+view+"'");
            if(result.next()){
                nameLabelText.setText(result.getString("name"));
                meter_noText.setText(result.getString("meterNo"));
                addresText.setText(result.getString("address"));
                cityText.setText(result.getString("city"));
                stateText.setText(result.getString("state"));
                emailText.setText(result.getString("phone"));
                phoneText.setText(result.getString("email"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        cancelButton = new JButton("Close");
        cancelButton.setBounds(30,250,100,25);
        cancelButton.setBackground(new Color(0,90,158));
        cancelButton.setForeground(new Color(255,255,255));
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon infoImage = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/reader.jpg"));
        Image infoOne = infoImage.getImage().getScaledInstance(205,205, Image.SCALE_DEFAULT);
        ImageIcon infoTwo = new ImageIcon(infoOne);
        JLabel infoImageLabel = new JLabel(infoTwo);
        infoImageLabel.setBounds(120,230,305,225);
        add(infoImageLabel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new viewInformation("");
    }
}
