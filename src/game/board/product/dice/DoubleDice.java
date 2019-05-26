package game.board.product.dice;

public class DoubleDice extends DiceDecorator implements Rollable {

    public DoubleDice(Rollable dice) {
        super(dice);
    }

    @Override
    public int roll(){
        return this.dice.roll() * 2 ;
    }

}