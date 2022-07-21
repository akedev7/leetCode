package com.company;


import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        //1 path
        //0 wall
        //2 destination
        int[][] maze = {
                {2, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        Position startingPosition = new Position(0, 3);

        Stack<Position> paths = new Stack<>();
        paths.push(startingPosition);
        while (true) {
            Position peekPosition = paths.peek();
            maze[peekPosition.x][peekPosition.y] = 0;

            //Check bottom
            int bottomDirection = maze[peekPosition.x + 1][peekPosition.y];
            if (bottomDirection == 2) {
                System.out.println("Go down, and you won");
                break;
            } else if (bottomDirection == 1) {
                System.out.println("Go down");
                paths.push(new Position(peekPosition.x + 1, peekPosition.y));
                continue;
            }

            //Check Top
            int upDirection = maze[peekPosition.x - 1][peekPosition.y];
            if (upDirection == 2) {
                System.out.println("Go top, and you won");
                break;
            } else if (upDirection == 1) {
                System.out.println("Go top");
                paths.push(new Position(peekPosition.x - 1, peekPosition.y));
                continue;
            }

            //Check Left
            int leftDirection = maze[peekPosition.x][peekPosition.y - 1];
            if (leftDirection == 2) {
                System.out.println("Go left, and you won");
                break;
            } else if (leftDirection == 1) {
                System.out.println("Go left");
                paths.push(new Position(peekPosition.x, peekPosition.y - 1));
                continue;
            }

            //Check right
            int rightDirection = maze[peekPosition.x][peekPosition.y + 1];
            if (rightDirection == 2) {
                System.out.println("Go right, and you won");
                break;
            } else if (rightDirection == 1) {
                System.out.println("Go right");
                paths.push(new Position(peekPosition.x, peekPosition.y + 1));
                continue;
            }
        }
    }

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}




