package game.board.product;

public class MicrosoftFactory extends ProductFactory
{
    public Product generateProduct(String productType, int x, int y)
    {
        if(productType.equalsIgnoreCase("SURFACEPRO"))
        {
            return new SurfacePro(x,y);
        } 
        else if(productType.equalsIgnoreCase("WINDOWS10"))
        {
            return new Windows10(x,y);
        }
        else if(productType.equalsIgnoreCase("POWERSHELL"))
        {
            return new Powershell(x,y);
        } 
        else
        {
            return null;
        }
    }
}

