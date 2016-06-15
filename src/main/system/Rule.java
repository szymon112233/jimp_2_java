package main.system;

import java.util.*;

/**
 * Created by Szymon on 2016-06-15.
 */
public class Rule {

    private List<Character> variables;
    private List<Character> operators;
    private List<Boolean> negations;

    public Rule()
    {
        variables = new ArrayList<Character>();
        operators = new ArrayList<Character>();
        negations = new ArrayList<Boolean>();
    }
}
