package game.board.product;

public class Windows10 extends MicrosoftProducts {

    public static int[] dice = {1,2,3,4,5,6};
    
    public Windows10(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logosml/win10.png";
        productID = "Windows10";
//        productTeam = "windows";
    }
    
}