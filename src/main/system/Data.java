package main.system;

import java.io.*;
import java.util.*;

/**
 * Created by Szymon on 2016-05-17.
 */
public class Data extends Files implements Serializable {

    private List<String> dataNames;
    private List<Character> dataValues;

    public Data(String fileName)
    {
        super(fileName);
        dataNames = new ArrayList<String>();
        dataValues = new ArrayList<Character>();
    }
    public Data()
    {
        super();
        dataNames = new ArrayList<String>();
        dataValues = new ArrayList<Character>();
    }

    public int getSize()
    {
        return dataNames.size();
    }

    public void addValue(String name, Character value)
    {
        if (dataNames!=null)
        {
            dataNames.add(name);
            dataValues.add(value);
        }

    }


    public Character getValue(String name)
    {
        if(dataNames!=null)
            return dataValues.get(dataNames.indexOf(name));
        else
            return '?';
    }

    public Character getValue(int number)
    {
        if(dataNames!=null)
            return dataValues.get(number);
        else
            return '?';
    }

    public String getName(int number)
    {
        if(dataNames!=null)
            return dataNames.get(number);
        else
            return null;
    }


    public void setValue(String name, Character newValue)
    {
        if(dataNames!=null)
        {
            dataValues.set(dataNames.indexOf(name),newValue);
        }

    }

    public Boolean dataExists(String name)
    {
        if(dataNames.contains(name))
            return true;
        else
            return false;
    }

    public void serialize(OutputStream os) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static Data deserialize(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        Data obj = (Data) objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

}
