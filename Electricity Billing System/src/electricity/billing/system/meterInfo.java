package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocal, meterTypeCho, phaseCodeCho, billTypeCho;
    JButton submit;
    String meter_num;

    meterInfo(String meter_num){
        super("Meter Information");

        this.meter_num = meter_num;

        setSize(700,500);
        setLocation(350,100);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245,245,245));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,24);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumInfo = new JLabel("Meter Number");
        meterNumInfo.setBounds(40,70,100,20);
        meterNumInfo.setFont(new Font("Tahoma",Font.BOLD,14));
        meterNumInfo.setForeground(new Color(44,62,80));
        panel.add(meterNumInfo);

        JLabel meterNumberText = new JLabel(meter_num);
        meterNumberText.setBounds(180,70,100,20);
        meterNumberText.setFont(new Font("Tahoma",Font.BOLD,14));
        meterNumberText.setForeground(new Color(44,62,80));
        panel.add(meterNumberText);

        JLabel meterLoc = new JLabel("Local");
        meterLoc.setBounds(40,110,100,20);
        meterLoc.setFont(new Font("Tahoma",Font.BOLD,14));
        meterLoc.setForeground(new Color(44,62,80));
        panel.add(meterLoc);

        meterLocal = new Choice();
        meterLocal.add("Outside");
        meterLocal.add("Inside");

        JPanel meterChoice = new JPanel();
        meterChoice.setLayout(new BorderLayout());
        meterChoice.add(meterLocal, BorderLayout.CENTER);

        Border greyBorder = BorderFactory.createLineBorder(new Color(188,188,188),3,true);
        meterChoice.setBounds(180,110,150,24);
        meterChoice.setBorder(greyBorder);
        panel.add(meterChoice);

        JLabel meterType = new JLabel("Meter Type");
        meterType.setBounds(40,150,100,20);
        meterType.setFont(new Font("Tahoma",Font.BOLD,14));
        meterType.setForeground(new Color(44,62,80));
        panel.add(meterType);

        meterTypeCho = new Choice();
        meterTypeCho.add("Electric Meter");
        meterTypeCho.add("Solar Meter");
        meterTypeCho.add("Smart Meter");

        JPanel meterTypePanel = new JPanel();
        meterTypePanel.setLayout(new BorderLayout());
        meterTypePanel.add(meterTypeCho, BorderLayout.CENTER);

        meterTypePanel.setBounds(180,150,150,24);
        meterTypePanel.setBorder(greyBorder);
        panel.add(meterTypePanel);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(40,190,100,20);
        phaseCode.setFont(new Font("Tahoma",Font.BOLD,14));
        phaseCode.setForeground(new Color(44,62,80));
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");

        JPanel phaseCodePanel = new JPanel();
        phaseCodePanel.setLayout(new BorderLayout());
        phaseCodePanel.add(phaseCodeCho, BorderLayout.CENTER);

        phaseCodePanel.setBounds(180,190,150,24);
        phaseCodePanel.setBorder(greyBorder);
        panel.add(phaseCodePanel);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(40,230,100,20);
        billType.setFont(new Font("Tahoma",Font.BOLD,14));
        billType.setForeground(new Color(44,62,80));
        panel.add(billType);

        billTypeCho = new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industrial");

        JPanel billTypePanel = new JPanel();
        billTypePanel.setLayout(new BorderLayout());
        billTypePanel.add(billTypeCho, BorderLayout.CENTER);

        billTypePanel.setBounds(180,230,150,24);
        billTypePanel.setBorder(greyBorder);
        panel.add(billTypePanel);

        JLabel day = new JLabel("30 days billing Time...");
        day.setBounds(40,270,200,20);
        day.setFont(new Font("Tahoma",Font.BOLD,14));
        day.setForeground(new Color(44,62,80));
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(40,310,100,20);
        note.setFont(new Font("Tahoma",Font.BOLD,14));
        note.setForeground(new Color(44,62,80));
        panel.add(note);

        JLabel note1 = new JLabel("By default bill is calculated for 30 days only.");
        note1.setBounds(40,330,200,20);
        note1.setFont(new Font("Tahoma",Font.BOLD,14));
        note1.setForeground(new Color(44,62,80));
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(95,390,100,35);
        submit.setBackground(new Color(0,90,158));
        submit.setForeground(new Color(255,255,255));
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon boy = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/details.png"));
        Image boyImage = boy.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon boyIcon = new ImageIcon(boyImage);
        JLabel boyLabel = new JLabel(boyIcon);
        add(boyLabel,"East");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeterNum = meter_num;
            String slocal = meterLocal.getSelectedItem();
            String smeterType = meterTypeCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String bllTypeCho = billTypeCho.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info value('"+smeterNum+"','"+slocal+"','"+smeterType+"','"+sphaseCode+"','"+bllTypeCho+"','"+sday+"')";

            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null,"Meter Information Updated!");

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
