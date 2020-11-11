/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ctralie
 */
import java.util.HashMap;

public class Person implements Cloneable {
    private String name;
    public Person(String n) {
        name = n;
    }
    public String toString() {
        return name;
    }
    public void updateName(String name) {
        this.name = name;
    }
    @Override
    public Person clone() {
        return new Person(this.name);
    }
    

    public static void testHashMapValueRef() {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("chris", new String[]{"upbeat", "passionate"});
        String[] value = map.get("chris");
        value[0] = "tired";
        System.out.println(map.get("chris")[0]);
    }
    
    
    public static void testObjectDeepCopy() {
        Person chris = new Person("Chris");
        Person celia = new Person("Celia");
        chris = celia.clone(); // Creates a copy of celia
        chris.updateName("Christopher");
        System.out.println(chris + ", " + celia);
    }
    
    public static void testObjectReferences() {
        Person chris = new Person("Chris");
        Person celia = new Person("Celia");
        chris = celia; // Creates a "pointer" / "reference"
        chris.updateName("Chris");
        System.out.println(chris + ", " + celia);
    }
    
    public static void testCharReference() {
        char a = 'a';
        char b = 'b';
        b = a; // This actually copies the char!!
        b = 'c';
        System.out.println(a + ", " + b);
    }
    
    public static void main(String[] args){
        testObjectDeepCopy();
        //testObjectReferences();
        //testCharReference();
    }
}
