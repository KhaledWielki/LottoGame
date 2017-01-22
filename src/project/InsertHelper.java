package project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class InsertHelper {

    public static boolean isUnique(Integer[] nums){
        return new HashSet<Integer>(Arrays.asList(nums)).size() == nums.length;
    }

    public static boolean enoughArguments(Integer[] nums){
        if(nums.length == 6){
            return true;
        }
        else{
            return false
        }
        return false;
    }

    public static boolean isInteger(List<String> str) {
        System.out.print("1 " + str + "\n");
        for(int i = 0; i < str.size(); i++){
            if (isInt(str.get(i))){
                System.out.print("2 " + str.get(i) + "\n");
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static boolean isInt( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
