package com.mmu.gen;

import com.mmu.model.Person;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Snippets8 {


    public static OptionalInt getMax( List<Integer> list ){
        return list.stream().mapToInt(Integer::intValue).max();
    }

    public static List<Integer> uniqueSquares(List<Integer> numbers){
        return numbers.stream().map( x -> x * x ).distinct().collect(Collectors.toList());
    }

    public static Stream<String> stringArrayToFlatMap(String[][] data) {
        Stream<String[]> temp = Arrays.stream(data);
        return temp.flatMap(Arrays::stream);
    }

    public static Map<String,Integer> listToMap(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1 ));
    }

    public static List<Integer> twoDimArrayToList( Integer[][] twoDim ){

        return Arrays.stream(twoDim)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }


    private static int getTotalAge(List<Person> persons){
        return persons.stream().mapToInt(Person::getAge).sum();
    }

    private static void skipnLimit(int[] a, int skip, int limit ){
        Arrays.stream(a).skip(skip).limit(limit).forEach(System.out::println);
    }
    public static void main(String[] args) {


      //  System.out.println(Snippets.getMax(Arrays.asList(1,2,3,4,5)));
      //  Snippets.uniqueSquares(Arrays.asList(1,2,3,4,4,5)).forEach(System.out::println);


       // String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
       // Snippets.stringArrayToFlatMap(data).forEach(System.out::println);

    //    Snippets.listToMap(Arrays.asList("Visa","Master","Master", "Visa", "Express")).entrySet().forEach(System.out::println);
      /*  Integer [][] twoDArray = {
                {1,  2,  3,  4,  40},
                {5,  6,  7,  8,  50},
                {9,  10, 11, 12, 60},
                {13, 14, 15, 16, 70},
                {17, 18, 19, 20, 80},
                {21, 22, 23, 24, 90},
                {25, 26, 27, 28, 100},
                {29, 30, 31, 32, 110},
                {33, 34, 35, 36, 120}};*/

      //  Snippets8.twoDimArrayToList( twoDArray ).forEach(System.out::println);
        Snippets8.skipnLimit(new int[]{1,2,3,4,5}, 2, 2);
    }


}
