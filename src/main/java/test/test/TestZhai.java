package test.test;

import com.store.common.OutputObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangPei on 2019/3/13.
 */
public class TestZhai {
    public static void main(String[] args) {
        //假设有a,b,c,d,e五个站点,a-b,b-c,c-e,e-a
        ArrayList<String[]> checks = new ArrayList<String[]>();
        String[] first = {"a", "b"};
        String[] eighth = {"b", "a"};
        String[] second = {"b", "c"};
        String[] third = {"c", "a"};
        String[] fourth = {"c", "d"};
        String[] fifth = {"d", "a"};
        String[] sixth = {"d", "e"};
        String[] seventh = {"e", "a"};

        checks.add(first);
        checks.add(second);
        checks.add(third);
        checks.add(fourth);
        checks.add(fifth);
        checks.add(sixth);
        checks.add(seventh);

        test(checks, "a", "a");

        OutputObject outputObject = new OutputObject();


    }

    public static void test(List<String[]> list, String start, String end) {
        for (int i = 0; i < list.size(); i++) {
            if (start.equals(list.get(i)[0])) {
                if (list.get(i)[1].equals(end)) {

                } else {
                    test(list, list.get(i)[1], end);
                }
            }
        }

    }
}
