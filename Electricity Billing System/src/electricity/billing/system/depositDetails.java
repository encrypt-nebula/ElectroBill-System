package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class depositDetails extends JFrame implements ActionListener {
    Choice searchMeterCh, MonthCh;
    JTable table;
    JButton searchButton, printButton, closeButton;

    depositDetails(){
        super("Deposit Details");

        getContentPane().setBackground(new Color(187, 187, 187));
        setSize(700,500);
        setLocation(350,100);
        setLayout(null);

        JLabel searchMeter = new JLabel("Search by meter number: ");
            searchMeter.setBounds(20,20,180,20);
            searchMeter.setFont(new Font("Tahoma",Font.BOLD,14));
            searchMeter.setForeground(new Color(44,62,80));
        add(searchMeter);

        searchMeterCh = new Choice();
        searchMeterCh.setBounds(210,20,80,20);
        add(searchMeterCh);

            try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from bill");
            while(result.next()){
                searchMeterCh.add(result.getString("meterNum"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        JLabel searchMonth = new JLabel("Search by Month:");
        searchMonth.setBounds(320,20,180,20);
        searchMonth.setFont(new Font("Tahoma",Font.BOLD,14));
        searchMonth.setForeground(new Color(44,62,80));
        add(searchMonth);

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
        MonthCh.setBounds(520,20,80,20);
        add(MonthCh);



        table = new JTable();
            try{
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(result));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    //        add(table);

        JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0,100,700,500);
            scrollPane.setBackground(Color.white);
        add(scrollPane);

        searchButton = new JButton("Search");
        searchButton.setBounds(25,60,100,25);
        searchButton.setBackground(new Color(0,90,158));
        searchButton.setForeground(new Color(255,255,255));
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(145,60,100,25);
        printButton.setBackground(new Color(0,90,158));
        printButton.setForeground(new Color(255,255,255));
        printButton.addActionListener(this);
        add(printButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(265,60,100,25);
        closeButton.setBackground(new Color(0,90,158));
        closeButton.setForeground(new Color(255,255,255));
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == searchButton) {
        String query_search = "select * from bill where meterNum = '" + searchMeterCh.getSelectedItem() + "' and month = '" + MonthCh.getSelectedItem() + "' ";
        try {
            DataBase c = new DataBase();
            ResultSet result = c.statement.executeQuery(query_search);
            table.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == printButton) {
        try {
            table.print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else {
        setVisible(false);
    }
    setVisible(true);
}

    public static void main(String[] args) {
        new depositDetails();
    }
}
