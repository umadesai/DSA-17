
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StocksTest {

    /**
     * Test method for {@link Stocks#maxProfit(int[])}.
     */
    @Test
    public void testMaxProfit() throws FileNotFoundException {
        for(int i = 1; i <= 7; i++){
            Scanner input = new Scanner(new File(
                    "testcases/maxprofit." + i + ".in"));
            Scanner output = new Scanner(new File(
                    "testcases/maxprofit." + i + ".out"));

            int n = input.nextInt();
            int[] prices = new int[n];
            for(int j = 0; j < n; j++){
                prices[j] = input.nextInt();
            }
            int expected = output.nextInt();
            int actual = new Stocks().maxProfit(prices);
            assertEquals(expected, actual);

            input.close();
            output.close();
        }
    }

    /**
     * Test method for {@link Stocks#maxProfitWithK(int[], int)}}.
     */
    @Test
    public void testMaxProfitWithK() throws FileNotFoundException {
        for(int i = 1; i <= 9; i++){
            Scanner input = new Scanner(new File(
                    "testcases/maxprofitk." + i + ".in"));
            Scanner output = new Scanner(new File(
                    "testcases/maxprofitk." + i + ".out"));

            int n = input.nextInt();
            int k = input.nextInt();
            int[] prices = new int[n];
            for(int j = 0; j < n; j++){
                prices[j] = input.nextInt();
            }

            assertEquals(output.nextInt(),new Stocks().maxProfitWithK(prices,k));

            input.close();
            output.close();
        }
    }
}
