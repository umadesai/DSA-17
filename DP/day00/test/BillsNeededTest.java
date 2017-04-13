import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BillsNeededTest {

    /**
     * Test method for {@link BillsNeeded#billsNeeded(int, int[])}.
     */
    @Test
    public void testBillsNeeded() throws FileNotFoundException {
        for(int i = 1; i <= 10; i++){
            Scanner input = new Scanner(new File(
                    "testcases/change." + i + ".in"));
            Scanner output = new Scanner(new File(
                    "testcases/change." + i + ".out"));

            int target = input.nextInt();
            int n = input.nextInt();
            int[] bills = new int[n];
            for(int j = 0; j < n; j++){
                bills[j] = input.nextInt();
            }

            assertEquals(output.nextInt(),new BillsNeeded().billsNeeded(target,bills));

            input.close();
            output.close();
        }
    }
}
