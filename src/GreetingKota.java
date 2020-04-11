import java.util.ArrayList;
import java.util.Collections;

/**
 * Course- CSC 309: Software Engineering I
 * Professor Bruno Da Silva
 * Student- Jaipreet Hundal
 * Practicing and Performing Unit Testing with TDD(Test-Driven-Development)
 **/
public class GreetingKota {
    public String greet(String... name){
        /**Function will return the proper greetings based on the format of the names given**/
        String greeting = "";
        String extra = "";
        boolean flagged = false;
        if(name == null || name[0].length() == 0){
            greeting = "Hello, my friend.";
        }
        else {
            ArrayList names = splitCommas(name);
            if (names.size() > 1) {
                greeting += "Hello, ";
                ArrayList lowers = lowerCount(names);
                if(lowers != null){
                    flagged = true;
                    greeting += lowers.get(0) + " and " + lowers.get(1) + ".";
                }
                for (int i = 0; i < names.size(); i++) {
                    if (allUpper(names.get(i).toString())) {
                        extra = " AND HELLO " + names.get(i) + "!";
                    }
                    else if (!flagged) {
                        if(names.size() == 2){
                            greeting += names.get(i) + ".";
                        }
                        else {
                            if (!(names.size() - 1 == i))
                                greeting += names.get(i) + ", ";
                            else {
                                greeting += "and " + names.get(i) + ".";
                            }
                        }
                    }
                }
                greeting += extra;
            }
            else {
                if (allUpper(names.get(0).toString())) {
                    greeting = "HELLO " + names.get(0) + "!";
                } else {
                    greeting = "Hello, " + names.get(0) + ".";
                }
            }
        }
        return greeting;
    }

    private boolean allUpper(String str){
        /**Check if a given name is all Uppercase**/
        for(int i = 0; i < str.length(); i++){
            if(!Character.isUpperCase(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> lowerCount(ArrayList<String> names){
        /**Check if there are exactly 2 words that are not all Uppercase**/
        int count = 0;
        ArrayList<String> lowers = new ArrayList<>();
        for(String name : names){
            if(!allUpper(name) && count <= 2){
                lowers.add(name);
                count++;
            }
        }
        if(count != 2){
            return null;
        }
        return lowers;
    }

    private ArrayList<String> splitCommas(String... names){
        /**Split special format entries, specified in the greet7 and greet8 testcases, into separate names**/
        ArrayList<String> strs = new ArrayList<>();
        for(String name : names){
            if(name.contains("\""))
                strs.add(name.substring(1, name.length() - 1));
            else if(name.contains(",")){
                String[] temp = name.split(", ");
                Collections.addAll(strs, temp);
            }
            else{
                strs.add(name);
            }
        }
        return strs;
    }
}