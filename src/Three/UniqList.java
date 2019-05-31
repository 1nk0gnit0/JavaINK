package Three;


import java.util.*;

public class UniqList {
    public static void main(String[] args) {

        String[] arr = {"one","two","three","one","four","two","five","four","three","one",};

        Set<String> unique = new HashSet<>(Arrays.asList(arr));

        System.out.println(unique);

        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
           map.merge(s, 1, (a, b)->a + b);
        }

        System.out.println(map);




    }
}
