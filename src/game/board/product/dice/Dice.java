package game.board.product.dice;

import java.util.Arrays;
import java.util.Random;

public class Dice{

    private int[] config;

    public Dice(int[] config) {
       this.config = config;
    }

    public Dice(){

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
