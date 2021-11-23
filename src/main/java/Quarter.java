package main.java;

public class Quarter implements FinancialEvents, QOddEvents {
    
    private int order;
    
    public int getOrder() {
        return this.order;
    }
    
    public void setOrder(int num) {
        this.order = num;
    }

    @Override
    public void SupplyChainCollapse() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void InternationalConflict() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Nationalization() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void TaxCuts() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void marketShareVariance(MarketSystem system) {
        //System.out.println("calling marketShareVariance");
        for (Startup listElement : system.allStartups) {
            double currentMS = listElement.getMarketShare();
            int msRoll = listElement.roll(listElement.getMarketShareMod());
            System.out.println(listElement.getName() + " rolls " + msRoll);
            if (msRoll < 6) {
                listElement.adjMarketShare(-1 * (currentMS / 10) );
            } else if (msRoll < 15) {
                listElement.adjMarketShare(0);
            } else {
                listElement.adjMarketShare(currentMS / 10);
            }
        }
    }

    @Override
    public void catchStartup(MarketSystem system) {
        // TODO Auto-generated method stub
        
    }

}
