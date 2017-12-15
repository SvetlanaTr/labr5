package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        int size = 7; //размер массива записываем в size
        int m = 0;
        int[] arrayХ = {1, 2, 3, 4, 5, 6, 7};
        System.out.print(" множество X = {");
        for (int i = 0; i < size; i++) {
            if (i == size-1){ System.out.print(" " + (arrayХ[i]));}
            else System.out.print(" " + (arrayХ[i]+",")); // Выводим на экран, полученный массив
        }
        System.out.print(" }");
        System.out.println();

        int[][] matrR1 = new int[arrayХ.length][arrayХ.length];
        int[][] matrR2 = new int[arrayХ.length][arrayХ.length];
        int ost =0;
        int[] matrRR1 = new int[0];
        int[] matrRR2 = new int[0];

        System.out.println("Отношение R1 -> быть меньше");
        System.out.println("Отношение R2 ->(i+j => (i,j)) делиться на 3");

        for (int i = 0; i < arrayХ.length; i++) {
            for (int j = 0; j < arrayХ.length; j++) {
                    if (arrayХ[i] < arrayХ[j]) {
                        matrR1[i][j] = 1;

                    }
                    else matrR1[i][j]=0;

                if ((arrayХ[i]+arrayХ[j]) % 3 == 0){
                    matrR2[i][j] = 1;
                }
                    else matrR2[i][j] = 0;

                }
            }
        System.out.println("Матрица бинарного отношени R1 ->");
        for (int i = 0; i < size; i++) {
            System.out.print("\t"+arrayХ[i] + "|");
        }
        System.out.println(" ");
        for (int s = 0; s < matrR1.length; s++){
            System.out.print(arrayХ[s] + "| \t");
            for (int z = 0;z < matrR1.length; z++) {
                m +=1;

                System.out.print((matrR1[s][z])+"\t");
                if (m == size) {
                    System.out.print("\n");
                    m = 0;
                }
            }
        }
        System.out.println("Матрица бинарного отношени R2 ->");
        for (int i = 0; i < size; i++) {
            System.out.print("\t"+arrayХ[i] + "|");
        }
        System.out.println(" ");
        for (int s = 0; s < matrR1.length; s++){
            System.out.print(arrayХ[s] + "| \t");
            for (int z = 0;z < matrR2.length; z++) {
                m +=1;

                System.out.print((matrR2[s][z])+"\t");
                if (m == size) {
                    System.out.print("\n");
                    m = 0;
                }
            }
        }
        System.out.println(" в виде пар элементов");
        System.out.println(" ");
        ArrayList<Integer> arrayListR1 = new ArrayList<>();
        ArrayList<Integer> arrayListR2 = new ArrayList<>();
        //в виде пар элементов
        for (int i = 0; i < arrayХ.length; i++) {
            for (int j = 0; j < arrayХ.length; j++) {
                if (arrayХ[i] < arrayХ[j]) {
                    String h = Integer.toString(arrayХ[i]) + Integer.toString(arrayХ[j]);
                    int y = Integer.parseInt(h); //если нужно новое число снова в int
                    arrayListR1.add(y);
                } else continue;
            }
        }
            for (int i = 0; i < arrayХ.length; i++) {
                for (int j = 0; j < arrayХ.length; j++) {
                    if ((arrayХ[i] + arrayХ[j]) % 3 == 0) {
                        String d = Integer.toString(arrayХ[i]) + Integer.toString(arrayХ[j]);
                        int q = Integer.parseInt(d); //если нужно новое число снова в int
                        arrayListR2.add(q);
                    } else continue;
                }
            }
        System.out.print("Бинарного отношения R1 в виде пар элементов -> ");
        System.out.println(arrayListR1);
        System.out.print("Бинарного отношения R2 в виде пар элементов -> ");
        System.out.println(arrayListR2);
//__________________________________________________________________________________________________________________
        sort(arrayListR1);
        sort(arrayListR2);
        Set<Integer> listsetR1 = new HashSet<Integer>(arrayListR1);//arrayA arrayB
        Set<Integer> listsetR2 = new HashSet<Integer>(arrayListR2);

        System.out.print("Объеденение R1 и R2 ->");
        Set<Integer> Obedenenie1 =obedenen(listsetR1, listsetR2);
        ArrayList<Integer> arrayListSort5 = new ArrayList<>(Obedenenie1);
        Collections.sort(arrayListSort5);
        System.out.println(arrayListSort5);
//        System.out.println("Кол-во общих элементов: "+Obedenenie1.size());

        System.out.print("Пересечение R1 и R2 ->");
        Set<Integer> Peresecenye1 =  peresec(listsetR1, listsetR2);
        ArrayList<Integer> arrayListSort4 = new ArrayList<>(Peresecenye1);
        Collections.sort(arrayListSort4);
        System.out.println(arrayListSort4);
//        System.out.println("Число общих элементов:"+Peresecenye1.size());

        System.out.print("Разность R1 \\ R2 ->");
        Set<Integer> Raznost1 = raznost(listsetR1, listsetR2);
        //List listraznSort = Arrays.asList(Raznost1);
        ArrayList<Integer> arrayListSort = new ArrayList<>(Raznost1);
        Collections.sort(arrayListSort);
        System.out.println(arrayListSort);
//        System.out.println("Число общих элементов:"+Raznost1.size());

        System.out.print("Разность R2 \\ R1 ->");
        Set<Integer> Raznost2 = raznost( listsetR2,listsetR1);
        ArrayList<Integer> arrayListSort2 = new ArrayList<>(Raznost2);
        Collections.sort(arrayListSort2);
        System.out.println(arrayListSort2);
//        System.out.println("Число общих элементов:"+Raznost2.size());

        System.out.print("Дизъюнктивная сумма R1 и R2 ->");
        Set<Integer> setAdiz = new HashSet<Integer>(Raznost1);
        Set<Integer> setBdiz = new HashSet<Integer>(Raznost2);
        Set<Integer> dizSum = dizsumm(setAdiz,setBdiz);
        ArrayList<Integer> arrayListSort3 = new ArrayList<>(dizSum);
        Collections.sort(arrayListSort3);
        System.out.println(arrayListSort3);
//        System.out.println("Число общих элементов:"+dizSum.size());

        System.out.print("Инверсия R1 -> ");
        ArrayList<String> arrayListRR1 = new ArrayList<>();

        for ( int i =0 ; i < arrayListR1.size(); i++){
            String str = arrayListR1.get(i).toString();
            char[] chr = str.toCharArray();
            char sibol = chr[0];
            chr[0] = chr[1];
            chr[1] = sibol;
            String strok = new String(chr);
            arrayListRR1.add(strok);
        }
        System.out.print(arrayListRR1);
        System.out.println(" ");
        System.out.print("Композиция R1 и R2 -> ");
        ArrayList<String> arrayListRR2 = new ArrayList<>();

        for (int i = 0; i < arrayListR1.size(); i++) {
            for (int j = 0; j < arrayListR2.size(); j++) {
                String str = arrayListR1.get(i).toString();
                String str2 = arrayListR2.get(j).toString();
                char[] chrArr = str.toCharArray();
                char[] chr2Arr = str2.toCharArray();
                char firs1 = chrArr[0];
                char second1 = chrArr[1];
                char firs2 = chr2Arr[0];
                char second2 = chr2Arr[1];
                if (second1 == firs2) {
                    String chr3 = String.valueOf((firs1) + String.valueOf(second2));

                    String ctrok = new String(chr3);
                    arrayListRR2.add(ctrok);
                } else continue;

            }
        }
        List<String> arrayListR = arrayListRR2.stream().distinct().collect(Collectors.toList());
        System.out.print(arrayListR);
    }
    private static Set<Integer> dizsumm(Set<Integer> a, Set<Integer> b) { //Дизъюнктивная сумма A и Б
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);//добавляет в а, все из б
        return result;
    }
    private static Set<Integer> raznost(Set<Integer> a, Set<Integer> b) {// разность двух множеств
        Set<Integer> result = new HashSet<Integer>();
        for(Integer i : a) {
            if(!b.contains(i)) {// все что НЕ содержиться в одном из множеств
                result.add(i);
            }
        }
        return  result;
    }
    private static Set<Integer> peresec(Set<Integer> a, Set<Integer> b) {// пересечение двух множеств
        Set<Integer> result = new HashSet<Integer>(a);
        result.retainAll(b);//retainAll(Collection c) — удаляет элементы б, не принадлежащие переданной коллекции а из (общее)
        return result;
    }
    private static Set<Integer> obedenen(Set<Integer> a, Set<Integer> b) {// объединение двух множеств
        Set<Integer> result = new HashSet<Integer>(a);
        result.addAll(b);// добавляет все из б
        return result;
    }
}

/*
