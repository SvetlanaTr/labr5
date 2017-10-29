package com.company;
import javafx.print.Collation;

import java.util.*;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {

       // Integer[] arrayA = { 1, 2, 3, 4 , 5 };
       // Integer[] arrayB = { 4, 5, 6, 7 };

        int sizeA = 0;  //размеры соответствующих массивов
        int sizeB =0 ;
        int maxA, minA, maxB, minB;  //задают диапазон значений элементов
        // массивов

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите количество элементов А: ");
        sizeA = scanner.nextInt();
        Integer[] arrayA = new Integer[sizeA];
        System.out.println("введите количество элементов B: ");
        sizeB = scanner.nextInt();
        Integer[] arrayB = new Integer[sizeB];
        System.out.println("размер множества B = " + sizeB);
        System.out.println("размер множества А = " + sizeA);

        System.out.println("введите минимальное значение для множ. А: ");
        minA = scanner.nextInt();
        System.out.println("введите минимальное значение для множ. В: ");
        minB = scanner.nextInt();

        System.out.println("введите максимальное значение для множ. A: ");
        maxA = scanner.nextInt();
        System.out.println("введите максимальное значение для множ. В: ");
        maxB = scanner.nextInt();

       // System.out.println("Множество А");
        ArrayList<Integer> arrayAList = new ArrayList<>(sizeA);
        while (arrayAList.size() < sizeA) {
            int randnumb =(minA + (int) (Math.random() * ((maxA - minA) + 1)));
            if (!arrayAList.contains(randnumb)) {
                arrayAList.add(randnumb);
            }
        }
        int[] randomArray = arrayAList.stream().mapToInt(i -> i).toArray();

        ArrayList<Integer> arrayBList = new ArrayList<>(sizeB);
        while (arrayBList.size() < sizeB) {
            int randnumb =(minB + (int) (Math.random() * ((maxB - minB) + 1)));
            if (!arrayBList.contains(randnumb)) {
                arrayBList.add(randnumb);
            }
        }
        int[] random2Array = arrayBList.stream().mapToInt(i -> i).toArray();

       // System.out.println(arrayBList);


        //   rand(arrayA, maxA, minA);
     //   rand(arrayB, maxB, minB);
        System.out.println("Отсортированое множество A");
        sort(arrayAList);
        System.out.println(arrayAList);
        System.out.println("Отсортированое множество Б");
        sort(arrayBList);
        System.out.println(arrayBList);

        Set<Integer> listsetA = new HashSet<Integer>(arrayAList);//arrayA arrayB
        Set<Integer> listsetB = new HashSet<Integer>(arrayBList);

       // System.out.println(Arrays.toString(arrayA));
       // System.out.println(Arrays.toString(arrayB));
        //setA.add(Integer.valueOf(Arrays.toString(arrA)));

        System.out.println("Объеденение А и Б ");
        Set<Integer> Obedenenie1 =obedenen(listsetA, listsetB);
        ArrayList<Integer> arrayListSort5 = new ArrayList<>(Obedenenie1);
        Collections.sort(arrayListSort5);
        System.out.println(arrayListSort5);
        System.out.println("Кол-во общих элементов: "+Obedenenie1.size());

        System.out.println("Пересечение А и Б ");
        Set<Integer> Peresecenye1 =  peresec(listsetA, listsetB);
        ArrayList<Integer> arrayListSort4 = new ArrayList<>(Peresecenye1);
        Collections.sort(arrayListSort4);
        System.out.println(arrayListSort4);
        System.out.println("Число общих элементов:"+Peresecenye1.size());

        System.out.println("Разность А и Б ");
        Set<Integer> Raznost1 = raznost(listsetA, listsetB);
        //List listraznSort = Arrays.asList(Raznost1);
        ArrayList<Integer> arrayListSort = new ArrayList<>(Raznost1);
        Collections.sort(arrayListSort);
        System.out.println(arrayListSort);
        System.out.println("Число общих элементов:"+Raznost1.size());

        System.out.println("Разность Б и А ");
        Set<Integer> Raznost2 = raznost( listsetB,listsetA);
        ArrayList<Integer> arrayListSort2 = new ArrayList<>(Raznost2);
        Collections.sort(arrayListSort2);
        System.out.println(arrayListSort2);
        System.out.println("Число общих элементов:"+Raznost2.size());

        System.out.println("Дизъюнктивная сумма A и Б");
        Set<Integer> setAdiz = new HashSet<Integer>(Raznost1);
        Set<Integer> setBdiz = new HashSet<Integer>(Raznost2);
        Set<Integer> dizSum = dizsumm(setAdiz,setBdiz);
        ArrayList<Integer> arrayListSort3 = new ArrayList<>(dizSum);
        Collections.sort(arrayListSort3);
        System.out.println(arrayListSort3);
        System.out.println("Число общих элементов:"+dizSum.size());

    }
    private static Set<Integer> dizsumm(Set<Integer> a, Set<Integer> b) { //Дизъюнктивная сумма A и Б
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);
        return result;
    }
    private static Set<Integer> raznost(Set<Integer> a, Set<Integer> b) {// разность двух множеств
        Set<Integer> result = new HashSet<Integer>();
        for(Integer i : a) {
            if(!b.contains(i)) {
                result.add(i);
            }

        }
        return  result;
    }
    private static Set<Integer> peresec(Set<Integer> a, Set<Integer> b) {// пересечение двух множеств
        Set<Integer> result = new HashSet<Integer>(a);
        result.retainAll(b);
        return result;
    }
    private static Set<Integer> obedenen(Set<Integer> a, Set<Integer> b) {// объединение двух множеств
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);
        return result;
    }
}