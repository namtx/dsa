package dev.namtx.adventofcode2022.day15;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day15/input.txt";

    private static List<Point[]> parseInput() throws IOException {
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        List<Point[]>[] ans = new List[]{new ArrayList<Point[]>()};
        fileReader.forEach(s -> {
            Pattern pattern = Pattern.compile("^.+x=(.+),\\sy=(.+):.+x=(.+),\\sy=(.+)$");
            Matcher matcher = pattern.matcher(s);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    list.add(matcher.group(i));
                }
            }
            Point sensor = new Point(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
            Point beacon = new Point(Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
            ans[0].add(new Point[]{sensor, beacon});
        });

        return ans[0];
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Sensor {
        Point point;
        int distance;

        Sensor(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        boolean reach(int x, int y) {
            return Math.abs(point.x - x) + Math.abs(point.y - y) <= distance;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            int inspectingLine = 2000000;
            boolean[] impossiblePoints = new boolean[20_000_000];
            List<Point[]> points = parseInput();
            for (Point[] pair : points) {
                Point sensor = pair[0];
                Point beacon = pair[1];
                int distance = Math.abs(sensor.x - beacon.x) + Math.abs(sensor.y - beacon.y);
                int yDistance = Math.abs(sensor.y - inspectingLine);
                if (yDistance <= distance) {
                    for (int i = sensor.x - (distance - yDistance); i <= sensor.x + (distance - yDistance); i++) {
                        impossiblePoints[i + 10_000_000] = true;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < 20_000_000; i++) {
                if (impossiblePoints[i]) ans++;
            }

            Set<Integer> visitedPointX = new HashSet<>();
            for (Point[] pair : points) {
                if (pair[1].y == inspectingLine) {
                    if (!visitedPointX.contains(pair[1].x)) {
                        visitedPointX.add(pair[1].x);
                        ans--;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            int range = 4_000_000;
            List<Sensor> sensors = new ArrayList<>();

            List<Point[]> points = parseInput();
            for (Point[] pair : points) {
                Point sensor = pair[0];
                Point beacon = pair[1];
                int distance = Math.abs(sensor.x - beacon.x) + Math.abs(sensor.y - beacon.y);

                sensors.add(new Sensor(sensor, distance));
            }

            for (Sensor sensor : sensors) {
                for (int i = 0; i < sensor.distance; i++) {
                    int j = sensor.distance - i + 1;
                    int[][] dirs = {{i, j}, {-i, j}, {-i, -j}, {i, -j}};
                    for (int[] dir : dirs) {
                        int dx = sensor.point.x + dir[0];
                        int dy = sensor.point.y + dir[1];
                        if (dx > 0 && dx < range && dy > 0 && dy < range) {
                            final int fDx = dx;
                            final int fDy = dy;
                            if (sensors.stream().noneMatch(s -> s.reach(fDx, fDy))) {
                                System.out.println(((long) fDx * 4_000_000) + fDy);
                            }
                        }
                    }
                }
            }
        }
    }
}
