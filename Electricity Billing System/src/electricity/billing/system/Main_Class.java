package electricity.billing.system;

//import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main_Class extends JFrame implements ActionListener{

    String acc_type, meterPass;

    Main_Class(String acc_type, String meterPass){
        super("Electricity Billing System");
        this.acc_type = acc_type;
        this.meterPass = meterPass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/main_image.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1300,645, Image.SCALE_DEFAULT);
        ImageIcon bgOne = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(bgOne);
        add(bgLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem new_Customer = new JMenuItem("New Customer");
        new_Customer.setFont(new Font("monospace", Font.PLAIN, 13));
        ImageIcon newCosIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/newcustomer.png"));
        Image newCosImage = newCosIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        new_Customer.setIcon(new ImageIcon(newCosImage));
        new_Customer.addActionListener(this);
        menu.add(new_Customer);

        JMenuItem cosDetail = new JMenuItem("Costumer Detail");
        cosDetail.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon cosDetailIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/customerDetails.png"));
        Image cosDetailImage = cosDetailIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        cosDetail.setIcon(new ImageIcon(cosDetailImage));
        cosDetail.addActionListener(this);
        menu.add(cosDetail);

        JMenuItem depDetail = new JMenuItem("Deposit Details");
        depDetail.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon depDetailIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/depositDetails.png"));
        Image depDetailImage = depDetailIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depDetail.setIcon(new ImageIcon(depDetailImage));
        depDetail.addActionListener(this);
        menu.add(depDetail);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon calculateIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/calculatorbills.png"));
        Image calculateImage = calculateIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateImage));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem updateInfo = new JMenuItem("Update Information");
        updateInfo.setFont(new Font("monospace", Font.PLAIN,13));
        ImageIcon updateInfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/update.png"));
        Image updateImage = updateInfoIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateInfo.setIcon(new ImageIcon(updateImage));
        updateInfo.addActionListener(this);
        info.add(updateInfo);

        JMenuItem viewInfo = new JMenuItem("View information");
        viewInfo.setFont(new Font("monospace", Font.PLAIN,13));
        ImageIcon viewInfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/viewinfo.png"));
        Image viewInfoImage = viewInfoIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem payBills = new JMenuItem("Pay Bills");
        payBills.setFont(new Font("monospace", Font.PLAIN,13));
        ImageIcon payBillsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/pay.png"));
        Image payBillsImage = payBillsIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBills.setIcon(new ImageIcon(payBillsImage));
        payBills.addActionListener(this);
        user.add(payBills);

        JMenuItem billdetails =new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/detail.png"));
        Image billdetailsImage = billdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));



        JMenuItem genBill =new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon genBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/bill.png"));
        Image genBillImage = genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));



        JMenuItem notepad =new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);


        JMenuItem calculator =new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/calculator.png"));
        Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(exit);


        JMenuItem eexit =new JMenuItem("Exit");
        eexit.setFont(new Font("monospace",Font.PLAIN,13));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/exit.png"));
        Image eexitImage = eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if(acc_type.equals("Admin")){
            menuBar.add(menu);
        } else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new newCustomer();
        } else if(msg.equals("Costumer Detail")){
            new customerDetail();
        } else if(msg.equals("Deposit Details")){
            new depositDetails();
        } else if(msg.equals("Calculate Bill")){
            new calculate_bill();
        } else if(msg.equals("Update Information")){
            new updateInformation(meterPass);
        } else if(msg.equals("View information")){
            new viewInformation(meterPass);
        } else if(msg.equals("Pay Bills")){
            new pay_bill(meterPass);
        } else if(msg.equals("Bill Details")){
            new bill_details(meterPass);
        } else if(msg.equals("Generate Bill")){
            new generateBill(meterPass);
        } else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {

        new Main_Class("","");
    }
}
