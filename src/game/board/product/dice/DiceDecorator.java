package game.board.product.dice;

public abstract class DiceDecorator implements Rollable {

    protected Rollable dice;

    public DiceDecorator(Rollable dice )
    {
        this.dice = dice;
    }

    public int roll() {
        return this.dice.roll();
    }

    public Rollable getDice() {
        return this.dice;
    }


}










