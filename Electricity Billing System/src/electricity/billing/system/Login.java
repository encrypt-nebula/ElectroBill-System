package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    TextField userText, passwordText;
    Choice loginAs;
    JButton loginButton, signUpButton, cancelButton;

    Login(){
        super("Log-in");

        ImageIcon userImage = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/user.png"));
        Image userOne = userImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon imageTwo = new ImageIcon(userOne);
        JLabel userImageLabel = new JLabel(imageTwo);
        userImageLabel.setBounds(20,1,270,270);
        add(userImageLabel);

        JLabel userName = new JLabel("User-Name");
        userName.setBounds(300,60,100,20);
        add(userName);

        userText = new TextField();
        userText.setBounds(400,60,100,20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(400,100,100,20);
        add(passwordText);

        JLabel loginCred = new JLabel("Login as");
        loginCred.setBounds(300,140,100,20);
        add(loginCred);

        loginAs = new Choice();
        loginAs.add("Customer");
        loginAs.add("Admin");
        loginAs.setBounds(400,140,100,20);
        add(loginAs);

        loginButton = new JButton("Log-in");
        loginButton.setBounds(350, 180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        signUpButton = new JButton("Sign-Up");
        signUpButton.setBounds(470, 180,100,20);
        signUpButton.addActionListener(this);
        add(signUpButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(400, 210,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(640,300);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = loginAs.getSelectedItem();

            try{
                DataBase c = new DataBase();
                String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and user_type = '"+suser+"'";
                ResultSet result = c.statement.executeQuery(query);

                if(result.next()){
                    String meter = result.getString("meter_no");
                    setVisible(false);
                    new Main_Class(suser,meter);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            } catch(Exception x){
                x.printStackTrace();
            }


        } else if(e.getSource() == cancelButton){
            setVisible(false);
        } else if(e.getSource() == signUpButton){
            setVisible(false);
            new SignUp();
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
