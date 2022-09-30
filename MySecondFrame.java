import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MySecondFrame extends JFrame implements ActionListener {
    Hangman hangman = new Hangman();
    

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
    

    MySecondFrame() throws FileNotFoundException{
        
        
        
        
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

        buttonA.setText("A");
        buttonB.setText("B");
        buttonC.setText("C");
        buttonD.setText("D");
        buttonE.setText("E");
        buttonF.setText("F");
        buttonG.setText("G");
        buttonH.setText("H");
        buttonI.setText("I");
        buttonJ.setText("J");
        buttonK.setText("K");
        buttonL.setText("L");
        buttonM.setText("M");
        buttonN.setText("N");
        buttonO.setText("O");
        buttonP.setText("P");
        buttonQ.setText("Q");
        buttonR.setText("R");
        buttonS.setText("S");
        buttonT.setText("T");
        buttonU.setText("U");
        buttonV.setText("V");
        buttonY.setText("Y");
        buttonZ.setText("Z");
        buttonX.setText("X");
        buttonW.setText("W");

        
        
        

        
        for (JButton button : buttonList){
            
            //Bounds should be determined.
            button.setFont(new Font("MV Boli", Font.BOLD,20));
            button.setBorder(null);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.getCursor();
            button.setRolloverEnabled(true);
            button.addActionListener(this);
            button.setBackground(Color.WHITE);
            button.setFocusable(false);
        }
        
        
        


        JPanel panel = new JPanel();
        for(JButton button : buttonList){
            panel.add(button);
        }
        
        panel.setBounds(0,400,550,180);
        //panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(label1());
        panel.add(label2());
        
        
        


        

            
        this.setSize(550,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("indir.png");
        this.setIconImage(image.getImage());
        this.setTitle("HangmanGame");
        this.getContentPane().setBackground(Color.WHITE);
        this.add(panel);
        this.add(label0());
        

        
        
    }
    
    public JLabel label0(){
        JLabel label0 = new JLabel();
        label0.setBounds(150, 0, 420, 220);
        label0.setOpaque(true);
        label0.setText("" + hangman.getKnownSoFar());
        label0.setFont(new Font("MV Boli", Font.BOLD,22));
        label0.setBackground(Color.white);
        return label0;
    }
    public JLabel label1(){
        JLabel label1 = new JLabel();
        label1.setBounds(50, 0, 420, 220);
        label1.setOpaque(true);
        label1.setText("Score: " + "        ");
        label1.setFont(new Font("MV Boli", Font.BOLD,22));
        label1.setBackground(Color.white);
        return label1;
    }
    public JLabel label2(){
        JLabel label2 = new JLabel();
        label2.setBounds(80, 0, 420, 220);
        label2.setOpaque(true);
        label2.setText("Left Attend: " + " " + (hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()));
        label2.setFont(new Font("MV Boli", Font.BOLD,22));
        label2.setBackground(Color.white);
        return label2;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       for(JButton button : buttonList){
        if(e.getSource() == button){
            button.setEnabled(false);
            hangman.tryThis(button.getText());
            System.out.println(hangman.getKnownSoFar());
            this.dispose();
            try {
                new MySecondFrame();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
       }
        
    }
}
