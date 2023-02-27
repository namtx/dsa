package dev.namtx.leetcode.editor.en;

public class DesignParkingSystem {
    //leetcode submit region begin(Prohibit modification and deletion)
    class ParkingSystem {
        int[] quantity;
        int[] numberOfCars = new int[]{0, 0, 0};

        public ParkingSystem(int big, int medium, int small) {
            quantity = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (numberOfCars[carType - 1] == quantity[carType - 1]) return false;
            numberOfCars[carType - 1]++;
            return true;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
    //leetcode submit region end(Prohibit modification and deletion)

}
