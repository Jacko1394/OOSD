package game.board.product.dice;

public class PowerDiceDecorator  extends DiceDecorator {
    private float power;

    public PowerDiceDecorator(Dice decoratedDice, float power){
        super(decoratedDice);
        this.power = power;
    }

    @Override
    public int roll() {
        int super_out = super.roll();
        return (int)((float) super_out * this.power);
    }
}
