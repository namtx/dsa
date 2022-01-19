package dev.namtx.leetcode;

import java.util.*;

public class CourseScheduleIV {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = new int[][]{{1, 0}, {1, 2}};

        System.out.println(
                new CourseScheduleIV()
                        .checkIfPrerequisite(
                                numCourses,
                                prerequisites,
                                queries
                        )
        );
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] inDegrees = new int[numCourses];
        List<Set<Integer>> adjacent = new ArrayList<>();
        List<Set<Integer>> prerequisitesMap = new ArrayList<>();
        List<Boolean> answers = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacent.add(new HashSet<>());
            prerequisitesMap.add(new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacent.get(prerequisite[0]).add(prerequisite[1]);
            inDegrees[prerequisite[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            Set<Integer> s = adjacent.get(course);

            for (int i : s) {
                prerequisitesMap.get(i).add(course);
                prerequisitesMap.get(i).addAll(prerequisitesMap.get(course));

                inDegrees[i]--;
                if (inDegrees[i] == 0) q.offer(i);
            }
        }

        for (int[] query : queries) {
            if (prerequisitesMap.get(query[1]).contains(query[0])) {
                answers.add(true);
            } else {
                answers.add(false);
            }
        }

        return answers;
    }
}
