package game.board.product.dice;

import java.util.Arrays;
import java.util.Random;

public class Dice {

    protected int[] config;
    private DiceDecorator dd;

    public Dice(int[] config, DiceDecorator dd) {
        this.config = config;
        this.dd = dd;
    }

    public int roll() {
        Random rand = new Random();
        int[] currentTurnConfig = dd.decorate();
        int rolled = currentTurnConfig[rand.nextInt(currentTurnConfig.length)];
        return rolled;
    }

    public int[] getConf() {
        return config;
    }

    public DiceDecorator powerUpDecorator(Powerup powerUp)
    {

    }
}
