import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MixingMilkTest {
    private int numTests = 8;
    private int M, N;
    private int[] units, price;
    private int[] answers = {630, 0, 20, 0, 2000000, 2000000000, 993159, 86776774};

    @Test
    public void run() throws IOException {
        BufferedReader f = BarnRepairTest.readTestFile("mixingmilk.test");
        StringTokenizer st;
        int solution;
        boolean passed = true;

        for (int t=0; t<numTests; t++) {
            f.readLine();
            st = new StringTokenizer(f.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            units = new int[N]; price = new int[N];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(f.readLine());
                units[i] = Integer.parseInt(st.nextToken());
                price[i] = Integer.parseInt(st.nextToken());
            }

            solution = MixingMilk.solve(M, N, units, price);
            System.out.print("Test case " + t);

            if (solution != answers[t]) {
                System.out.println(" fails");
                passed = false;
            } else {
                System.out.println(" passes");
            }
        }

        assert passed;
    }
}
