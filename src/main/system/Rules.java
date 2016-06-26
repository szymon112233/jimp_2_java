package main.system;

import java.io.*;
import java.util.*;

/**
 * Created by Szymon on 2016-05-17.
 */
public class Rules extends Files implements Serializable
{
    public List<Rule> ruleList;

    public Rules()
    {
        ruleList = new ArrayList<Rule>();
    }

    public void addRule(Rule newRule)
    {
        ruleList.add(newRule);
    }

    public int getSize()
    {
        return ruleList.size();
    }

    public String getRuleString(int number)
    {
        String returnString ="";

        if(ruleList.get(number).getNegation(0))
            returnString += "!" + ruleList.get(number).getVariable(0);
        else
            returnString += ruleList.get(number).getVariable(0);

        returnString +=ruleList.get(number).getOperator(0).toString();

        if(ruleList.get(number).getNegation(1))
            returnString += "!" + ruleList.get(number).getVariable(1);
        else
            returnString += ruleList.get(number).getVariable(1);

        returnString +=ruleList.get(number).getOperator(1).toString();

        if(ruleList.get(number).getNegation(2))
            returnString += "!" + ruleList.get(number).getVariable(2);
        else
            returnString += ruleList.get(number).getVariable(2);


        returnString +="="+ruleList.get(number).getVariable(3);
        return returnString;

    }

    public Rule getRule(int number)
    {
        return ruleList.get(number);
    }



    public void serialize(OutputStream os) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static Rules deserialize(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        Rules obj = (Rules) objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

}
