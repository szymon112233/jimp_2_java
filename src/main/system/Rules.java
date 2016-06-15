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
