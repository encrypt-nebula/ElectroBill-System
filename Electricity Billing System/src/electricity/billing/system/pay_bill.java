package electricity.billing.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class pay_bill extends JFrame implements ActionListener {
    String meter;
    Choice MonthCh;
    JButton payButton, backButton;

    pay_bill(String meter){
        this.meter = meter;

        setBounds(200,100,570,370);
        setLayout(null);

        JLabel heading =new JLabel("Pay Bill");
        heading.setBounds(200,25,180,30);
        heading.setFont(new Font("Poppins",Font.BOLD,20));
        add(heading);

        JLabel meterNumber =new JLabel("MeterNumber");
        meterNumber.setBounds(60,80,100,20);
        add(meterNumber);

        JLabel meterText =new JLabel();
        meterText.setBounds(170,80,100,20);
        add(meterText);

        JLabel name =new JLabel("Name");
        name.setBounds(60,120,100,20);
        add(name);

        JLabel nameText =new JLabel();
        nameText.setBounds(170,120,100,20);
        add(nameText);

        JLabel address =new JLabel("Address");
        address.setBounds(60,160,100,20);
        add(address);

        JLabel addresText =new JLabel();
        addresText.setBounds(170,160,100,20);
        add(addresText);

        JLabel month =new JLabel("Month");
        month.setBounds(60,200,100,20);
        add(month);

        MonthCh = new Choice();
        MonthCh.add("January");
        MonthCh.add("February");
        MonthCh.add("March");
        MonthCh.add("April");
        MonthCh.add("May");
        MonthCh.add("June");
        MonthCh.add("July");
        MonthCh.add("August");
        MonthCh.add("September");
        MonthCh.add("October");
        MonthCh.add("November");
        MonthCh.add("December");
        MonthCh.setBounds(170,200,80,20);
        add(MonthCh);

        JLabel unit =new JLabel("Unit");
        unit.setBounds(320,80,100,20);
        add(unit);

        JLabel unitText =new JLabel();
        unitText.setBounds(430,80,100,20);
        add(unitText);

        JLabel totalBill =new JLabel("Total Bill");
        totalBill.setBounds(320,120,100,20);
        add(totalBill);

        JLabel totalBillText =new JLabel();
        totalBillText.setBounds(430,120,100,20);
        add(totalBillText);

        JLabel status =new JLabel("Status");
        status.setBounds(320,160,100,20);
        add(status);

        JLabel statusText =new JLabel();
        statusText.setBounds(430,160,100,20);
        statusText.setForeground(new Color(255, 75, 75));
        add(statusText);

        try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+meter+"'");
            while(result.next()){
                meterText.setText(meter);
                nameText.setText(result.getString("name"));
                addresText.setText(result.getString("address"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        MonthCh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                DataBase c = new DataBase();
                try{
                    ResultSet result = c.statement.executeQuery("select * from bill where meterNum = '"+meter+"' and month = '"+MonthCh.getSelectedItem()+"'");
                    while(result.next()){
                        unitText.setText(result.getString("unit_consumption"));
                        totalBillText.setText(result.getString("total_bill"));
                        statusText.setText(result.getString("status"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        payButton = new JButton("Pay");
        payButton.setBounds(130,250,100,25);
        payButton.setBackground(new Color(0,90,158));
        payButton.setForeground(new Color(255,255,255));
        payButton.addActionListener(this);
        add(payButton);

        backButton = new JButton("Back");
        backButton.setBounds(250,250,100,25);
        backButton.setBackground(new Color(0,90,158));
        backButton.setForeground(new Color(255,255,255));
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==payButton){
            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate("update bill set status = 'Paid' where meterNum = '"+meter+"' and month = '"+MonthCh.getSelectedItem()+"'");
            }catch(Exception ex){
                ex.printStackTrace();
            }
            setVisible(false);
            new payment_Bill(meter);
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pay_bill("");
    }
}
