package game.board.cell;

import game.board.cell.product.Product;

public class Cell {

    private Product[] product = new Product[6];
    private char[] directions = new char[4];

    private boolean isSet = false;
    public boolean getIsSet() {return isSet;}

    public void emptyCell()
    {

    }

    public void addPiece()
    {

    }

    public void removeProduct(Cell cell)
    {

    }

    public void setDirections(String directions)
    {
        this.directions = directions.toCharArray();
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public Product[] getProduct() {
        return this.product;
    }


}