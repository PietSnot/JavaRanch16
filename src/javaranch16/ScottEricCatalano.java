/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Piet
 */
public class ScottEricCatalano {
    public static void main(String... args) {
        SwingUtilities.invokeLater(FrameTester::new);
    }
}

//*******************************************************************
class FrameTester {
//*******************************************************************
    JFrame main, secondFrame;
    JButton button;
    
    //--------------------------------------------------
    FrameTester() {
        createMainFrame();
        createSecondFrame();
        createWindowAdapter();
        main.setVisible(true);
    }
    
    //--------------------------------------------------
    private void processClick(ActionEvent e) {
        if (secondFrame.isShowing()) {
            secondFrame.setVisible(false);
            button.setText("click to open second frame");
        }
        else {
            secondFrame.setVisible(true);
            button.setText("click to close second frame");
        }
    }
    
   //--------------------------------------------------
   private void createMainFrame() {
        main = new JFrame("main");
        Container c = main.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.yellow);
        
        button = new JButton("click to open second frame");
        c.add(button);
        button.addActionListener(this::processClick);
        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("frame2 closing....");
                secondFrame.dispose();
                System.out.println("shutting down...");
                System.exit(0);
            }
        };
        main.addWindowListener(wa);
        main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        main.setSize(300, 100);
        main.setLocationRelativeTo(null);
    }
    
    //--------------------------------------------------
    private void createSecondFrame() {
        secondFrame = new JFrame("second frame");
        File f = new File("D:\\Piets fotoos\\2006-07-22 001.jpg");
        BufferedImage buf;
        try {
            buf = ImageIO.read(f);
        }
        catch (IOException e) {
            System.out.println("Can't load image");
            return;
        }
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(buf, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        secondFrame.setContentPane(panel);
        secondFrame.setSize(100, 100);
        secondFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    //--------------------------------------------------
    private void createWindowAdapter() {
        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("frame2 closing....");
                secondFrame.setVisible(false);
                button.setText("click to open second frame");
            }
            @Override
            public void windowIconified(WindowEvent we) {
                System.out.println("frame2 iconified....");
                button.setText("use the taskbar to open second frame");
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("second frame de-iconified....");
                button.setText("click to close frame2...");
            }
        };
        secondFrame.addWindowListener(wa);
    }
}
