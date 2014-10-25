package com.druidkuma.codingame.onboarding;

import java.util.*;

/**
 * The code below will read all the game information for you.
 * On each game turn, information will be available on the standard input, you will be sent:
 * -> the total number of visible enemies
 * -> for each enemy, its name and distance from you
 * The system will wait for you to write an enemy name on the standard output.
 * Once you have designated a target:
 * -> the cannon will shoot
 * -> the enemies will move
 * -> new info will be available for you to read on the standard input.
 **/
class Player {

    private static class Enemy {
        public String name;
        public Integer distance;

        public Enemy(String name, Integer distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            List<Enemy> enemies = new ArrayList<Enemy>();

            int count = in.nextInt(); // The number of current enemy ships within range
            in.nextLine();
            for (int i = 0; i < count; i++) {
                enemies.add(new Enemy(in.next(), in.nextInt()));
                in.nextLine();
            }

            Collections.sort(enemies, new Comparator<Enemy>() {
                @Override
                public int compare(Enemy o1, Enemy o2) {
                    return o1.distance.compareTo(o2.distance);
                }
            });

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            if(enemies.size() > 0) {
                System.out.println(enemies.get(0).name);
            }
        }
    }
}