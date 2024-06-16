package leetcode;

import java.util.*;

public class BehaviourOfMap {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('c', 1);

        System.out.println(map.get('c') == null);
        map.put('c', map.get('c') -1);
        System.out.println(map.get('c'));

    }


    
}
