package game.board.product.dice;

public class BigTen extends DiceDecorator {

    public BigTen(Dice decoratedDice) {
        super(decoratedDice);
    }

    /*@Override
    public int roll() {
        return 10;
    }*/

    @Override
    public int[] decorate()
    {
        for(int i = 0; i < config.length; i++)
        {
            config[i] = 10;
        }
        return config;
    }
}