package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateInformation extends JFrame implements ActionListener {
    String meter;
    JButton updateButton, cancelButton;
    TextField addresText, cityText, stateText, emailText, phoneText;

    updateInformation(String meterNo){
        this.meter = meter;
        setBounds(400,150,600,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading =new JLabel("Update customer Information");
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

        addresText =new TextField();
        addresText.setBounds(170,160,100,20);
        add(addresText);

        JLabel city =new JLabel("City");
        city.setBounds(60,200,100,20);
        add(city);

        cityText =new TextField();
        cityText.setBounds(170,200,100,20);
        add(cityText);

        JLabel state =new JLabel("State");
        state.setBounds(320,80,100,20);
        add(state);

        stateText =new TextField();
        stateText.setBounds(430,80,100,20);
        add(stateText);

        JLabel email =new JLabel("Email");
        email.setBounds(320,120,100,20);
        add(email);

        emailText =new TextField();
        emailText.setBounds(430,120,100,20);
        add(emailText);

        JLabel phone =new JLabel("Phone");
        phone.setBounds(320,160,100,20);
        add(phone);

        phoneText =new TextField();
        phoneText.setBounds(430,160,100,20);
        add(phoneText);

        try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+meter+"'");
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

        updateButton = new JButton("Update");
        updateButton.setBounds(30,250,100,25);
        updateButton.setBackground(new Color(0,90,158));
        updateButton.setForeground(new Color(255,255,255));
        updateButton.addActionListener(this);
        add(updateButton);

        cancelButton = new JButton("Close");
        cancelButton.setBounds(150,250,100,25);
        cancelButton.setBackground(new Color(0,90,158));
        cancelButton.setForeground(new Color(255,255,255));
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon updateImage = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/update.png"));
        Image updateOne = updateImage.getImage().getScaledInstance(190,190, Image.SCALE_DEFAULT);
        ImageIcon updateTwo = new ImageIcon(updateOne);
        JLabel updateImageLabel = new JLabel(updateTwo);
        updateImageLabel.setBounds(310,210,190,190);
        add(updateImageLabel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==updateButton){
            String saddress = addresText.getText();
            String scity =cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate("update NewCustomer set address = '"+saddress+"',city ='"+scity+"',state = '"+sstate+"',email = '"+semail+"',phone = '"+sphone+"'");

                JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
                setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();

            }
        }else{
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new updateInformation("");
    }
}
