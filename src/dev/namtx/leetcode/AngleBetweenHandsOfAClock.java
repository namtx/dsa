package dev.namtx.leetcode;

class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12 + minutes / 60.0) * 30;
        double minuteAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minuteAngle);
        return angle > 180 ? 360 - angle : angle;
    }

    public static void main(String[] args) {
        AngleBetweenHandsOfAClock solution = new AngleBetweenHandsOfAClock();
        System.out.println(solution.angleClock(12, 30));
    }
}
