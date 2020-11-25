package com.company;
 
import java.util.ArrayList;
import java.util.LinkedList;
 
public class Main {
 
    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<>();
        LinkedList<Integer> test2 = new LinkedList<>();
        int[] data = new int[]{100, 10000, 100000};
 
        for (int test :
                data) {
            System.out.println("��� " + test + " ���������:");
            System.out.println();
            System.out.println("����� add ��� ArrayList");
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                test1.add(i);
            }
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
 
            System.out.println("����� add ��� LinkedList");
            time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                test2.add(i);
            }
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
 
            System.out.println("����� get ��� ArrayList");
            time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                int a = test1.get(i);
            }
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
 
            System.out.println("����� get ��� LinkedList");
            time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                int a = test2.get(i);
            }
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
 
            System.out.println("����� remove ��� ArrayList");
            time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                test1.remove(0);
            }
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
 
            System.out.println("����� remove ��� LinkedList");
            time1 = System.currentTimeMillis();
            for (int i = 0; i < test; i++) {
                test2.remove(0);
            }
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1 + " ms");
            System.out.println();
        }
 
    }
}