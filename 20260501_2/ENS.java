package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
    기존
    매 query마다 전체 map.values() 순회
    → Set에 다시 add
    → 색상 중복 개수 관리 불가
    → O(n²)에 가까움

    개선
    변경된 index의 이전 색상 개수 -1
    새로운 색상 개수 +1
    개수가 0이 되면 colors에서 제거
    현재 색상 종류 수는 colors.size()
    → 매 query O(1)
 */
public class AnotherCircle {
    public static void main(String[] args) {
        AnotherCircle anotherCircle = new AnotherCircle();
        int[] ints = anotherCircle.queryResults(4, new int[][]{{0,2},{1,10},{0,10},{0,3},{1,5}});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Integer> indexs = new HashMap<>();


        int cnt = 0;
        for (int[] query : queries) {

            int index = query[0];
            int color = query[1];

            if (indexs.containsKey(index)) {
                Integer previousColor = indexs.get(index);
                Integer i = colors.get(previousColor);
                i--;
                if (i <= 0) {
                    colors.remove(previousColor);
                }else {
                    colors.put(previousColor, i);
                }
                colors.put(color, colors.getOrDefault(color, 0) + 1);
                indexs.put(index, color);

            } else {
                indexs.put(index, color);
                if (colors.containsKey(color)) {
                    int i = colors.get(color) + 1;
                    colors.put(color, i);
                } else {
                    colors.put(color, 1);
                }
            }


            result[cnt] = colors.size();

            cnt++;
        }

        return result;
    }
}
