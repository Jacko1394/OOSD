package game.board.cell;

import game.board.cell.product.Product;

public class Cell {

    private char[] directions = new char[4];

    private boolean isSet = false;
    public boolean getIsSet() {return isSet;}

    public void emptyCell()
    {

    }

    public void addPiece(Product product)
    {

    }

    public void removeProduct(Product product)
    {

    }

    public void setDirections(String directions)
    {
        
        this.directions = directions.toCharArray();
        if(this.directions[0] != '_') {
            this.isSet = true;
        }
    }


}