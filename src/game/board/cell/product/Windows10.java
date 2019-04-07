package game.board.cell.product;

public class Windows10 extends Product {

    public Windows10() {
        super();
    }

    @Override
    public int[] getDice(){
        return new int[] {0,1,2,3,4,5,6};
    }

}