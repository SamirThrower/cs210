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
        int totalGreater = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            if (values[i] > testValue) 
                totalGreater++;
        }

        return totalGreater;
    }

    // method to return the number of array elements <= testValue with indices in
    // [lowerBound, upperBound) using a while loop to examine the array elements
    public int whileLoopTest(int[] values, int lowerBound, int upperBound, int testValue)
    {
        int lessOrEqual = 0;
        while (lowerBound < upperBound) {
            if (values[lowerBound] <= testValue)
                lessOrEqual++;
            lowerBound++;
        }
        return lessOrEqual;
    }

    // method to return the number of array elements in (testValue1, testValue2)
    // or (testValue2, testValue1) with indices in [lowerBound, upperBound] using
    // a do-while loop to examine the array elements
    public int doWhileLoopTest(int[] values, int lowerBound, int upperBound, int testValue1, int testValue2)
    {
        int lowerValue;
        int higherValue;
        if (testValue1 > testValue2) {
            higherValue = testValue1;
            lowerValue = testValue2;
        }

        else {
            higherValue = testValue2;
            lowerValue = testValue1;
        }

        int withinBounds = 0;
        do {
            if (values[lowerBound] > lowerValue && values[lowerBound] < higherValue)
                withinBounds++;
            lowerBound++;
        } while(lowerBound <= upperBound);

        return withinBounds;
    }

    // method to return the number of array elements that match the switch cases
    // [0, 3, 6, 9, 12, 15, 18, 21, 24, 27] and the default case with indices in
    // (lowerBound, upperBound)
    public int[] switchTest(int[] values, int lowerBound, int upperBound)
    {
        int[] matches = new int[11];

        for (int i = lowerBound + 1; i < upperBound; i++) {
            switch (values[i]) {
                case 0:
                    matches[0]++;
                    break;
                case 3:
                    matches[1]++;
                case 6:
                    matches[2]++;
                    break;
                case 9:
                    matches[3]++;
                case 12:
                    matches[4]++;
                    break;
                case 15:
                    matches[5]++;
                case 18:
                    matches[6]++;
                    break;
                case 21:
                    matches[7]++;
                case 24:
                    matches[8]++;
                    break;
                case 27:
                    matches[9]++;
                default:
                    matches[10]++;
                    break;
            }  
        }

        return matches;
    }
}
