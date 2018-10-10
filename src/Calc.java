import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

  /*  String Delete_extra_spaces(String formula)
    {
        return formula = formula.replaceAll("\\s", "");
    }
    String Change_commas_to_dots(String formula)
    {
        return formula = formula.replaceAll("[,]", ".");
    }
    boolean Check_if_parenthesis_err(String formula)
    {
        long open = formula.codePoints().filter(ch -> ch=='(').count();
        long close = formula.codePoints().filter(ch -> ch==')').count();
        if(open != close)
            return true;
        else return false;
    }
    boolean Check_if_operation (char c) {
        return c=='+' || c=='-' || c=='*' || c=='/';
    }
    Integer Get_priority (char op) {
        if (op < 0)
            return 4;
        return
                op == '+' || op == '-' ? 1 : op == '*' || op == '/' || op == '%' ? 2 : -1;
    }

    void Process_operator (LinkedList<Float> Nums, char op) {
        if (op < 0) {
            Float l = Nums.pollLast();
            switch (-op) {
                case '+':  Nums.add(l);  break;
                case '-':  Nums.add(l);  break;
            }
        }
        else {
            Float r = Nums.pollLast();
            Float l = Nums.pollLast();
            switch (op) {
                case '+':  Nums.add(l + r);  break;
                case '-':  Nums.add(l - r);  break;
                case '*':  Nums.add(l * r);  break;
                case '/':  Nums.add(l / r);  break;
                case '%':  Nums.add(l % r);  break;
            }
        }
    }
    Float Solve_formula(String formula)
    {
        if( !this.Check_if_parenthesis_err(formula) )
        {
            formula = this.Delete_extra_spaces(formula);
            formula = this.Change_commas_to_dots(formula);
        }
        boolean may_unary = true;
        LinkedList<Float> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();;
        for (int i=0; i<formula.length(); ++i)
                if (formula.charAt(i) == '(') {
                    op.add('(');
                    may_unary = true;
                }
                else if (formula.charAt(i) == ')') {
                    while (op.getLast() != '(')
                        Process_operator(st, op.pollLast());
                    may_unary = false;
                }
                else if ( Check_if_operation (formula.charAt(i)) ) {
                    char curop = formula.charAt(i);
                    if (may_unary && isunary (curop))  curop = -curop;
                    while (!op.isEmpty() && (
                            curop >= 0 && Get_priority(op.peekLast()) >= Get_priority(curop)
                                    || curop < 0 && Get_priority(op.peekLast()) >Get_priority(curop))
                            )
                        Process_operator(st, op.pollLast());
                    op.add(curop);
                    may_unary = true;
                }
                else {
                    Character operand;
                    while (i < formula.length() && isalnum (s[i])))
                    operand += s[i++];
                    --i;
                    if (isdigit (operand[0]))
                        st.push_back (atoi (operand.c_str()));
                    else
                        st.push_back (get_variable_val (operand));
                    may_unary = false;
                }
        while (!op.isEmpty())
            Process_operator(st, op.pollLast());
        return st.getLast();



    }
*/



    public static void main(String[] args)
    {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        //dfs.setDecimalSeparator(',');
        System.out.println(dfs.getDecimalSeparator());
        String str = "abqq";
        //boolean bbb = str.("[^1234567890/+/-/*//]");
        //boolean bbb = str.matches("(\\d+| )?");
        //boolean bbb = str.matches("[\\d\\+\\-\\*\\/\\.\\(\\)]+");
        boolean bbb = str.matches("^([0-9//(])+");
        System.out.println(bbb);
        String regex1 = "(^[0-9]+)([q]+)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(str);
        System.out.println(matcher1.matches());

        final String regex = "^[^.\\n]+(?:\\.[^.\\n]+)+$";
        final String string = ".sss.\n"
                + ".ssssss\n"
                + "sssssss.\n"
                + ".sssss.sss.\n"
                + "ssss.ssss\n";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }




        /*Calc Calculator = new Calc();
        //Calculator.Solve_formula(str);
        //float a = Float.parseFloat(str);
        String regex = "^[0-9]";
        String data = "23343453a";
        System.out.println(data.matches(regex));
        System.out.println(str);*/
        //System.out.println(a);
    }
}

// https://bitbucket.org/tschool/javaschoolexam