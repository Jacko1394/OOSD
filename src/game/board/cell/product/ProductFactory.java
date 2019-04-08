package game.board.cell.product;

public class ProductFactory {
    //use getShape method to get object of type shape
    public Product getProduct(String productType,int x,int y){
        if(productType == null){
            return null;
        }

        if(productType.equalsIgnoreCase("MAC")){
            return new Mac(x,y);
        } else if(productType.equalsIgnoreCase("OSX")){
            return new OSX(x,y);
        } else if(productType.equalsIgnoreCase("POWERSHELL")){
            return new Powershell(x,y);
        } else if(productType.equalsIgnoreCase("SURFACEPRO")){
            return new SurfacePro(x,y);
        } else if(productType.equalsIgnoreCase("TERMINAL")){
            return new Terminal(x,y);
        } else if(productType.equalsIgnoreCase("WINDOWS10")){
            return new Windows10(x,y);
        }

        return null;
    }

}
