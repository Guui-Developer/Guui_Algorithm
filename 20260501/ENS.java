import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ENS {

     public int[] asteroidCollision(int[] asteroids) {
        boolean[] asteroidStatus = new boolean[asteroids.length];
        LinkedList<Integer> positiveAsteroid = new LinkedList<>();
        LinkedList<Integer> positiveAsteroidIndex = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean nowChange = false;
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                positiveAsteroid.add(asteroid);
                positiveAsteroidIndex.add(i);
                nowChange = true;
            }

            if (!nowChange) {
                int count = 0;
                for (int j = positiveAsteroid.size() - 1; j >= 0; j--) {
                    if (positiveAsteroid.get(j) < Math.abs(asteroid)) {
                        asteroidStatus[positiveAsteroidIndex.get(j)] = true;
                        count++;
                    } else if (positiveAsteroid.get(j) == Math.abs(asteroid)) {
                        positiveAsteroid.remove(j);
                        asteroidStatus[positiveAsteroidIndex.get(j)] = true;
                        positiveAsteroidIndex.remove(j);
                        asteroidStatus[i] = true;
                        break;
                    } else if (positiveAsteroid.get(j) > Math.abs(asteroid)) {
                        asteroidStatus[i] = true;
                        break;
                    } else {
                        asteroidStatus[i] = true;
                    }

                }

                for (int j = 0; j < count; j++) {
                    positiveAsteroid.removeLast();
                    positiveAsteroidIndex.removeLast();
                }
            }

        }


        for (int i = 0; i < asteroids.length; i++) {
            if (!asteroidStatus[i]) {
                result.add(asteroids[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
