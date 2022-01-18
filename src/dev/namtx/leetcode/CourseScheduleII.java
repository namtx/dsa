package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegrees = new int[numCourses];
        int courseCount = 0;
        int[] courseOrder = new int[numCourses];

        // You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int p = q.poll();
            courseOrder[courseCount] = p;
            courseCount++;

            for (int[] pre : prerequisites) {
                if (pre[1] == p) {
                    inDegrees[pre[0]]--;

                    if (inDegrees[pre[0]] == 0) {
                        q.add(pre[0]);
                    }
                }
            }
        }

        if (courseCount != numCourses) {
            return new int[]{};
        }    

        return courseOrder;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(numCourses, prerequisites)));
    }
}
