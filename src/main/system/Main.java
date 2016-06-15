package main.system;


import main.gui.*;

import javax.swing.*;

/**
 * Created by Szymon on 2016-05-17.
 */
public class Main {


    public static void main(String[] args)
    {

        JFrame mainFrame = new JFrame("Decision System");
        mainFrame.setContentPane(new MainWindow().mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        System.out.println("Hej?");
    }
}
