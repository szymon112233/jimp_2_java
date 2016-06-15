package main.gui;

import main.system.Data;

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

    public Data data;
    private String currentFileName;
    final JFileChooser fileChooser;

    public MainWindow() {

        data = new Data();
        currentFileName = null;
        fileChooser = new JFileChooser();

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
                save();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Can't save file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loadDataButton.addActionListener(actionEvent -> {
            try {
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentFileName = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    return;
                }

                FileInputStream is = new FileInputStream(currentFileName);
                data = Data.deserialize(is);
                tabbedPane1.setSelectedIndex(1);

                updateDataView();
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
    }
    public void updateDataView()
    {
        textData.setText("");
        for(int i= 0; i<data.getSize(); i++)
            textData.setText(textData.getText() + data.getName(i) + "=" + data.getValue(i)+"\n");
    }

    private void save() throws IOException {
        if (currentFileName == null) {
            if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                currentFileName = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                return;
            }
        }

        FileOutputStream is = new FileOutputStream(currentFileName);
        data.serialize(is);
    }
}
