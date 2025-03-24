package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class bill_details extends JFrame {
    String meter;
    bill_details(String meter){
        this.meter = meter;

        setBounds(300,50,700,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JTable table = new JTable();
        try{
            DataBase c = new DataBase();
            String query_bill = "select * from bill where meterNum = '"+meter+"'";
            ResultSet result = c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(result));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);

        setVisible(true);

    }

    public static void main(String[] args) {
        new bill_details("");
    }
}
