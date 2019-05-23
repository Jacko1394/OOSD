package game.board.product.dice;

public class DoubleDice extends DiceDecorator implements Rollable {

    public DoubleDice(Dice dice) {
        super(dice);
    }

    public int roll(){
        return this.dice.roll() * 2 ;
    }

}