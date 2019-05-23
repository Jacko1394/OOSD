package game.board.product.dice;

public class BigTen extends DiceDecorator implements Rollable {

    public BigTen(Dice dice){
        super(dice);
    }

    public int role(){
        return 10;
    }
}