package game.board.product.dice;

public class StandardDice extends DiceDecorator {

    public StandardDice(int[] config) {
        super(config);
    }

    @Override
    public int[] decorate()
    {
        return config;
    }
}