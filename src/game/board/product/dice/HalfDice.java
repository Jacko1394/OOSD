package game.board.product.dice;

public class HalfDice extends DiceDecorator implements Rollable {
    public HalfDice(Rollable dice) {
        super(dice);
    }

    @Override
    public int roll(){
        return this.dice.roll() / 2 ;
    }
}

