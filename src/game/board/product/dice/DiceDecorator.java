package game.board.product.dice;

public class DiceDecorator  extends Dice {
    protected Dice decoratedDice;
    public DiceDecorator(Dice decoratedDice){
        super();
        this.decoratedDice = decoratedDice;
    }

}










