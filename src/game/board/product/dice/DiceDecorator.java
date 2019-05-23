package game.board.product.dice;

public abstract class DiceDecorator implements Rollable {

    protected Dice dice;

    public DiceDecorator(Dice dice )
    {
        this.dice = dice;
    }

    public int roll() {
        return this.dice.roll();
    }

    public Dice getDice() {
        return this.dice;
    }


}










