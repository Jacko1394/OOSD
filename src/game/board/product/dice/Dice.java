package game.board.product.dice;

import java.util.Arrays;
import java.util.Random;
import game.board.product.dice.Rollable;

public class Dice implements Rollable{

    private int[] config;

    public Dice(int[] config) {
       this.config = config;
    }

    public int roll() {
        Random rand = new Random();
        int rolled = this.config[rand.nextInt(this.config.length)];
        return rolled;
    }

    public String getConf() {
        return Arrays.toString(this.config);
    }
}
