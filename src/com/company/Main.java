package com.company;


import javax.imageio.ImageReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        //1 path
        //0 wall
        //2 destination
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 2}
        };

        Position startingPosition = new Position(0, 0);

        Stack<Position> paths = new Stack<>();
        paths.push(startingPosition);
        while (true) {
            Position peekPosition = paths.peek();
            maze[peekPosition.x][peekPosition.y] = 0;

            //Check bottom
            int xBottom = peekPosition.x + 1;
            if (xBottom < maze.length) {
                int bottomDirection = maze[xBottom][peekPosition.y];
                if (bottomDirection == 2) {
                    System.out.println("Go down, and you won");
                    break;
                } else if (bottomDirection == 1) {
                    System.out.println("Go down");
                    paths.push(new Position(xBottom, peekPosition.y));
                    continue;
                }
            }

            //Check Top
            int xTop = peekPosition.x - 1;
            if (xTop >= 0) {
                int upDirection = maze[xTop][peekPosition.y];
                if (upDirection == 2) {
                    System.out.println("Go top, and you won");
                    break;
                } else if (upDirection == 1) {
                    System.out.println("Go top");
                    paths.push(new Position(xTop, peekPosition.y));
                    continue;
                }
            }

            //Check Left
            int yLeft = peekPosition.y - 1;
            if (yLeft >= 0) {
                int leftDirection = maze[peekPosition.x][yLeft];
                if (leftDirection == 2) {
                    System.out.println("Go left, and you won");
                    break;
                } else if (leftDirection == 1) {
                    System.out.println("Go left");
                    paths.push(new Position(peekPosition.x, yLeft));
                    continue;
                }
            }

            //Check right
            int yRight = peekPosition.y + 1;
            if (yRight < maze[peekPosition.x].length) {
                int rightDirection = maze[peekPosition.x][yRight];
                if (rightDirection == 2) {
                    System.out.println("Go right, and you won");
                    break;
                } else if (rightDirection == 1) {
                    System.out.println("Go right");
                    paths.push(new Position(peekPosition.x, yRight));
                    continue;
                }
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




