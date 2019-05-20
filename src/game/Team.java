package game;

import game.board.product.Product;
import java.util.ArrayList;

public class Team
{
    private String teamID;
    private Boolean isAI;
    ArrayList<Product> products = new ArrayList();

    public Team(String teamID, Boolean isAI)
    {
        this.isAI = isAI;
        this.teamID = teamID;
    }

    public String getTeamID() { return teamID; }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public ArrayList<Product> getProduct()
    {
        return products;
    }

    public Boolean getIsAI()
    {
        return isAI;
    }
}