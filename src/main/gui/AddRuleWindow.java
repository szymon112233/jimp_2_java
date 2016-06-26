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
            String tempString = comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
            r.addOperator( tempString.charAt(0) );
            tempString = comboBox2.getItemAt(comboBox2.getSelectedIndex()).toString();
            r.addOperator(tempString.charAt(0)  );

            tempString = comboBox4.getItemAt(comboBox4.getSelectedIndex()).toString();
            if(tempString.charAt(0)=='!')
                r.addVariable(tempString.substring(1),true);
            else
                r.addVariable(tempString,false);
            tempString = comboBox3.getItemAt(comboBox3.getSelectedIndex()).toString();
            if(tempString.charAt(0)=='!')
                r.addVariable(tempString.substring(1),true);
            else
                r.addVariable(tempString,false);

            tempString = comboBox5.getItemAt(comboBox5.getSelectedIndex()).toString();
            if(tempString.charAt(0)=='!')
                r.addVariable(tempString.substring(1),true);
            else
                r.addVariable(tempString,false);
            tempString = comboBox6.getItemAt(comboBox6.getSelectedIndex()).toString();
            if(tempString.charAt(0)=='!')
                r.addVariable(tempString.substring(1),true);
            else
                r.addVariable(tempString,false);

            window.rules.addRule(r);
            window.updateRulesView();


        });
    }
}


