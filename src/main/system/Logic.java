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

    public boolean istrue(char aa, char bb, boolean na, boolean nb, char t)
    {
        boolean a,b;
        if (aa=='1')
            a=true;
        else
            a=false;

        if (bb=='1')
            b=true;
        else
            b=false;



        if (t=='&')
        {
            if (!na && !nb)
            {
                if (a && b)
                    return true;
                else
                    return false;
            }
            else if (na && nb)
            {
                if (!a&&!b)
                    return true;
                else
                    return false;
            }
            else if (na)
            {
                if (!a&&b)
                    return true;
                else
                    return false;
            }
            else if (nb)
            {
                if (a&&!b)
                    return true;
                else
                    return false;
            }
        }

        else if (t=='|')
        {
            if (!na && !nb)
            {
                if (a||b)
                    return true;
                else
                    return false;
            }
            if (na && nb)
            {
                if (!a||!b)
                    return true;
                else
                    return false;
            }
            else if (na)
            {
                if (!a||b)
                    return true;
                else
                    return false;
            }
            else if (nb)
            {
                if (a||!b)
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
                if(window.rules.getRule(i).getVariable(3)==name)
                {
                    countable = true;
                }
            }
            if (!countable)
            {
                JOptionPane.showMessageDialog(null,"Cannot count from given rules !");
                return;
            }

            while (window.data.getValue(name)=='?')
            {
                for(int i=0 ; i<window.rules.getSize() ; i++ )
                {
                    if(!window.rules.getRule(i).isCounted())
                    {
                        tempValue =false;
                        countable = true;
                        for (int j=0; j<2 ; j++)
                        {
                            if(window.data.getValue(window.rules.getRule(i).getVariable(j))=='?')
                                countable = false;
                        }

                        if (countable)
                        {

                            if (window.data.getValue(window.rules.getRule(i).getVariable(0))=='1')
                                tempValue=true;
                            else
                                tempValue=false;

                            for (int j=0 ; j<1 ; j++)
                            {
                                if (j==0)
                                    tempValue = istrue(window.data.getValue(window.rules.getRule(i).getVariable(j)),window.data.getValue(window.rules.getRule(i).getVariable(j+1))
                                            ,window.rules.getRule(i).getNegation(j),window.rules.getRule(i).getNegation(j+1),window.rules.getRule(i).getOperator(j));
                                else
                                {
                                    if (tempValue)
                                        tempValue = istrue('1',window.data.getValue(window.rules.getRule(i).getVariable(j+1))
                                                ,false,window.rules.getRule(i).getNegation(j+1),window.rules.getRule(i).getOperator(j));
                                    else
                                        tempValue = istrue('0',window.data.getValue(window.rules.getRule(i).getVariable(j+1))
                                                ,false,window.rules.getRule(i).getNegation(j+1),window.rules.getRule(i).getOperator(j));
                                }
                            }
                            window.writeInChaining("Rule number " + i + " counted");

                            if (tempValue)
                                window.data.setValue(window.rules.getRule(i).getVariable(3),'1');
                            else
                                window.data.setValue(window.rules.getRule(i).getVariable(3),'0');

                            window.rules.getRule(i).setCounted();

                            if (window.rules.getRule(i).getVariable(3)==name)
                                i=window.rules.getSize();
                        }
                        else
                            window.writeInChaining("Uncountable for now .. skipping");
                    }
                }
            }

            window.writeInChaining(name+"="+window.data.getValue(name));
        }
        else
            window.writeInChaining("There's no \""+name+"\" in data");

        window.updateDataView();
    }
}
