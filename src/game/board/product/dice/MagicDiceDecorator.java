package game.board.product.dice;

public class MagicDiceDecorator extends DiceDecorator {

    public MagicDiceDecorator(Dice decoratedDice){
        super(decoratedDice);

    }

    @Override
    public int roll() {
        return 10;
    }
}