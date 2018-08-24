/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Piet
 */
public class PeterSeeger {

}

class Main2 {

    int variable = 1;

    JButton button = new JButton("Set in class Main");

    public static void main(String[] args) {

        Main2 mainObject = new Main2();

        mainObject.buttonManager();
    }

    public void buttonManager() {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        panel.add(button);
        frame.add(panel);
        panel.setPreferredSize(new Dimension(200, 200));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ChangeButton changeButtonObject = new ChangeButton();

        if (variable == 2) {

            //calling a working method from another class
        }

        if (variable == 1) {
            while (true) {
                changeButtonObject.setActionListener(button);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}

class ChangeButton {

    public void setActionListener(JButton button) {

//        Main2 mainObject = new Main2();

        System.out.println("this line works");

//        mainObject.button.setText("set in ChangeButton");
//        mainObject.button.setBackground(Color.RED);
         button.setBackground(button.getBackground().equals(Color.RED) ? Color.GREEN : Color.RED);

        System.out.println("this line works a well");
    }

}
