package day01;

import org.w3c.dom.ls.LSOutput;

public class CustomFunctionalInterface {

  public static void main(String[] args) {

    StringFunctions longestString = (s1, s2) -> {
      if (s1.length() > s2.length())
        return s1;
      return s2;
    };

    //"java", "C#"

    System.out.println(longestString.function("Java", "C#"));

    System.out.println("=========================");

    DataFunction<String> reverse = s -> new StringBuilder(s).reverse().toString();

    System.out.println(reverse.function("Java"));

    System.out.println("=========================");

    DataFunction<Integer> cube = n -> n * n * n;

    int r1 = cube.function(10);
    System.out.println(r1);

  }
}