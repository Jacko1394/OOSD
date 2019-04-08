package game.board.cell;

import game.board.cell.product.Product;

public class Cell {

    private char[] directions = new char[4];

    private boolean isSet = false;
    public boolean getIsSet() {return isSet;}

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void emptyCell()
    {

    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public void removeProduct()
    {
        this.product = null;
    }

    public void setDirections(String directions)
    {
        
        this.directions = directions.toCharArray();
        if(this.directions[0] != '_') {
            this.isSet = true;
        }
    }


}