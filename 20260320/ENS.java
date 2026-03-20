import java.io.*;
import java.util.Map;

public class YourPrice_25206 {

    public static final Map<String, Double> priceMap = Map.of(
            "A+", 4.5,
            "A0", 4.0,
            "B+", 3.5,
            "B0", 3.0,
            "C+", 2.5,
            "C0", 2.0,
            "D+", 1.5,
            "D0", 1.0,
            "F", 0.0
    );

    public static final String PASS = "P";
    public static final String FAIL = "F";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double count = 0.0;
        double total = 0.0;

        for (int i = 0; i < 20; i++) {

            String[] tokens = br.readLine().split(" ");

            if (PASS.equals(tokens[0])) {
                continue;
            }

            total += priceMap.get(tokens[2]) * Double.parseDouble(tokens[1]);
            count += Double.parseDouble(tokens[1]);

        }

        bw.write(String.format("%.6f", total / count));
        bw.flush();
        bw.close();

    }

}
