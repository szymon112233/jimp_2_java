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
                window.data.addValue(variableNameTextField.getText(),variableValueTextField.getText().charAt(0));
                window.updateDataView();


            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


