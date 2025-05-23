package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generateBill extends JFrame implements ActionListener {
    String meter;
    Choice monthCho;
    JTextArea area;
    JButton bill;

    generateBill(String meter){
        this.meter = meter;
        setBounds(450,30,410,600);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");

        JLabel meter_no = new JLabel(meter);

        JLabel month = new JLabel("Month");

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


        area = new JTextArea(50,15);
        area.setText("\n \n \t --------Click on the --------------\n \t--------Generate Bill-----");
        area.setFont(new Font("Seneserif", Font.ITALIC,15));
        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        add(bill,"South");

        add(pane);
        panel.add(heading);
        panel.add(meter_no);
        panel.add(monthCho);
        add(panel, "North");


        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            DataBase c = new DataBase();
            String smonth = monthCho.getSelectedItem();
            area.setText("\n Power Limited\n Electricity Bill For Month of '"+smonth+"',2023\n\n\n");
            ResultSet resultSet = c.statement.executeQuery("select * from NewCustomer where meterNo = '"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Name                  : "+resultSet.getString("name"));
                area.append("\n    Customer Meter Number       : "+resultSet.getString("meterNo"));
                area.append("\n    Customer Address               : "+resultSet.getString("address"));
                area.append("\n    Customer City                    : "+resultSet.getString("city"));
                area.append("\n    Customer State                   : "+resultSet.getString("state"));
                area.append("\n    Customer Email                  : "+resultSet.getString("email"));
                area.append("\n    Customer Phone Number      : "+resultSet.getString("phone"));

            }

            resultSet = c.statement.executeQuery("select * from meter_info where meter_num ='"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Meter Location     : "+resultSet.getString("location"));
                area.append("\n    Customer Meter Type          : "+resultSet.getString("meter_type"));
                area.append("\n    Customer Phase Code         : "+resultSet.getString("phase_Code"));
                area.append("\n    Customer Bill Type             : "+resultSet.getString("bill_Type"));
                area.append("\n    Customer Days                  : "+resultSet.getString("days"));


            }
            resultSet = c.statement.executeQuery("select * from tax");
            if (resultSet.next()){
                area.append("\n   Cost Per Unit                     : "+resultSet.getString("cost_per_unit"));
                area.append("\n   Meter Rent                        : "+resultSet.getString("meter_rent"));
                area.append("\n   Service Charge                  : "+resultSet.getString("service_charge"));
                area.append("\n   Service Tax                  : "+resultSet.getString("service_tax"));
                area.append("\n   Swachchh Bharat               : "+resultSet.getString("swachchh_Bharat"));
                area.append("\n   Fixed Tax                         : "+resultSet.getString("fixed_tax"));

            }
            resultSet = c.statement.executeQuery("select * from bill where meterNum = '"+meter+"' and month = '"+monthCho.getSelectedItem()+"'");
            if (resultSet.next()) {
                area.append("\n    Current Month               : " + resultSet.getString("month"));
                area.append("\n   Units Consumed             : " + resultSet.getString("unit_consumption"));
                area.append("\n   Total Charges                : " + resultSet.getString("total_bill"));
                area.append("\n Total Payable                   : "+resultSet.getString("total_bill"));
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generateBill("");
    }
}
