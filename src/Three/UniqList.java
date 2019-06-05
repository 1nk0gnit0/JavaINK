package Three;


import java.util.*;

public class UniqList {
    public static void main(String[] args) {

        String[] arr = {"one","two","three","one","four","two","five","four","three","one",};

        Set<String> unique = new HashSet<>(Arrays.asList(arr));

        System.out.println(unique);

        Map<String, Integer> map = new HashMap<>();


        for (String s : arr) {
           map.put(s, map.getOrDefault(s, 0)+1);
        }

        System.out.println(map);




    }
}
