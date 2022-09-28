import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;

public class Myframe extends JFrame implements Action{
    JButton startButton = new JButton();
    JButton exitButton = new JButton();
    Myframe(){
        
        startButton.setText("Start");
        startButton.setBounds(200,300, 100, 30);
        startButton.setBackground(Color.white);
        startButton.setFont(new Font("MV Boli", Font.BOLD,30));
        startButton.setBorder(null);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.getCursor();
        startButton.setRolloverEnabled(true);
        startButton.addActionListener(this);

        exitButton.setText("Exit");
        exitButton.setBounds(200,350, 100, 30);
        exitButton.setBackground(Color.white);
        exitButton.setFont(new Font("MV Boli", Font.BOLD,30));
        exitButton.setBorder(null);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.getCursor();
        exitButton.setRolloverEnabled(true);
        exitButton.addActionListener(this);

       
        
        
        

        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("icon.png");
        label.setIcon(icon);
        label.setBounds(50, 0, 420, 220);
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        

        
        this.setTitle("HangmanGame");
        this.setResizable(false);
        this.setSize(550,600);
        this.setBackground(Color.white);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("indir.png");
        this.setIconImage(image.getImage());
        this.add(label);
        this.add(startButton);
        this.add(exitButton);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == startButton){
            System.out.println("poo");
        }
        if (e.getSource()== exitButton){
            this.dispose();
        }
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        
    }
    
}
