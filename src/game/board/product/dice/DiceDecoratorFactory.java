package game.board.product.dice;

public class DiceDecoratorFactory {

    static public Rollable build(String type,Rollable dice){
        switch (type){
            case "OSX":
            case "Terminal":
            case "Powershell":
                return new BigTen(dice);
            case "Mac":
            case "SurfacePro":
            case "Windows10":
                return new DoubleDice(dice);
            default:
                return new BigTen(dice);

        }
    }
}
