import java.util.Random;

public class Homework1 {
    public static int[] insert(int[] array, int index, int value)                    //O(n)
    {

        // Create new array one larger than original array
        int newArray[] = new int [array.length + 1];                                 //O(1)

        for (int i = 0; i < array.length ; i++) {                                    //O(n)

            // Copy elements up to insert point from original array to new array
            if (i  < index )                                                         //O(1)
                newArray[i] = array[i];                                              //O(1)

            // Place insert value into new array
            else if (i == index )                                                    //O(1)
                newArray[i] = value;                                                 //O(1)

            // Copy elements after insert point from original array to new array
            else  newArray[i + 1] = array[i];                                        //O(1)
        }
    return newArray;                                                                 //O(1)
    }

    public static void main(String args[]) {

    // Setting to allow fine-tuning the granularity of the readings
    final double NUM_READINGS = 60;
    final double INSERTS_PER_READING = 1000;
    final double NANO_SECONDS_PER_SECOND = 1000000000;

    // Start with an array containing 1 element
    int array[] = {0};

    System.out.format("%4s\t%7s\n" ,"Array length" , "Seconds per insert");

    // Loop NUM_READINGS times
    for( int j = 0; j<NUM_READINGS ; j++)

    {

        // set start time = current time
        long start = System.nanoTime();

        // Loop INSERTS_PER_READING times
        for (int k = 0; k < INSERTS_PER_READING; k++) {
            Random r = new Random();
            int index = r.nextInt(array.length);
            int value = r.nextInt();
            array = Homework1.insert(array, index, value);
        }

        // set stop time
        long stop = System.nanoTime();

        // calculate the time duration for each insert
        //double time = (double) (stop - start) / (INSERTS_PER_READING * NANO_SECONDS_PER_SECOND);
        String TimePerInsert=String.format("%.6f",(stop - start) / (INSERTS_PER_READING * NANO_SECONDS_PER_SECOND));

        // output in tabular format
        System.out.format("%7d%23s\n" ,array.length , TimePerInsert);
    }
}
}
