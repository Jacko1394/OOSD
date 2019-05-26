package game.board.product.dice;

public class BigTen extends DiceDecorator implements Rollable {

    public BigTen(Rollable dice){
        super(dice);
    }

    @Override
    public int roll(){
        return 10;
    }
}