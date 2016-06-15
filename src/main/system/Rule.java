package main.system;

import java.util.*;

/**
 * Created by Szymon on 2016-06-15.
 */
public class Rule {

    private List<String> variables;
    private List<Character> operators;
    private List<Boolean> negations;

    public Rule()
    {
        variables = new ArrayList<String>();
        operators = new ArrayList<Character>();
        negations = new ArrayList<Boolean>();
    }
    public void addVariable(String name, Boolean negation)
    {
        variables.add(name);
        negations.add(negation);
    }

    public void addOperator(Character operator)
    {
        operators.add(operator);
    }

    public String getVariable(int number)
    {
        if(negations.get(number))
            return "!"+variables.get(number);
        else
            return variables.get(number);
    }

    public Character getOperator(int number)
    {
        return operators.get(number);
    }

}
