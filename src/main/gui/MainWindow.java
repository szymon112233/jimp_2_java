package main.gui;

import main.system.Data;
import main.system.Logic;
import main.system.Rules;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Szymon on 2016-05-31.
 */
public class MainWindow {
    public JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextArea textChaining;
    private JTextArea textData;
    private JTextArea textRules;
    private JButton addDataButton;
    private JButton saveDataButton;
    private JButton loadDataButton;
    private JButton chainButton;
    private JButton loadRulesButton;
    private JButton saveRuleButton;
    private JButton newRuleButton;
    private JRadioButton radioForward;
    private JRadioButton radioBackward;
    private JComboBox comboBox1;

    public Data data;
    public Rules rules;
    public Logic logic;
    private String currentDataFileName;
    private String currentRulesFileName;
    final JFileChooser fileChooser;

    public MainWindow() {

        data = new Data();
        rules = new Rules();
        logic = new Logic(this);
        currentDataFileName = null;
        currentRulesFileName = null;
        fileChooser = new JFileChooser();
        reloadVariables();

        addDataButton.addActionListener(ActionEvent -> {
            JFrame buttonFrame = new JFrame("Add Variables");
            buttonFrame.setContentPane(new AddVariableWindow(this).panel1);
            buttonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            buttonFrame.pack();
            buttonFrame.setVisible(true);
            tabbedPane1.setSelectedIndex(1);
        });

        saveDataButton.addActionListener(actionEvent -> {
            try {
                save('D');
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Can't save file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loadDataButton.addActionListener(actionEvent -> {
            try {
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentDataFileName = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    return;
                }

                FileInputStream is = new FileInputStream(currentDataFileName);
                data = Data.deserialize(is);
                tabbedPane1.setSelectedIndex(1);

                updateDataView();
                reloadVariables();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Can't load file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        newRuleButton.addActionListener(ActionEvent -> {
            if(data.getSize()!=0)
            {
                JFrame buttonFrame = new JFrame("Add Rules");
                buttonFrame.setContentPane(new AddRuleWindow(this).mainPanel);
                buttonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                buttonFrame.pack();
                buttonFrame.setVisible(true);
                tabbedPane1.setSelectedIndex(2);
            }
            else
                JOptionPane.showMessageDialog(null,"To Add Rules, add some Variables first !");

        });
        saveRuleButton.addActionListener(ActionListener-> {
            try {
                save('R');
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Can't save file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        loadRulesButton.addActionListener(ActionListener -> {
            try {
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentRulesFileName = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    return;
                }

                FileInputStream is = new FileInputStream(currentRulesFileName);
                rules = Rules.deserialize(is);
                tabbedPane1.setSelectedIndex(2);

                updateRulesView();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Can't load file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        chainButton.addActionListener(ActionListener -> {

            tabbedPane1.setSelectedIndex(0);
            if(data.getSize()==0 || rules.getSize()==0)
                writeInChaining("Add Data and Rules First !");
            else
            {
                logic.forwardChain(comboBox1.getSelectedItem().toString());
            }

        });
    }
    public void updateDataView()
    {
        textData.setText("");
        for(int i= 0; i<data.getSize(); i++)
            textData.setText(textData.getText() + data.getName(i) + "=" + data.getValue(i)+"\n");
    }
    public void updateRulesView()
    {
        textRules.setText("");
        for(int i= 0; i<rules.getSize(); i++)
            textRules.setText(textRules.getText() + rules.getRuleString(i)+"\n");
    }

    private void save(char type) throws IOException {
        if (type=='D')
        {
            if (currentDataFileName == null) {
                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentDataFileName = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    return;
                }
            }

            FileOutputStream is = new FileOutputStream(currentDataFileName);
            data.serialize(is);
        }
        else if (type=='R')
        {
            if (currentRulesFileName == null) {
                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentRulesFileName = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    return;
                }
            }

            FileOutputStream is = new FileOutputStream(currentRulesFileName);
            rules.serialize(is);
        }
        else
            return;
    }
    public void reloadVariables()
    {
        comboBox1.removeAllItems();
        for (int i=0 ; i<data.getSize() ; i++)
            comboBox1.addItem(data.getName(i));
    }
    public void writeInChaining(String text)
    {
        textChaining.setText(textChaining.getText()+"\n"+text);
    }
}
