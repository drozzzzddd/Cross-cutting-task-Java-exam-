package org.example.Calculation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {
    private String expression;
    private Integer result;


    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    public static ArrayList<ArrayList<String>> Calc(ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+([\\+\\-\\*\\/][0-9])*");
        for(int i = 0; i < lines.size(); ++i) {
            ArrayList<String> tmp = new ArrayList<>();
            for(int j = 0; j < lines.get(i).size(); ++j) {
                Matcher matcher = pattern.matcher(lines.get(i).get(j));
                if(matcher.find()) {
                    tmp.add(String.valueOf(rating(lines.get(i).get(j))));
                } else {
                    tmp.add(lines.get(i).get(j));
                }
            }
            answer.add(i, tmp);
        }
        return answer;
    }

    static boolean isOperator(char c) {

        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    public static int rating(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (delim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    static boolean delim(char c){

        return c == ' ';
    }

    static void processOperator(LinkedList<Integer> st, char operator) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (operator) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
}
