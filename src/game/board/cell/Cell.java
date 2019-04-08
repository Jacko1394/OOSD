package game.board.cell;

import game.board.cell.product.Product;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Cell {

    private char[] directions = new char[4];

    private boolean isSet = false;
    public boolean getIsSet() {return isSet;}

    //Assumes a max number of 6 products on the board
    private Product[] products = new Product[6];

    public Product[] getProducts()
    {
        return this.products;
    }


    public void addProduct(Product product)
    {
        int index = Arrays.asList(this.products).indexOf(null);
        this.products[index] = product;
    }

    public void removeProduct(Product product)
    {
        int index = Arrays.asList(this.products).indexOf(product);
        if( index > -1 ){
            this.products[index] = null;
        } else {
            System.out.println("That product is not in this cell");
    }

    }

    public void setDirections(String directions)
    {
        
        this.directions = directions.toCharArray();
        if(this.directions[0] != '_') {
            this.isSet = true;
        }
    }


}