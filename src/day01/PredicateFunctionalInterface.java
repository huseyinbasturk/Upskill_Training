package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {

  public static void main(String[] args) {

    Predicate<Integer> isEven = number ->
      number %2 == 0 ? true : false;


    boolean r1 = isEven.test(1002);

    System.out.println("--------------------");

    List<String> list = new ArrayList<>();
    list.addAll(Arrays.asList("Java","C#","C#","C++","Python"));

    Predicate<String> isUnique = p -> Collections.frequency(list, p) == 1;

    System.out.println(isUnique.test("C##"));

    for (String s: list) {
      if(isUnique.test(s)){
        System.out.println(s);
      }
    }

    System.out.println("---------------------");

    List<Integer> nums = new ArrayList<>(Arrays.asList(10,10,10,20,20,30,30,30,40,40,50,60,70,80));

    for(int i = 0; i < nums.size(); i++) {
      if(nums.get(i) < 40) {
        nums.remove(i);
      }
    }
    System.out.println(nums);

    System.out.println("--------------------------");

    List<Integer> nums2 = new ArrayList<>(Arrays.asList(10,10,10,20,20,30,30,30,40,40,50,60,70,80));

    Iterator<Integer> iterator = nums2.iterator();
    while (iterator.hasNext()){
      if(iterator.next() < 40){
        iterator.remove();

      }
    }
    System.out.println(nums2);

    System.out.println("-------------------------------");

    //removeIf()
    List<Integer> nums3 = new ArrayList<>(Arrays.asList(10,10,10,20,20,30,30,30,40,40,50,60,70,80));
    Predicate<Integer> lessThan40 = p -> p < 40;

    //nums3.removeIf(p -> p < 20);
    nums3.removeIf(lessThan40);

    System.out.println(nums3);
  }


}
