package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.system.Rule;


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
            comboBox3.addItem("!"+window.data.getName(i));
            comboBox4.addItem(window.data.getName(i));
            comboBox4.addItem("!"+window.data.getName(i));
            comboBox5.addItem(window.data.getName(i));
            comboBox5.addItem("!"+window.data.getName(i));
            comboBox6.addItem(window.data.getName(i));
            comboBox6.addItem("!"+window.data.getName(i));
        }


        button1.addActionListener(ActionListener-> {
            Rule r = new Rule();
            String tempString = comboBox1.getSelectedItem().toString();
            r.addOperator( tempString.charAt(0) );

            tempString = comboBox2.getSelectedItem().toString();
            r.addOperator(tempString.charAt(0)  );

            tempString = comboBox4.getSelectedItem().toString();
            r.addVariable(tempString);

            tempString = comboBox3.getSelectedItem().toString();
            r.addVariable(tempString);

            tempString = comboBox5.getSelectedItem().toString();
            r.addVariable(tempString);

            tempString = comboBox6.getSelectedItem().toString();
            r.addVariable(tempString);

            window.rules.addRule(r);
            window.updateRulesView();


        });
    }
}


