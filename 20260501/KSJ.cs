using System;
using System.Collections.Generic;

public class Solution {
    public int[] AsteroidCollision(int[] asteroids) {
        List<int> asteroidList = new List<int>(asteroids);
        bool[] deadList = new bool[asteroids.Length];

        for (int index = 0; index < asteroidList.Count; index++)
        {
            int asteroid = asteroidList[index];

            if (deadList[index] || asteroid > 0)
            {
                continue;
            }

            int searchIndex = index - 1;
            while (searchIndex >= 0)
            {
                if (deadList[searchIndex])
                {
                    searchIndex--;
                    continue;
                }

                if (asteroidList[searchIndex] < 0)
                {
                    break;
                }

                int currentSize = Math.Abs(asteroid);
                int previousSize = Math.Abs(asteroidList[searchIndex]);

                if (currentSize > previousSize)
                {
                    deadList[searchIndex] = true;
                    searchIndex--;
                    continue;
                }

                if (currentSize == previousSize)
                {
                    deadList[searchIndex] = true;
                }

                deadList[index] = true;
                break;
            }
        }

        List<int> result = new List<int>();
        for (int i = 0; i < asteroidList.Count; i++)
        {
            if (!deadList[i])
            {
                result.Add(asteroidList[i]);
            }
        }
        return result.ToArray();
    }

    public static void Main(string[] args)
    {
        foreach (var v in new Solution().AsteroidCollision(new[] { -2,-1,1,2 }))
        {
            Console.Write(v+" ");
        }
    }
}
