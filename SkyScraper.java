package com.building.gl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//Skyscraper question no 1, tested for TESTCASE 3

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        System.out.println("enter the total number of floors in the building");
        int floors = scan.nextInt();
        int[] floorSizeArray = new int[floors];
        int[] sortedFloors = new int[floors];
        for(int i=0; i< floors; i++) {
            System.out.println("enter the floor size given on day : "+ (i+1));
            floorSizeArray[i] = scan.nextInt();
            sortedFloors[i] = floorSizeArray[i];
        }
      
        Arrays.sort(sortedFloors);
        System.out.println("The order of construction is as follows");
        int j = floors - 1;
        for(int day=1;day<=floors; day++) {
            System.out.println("Day : "+day);
            if(floorSizeArray[day-1] == sortedFloors[j]) {
                System.out.print(sortedFloors[j]+" ");
                j--;
                while (!s.empty()) {
                    if(s.peek() == sortedFloors[j]) {
                        System.out.print(s.pop()+" ");
                        j--;
                    } else {
                        break;
                    }
                }
            } else{
                sortedInsert(s, floorSizeArray[day-1]);
            }
            System.out.println();
        }

        scan.close();

    }

    static void sortedInsert(Stack<Integer> s, int x)
    {

        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }

        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);

    }
}








