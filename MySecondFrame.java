import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MySecondFrame extends JFrame implements ActionListener {
    ArrayList<JButton> buttonList = new ArrayList<>();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton buttonE = new JButton();
    JButton buttonF = new JButton();
    JButton buttonG = new JButton();
    JButton buttonH = new JButton();
    JButton buttonI = new JButton();
    JButton buttonJ = new JButton();
    JButton buttonK = new JButton();
    JButton buttonL = new JButton();
    JButton buttonM = new JButton();
    JButton buttonN = new JButton();
    JButton buttonO = new JButton();
    JButton buttonP = new JButton();
    JButton buttonQ = new JButton();
    JButton buttonR = new JButton();
    JButton buttonS = new JButton();
    JButton buttonT = new JButton();
    JButton buttonU = new JButton();
    JButton buttonV = new JButton();
    JButton buttonY = new JButton();
    JButton buttonZ = new JButton();
    JButton buttonX = new JButton();
    JButton buttonW = new JButton();
    
    MySecondFrame(){
        buttonList.add(buttonA);
        buttonList.add(buttonB);
        buttonList.add(buttonC);
        buttonList.add(buttonD);
        buttonList.add(buttonE);
        buttonList.add(buttonF);
        buttonList.add(buttonG);
        buttonList.add(buttonH);
        buttonList.add(buttonI);
        buttonList.add(buttonJ);
        buttonList.add(buttonK);
        buttonList.add(buttonL);
        buttonList.add(buttonM);
        buttonList.add(buttonN);
        buttonList.add(buttonO);
        buttonList.add(buttonP);
        buttonList.add(buttonQ);
        buttonList.add(buttonR);
        buttonList.add(buttonS);
        buttonList.add(buttonT);
        buttonList.add(buttonU);
        buttonList.add(buttonV);
        buttonList.add(buttonY);
        buttonList.add(buttonZ);
        buttonList.add(buttonX);
        buttonList.add(buttonW);

        
        for (JButton button : buttonList){
            button.setText("Start");
            //Bounds should be determined.
            button.setFont(new Font("MV Boli", Font.BOLD,20));
            button.setBorder(null);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.getCursor();
            button.setRolloverEnabled(true);
            button.addActionListener(this);
            button.setBackground(Color.WHITE);
        }

            
        this.setSize(550,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("indir.png");
        this.setIconImage(image.getImage());
        this.setTitle("HangmanGame");
        this.getContentPane().setBackground(Color.WHITE);
        

        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
