package game.board.product.dice;

public class FiftyFifty extends DiceDecorator implements Rollable {
    public FiftyFifty(Rollable dice) {
        super(dice);
    }

    @Override
    public int roll(){
        int rolled = this.dice.roll();
        if (rolled >= 5 ){
            return Math.max(rolled,10);
        }else {
            return 0;
        }
    }
}