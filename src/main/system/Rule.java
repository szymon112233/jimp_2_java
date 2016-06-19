package main.system;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Szymon on 2016-06-15.
 */
public class Rule implements Serializable {

    private List<String> variables;
    private List<Character> operators;
    private boolean counted;

    public Rule()
    {
        variables = new ArrayList<String>();
        operators = new ArrayList<Character>();
        counted = false;
    }
    public void addVariable(String name)
    {
        variables.add(name);
    }

    public void addOperator(Character operator)
    {
        operators.add(operator);
    }

    public String getVariable(int number)
    {
        return variables.get(number);
    }

    public Character getOperator(int number)
    {
        return operators.get(number);
    }

    public boolean isCounted()
    {
        if (counted)
            return true;
        else
            return false;
    }

}
