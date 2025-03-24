package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculate_bill extends JFrame implements ActionListener{
    JLabel nameText, addressText;
    JTextField unitConsumedText;
    JButton submit, cancel;

    Choice meternumCh, monthCho;

    calculate_bill() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70, 10, 300, 30);
        heading.setFont(new Font("Montserrat", Font.BOLD, 20));
        heading.setForeground(new Color(41, 103, 127));
        panel.add(heading);

        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(40, 70, 100, 20);
        meternum.setFont(new Font("Montserrat", Font.BOLD, 14));
        meternum.setForeground(new Color(53, 96, 152));
        panel.add(meternum);

        meternumCh = new Choice();
        try {
            DataBase c = new DataBase();
            ResultSet resultSet = c.statement.executeQuery("select * from NewCustomer");
            while (resultSet.next()) {
                meternumCh.add(resultSet.getString("meterNo"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JPanel meterChoice = new JPanel();
        meterChoice.setLayout(new BorderLayout());
        meterChoice.add(meternumCh, BorderLayout.CENTER);

        Border greyBorder = BorderFactory.createLineBorder(new Color(16, 111, 116), 4, true);
        meterChoice.setBounds(180, 70, 100, 27);
        meterChoice.setBorder(greyBorder);
        panel.add(meterChoice);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 110, 100, 20);
        name.setFont(new Font("Montserrat", Font.BOLD, 14));
        name.setForeground(new Color(53, 96, 152));
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180, 110, 100, 20);
        nameText.setFont(new Font("Montserrat", Font.BOLD, 14));
        nameText.setForeground(new Color(41, 107, 136));
        panel.add(nameText);

        JLabel address = new JLabel("Address");
        address.setBounds(40, 150, 100, 20);
        address.setFont(new Font("Montserrat", Font.BOLD, 14));
        address.setForeground(new Color(53, 96, 152));
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180, 150, 100, 20);
        addressText.setFont(new Font("Montserrat", Font.BOLD, 14));
        addressText.setForeground(new Color(41, 107, 136));
        panel.add(addressText);

        try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+meternumCh.getSelectedItem()+"' ");
            while(result.next()){
                nameText.setText(result.getString("name"));
                addressText.setText(result.getString("address"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        meternumCh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    DataBase c = new DataBase();
                    ResultSet result = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+meternumCh.getSelectedItem()+"' ");
                    while(result.next()){
                        nameText.setText(result.getString("name"));
                        addressText.setText(result.getString("address"));
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JLabel unitConsumed = new JLabel("Unit Consumed");
        unitConsumed.setBounds(40, 190, 150, 20);
        unitConsumed.setFont(new Font("Montserrat", Font.BOLD, 14));
        unitConsumed.setForeground(new Color(53, 96, 152));
        panel.add(unitConsumed);

        unitConsumedText = new JTextField();
        unitConsumedText.setBounds(180, 190, 100, 24);
        unitConsumedText.setBorder(BorderFactory.createLineBorder(new Color(16, 111, 116), 4,true));
        panel.add(unitConsumedText);

        JLabel month = new JLabel("Month");
        month.setBounds(40, 230, 100, 20);
        month.setFont(new Font("Montserrat", Font.BOLD, 14));
        month.setForeground(new Color(53, 96, 152));
        panel.add(month);

        monthCho = new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");

        JPanel meterTypePanel = new JPanel();
        meterTypePanel.setLayout(new BorderLayout());
        meterTypePanel.add(monthCho, BorderLayout.CENTER);

        meterTypePanel.setBounds(180, 230, 100, 27);
        meterTypePanel.setBorder(greyBorder);
        panel.add(meterTypePanel);

        submit = new JButton("Submit");
        submit.setBounds(50,285,100,35);
        submit.setBackground(new Color(53, 96, 152));
        submit.setFont(new Font("Montserrat", Font.BOLD, 16));
        submit.setForeground(new Color(255,255,255));
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(175,285,100,35);
        cancel.setBackground(new Color(53, 96, 152));
        cancel.setFont(new Font("Montserrat", Font.BOLD, 16));
        cancel.setForeground(new Color(255,255,255));
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon budget = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/budget.jpg"));
        Image budgetImage = budget.getImage().getScaledInstance(300,450,Image.SCALE_DEFAULT);
        ImageIcon budgetIcon = new ImageIcon(budgetImage);
        JLabel budgetLabel = new JLabel(budgetIcon);
        add(budgetLabel,"East");

        setSize(650, 400);
        setLocation(400, 100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeter_num = meternumCh.getSelectedItem();
            String smonth = monthCho.getSelectedItem();
            String sunit = unitConsumedText.getText();

            int totalBill = 0;
            int units = Integer.parseInt(sunit);
            String query_tax = "select * from tax";
            try{
                DataBase c = new DataBase();
                ResultSet resultSet = c.statement.executeQuery(query_tax);
                while (resultSet.next()){
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_tax"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("swachchh_Bharat"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));

                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            String query_bill = "insert into bill values('"+smeter_num+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";
            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate(query_bill);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }

        } else{
            setVisible(false);
        }
    }

    public static void main (String[] args){
        new calculate_bill();
    }
}
