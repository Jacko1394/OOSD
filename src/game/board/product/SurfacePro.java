package game.board.product;

public class SurfacePro extends MicrosoftProducts {

    private static int[] dice = {3,3,5,5,5,8};

    
    public SurfacePro(int positionX, int positionY) {
        super(dice, positionX, positionY);
        imgPath = "src/logosml/surface.png";
    }

    @Override
    public String getProductID() {
        return "SurfacePro";
    }

}