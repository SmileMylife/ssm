package test.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ZhangPei on 2018/8/30.
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        /*for (Object i : arrayList) {
            if (Integer.parseInt(i.toString()) == 3) {
                arrayList.remove(i);
            }
        }*/
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 3) {
                iterator.remove();
            }
        }
        System.out.println(arrayList.toString());
        Player player = new Player(22);
        player.remove();
        int age = player.getAge();
        System.out.println(age);

    }
}

class Player {
    private int age;

    public int getAge() {
        return this.age;
    }

    public Player(int age) {
        this.age = age;
    }

    public boolean remove() {
        --age;
        return true;
    }
}
