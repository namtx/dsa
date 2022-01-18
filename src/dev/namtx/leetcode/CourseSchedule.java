package dev.namtx.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * tags: Topological Sort
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegrees = new int[numCourses];
        int courseCount = 0;

        // prerequisites[i] = [ai, bi] indicates that you must take course bi first if
        // you want to take course ai. bi -> ai
        for (int[] pre : prerequisites) {
            inDegrees[pre[1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int p = q.poll();
            courseCount++;

            for (int[] pre : prerequisites) {
                if (pre[0] == p) {
                    inDegrees[pre[1]]--;

                    if (inDegrees[pre[1]] == 0) {
                        q.add(pre[1]);
                    }
                }
            }
        }

        return courseCount == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
        int numCourses = 2;

        System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
    }
}
