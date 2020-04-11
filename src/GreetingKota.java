import java.util.ArrayList;

public class GreetingKota {
    public String greet(String... name){
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
        for(int i = 0; i < str.length(); i++){
            if(!Character.isUpperCase(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> lowerCount(ArrayList<String> names){
        int count = 0;
        ArrayList<String> lowers = new ArrayList<>();
        for(int i = 0; i < names.size(); i++){
            if(!allUpper(names.get(i)) && count <= 2){
                lowers.add(names.get(i));
                count++;
            }
        }
        if(count != 2){
            return null;
        }
        return lowers;
    }

    private ArrayList<String> splitCommas(String... name){
        ArrayList<String> strs = new ArrayList<>();
        for(int i = 0; i < name.length; i++){
            if(name[i].contains("\""))
                strs.add(name[i].substring(1, name[i].length() - 1));
            else if(name[i].contains(",")){
                String[] temp = name[i].split(", ");
                for(String t : temp){
                    strs.add(t);
                }
            }
            else{
                strs.add(name[i]);
            }
        }
        return strs;
    }
}