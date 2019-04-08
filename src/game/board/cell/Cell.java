package game.board.cell;

import game.board.product.Product;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Cell {

    private char[] directions = new char[4];

    private boolean isSet = false;
    

    //Assumes a max number of 6 products on the board
    private Product[] products = new Product[6];
    private String cellType;

    public Product[] getProducts()
    {
        // returns an array of products with out the nulls
        return Arrays.stream(this.products).filter(x -> x != null).toArray(Product[] :: new);
    }


    public void addProduct(Product product)
    {
        int index = Arrays.asList(this.products).indexOf(null);
        this.products[index] = product;
    }

    public boolean isEmpty() {
        for(Product prod : this.products ){
            if ( prod != null ){
                return false;
            }
        }
        return true;
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

    public boolean getIsSet() 
    {
        return isSet;
    }

    public char[] getDirections()
    {
        return this.directions;
    }

    public String getCellType()
    {
        return this.cellType;
    }

}