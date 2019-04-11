package game.board.cell;

import game.board.product.Product;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;

public class Cell {

    private char[] directions = new char[4];

    private boolean isSet = false;
    
    private ArrayList<Product> products = new ArrayList<>();
    private String cellType;

    public ArrayList<Product> getProducts()
    {
        // returns an arraylist of products
        return products;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public boolean isEmpty()
    {
        for(Product prod : this.products )
        {
            if ( prod != null )
            {
                return false;
            }
        }
        return true;
    }

    public void removeProduct(Product product)
    {
        products.remove(products.indexOf(product));
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

    public void setCellType(String cellType)
    {
        this.cellType = cellType;
    }

}