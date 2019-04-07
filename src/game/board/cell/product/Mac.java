package game.board.cell.product;

public class Mac extends Product {

    public Mac() {

    }

    @Override
    public int[] getDice(){
        return new int[] {0,1,2,3,4,5,6};
    }

}