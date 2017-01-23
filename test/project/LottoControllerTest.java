package project;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Piotrek on 23.01.2017.
 */
public class LottoControllerTest {

    @Test
    public void lottoCompare() throws Exception {
        System.out.println("Test porównywania list:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list3.add(11);
        list3.add(12);
        list3.add(13);
        list3.add(14);
        list3.add(15);
        list3.add(16);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        assertTrue(LottoController.lottoCompare(list1, list2));
        assertFalse(LottoController.lottoCompare(list1, list3));
    }

}