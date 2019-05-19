package game.board.product.dice;

public class StandardDice extends DiceDecorator {

    public StandardDice(int[] config)
    {
        super(config);
    }

    /*
    public int roll() {
        int super_out = super.roll();
        return (int)((float) super_out * this.power);
    }*/

    @Override
    public int[] decorate()
    {
        return config;
    }
}