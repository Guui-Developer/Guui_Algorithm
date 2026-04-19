using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class Solution
{
    private int[] dx = [-1, 0, 1, -1, 1, -1, 0, 1];
    private int[] dy = [-1, -1, -1, 0, 0, 1, 1, 1];
    
    public void GameOfLife(int[][] board)
    {
        //깊은 복사
        List<List<int>> orginBoard = new List<List<int>>(board.ToList().Select(x=>x.ToList()));

        int maxX = orginBoard.Count;
        int maxY = orginBoard[0].Count;
        
        for (int i = 0; i < orginBoard.Count; i++)
        {
            for (int j = 0; j < orginBoard[i].Count; j++)
            {
                var neighbors = GetNeighbors(i, j);
                int current = orginBoard[i][j];
                int liveNeighbors = neighbors.Count(x => x == 1);
                
                //1.주변에 살아있는 세포가 두 개 미만인 세포는 개체 수 부족으로 인해 죽는 것처럼 보인다.
                if (liveNeighbors < 2)
                {
                    board[i][j] = 0;
                }
                //2.두세 개의 살아있는 이웃 세포와 함께 있는 살아있는 세포는 다음 세대로 이어집니다.
                else if (current == 1 &&(liveNeighbors == 2 || liveNeighbors == 3))
                {
                    board[i][j] = 1;
                }
                //3.주변에 살아있는 세포가 세 개 이상 있는 경우, 마치 과밀화로 인해 죽는 것처럼 보인다.
                else if (liveNeighbors > 3)
                {
                    board[i][j] = 0;
                }
                //4.죽은 세포가 살아있는 세포 세 개와 정확히 인접하게 되면, 마치 번식을 통해 살아있는 세포가 되는 것과 같습니다.
                else if (current == 0 && liveNeighbors == 3)
                {
                    board[i][j] = 1;
                }
            }
        }

        

        List<int> GetNeighbors(int x, int y)
        {
            List<int> neighbors = new List<int>();
            
            for (int k = 0; k < dx.Length; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx >= 0 && nx < maxX && ny >= 0 && ny < maxY)
                {
                    neighbors.Add(orginBoard[nx][ny]);
                }
            }
            return neighbors;
        }
    }
}