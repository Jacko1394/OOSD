package game.board.product;

public class Powershell extends MicrosoftProducts {

    public static int[] dice = {1,1,2,2,3,3};
    
    public Powershell(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logosml/powershell.png";
        productID = "Powershell";
//        productTeam = "Microsoft";
    }

}