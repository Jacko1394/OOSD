package game.board.product.dice;

public abstract class DiceDecorator {

    int[] config;

    public DiceDecorator(int[]  config)
    {
        this.config = config;
    }

    public int[] decorate()
    {
        return config;
    }

}










