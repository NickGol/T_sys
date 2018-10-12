import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    String [] Nums_arr;
    String Delete_extra_spaces(String formula)
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
    Integer Get_priority (int op) {
        if ((short)op < 0)
            return 4;
        return
                op == '+' || op == '-' ? 1 : op == '*' || op == '/' || op == '%' ? 2 : -1;
    }

    void Process_operator (LinkedList<Float> Nums, char op) {
        if ((short)op < 0) {
            Float l = Nums.pollLast();
            switch (-(short)op) {
                case '+':  Nums.add(l);  break;
                case '-':  Nums.add(-l);  break;
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
        String [] Nums_arr = formula.split("[^\\d.]+");
        Integer Num_cnt=0;
        if(Nums_arr[0].isEmpty()) Num_cnt = 1;

        if( !this.Check_if_parenthesis_err(formula) )
        {
            formula = this.Delete_extra_spaces(formula);
            formula = this.Change_commas_to_dots(formula);
            boolean check = formula.matches("(([\\(]*[\\-]?)*([\\d]+([\\.]?[\\d]+)?){1}([\\)]*[\\+\\-\\*\\/]{1}(?!$)|[\\)]*$)?)+");
            if(!check) {System.out.println("Ошибка в выражении"); return Float.parseFloat("-1");}
            System.out.println(check + "     67890");
        }
        else {System.out.println("Ошибка со скобками"); return Float.parseFloat("-1");}
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
                    op.pollLast();
                    may_unary = false;
                }
                else if ( Check_if_operation (formula.charAt(i)) ) {
                    int curop = formula.charAt(i);
                    if (may_unary /*&& isunary (curop)*/) curop = -curop;
                    while (!op.isEmpty() && (
                        curop >= 0 && Get_priority(op.peekLast()) >= Get_priority(curop)
                        || curop < 0 && Get_priority(op.peekLast())>Get_priority(curop))
                        )
                        Process_operator(st, op.pollLast());
                    op.add((char)curop);
                    //may_unary = true;
                }
                else {
                    st.add( Float.parseFloat(Nums_arr[Num_cnt]) );
                    i+=Nums_arr[Num_cnt].length()-1;
                    Num_cnt++;
                    may_unary = false;
                }
        while (!op.isEmpty())
            Process_operator(st, op.pollLast());
        return st.getLast();



    }




    public static void main(String[] args)
    {
        /*String[] aaa;
        aaa = "123.45:as75dfg555(+213".split("[^\\d.]+");
        float a = Float.parseFloat("123.45");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        //dfs.setDecimalSeparator(',');
        System.out.println(dfs.getDecimalSeparator());
        String str = "(156..+83)+";
*/
        //final String regex = "(([\\(]*[\\-]?)*([\\d]+([\\.]?[\\d]+)?){1}([\\)]*[\\+\\-\\*\\/]{1}(?!$)|[\\)]*$)?)+";
        //final String string = "(-55.55+75.55)+(55+55.25)+5*5/73*)";

        //String str123 = "(-55.55+75.5/5)+((55+55.25)+5*5/73)";
        //String str123 = "-(-(-55.55+75.5))+15*100+15";
        String str123 = "-12)1//(";
        Calc Calculator = new Calc();
        System.out.println("Result");
        System.out.println(Calculator.Solve_formula(str123));
        //float a = Float.parseFloat(str);

    }
}

// https://bitbucket.org/tschool/javaschoolexam

//(([\(]*[\-]?)*([\d]+([\.]?[\d]+)?){1}([\)]*[\+\-\*\/]{1}(?!$)|[\)]*$)?)+

//http://e-maxx.ru/algo/expressions_parsing