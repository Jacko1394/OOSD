package game.board.product.dice;

public class BigTen extends DiceDecorator {

    @Override
    public int[] decorate(int[] config)
    {
        for(int i = 0; i < config.length; i++)
        {
            config[i] = 10;
        }
        return config;
    }
}