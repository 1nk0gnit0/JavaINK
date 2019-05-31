package Three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Phonebook {
    private Map<String, HashSet<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phonenumber){
        HashSet<String> number = phonebook.getOrDefault(name,new HashSet<>());
        number.add(phonenumber);
        phonebook.put(name,number);
    }

    public void get(String name){
        System.out.println(name + phonebook.get(name));
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Ivanov", "+7-444-444-4444");
        phonebook.add("Ivanov", "+7-555-555-5555");
        phonebook.add("Petrov", "+7-666-666-6666");
        phonebook.add("Dali", "+7-777-777-7777");

        phonebook.get("Ivanov");

    }
}


