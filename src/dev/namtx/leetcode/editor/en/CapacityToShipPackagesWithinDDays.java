package dev.namtx.leetcode.editor.en;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        System.out.println(solution.shipWithinDays(new int[]{143, 351, 343, 327, 110, 39, 332, 143, 268, 283, 260, 380, 396, 133, 196, 166, 141, 490, 318, 209, 232, 467, 310, 155, 277, 239, 236, 77, 151, 447, 205, 6, 7, 261, 258, 3, 37, 33, 239, 130, 178, 75, 493, 32, 411, 455, 493, 18, 185, 208, 279, 192, 355, 234, 363, 225, 407, 52, 75, 344, 345, 50, 451, 270, 374, 100, 416, 141, 379, 365, 222, 383, 380, 237, 350, 101, 189, 159, 37, 484, 160, 428, 270, 124, 468, 342, 392, 124, 188, 278, 454, 423, 206, 174, 437, 182, 425, 56, 62, 356, 332, 133, 445, 229, 216, 311, 50, 199, 418, 440, 440, 444, 486, 356, 65, 41, 241, 283, 200, 457, 184, 157, 216, 104, 311, 240, 118, 96, 231, 77, 486, 300, 396, 239, 378, 76, 140, 359, 426, 430, 194, 378, 410, 280, 356, 114, 8, 476, 449, 270, 447, 195, 280, 201, 441, 38, 339, 239, 317, 316, 488, 460, 382, 453, 84, 251, 43, 320, 55, 332, 352, 287, 389, 298, 412, 426, 189, 398, 73, 112, 388, 414, 193, 438, 442, 459, 445, 389, 422, 295, 453, 412, 221, 312, 465, 412, 387, 227, 159, 386, 293, 434, 446, 313, 112, 47, 224, 453, 341, 238, 122, 341, 7, 395, 395, 446, 40, 93, 204, 390, 232, 45, 303, 34, 481, 17, 111, 288, 213, 69, 50, 485, 371, 133, 143, 492, 278, 469, 76, 241, 448, 84, 474, 391, 361, 337, 48, 264, 21, 429, 103, 455, 334, 39, 125, 389, 408, 195, 393, 57, 330, 92, 164, 261, 4, 434, 36, 376, 435, 356, 64, 355, 383, 375, 405, 131, 302, 45, 256, 78, 370, 95, 341, 382, 234, 363, 6, 213, 466, 135, 274, 243, 343, 196, 278, 303, 152, 416, 91, 178, 144, 269, 118, 142, 309, 431, 219, 448, 298, 490, 127, 27, 218, 333, 90, 355, 119, 373, 2, 54, 35, 136, 90, 275, 447, 134, 219, 174, 351, 91, 170, 373, 359, 459, 284, 54, 142, 377, 481, 322, 45, 220, 2, 296, 61, 397, 231, 376, 46, 223, 457, 257, 52, 326, 289, 39, 122, 17, 175, 78, 90, 399, 168, 365, 314, 270, 405, 423, 50, 307, 66, 186, 148, 408, 56, 351, 451, 362, 167, 419, 48, 207, 272, 273, 388, 321, 216, 289, 116, 193, 375, 491, 359, 257, 222, 194, 244, 182, 205, 18, 474, 219, 374, 130, 170, 468, 233, 222, 284, 316, 294, 303, 34, 220, 398, 462, 383, 474, 145, 233, 158, 62, 106, 113, 229, 384, 342, 173, 122, 172, 5, 25, 397, 477, 422, 184, 491, 294, 477, 175, 93, 356, 384, 420, 199, 218, 491, 96, 274, 12, 223, 313, 323, 380, 467, 141, 445, 256, 10, 357, 319, 3, 192, 43, 203, 363, 108, 48, 500, 409, 465, 322, 161, 313, 317, 323, 388, 165, 379, 476, 236, 451, 55, 423, 291, 380, 165, 482, 180, 158, 257, 314, 207, 131, 282, 89, 164, 483, 166, 148, 292, 166, 84, 465, 184, 335, 58, 147, 99, 362, 467, 325, 205, 31, 190, 146, 342, 305, 333, 160, 71, 352, 412, 140, 454, 380, 411, 236, 9, 296, 459, 426, 395, 227, 170, 382, 258, 82, 274, 120, 18, 336, 426, 131, 273, 345, 217, 51, 373, 168, 61, 468, 497, 204, 405, 100, 380, 359, 208, 209, 421, 462, 112, 229, 141, 14, 67, 352, 64, 115, 422, 194, 40, 251, 380, 475, 220, 184, 307, 120, 267, 231, 352, 368, 19, 278, 318, 469, 42, 70, 155, 155, 432, 418, 4, 225, 251, 290, 436, 52, 497, 197, 316, 409, 330, 20, 141, 343, 363, 80, 129, 227, 444, 244, 46, 138, 351, 284, 154, 359, 455, 440, 238, 494, 346, 462, 99, 186, 431, 88, 311, 316, 237, 476, 174, 30, 466, 374, 434, 321, 205, 401, 209, 235, 160, 334, 280, 482, 87, 464, 134, 450, 499, 230, 321, 403, 124, 96, 305, 369, 31, 162, 87, 58, 173, 380, 427, 344, 6, 117, 266, 432, 454, 472, 93, 220, 132, 133, 80, 486, 126, 285, 80, 227, 367, 117, 458, 345, 365, 463, 182, 173, 471, 106, 465, 293, 175, 22, 411, 439, 145, 441, 353, 269, 235, 88, 480, 375, 499, 418, 92, 364, 500, 19, 86, 145, 121, 398, 347, 232, 53, 12, 499, 402, 365, 15, 10, 458, 205, 148, 403, 368, 19, 362, 96, 326, 118, 397, 114, 207, 153, 283, 55, 315, 102, 486, 271, 396, 307, 248, 35, 260, 92, 34, 299, 345, 459, 62, 371, 407, 174, 128, 221, 486, 137, 33, 365, 233, 225, 375, 404, 120, 366, 431, 378, 275, 139, 235, 448, 424, 12, 452, 354, 238, 191, 425, 90, 488, 280, 418, 475, 306, 179, 494, 195, 433, 158, 85, 322, 461}, 400));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int maxWeight = Integer.MIN_VALUE;
            int totalWeight = 0;
            for (int w : weights) {
                maxWeight = Math.max(maxWeight, w);
                totalWeight += w;
            }

            int left = maxWeight;
            int right = totalWeight;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canLoad(weights, days, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canLoad(int[] weights, int days, int load) {
            int daysNeeded = 1;
            int currentLoad = 0;
            for (int w : weights) {
                currentLoad += w;
                if (currentLoad > load) {
                    daysNeeded++;
                    currentLoad = w;
                }
            }

            return daysNeeded <= days;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}