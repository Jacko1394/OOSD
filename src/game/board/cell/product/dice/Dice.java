package game.board.cell.product.dice;

import java.util.Random;
import game.board.cell.product.dice.Rollable;

public class Dice implements Rollable{

    private int[] config;

    public Dice(int[] config) {
       this.config = config;
    }

    public int roll() {
        Random rand = new Random();
        int rolled = this.config[rand.nextInt(this.config.length - 1)];
        return rolled;
    }
}
