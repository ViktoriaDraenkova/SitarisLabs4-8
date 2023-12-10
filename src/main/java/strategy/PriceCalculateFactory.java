package strategy;

public class PriceCalculateFactory {
    public PriceCalculateStrategy createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("total")) {
            return new TotalPriceStrategy();
        } else if (strategyType.equalsIgnoreCase("promocode")) {
            return new PromocodePriceStrategy();
        }
        throw new IllegalArgumentException("Invalid strategy type: " + strategyType);
    }
}
