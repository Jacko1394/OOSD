package game.board.product.dice;

public class DiceDecoratorFactory {

    static public Rollable build(String type,Rollable dice){
        switch (type){
            case "OSX":
            case "Terminal":
                return new FiftyFifty(dice);
            case "Powershell":
                return new BigTen(dice);
            case "Mac":
            case "SurfacePro":
                return new HalfDice(dice);
            case "Windows10":
                return new DoubleDice(dice);
            default:
                return dice;

        }
    }
}
