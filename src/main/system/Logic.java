package main.system;

import main.gui.MainWindow;

import javax.swing.*;

/**
 * Created by Szymon on 2016-06-18.
 */
public class Logic {

    private MainWindow window;

    public Logic(MainWindow window)
    {
        this.window = window
;    }

    public Logic()
    {
        this.window = null;
    }

    public boolean istrue(boolean aa, boolean bb, boolean na, boolean nb, char t)
    {


        if (t=='&')
        {
            if (!na && !nb)
            {
                if (aa && bb)
                    return true;
                else
                    return false;
            }
            else if (na && nb)
            {
                if (!aa&&!bb)
                    return true;
                else
                    return false;
            }
            else if (na)
            {
                if (!aa&&bb)
                    return true;
                else
                    return false;
            }
            else if (nb)
            {
                if (aa&&!bb)
                    return true;
                else
                    return false;
            }
        }

        else if (t=='|')
        {
            if (!na && !nb)
            {
                if (aa||bb)
                    return true;
                else
                    return false;
            }
            if (na && nb)
            {
                if (!aa||!bb)
                    return true;
                else
                    return false;
            }
            else if (na)
            {
                if (!aa||bb)
                    return true;
                else
                    return false;
            }
            else if (nb)
            {
                if (aa||!bb)
                    return true;
                else
                    return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Unknown operator: " + t);
            return false;
        }
        return false;
    }

    public  void forwardChain(String name)
    {

        boolean tempValue = false;
        boolean countable = false;


        if (window.data.dataExists(name))
        {
            for(int i=0 ; i<window.rules.getSize() ; i++) //Check if s is countable
            {
                if(window.rules.getRule(i)==name)
                    countable= true;
            }
            if (!countable)
            {
                printf("Cannot count %c from given rules !\n",s);
                return;
            }

            if(window.data.getValue(name)=='?')
            {

            }

            window.writeInChaining(name+"="+window.data.getValue(name));
        }
        else
            window.writeInChaining("There's no \""+name+"\" in data");

        window.updateDataView();


    }


}
