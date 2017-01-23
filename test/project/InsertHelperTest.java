package project;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Piotrek on 23.01.2017.
 */
public class InsertHelperTest {
    @Test
    public void isUnique() throws Exception {
        System.out.println("Test unikalności list:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        Integer[] num1 = new Integer[list1.size()];
        num1 = list1.toArray(num1);

        list2.add(11);
        list2.add(22);
        list2.add(33);
        list2.add(11);
        list2.add(1);
        list2.add(6);

        Integer[] num2 = new Integer[list2.size()];
        num2 = list2.toArray(num2);

        System.out.println(list1);
        System.out.println(list2);

        assertTrue(InsertHelper.isUnique(num1));
        assertFalse(InsertHelper.isUnique(num2));
    }

    @Test
    public void enoughArguments() throws Exception {
        System.out.println("Test wielkości list:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        Integer[] num1 = new Integer[list1.size()];
        num1 = list1.toArray(num1);

        list2.add(11);
        list2.add(22);
        list2.add(33);
        list2.add(11);
        list2.add(1);

        Integer[] num2 = new Integer[list2.size()];
        num2 = list2.toArray(num2);
        System.out.println(list1);
        System.out.println(list2);

        assertTrue(InsertHelper.enoughArguments(num1));
        assertFalse(InsertHelper.enoughArguments(num2));
    }

    @Test
    public void isFromRange() throws Exception {
        System.out.println("Test sprawdzenia przedziału:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list2.add(91);
        list2.add(2);
        list2.add(3);
        list2.add(77);
        list2.add(5);
        list2.add(68);

        System.out.println(list1);
        System.out.println(list2);

        assertTrue(InsertHelper.isFromRange(list1));
        assertFalse(InsertHelper.isFromRange(list2));
    }

    @Test
    public void isInteger() throws Exception {
        System.out.println("Test czy String zamieni sie na int:");
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");

        list2.add("a");
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("5");
        list2.add("6");

        System.out.println(list1);
        System.out.println(list2);

        assertTrue(InsertHelper.isInteger(list1));
        assertFalse(InsertHelper.isInteger(list2));
    }

}