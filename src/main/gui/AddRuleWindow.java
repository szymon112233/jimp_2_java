package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Szymon on 2016-06-15.
 */
public class AddRuleWindow {

    public JPanel mainPanel;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;


    public AddRuleWindow(MainWindow window) {

        comboBox1.addItem("&&");
        comboBox2.addItem("&&");
        comboBox1.addItem("||");
        comboBox2.addItem("||");

        for (int i=0 ; i<window.data.getSize() ; i++)
        {
            comboBox3.addItem(window.data.getName(i));
            comboBox4.addItem(window.data.getName(i));
            comboBox5.addItem(window.data.getName(i));
            comboBox6.addItem(window.data.getName(i));
        }


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}


