package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/contest/weekly-contest-307/problems/minimum-hours-of-training-to-win-a-competition/
 * <br>
 * <b>Input</b>: initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
 * <br>
 * <b>Output</b>: 8
 */
public class MinimumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hourToTrainExp = 0;
        int hourToTrainEnergy = 0;
        int currentExp = initialExperience;
        int currentEnergy = initialEnergy;

        for (int i = 0; i < experience.length; i++) {
            if (currentExp <= experience[i]) {
                hourToTrainExp += experience[i] - currentExp + 1;
                currentExp += experience[i] - currentExp + 1;
            }
            currentExp += experience[i];
        }

        for (int i = 0; i < energy.length; i++) {
            if (currentEnergy <= energy[i]) {
                hourToTrainEnergy += energy[i] - currentEnergy + 1;
                currentEnergy += energy[i] - currentEnergy + 1;
            }
            currentEnergy -= energy[i];
        }

        return hourToTrainEnergy + hourToTrainExp;
    }

    public static void main(String[] args) {
//        System.out.println(new MinimumHoursOfTrainingToWinACompetition().minNumberOfHours(5,3,new int[]{1,4,3,2}, new int[]{2,6,3,1}));
//        System.out.println(new MinimumHoursOfTrainingToWinACompetition().minNumberOfHours(2,4,new int[]{1}, new int[]{3}));
        System.out.println(new MinimumHoursOfTrainingToWinACompetition().minNumberOfHours(1,1,new int[]{1,1,1,1}, new int[]{1,1,1,50}));
    }
}
