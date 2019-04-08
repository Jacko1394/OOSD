package game.board.cell.product;

public class OSX extends AppleProducts {

    public static  int[] dice = {1,2,3,4,5,6};

    public OSX(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logos/macOS.png";
    }
}