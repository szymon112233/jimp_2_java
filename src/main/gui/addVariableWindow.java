package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.system.Data;

/**
 * Created by Szymon on 2016-06-15.
 */
public class AddVariableWindow {
    public JPanel panel1;
    private JButton okButton;
    private JTextField variableNameTextField;
    private JTextField variableValueTextField;



    public AddVariableWindow(MainWindow window) {



        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (variableValueTextField.getText().equals("0") || variableValueTextField.getText().equals("1") || variableValueTextField.getText().equals("?"))
                {
                    window.data.addValue(variableNameTextField.getText(),variableValueTextField.getText().charAt(0));
                    variableNameTextField.setText("");
                    variableValueTextField.setText("");
                    window.updateDataView();
                }
                else
                    JOptionPane.showMessageDialog(null,"Variable value must be '1','0' or '?'");



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


