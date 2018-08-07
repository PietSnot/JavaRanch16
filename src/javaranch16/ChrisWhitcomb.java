/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Piet
 */
public class ChrisWhitcomb {

}

class PicView extends JFrame {

    public PicView() {
        createUserInterface();
        setTitle("Picture viewing and sorting application");
        setSize(600, 600);
        setVisible(true);
    }

    public void createUserInterface() {

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        PicDisplay onePic = new PicDisplay();
        contentPane.add(onePic);
    }

    public static void main(String[] args) {
        PicView application = new PicView();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class PicDisplay extends JPanel {

    // Holds text for 'archive or trash' action
    private JLabel archiveOrTrashText;

    // Font for labels
    Font labelFont = new Font("Courier", Font.PLAIN, 18);

    // no arguement constructor
    public PicDisplay() {
        setSize(450, 450);
        setBorder(BorderFactory.createEtchedBorder());
        this.setBackground(Color.red);
        setLayout(null);
        createArchiveOrTrashText();
        setVisible(true);
    }

    private void createArchiveOrTrashText() {
        archiveOrTrashText = new JLabel("Archive or move to trash: ");
        archiveOrTrashText.setForeground(Color.green);
        archiveOrTrashText.setFont(labelFont);
        archiveOrTrashText.setBounds(10, 10, 300, 60);
        archiveOrTrashText.setVisible(true);
        add(archiveOrTrashText);
    }

}
