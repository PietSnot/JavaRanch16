/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Piet
 */
public class BlaineJackson2 {

}

class JVacationFrame2 extends JFrame implements ActionListener {

    JLabel loc = new JLabel("Select a location: ");
    JRadioButton lc1 = new JRadioButton("ParkSide $600");
    JRadioButton lc2 = new JRadioButton("LakeSide $750");
    JRadioButton lc3 = new JRadioButton("PoolSide $825");
    JRadioButton r = new JRadioButton("1 room for no additional cost");
    JRadioButton r2 = new JRadioButton("2 rooms for $475");
    JRadioButton r3 = new JRadioButton("3 rooms for $150");
    JCheckBox meal = new JCheckBox("Include Meals for $200");
    JCheckBox none = new JCheckBox("No meals");

    JTextField finaltotal = new JTextField(8);
    final int parkside = 600, poolside = 750, lakeside = 825;
    final int m = 200, oner = 0, twor = 75, threer = 150;
    int total = 0;

    public JVacationFrame2() {
        super("Lambert's Vaction Rentals");
        setSize(400, 600);
        setLayout(new FlowLayout());
        ButtonGroup location = new ButtonGroup();
        add(lc1);
        add(lc2);
        add(lc3);
        lc1.addActionListener(this);
        lc2.addActionListener(this);
        lc3.addActionListener(this);
        ButtonGroup rooms = new ButtonGroup();
        add(r);
        add(r2);
        add(r3);
        r.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        ButtonGroup meals = new ButtonGroup();
        add(meal);
        add(none);
        meal.addActionListener(this);
        none.addActionListener(this);
        System.out.println(Integer.toBinaryString(2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (lc1.isSelected()) {
            total = parkside;
        }
        if (lc2.isSelected()) {
            total = lakeside;
        }
        if (lc3.isSelected()) {
            total = poolside;
        }
        if (r.isSelected()) {
            total += oner;
        }
        if (r2.isSelected()) {
            total += twor;
        }
        if (r3.isSelected()) {
            total += threer;
        }
        if (meal.isSelected()) {
            total += m;
        } else if (none.isSelected()) {
            total -= 0;
        }
        finaltotal.setText("$" + total);
    }
}

class JVacationFrameDemo2 {

    public static void main(String[] args) {
        // TODO code application logic here
        JVacationFrame2 v = new JVacationFrame2();
        v.setVisible(true);
    }
}


