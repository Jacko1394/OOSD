package game.board.product;

public class OSX extends AppleProducts {

    public static  int[] dice = {2,2,3,3,5,5};

    public OSX(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logosml/macOS.png";
        productID = "OSX";
        productTeam = "apple";
    }
}