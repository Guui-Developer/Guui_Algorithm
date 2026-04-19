public class GameOfLife {

    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }

    public void gameOfLife(int[][] board) {
        int[][] answer = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int oneCount = 0;
                for (int k = 0; k < 8; k++) {
                    int r = i + dx[k];
                    int c = j + dy[k];
                    if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                        if (board[r][c] == 1) {
                            oneCount++;
                        }
                    }
                }

                if (board[i][j] == 0) {
                    if (oneCount == 3) {
                        answer[i][j] = 1;
                    }
                } else {
                    if (oneCount < 2) {
                        answer[i][j] = 0;
                    } else if (oneCount > 3) {
                        answer[i][j] = 0;
                    }else {
                        answer[i][j] = 1;
                    }
                }

            }
        }
        System.arraycopy(answer, 0, board, 0, board.length);
    }
}
