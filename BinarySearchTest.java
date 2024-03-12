import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        
        // Test for values present in the array
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(4, BinarySearch.binarySearch(array, 9));
        assertEquals(7, BinarySearch.binarySearch(array, 15));
        
        // Test for values not present in the array
        assertEquals(-1, BinarySearch.binarySearch(array, 2));
        assertEquals(-1, BinarySearch.binarySearch(array, 10));
        assertEquals(-1, BinarySearch.binarySearch(array, 16));
    }

    @Test
    public void testBoundaryCases() {
        int[] array = {1, 2, 3, 4, 5};
        
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(4, BinarySearch.binarySearch(array, 5));
        assertEquals(-1, BinarySearch.binarySearch(array, 0));
        assertEquals(-1, BinarySearch.binarySearch(array, 6));
        
        int[] largeArray = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            largeArray[i] = i * 2;
        }
        assertEquals(500000, BinarySearch.binarySearch(largeArray, 1000000));
        assertEquals(-1, BinarySearch.binarySearch(largeArray, -1));
        assertEquals(-1, BinarySearch.binarySearch(largeArray, 2000000));
    }

    @Test
    public void testRandomArrays() {
        int[] randomArray = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        for (int i = 0; i < 100; i++) {
            int target = (int) (Math.random() * 100);
            int expected = linearSearch(randomArray, target);
            assertEquals(expected, BinarySearch.binarySearch(randomArray, target));
        }
    }

    // Linear search method 
    private int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
