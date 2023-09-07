public class sadaf_p1 {
    // constructor for the class
    public sadaf_p1() {}

    // method to sort an array of int values using selection sort
    public int[] selectionSort(int lowerBound, int upperBound, int[] values)
    {
        while (lowerBound < upperBound) {
            int minimum = values[lowerBound];
            int minIndex = lowerBound;
            for (int j = lowerBound + 1; j < upperBound; j++) {
                if (values[j] < minimum) {
                    minimum = values[j];
                    minIndex = j;
                }
            }

            if (minimum < values[lowerBound]) {
                int temp = values[lowerBound];
                values[lowerBound] = minimum;
                values[minIndex] = temp;
            }

            lowerBound++;
        }

        return values;
    }

    // method to return the number of array elements > testValue with indices in
    // [lowerBound, upperBound] using a for loop to examine the array elements
    public int forLoopTest(int[] values, int lowerBound, int upperBound, int testValue)
    {
    }

    // method to return the number of array elements <= testValue with indices in
    // [lowerBound, upperBound) using a while loop to examine the array elements
    public int whileLoopTest(int[] values, int lowerBound, int upperBound, int testValue)
    {
    }

    // method to return the number of array elements in (testValue1, testValue2)
    // or (testValue2, testValue1) with indices in [lowerBound, upperBound] using
    // a do-while loop to examine the array elements
    public int doWhileLoopTest(int[] values, int lowerBound, int upperBound, int testValue1, int testValue2)
    {
    }

    // method to return the number of array elements that match the switch cases
    // [0, 3, 6, 9, 12, 15, 18, 21, 24, 27] and the default case with indices in
    // (lowerBound, upperBound)
    public int[] switchTest(int[] values, int lowerBound, int upperBound)
    {
    }
}
