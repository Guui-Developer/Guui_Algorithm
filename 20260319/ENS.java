import java.io.*;

public class SugarDelivery_2839 {

    public static final int SUGAR_3KG = 3;
    public static final int SUGAR_5KG = 5;
    public static final int NOT_MOVE = -1;
    public static int SUGAR_5KG_COUNT = 0;
    public static int SUGAR_3KG_COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalSugar = Integer.parseInt(br.readLine());
        int move = 0;

        while (totalSugar / SUGAR_5KG != 0) {
            SUGAR_5KG_COUNT++;
            totalSugar -= SUGAR_5KG;
        }


        while (SUGAR_5KG_COUNT >= 0) {
            if (totalSugar % SUGAR_3KG == 0) {
                SUGAR_3KG_COUNT = totalSugar / SUGAR_3KG;
                break;
            }
            totalSugar += SUGAR_5KG;
            SUGAR_5KG_COUNT--;
        }

        move = SUGAR_3KG_COUNT + SUGAR_5KG_COUNT;

        if (SUGAR_3KG_COUNT == 0 && SUGAR_5KG_COUNT == 0) {
            move = NOT_MOVE;
        }

        bw.write(move + "");
        bw.flush();
        bw.close();
    }

}
