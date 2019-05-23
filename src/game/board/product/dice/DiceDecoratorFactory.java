package game.board.product.dice;

public class DiceDecoratorFactory {

    static public Rollable build(String type,Dice dice){
        switch (type){
            case "BigTen":
                return new BigTen(dice);
            case "Double":
                return new DoubleDice(dice);
            default:
                return dice;

        }
    }
}
