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
            return false;
        }
    }

    public static Integer[] listToTable(List<Integer> tmp){
        Integer[] num = new Integer[tmp.size()];
        num = tmp.toArray(num);
        return num;
    }

    public static boolean isFromRange(List<Integer> tmp){
        for(int i = 0; i < tmp.size(); i++){
            if ( tmp.get(i) < 50 && tmp.get(i) > 0){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static boolean isInteger(List<String> str) {
        for(int i = 0; i < str.size(); i++){
            if (isInt(str.get(i))){
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
