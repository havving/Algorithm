package org.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String s = "1 2 3 4";

        String answer = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        answer = "" + Collections.min(list) + "" + Collections.max(list);

        System.out.println(answer);
    }
}
