package game.board.cell;

import game.board.cell.product.Product;

public class Cell {

    private Product product = null;
    private char[] directions = null;
    private boolean isSet = false;


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
        // indicates cell exists
        this.isSet = true;
        String[] direction = directions.split(",");
        for (int i = 0; i < direction.length; i++)
        {
            this.directions[i] = direction[i].charAt(0);
        }
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }


}