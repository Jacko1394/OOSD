package game.board.product.dice;

public class DoubleDice extends DiceDecorator {

    public DoubleDice(int[] config)
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
        for(int i = 0; i < config.length; i++)
        {
            config[i] *= 2;
        }
        return config;
    }
}