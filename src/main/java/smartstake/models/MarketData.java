package smartstake.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketData {
    @JsonProperty("BID_PRICE")
    private float bidPrice;

    @JsonProperty("ASK_PRICE")
    private int askPrice;

    @JsonProperty("BUY_LIMIT")
    private int buyLimit;

    @JsonProperty("SELL_LIMIT")
    private int sellLimit;

    @JsonProperty("TICKER")
    private String ticker;

    @JsonProperty("MAX_PRICE_SHIFT")
    private int maxPriceShift;

    @JsonProperty("LAST_TRADED_PRICE")
    private float lastTradedPrice;

    public float getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public int getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(int buyLimit) {
        this.buyLimit = buyLimit;
    }

    public int getSellLimit() {
        return sellLimit;
    }

    public void setSellLimit(int sellLimit) {
        this.sellLimit = sellLimit;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getMaxPriceShift() {
        return maxPriceShift;
    }

    public void setMaxPriceShift(int maxPriceShift) {
        this.maxPriceShift = maxPriceShift;
    }

    public float getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(float lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }
}
