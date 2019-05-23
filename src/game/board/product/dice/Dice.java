package game.board.product.dice;

import java.util.Random;

public class Dice implements Rollable {

    private int[] config;


    public Dice(int[] config) {
        this.config = config;
    }

    public int roll() {
        Random rand = new Random();
        int rolled = config[rand.nextInt(config.length)];
        return rolled;
    }
}
