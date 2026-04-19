using System;
using System.Collections.Generic;

public class Robot
{
    public Dictionary<DIRECTION, int[]> dirData = new()
    {
        { DIRECTION.East, [1, 0] },
        { DIRECTION.North, [0, 1] },
        { DIRECTION.West, [-1, 0] },
        { DIRECTION.South, [0, -1] },
    };

    public enum DIRECTION
    {
        East = 0,
        North = 1,
        West = 2,
        South = 3
    }

    public int[,] map;
    private DIRECTION dir;
    private int[] pos;
    private int width, height, perimeter;

    public Robot(int width, int height)
    {
        map = new int[width, height];
        dir = DIRECTION.East;
        pos = new[] { 0, 0 };
        perimeter = GetCycleLength(width, height);
        this.width = width;
        this.height = height;
    }

    public void Step(int num)
    {
        if (num <= 0 || (width == 1 && height == 1))
        {
            return;
        }

        if (perimeter > 0)
        {
            num %= perimeter;
            if (num == 0)
            {
                num = perimeter;
            }
        }

        while (num > 0)
        {
            var gotoXorY = 0;
            switch (dir)
            {
                case DIRECTION.East:
                    gotoXorY = width - 1 - pos[0];
                    break;
                case DIRECTION.North:
                    gotoXorY = height - 1 - pos[1];
                    break;
                case DIRECTION.West:
                    gotoXorY = pos[0];
                    break;
                case DIRECTION.South:
                    gotoXorY = pos[1];
                    break;
            }

            if (gotoXorY == 0)
            {
                Rotate();
                continue;
            }

            var move = Math.Min(num, gotoXorY);
            pos[0] += dirData[dir][0] * move;
            pos[1] += dirData[dir][1] * move;
            num -= move;

            if (num > 0 && move == gotoXorY)
            {
                Rotate();
            }
        }
    }

    public int[] GetPos()
    {
        return new[] { pos[0], pos[1] };
    }

    public string GetDir()
    {
        return dir.ToString();
    }

    public void Rotate()
    {
        dir = dir == DIRECTION.South
            ? DIRECTION.East
            : (DIRECTION)((int)dir + 1);
    }

    private static int GetCycleLength(int width, int height)
    {
        if (width == 1 && height == 1)
        {
            return 0;
        }

        if (width == 1)
        {
            return (height - 1) * 2;
        }

        if (height == 1)
        {
            return (width - 1) * 2;
        }

        return (width + height - 2) * 2;
    }
}
