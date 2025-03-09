package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Jyarv extends JFrame {
    Jyarv(){
        super("Jyarv");

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Jyarv.png"));
        getContentPane().setBackground(Color.white);
        Image iconImage = image.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(iconImage);
        JLabel iconLabel = new JLabel(image2);
        add(iconLabel);

        setSize(640,360);
        setLocation(300,150);
        setVisible(true);

        try{
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }

        }
    public static void main(String[] args) {
        new Jyarv();
    }
}