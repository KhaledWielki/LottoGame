package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class LottoController {

    private static final int MAX_NUMBER = 49;
    private static final int MIN_NUMBER = 1;
    private static final int AMOUNT_OF_NUMBERS = 6;


    public LottoController(){}

    public static String lottoRandomize(){

        List<Integer> resultList = new ArrayList<>();
        //losowanie numerów
        List<Integer> helpList = IntStream.range(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(helpList);

        //wyciągnięcie 6 liczb
        resultList = helpList.subList(0, AMOUNT_OF_NUMBERS);

        //wyniki losowania na jednej liście
        Collections.sort(resultList);

        String result = resultList.stream().map(Object::toString).collect(Collectors.joining(", "));

        return result;
    }

    public static boolean lottoCompare(List<Integer> listUser, List<Integer> listServer){

        if (listUser.equals(listServer)){
            return true;
        }

        if((listUser == null && listServer != null
                || listUser != null && listServer == null
                || listUser.size() != listServer.size())){
            return false;
        }

        return false;
    }

    public static List<String> convertToList(String result){
        ArrayList resultList = new ArrayList(Arrays.asList(result.split(",")));
        return resultList;
    }

    public static List<Integer> getIntegerArray(String stringArray) {
        List<Integer> result = new ArrayList<>();
        for(String stringValue : stringArray.split(", ")) {
            try {
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

