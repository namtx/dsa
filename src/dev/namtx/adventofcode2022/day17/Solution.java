package dev.namtx.adventofcode2022.day17;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.Arrays;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day17/xxxx.txt";
    static final int HORIZONTAL_BAR = 0;
    static final int PLUS = 1;
    static final int ROTATED_L = 2;
    static final int VERTICAL_BAR = 3;
    static final int SQUARED = 4;

    static final int GAME_WIDTH = 7;

    static class Game {
        char[][] screen;
        int highestRow;

        Game() {
            this.screen = new char[2024 * 4][7];
            for (char[] r : screen) {
                Arrays.fill(r, '.');
            }
            this.screen[0] = "#######".toCharArray();
            this.highestRow = 0; // floor

        }

        int addRockToBegin(int rockType) {
            switch (rockType) {
                case HORIZONTAL_BAR:
                    this.screen[this.highestRow + 4] = "..@@@@.".toCharArray();
                    break;
                case PLUS:
                    this.screen[this.highestRow + 6] = "...@...".toCharArray();
                    this.screen[this.highestRow + 5] = "..@@@..".toCharArray();
                    this.screen[this.highestRow + 4] = "...@...".toCharArray();
                    break;
                case ROTATED_L:
                    this.screen[this.highestRow + 6] = "....@..".toCharArray();
                    this.screen[this.highestRow + 5] = "....@..".toCharArray();
                    this.screen[this.highestRow + 4] = "..@@@..".toCharArray();
                    break;
                case VERTICAL_BAR:
                    this.screen[this.highestRow + 7] = "..@....".toCharArray();
                    this.screen[this.highestRow + 6] = "..@....".toCharArray();
                    this.screen[this.highestRow + 5] = "..@....".toCharArray();
                    this.screen[this.highestRow + 4] = "..@....".toCharArray();
                    break;
                case SQUARED:
                    this.screen[this.highestRow + 5] = "..@@...".toCharArray();
                    this.screen[this.highestRow + 4] = "..@@...".toCharArray();
                    break;
            }

            return this.highestRow + 4;
        }

        boolean moveDown(int rockType, int lineIndex) {
            int firstPoint = findTheMostBottomLeftPoint(lineIndex);
            boolean stopped = false;
            switch (rockType) {
                case HORIZONTAL_BAR:
                    for (int i = 0; i < GAME_WIDTH; i++) {
                        if (this.screen[lineIndex][i] == '@' && this.screen[lineIndex - 1][i] == '#') {
                            // stop
                            for (int j = 0; j < GAME_WIDTH; j++) {
                                if (this.screen[lineIndex][j] == '@') {
                                    this.screen[lineIndex][j] = '#';
                                }
                            }
                            if (lineIndex > this.highestRow) {
                                highestRow = lineIndex;
                            }
                            return true;
                        }
                    }
                    // won't stop
                    for (int i = 0; i < GAME_WIDTH; i++) {
                        if (this.screen[lineIndex][i] == '@') {
                            this.screen[lineIndex][i] = '.';
                            this.screen[lineIndex - 1][i] = '@';
                        }
                    }
                    return false;
                case PLUS:
                    if (this.screen[lineIndex - 1][firstPoint] == '#' || this.screen[lineIndex][firstPoint - 1] == '#' || this.screen[lineIndex][firstPoint + 1] == '#') {
                        // stop
                        this.screen[lineIndex][firstPoint] = '#';
                        this.screen[lineIndex + 1][firstPoint - 1] = '#';
                        this.screen[lineIndex + 1][firstPoint] = '#';
                        this.screen[lineIndex + 1][firstPoint + 1] = '#';
                        this.screen[lineIndex + 2][firstPoint] = '#';
                        if (this.highestRow < lineIndex + 2) {
                            this.highestRow = lineIndex + 2;
                        }
                        return true;
                    } else {
                        this.screen[lineIndex + 1][firstPoint] = '@';
                        this.screen[lineIndex][firstPoint - 1] = '@';
                        this.screen[lineIndex][firstPoint + 1] = '@';
                        this.screen[lineIndex - 1][firstPoint] = '@';
                        this.screen[lineIndex + 2][firstPoint] = '.';
                        this.screen[lineIndex + 1][firstPoint - 1] = '.';
                        this.screen[lineIndex + 1][firstPoint + 1] = '.';
                        return false;
                    }
                case ROTATED_L:
                    for (int i = 0; i < 3; i++) {
                        if (this.screen[lineIndex - 1][firstPoint + i] == '#') {
                            stopped = true;
                            break;
                        }
                    }
                    if (stopped) {
                        for (int i = 0; i < 3; i++) {
                            this.screen[lineIndex][firstPoint + i] = '#';
                        }
                        this.screen[lineIndex + 1][firstPoint + 2] = '#';
                        this.screen[lineIndex + 2][firstPoint + 2] = '#';

                        if (this.highestRow < lineIndex + 2) {
                            this.highestRow = lineIndex + 2;
                        }
                        return true;
                    } else {
                        for (int i = 0; i < 3; i++) {
                            this.screen[lineIndex - 1][firstPoint + i] = '@';
                        }
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex][firstPoint + 1] = '.';
                        this.screen[lineIndex + 2][firstPoint + 2] = '.';
                        return false;
                    }
                case VERTICAL_BAR:
                    stopped = this.screen[lineIndex-1][firstPoint] == '#';
                    if (stopped) {
                        for (int i = 0; i < 4; i++) {
                            this.screen[lineIndex+i][firstPoint] = '#';
                        }
                        if (this.highestRow < lineIndex + 3) {
                            this.highestRow = lineIndex + 3;
                        }
                        return true;
                    } else {
                        this.screen[lineIndex+3][firstPoint] = '.';
                        this.screen[lineIndex-1][firstPoint] = '@';
                        return false;
                    }
                case SQUARED:
                    stopped = this.screen[lineIndex-1][firstPoint] == '#' || this.screen[lineIndex-1][firstPoint+1] == '#';
                    if (stopped) {
                        this.screen[lineIndex][firstPoint] = '#';
                        this.screen[lineIndex][firstPoint+1] = '#';
                        this.screen[lineIndex+1][firstPoint] = '#';
                        this.screen[lineIndex+1][firstPoint+1] = '#';
                        if (this.highestRow < lineIndex+1) {
                            this.highestRow = lineIndex+1;
                        }
                        return true;
                    } else {
                        this.screen[lineIndex-1][firstPoint] = '@';
                        this.screen[lineIndex-1][firstPoint+1] = '@';
                        this.screen[lineIndex+1][firstPoint] = '.';
                        this.screen[lineIndex+1][firstPoint+1] = '.';
                        return false;
                    }
            }
            return false;
        }

        void moveRight(int rockType, int lineIndex) {
            int firstPoint = findTheMostBottomLeftPoint(lineIndex);
            switch (rockType) {
                case HORIZONTAL_BAR:
                    if (firstPoint + 4 < GAME_WIDTH && this.screen[lineIndex][firstPoint+4] != '#') {
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex][firstPoint+4] = '@';
                    }
                    break;
                case PLUS:
                    if (firstPoint + 2 < GAME_WIDTH && this.screen[lineIndex][firstPoint + 1] != '#' && this.screen[lineIndex + 1][firstPoint + 2] != '#' && this.screen[lineIndex + 2][firstPoint + 1] != '#') {
                        this.screen[lineIndex][firstPoint + 1] = '@';
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex + 1][firstPoint - 1] = '.';
                        this.screen[lineIndex + 1][firstPoint + 2] = '@';
                        this.screen[lineIndex + 2][firstPoint] = '.';
                        this.screen[lineIndex + 2][firstPoint + 1] = '@';
                    }
                    break;
                case ROTATED_L:
                    if (firstPoint + 3 < GAME_WIDTH && this.screen[lineIndex][firstPoint + 3] != '#' && this.screen[lineIndex + 1][firstPoint + 3] != '#' && this.screen[lineIndex + 2][firstPoint + 3] != '#') {
                        this.screen[lineIndex][firstPoint + 3] = '@';
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex + 1][firstPoint + 3] = '@';
                        this.screen[lineIndex + 1][firstPoint + 2] = '.';
                        this.screen[lineIndex + 2][firstPoint + 3] = '@';
                        this.screen[lineIndex + 2][firstPoint + 2] = '.';
                    }
                    break;
                case VERTICAL_BAR:
                    if (firstPoint+1 < GAME_WIDTH && this.screen[lineIndex][firstPoint+1] != '#' && this.screen[lineIndex+1][firstPoint+1] != '#' && this.screen[lineIndex+2][firstPoint+1] != '#' && this.screen[lineIndex+3][firstPoint+1] != '#') {
                        for (int i = 0; i < 4; i++) {
                            this.screen[lineIndex+i][firstPoint] = '.';
                            this.screen[lineIndex+i][firstPoint+1] = '@';
                        }
                    }
                    break;
                case SQUARED:
                    if (firstPoint + 2 < GAME_WIDTH && this.screen[lineIndex][firstPoint+2] != '#' && this.screen[lineIndex+1][firstPoint+2] != '#') {
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex][firstPoint+2] = '@';
                        this.screen[lineIndex+1][firstPoint] = '.';
                        this.screen[lineIndex+1][firstPoint+2] = '@';
                    }
                    break;

            }
        }

        int findTheMostBottomLeftPoint(int lineIndex) {
            for (int i = 0; i < GAME_WIDTH; i++) {
                if (this.screen[lineIndex][i] == '@') {
                    return i;
                }
            }
            return -1;
        }

        void moveLeft(int rockType, int lineIndex) {
            int firstPoint = findTheMostBottomLeftPoint(lineIndex);
            switch (rockType) {
                case HORIZONTAL_BAR:
                    int j = 0;
                    while (this.screen[lineIndex][j] != '@') j++;
                    if (j == 0) { // wall
                        // do nothing
                    } else if (this.screen[lineIndex][j - 1] == '#') { // stopped rock
                        // do nothing
                    } else {
                        char[] newLine = new char[GAME_WIDTH];
                        Arrays.fill(newLine, '.');
                        for (int i = 0; i < GAME_WIDTH - 1; i++) {
                            if (this.screen[lineIndex][i + 1] == '@') {
                                newLine[i] = '@';
                            }
                        }
                        this.screen[lineIndex] = newLine;
                    }
                    break;
                case PLUS:
                    if (firstPoint >= 2 && this.screen[lineIndex][firstPoint-1] != '#' && this.screen[lineIndex+1][firstPoint-2] != '#' && this.screen[lineIndex+2][firstPoint-1] != '#') {
                        this.screen[lineIndex][firstPoint] = '.';
                        this.screen[lineIndex][firstPoint-1] = '@';
                        this.screen[lineIndex+1][firstPoint-2] = '@';
                        this.screen[lineIndex+1][firstPoint+1] = '.';
                        this.screen[lineIndex+2][firstPoint-1] = '@';
                        this.screen[lineIndex+2][firstPoint] = '.';
                    }
                    break;
                case ROTATED_L:
                    if (firstPoint >= 1 && this.screen[lineIndex][firstPoint-1] != '#' && this.screen[lineIndex+1][firstPoint-1] != '#' && this.screen[lineIndex+2][firstPoint-1] != '#') {
                        this.screen[lineIndex][firstPoint-1] = '@';
                        this.screen[lineIndex][firstPoint+2] = '.';
                        this.screen[lineIndex+1][firstPoint+2] = '.';
                        this.screen[lineIndex+2][firstPoint+2] = '.';
                        this.screen[lineIndex+1][firstPoint+1] = '@';
                        this.screen[lineIndex+2][firstPoint+1] = '@';
                    }
                    break;
                case VERTICAL_BAR:
                    if (firstPoint >= 1 && this.screen[lineIndex][firstPoint-1] != '#' && this.screen[lineIndex+1][firstPoint-1] != '#' && this.screen[lineIndex+2][firstPoint-1] != '#' && this.screen[lineIndex+3][firstPoint-1] != '#') {
                        for (int i = 0; i < 4; i++) {
                            this.screen[lineIndex+i][firstPoint] = '.';
                            this.screen[lineIndex+i][firstPoint-1] = '@';
                        }
                    }
                    break;
                case SQUARED:
                    if (firstPoint >= 1 && this.screen[lineIndex][firstPoint-1] != '#' && this.screen[lineIndex+1][firstPoint-1] != '#') {
                        this.screen[lineIndex][firstPoint+1] = '.';
                        this.screen[lineIndex][firstPoint-1] = '@';
                        this.screen[lineIndex+1][firstPoint+1] = '.';
                        this.screen[lineIndex+1][firstPoint-1] = '@';
                    }
                    break;
            }
        }

        void debug(int rockCount) throws InterruptedException {
            System.out.println("rocks: " + (rockCount+1));
            System.out.println("height: " + this.highestRow);
            for (int i = this.highestRow +5; i >= this.highestRow -15; i--) {
                if (i >= 0) {
                    System.out.println(this.screen[i]);
                }
            }
            System.out.println();
            System.out.println();
//            Thread.sleep(400);
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException, InterruptedException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            String[] lines = new String[1];
            fileReader.forEach(s -> lines[0] = s);
            String wind  = lines[0];
            System.out.println(wind);
            int frame = 0;
            int rockCount = 0;
            Game game = new Game();
            while (rockCount <= 2021) {
                int rockType = rockCount % 5;
                int lineIndex = game.addRockToBegin(rockType);
//                game.debug();
                boolean stopped;
                do {
                    if (wind.charAt(frame % wind.length()) == '>') {
//                        System.out.println("RIGHT");
                        game.moveRight(rockType, lineIndex);
                    } else {
//                        System.out.println("LEFT");
                        game.moveLeft(rockType, lineIndex);
                    }
//                    game.debug();
                    frame++;
//                    System.out.println("DOWN");
                    stopped = game.moveDown(rockType, lineIndex);
                    lineIndex--;
//                    game.debug(rockCount);
                } while (!stopped);
                rockCount++;
            }
            System.out.println(game.highestRow);
        }
    }
}
