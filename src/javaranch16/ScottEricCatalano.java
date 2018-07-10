/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.awt.Color;
import java.awt.Container;
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

class FrameTester {
    JFrame frame2;
    JButton button;
    
    FrameTester() {
        JFrame main = new JFrame("main");
        Container c = main.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.yellow);
        button = new JButton("click to open second frame");
        c.add(button);
        button.addActionListener(this::processClick);
        
        frame2 = new JFrame("second frame");
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
        frame2.setContentPane(panel);
        
        main.setSize(300, 100);
        frame2.setSize(100, 100);
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("frame2 closing....");
                frame2.setVisible(false);
                button.setText("click to open second frame");
            }
        };
        frame2.addWindowListener(wa);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
    
    private void processClick(ActionEvent e) {
        if (frame2.isShowing()) {
            frame2.setVisible(false);
            button.setText("click to open second frame");
        }
        else {
            frame2.setVisible(true);
            button.setText("click to close second frame");
        }
    }
}
