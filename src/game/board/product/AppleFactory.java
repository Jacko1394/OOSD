package game.board.product;


public class AppleFactory extends ProductFactory
{

    public Product generateProduct(String productType, int x, int y)
    {
        if(productType.equalsIgnoreCase("MAC"))
        {
            return new Mac(x,y);
        } 
        else if(productType.equalsIgnoreCase("OSX"))
        {
            return new OSX(x,y);
        } 
        else if(productType.equalsIgnoreCase("TERMINAL"))
        {
            return new Terminal(x,y);
        } 
        else
        {
            return null;
        }
    }
}

