import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Pyramid {
    Integer[][] Pyramid_Builder(List<Integer> List_in)
    {
        //Sn = (2a1+d(n-1))*n/2; d=1; a1=1;
        //2n+n^2-n = 2Sn; n^2+n-2Sn=0;; D = 1-4*2Sn; x = (-1+sqrt(D))/2;
        Integer row_cnt;
        Double cnt;
        Long aaa, aaa1;
        //cnt = (-1 + Math.sqrt(1-4*2*List_in.size()))/2;
        cnt = (-1 + Math.sqrt(1+4*2*22))/2;
        aaa = cnt.longValue();
        aaa1 = Math.round(cnt, 0);
        if(Math.round(cnt) == cnt.longValue())
            return new Integer[5][5];
        List_in.sort((a,b)->a.compareTo(b));
        return new Integer[5][5];

    }

    public static void main(String [] args)
    {
        List<Integer> L = new ArrayList<>();
        Pyramid P = new Pyramid();
        P.Pyramid_Builder(L);
    }
}
