<<<<<<< Updated upstream
// checkstyle:
// Checks Java source code for adherence to a set of rules.
// Copyright (C) 2024  Henry Becker
// Last modification by $Author: Justin Feinman $ 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
=======
public class TestingSetup{
    public static void main(String[] argas)
    {
        int[] array = new int[2];
        array[-1]=0;  //This line should generate an error because -1 is out of bounds for the array.
        System.out.println("The value at index -1 in the array is: " + array[-1]);
>>>>>>> Stashed changes

public class TestingSetup {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 9;
        array[1] = 10;
        System.out.println("The Value at 0 index is " + array[0] + "  value at index 1 is " + array[1]);
        // Working test class
    }
}
