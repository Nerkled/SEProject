public class testingSetup{
    public static void main(String[] argas)
    {
        int[] array = new int[2];
        array[-1]=0;  //This line should generate an error because -1 is out of bounds for the array.
        System.out.println("The value at index -1 in the array is: " + array[-1]);
        //adding this so i can comit again
    }
}
