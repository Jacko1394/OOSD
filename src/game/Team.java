package game;

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