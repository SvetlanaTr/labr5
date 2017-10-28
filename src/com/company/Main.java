package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Integer[] arrayA = { 1, 2, 3, 4 , 5 };
        Integer[] arrayB = { 4, 5, 6, 7 };

       /* int sizeA = 0, sizeB =0 ;  //размеры соответствующих массивов
        int maxA, minA, maxB, minB;  //задают диапазон значений элементов
        // массивов

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите количество элементов А: ");
        sizeA = scanner.nextInt();
        Integer[] arrA = new Integer[sizeA];
        System.out.println("введите количество элементов B: ");
        sizeB = scanner.nextInt();
        Integer[] arrB = new Integer[sizeB];
        System.out.print("размер множества B = " + sizeB);
        System.out.println(" размер множества А = " + sizeA);

        System.out.println("введите минимальное значение для множ. А: ");
        minA = scanner.nextInt();
        System.out.println("введите минимальное значение для множ. В: ");
        minB = scanner.nextInt();
        System.out.println("введите максимальное значение для множ. A: ");
        maxA = scanner.nextInt();
        System.out.println("введите максимальное значение для множ. В: ");
        maxB = scanner.nextInt();

        rand(arrA, maxA, minA);
        rand(arrB, maxB, minB);

        System.out.println("Сортировка ");



        int m = 0;
        System.out.println("множество А");
        for (int z = 0;z < sizeA; z++) {
            m +=1;

            System.out.print((arrA[z])+" ");
            if (m == 20) {
                System.out.print("\n");
                m = 0;
            }
        }
        System.out.println("множество В");
        for (int z = 0;z < sizeB; z++) {
            m +=1;
            System.out.print((arrB[z])+" ");
            if (m == 20) {
                System.out.print("\n");
                m = 0;
            }
        }

*/

        Set<Integer> setA = new HashSet<Integer>(Arrays.asList(arrayA));//arrayA arrayB
        Set<Integer> setB = new HashSet<Integer>(Arrays.asList(arrayB));

        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        //setA.add(Integer.valueOf(Arrays.toString(arrA)));

        System.out.println("Объеденение А и Б ");
        Set<Integer> Obedenenie1 =obedenen(setA, setB);
        System.out.println(Obedenenie1);

        System.out.println("Кол-во общих элементов: "+Obedenenie1.size());

        System.out.println("Пересечение А и Б ");
        Set<Integer> Peresecenye1 =  peresec(setA, setB);
        System.out.println(Peresecenye1);

        System.out.println("Число общих элементов:"+Peresecenye1.size());
        System.out.println("Общее число сравнений:");

        System.out.println("Разность А и Б ");
        Set<Integer> Raznost1 = raznost(setA, setB);
        System.out.println(Raznost1); /* 1, 2, 3, 6, 7 */

        System.out.println("Разность Б и А ");
        Set<Integer> Raznost2 = raznost( setB,setA);
        System.out.println(Raznost2);

        System.out.println("Дизъюнктивная сумма A и Б");
        Set<Integer> setAdiz = new HashSet<Integer>(Raznost1);//arrayA arrayB
        Set<Integer> setBdiz = new HashSet<Integer>(Raznost2);
        Set<Integer> dizSum = dizsumm(setAdiz,setBdiz);
        System.out.println(dizSum);

    }
    public static void rand(Integer[] Ar, int max, int min) {//создается случайный массив с определенным диапазоном
        label1:
        for ( int i = 0; i < Ar.length; ) {
            int randnumb = min + (int) (Math.random() * ((max - min) + 1));
            for (int j = 0; j < Ar.length;j++){
                if (randnumb == Ar[j]) continue label1;
            }
            Ar[i] = randnumb;

            i++;
        }
    }


    // объединение двух множеств
    private static Set<Integer> obedenen(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);
        return result;
    }

    // пересечение двух множеств
    private static Set<Integer> peresec(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>(a);
        result.retainAll(b);
        return result;
    }

    // разность двух множеств
    private static Set<Integer> raznost(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>();
        for(Integer i : a) {
            if(!b.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static Set<Integer> dizsumm(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);
        return result;

    }
}