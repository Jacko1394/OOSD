package game.board.product.dice;

public class StandardDice extends DiceDecorator {

    @Override
    public int[] decorate()
    {
        return config;
    }
}