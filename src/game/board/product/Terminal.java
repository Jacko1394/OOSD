package game.board.product;

public class Terminal extends AppleProducts {

    public static int[] dice = {1,1,1,3,3,3};

    public Terminal(int positionX, int positionY) {
        super(dice,positionX, positionY);
        imgPath = "src/logosml/terminal.png";
        productID = "Terminal";
//        productTeam = "apple";
    }

}