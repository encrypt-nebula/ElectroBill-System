package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignUp extends JFrame implements ActionListener{
    TextField employeeText, userText, nameText, passwordText, meterText;
    Choice createAs;
    JButton backButton, createButton;

    SignUp(){
        super("SignUp Page");

        getContentPane().setBackground(new Color(115,115,115));

        ImageIcon employeeImage = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/employee.png"));
        Image employeeOne = employeeImage.getImage().getScaledInstance(270, 270, Image.SCALE_DEFAULT);
        ImageIcon employeeIcon = new ImageIcon(employeeOne);
        JLabel employeeLabel = new JLabel(employeeIcon);
        employeeLabel.setBounds(330,30,270,270);
        add(employeeLabel);

        JLabel account = new JLabel("Create Account as");
        account.setBounds(30,50,100,20);
        add(account);

        createAs = new Choice();
        createAs.add("Admin");
        createAs.add("Customer");
        createAs.setBounds(150,50,120,20);
        add(createAs);


        JLabel employeeID = new JLabel("Employee ID");
        employeeID.setBounds(30,90,100,20);
        employeeID.setVisible(true);
        add(employeeID);

        employeeText = new TextField();
        employeeText.setBounds(150,90,120,20);
        employeeText.setVisible(true);
        add(employeeText);

        JLabel meterNum = new JLabel("Meter Number");
        meterNum.setBounds(30,90,100,20);
        meterNum.setVisible(false);
        add(meterNum);

        meterText = new TextField();
        meterText.setBounds(150,90,120,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel userName = new JLabel("User-Name");
        userName.setBounds(30,130,100,20);
        add(userName);

        userText = new TextField();
        userText.setBounds(150,130,120,20);
        add(userText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,170,100,20);
        add(name);

        nameText = new TextField("");
        nameText.setBounds(150,170,120,20);
        add(nameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    DataBase c = new DataBase();
                    ResultSet result = c.statement.executeQuery("select * from Signup where meter_no = '"+meterText.getText()+"'");
                    if(result.next()){
                        nameText.setText(result.getString("name"));
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(30,210,100,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(150,210,120,20);
        add(passwordText);

        createAs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                String user = createAs.getSelectedItem();
                if(user.equals("Customer")){
                    employeeID.setVisible(false);
                    nameText.setEditable(false);
                    employeeText.setVisible(false);
                    meterNum.setVisible(true);
                    meterText.setVisible(true);
                } else if(user.equals("Admin")){
                    employeeID.setVisible(true);
                    employeeText.setVisible(true);
                    meterNum.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        createButton = new JButton("Create");
        createButton.setBounds(30,265,100,20);
        createButton.addActionListener(this);
        add(createButton);

        backButton = new JButton("Back");
        backButton.setBounds(160,265,100,20);
        backButton.addActionListener(this);
        add(backButton);

        setSize(640,360);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == createButton){
             String schoice = createAs.getSelectedItem();
             String susername = userText.getText();
             String sname = nameText.getText();
             String spassword = passwordText.getText();
             String smeterNum = meterText.getText();

             try{
                DataBase c = new DataBase();
                String query = null;
                if(schoice.equals("Admin")) {
                    query = "insert into Signup value('"+smeterNum+"', '"+susername+"', '"+sname+"','"+spassword+"','"+schoice+"')";
                } else{
                    query = "update Signup set username = '"+susername+"',password = '"+spassword+"',user_type = '"+schoice+"' where meter_no = '"+smeterNum+"'";
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();

             }catch(Exception x){
                 x.printStackTrace();
             }
         } else if(e.getSource() == backButton){
             setVisible(false);
             new Login();
         }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}