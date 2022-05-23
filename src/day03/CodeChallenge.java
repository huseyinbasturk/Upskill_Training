package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import java.util.Arrays;
    import java.util.TreeSet;

public class CodeChallenge {

  public static void main(String[] args) {

    System.out.println(sameLetters("abc","cab"));
    System.out.println(sameLetters("abc","abb"));

    System.out.println(same("abc","cab"));
    System.out.println(same("abc","abb"));

    System.out.println(removeDup("AAABBBCCC"));

    System.out.println(unique("AAABBBCCCDEF"));

    System.out.println(strReverse("ABCD"));

    System.out.println(findFrequencyOfChar("AAABBCDD"));

    System.out.println(validatePassword("Hb2011-1."));
    System.out.println(validatePassword("43542"));

    int[] arr = {2,4,6,23,-1,9};
    System.out.println(maxValue(arr));

    int[] array = {10, 9, 8, 7};
    System.out.println(Arrays.toString(sortAscending(array)));

    int[] arr2 = {10,20,7, 8, 90};
    System.out.println(Arrays.toString(sortDescending(arr2)));


  }

  //  1. Write a return method that check if a string is build out of the same letters as another string.
//  Ex: same("abc", "cab"); -> true , same("abc", "abb"); -> false:
  public static boolean sameLetters(String str1, String str2) {
    if (str1.length() == 0 || str2.length() == 0)
      return false;

    if (str1.length() != str2.length())
      return false;

    boolean isSame = true;

    for (int j = 0; j < str2.length(); j++) {
      if (!str2.contains(str1.charAt(j) + "") || !str1.contains(str2.charAt(j) + "")) {
        isSame = false;
      }
    }

    return isSame;
  }

  public static boolean same(String str1, String str2) {
    str1 = new TreeSet<String>(Arrays.asList(str1.split(""))).toString();
    str2 = new TreeSet<String>(Arrays.asList(str2.split(""))).toString();
    return str1.equals(str2);
  }
  //  2. Write a return method that can remove the duplicated values from String
//  Ex: removeDup("AAABBBCCC") ==> ABC
  public static String removeDup(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      if (!result.contains("" + str.charAt(i))) {
        result += "" + str.charAt(i);
      }
    }
    return result;

  }
  //  3. Write a return method that can find the unique characters from the String
//  Ex: unique("AAABBBCCCDEF") ==> "DEF";
  public static String unique(String str) {
    String[] arr = str.split("");
    String unique1 = "";
    for(int j=0; j<arr.length; j++) {
      int num = 0;
      for(int i=0; i<arr.length;i++){
        if(arr[i].equals(arr[j])) {
          num++;
        }
      }
      if(num==1) {
        unique1 +=arr[j];
      }
    }
    return unique1;
  }

  //  4. Write a return method that can reverse String
//  Ex: Reverse("ABCD"); ==> DCBA
  public static String strReverse(String str) {
    String reverse="";
    for(int i=str.length()-1; i>=0;i--) {
      reverse +=str.toCharArray()[i];
    }
    return reverse;
  }

//5. Write a return method that can find the frequency of characters
//  Ex: FrequencyOfChars("AAABBCDD") ==> A3B2C1D2
  public static String findFrequencyOfChar(String str) {
    String expectedResult = "";
    int j = 0;
    while(j<str.length()) {
      int count = 0;
      for(int i=0;i<str.length();i++){
        if(str.charAt(i) == str.charAt(j)) {
          count++;
        }
      }
      expectedResult +=str.charAt(j)+""+count;
      str = str.replace(""+str.charAt(j),"");
    }
    return expectedResult;
  }

//  6. Write a return method that can verify if a password is valid or not.
//requirements:
//      1. Password MUST be at least have 6 characters and should not contain space
//      2. PassWord should at least contain one upper case letter
//      3. PassWord should at least contain one lowercase letter
//      4. Password should at least contain one special characters
//      5. Password should at least contain a digit
//    if all requirements above are met, the method returns true, otherwise returns false
  public static boolean validatePassword(String password) {
    String lowercase = "(.*[a-z].*)";
    String uppercase = "(.*[A-Z].*)";
    String numbers = "(.*[0-9].*)";
    String specialchars = "(.*[-/,:-@].*)";

    boolean hasLower = password.matches(lowercase),
            hasUpper = password.matches(uppercase),
            hasDigits = password.matches(numbers),
            hasSpecial = password.matches(specialchars),
            valid = false;

    if(password.length() >= 6 && !password.contains(" "))
      if(hasLower && hasUpper && hasDigits && hasSpecial)
        valid = true;

    return valid;
  }

//  7-8. Write a method that can find the maximum(minimum) number from an int Array
    public static int maxValue(int[] n) {
      Arrays.sort(n);
      return n[n.length-1];
      //return n[0]; -> for the minimum number
    }

//    9. Write a return method that can sort an int array in Ascending order without using the sort method of the Arrays class
//  Ex:
//  int[] arr = {10, 9, 8, 7};   arr = Sort(arr); ==>{ 7, 8, 9, 10};
  public static int[] sortAscending(int[] arr) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int each : arr)
      list.add(each);
    for(int i=0; i< arr.length; i++) {
      arr[i] = findMin(list);
      list.remove(Integer.valueOf(arr[i]));
    }
    return arr;
  }

  public static int findMin(ArrayList<Integer> array) {
    int min = Integer.MAX_VALUE;
    for(int each: array)
      min = Math.min(min,each);

    return min;
  }

//  10. Write a return method that can sort an int array in descending ordern without using the sort method of the Arrays class
//  Ex: int[] arr = {10,20,7, 8, 90};  arr = Sort(arr); ==> {90, 20, 10, 8, 7};
public static int[] sortDescending(int[] arr) {
  ArrayList<Integer> list = new ArrayList<Integer>();
  for(int each : arr)
    list.add(each);
  for(int i=0; i< arr.length; i++) {
    arr[i] = findMax(list);
    list.remove(Integer.valueOf(arr[i]));
  }
  return arr;
}

  public static int findMax(ArrayList<Integer> array) {
    int max = Integer.MIN_VALUE;
    for(int each: array)
      max = Math.max(max,each);

    return max;
  }
}

