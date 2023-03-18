package com.po.optimizer.model;


import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SP500_MarketCap")
public class SnPConstituentData {

      //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    //@BsonProperty("Company")
    private String Company;

    private String Sector;
    private String Ticker;
    private String Market_Cap;
    private float Market_Cap_Billion;
    private float PE_Ratio;

    public SnPConstituentData(String id, String Company, String Sector,String Ticker,
                              String Market_Cap,float Market_Cap_Billion, float PE_Ratio)
    {
        this.id = id;
        this.Company =Company;
        this.Sector = Sector;
        this.Market_Cap = Market_Cap;
        this.Market_Cap_Billion =Market_Cap_Billion;
        this.Ticker = Ticker;
        this.PE_Ratio =PE_Ratio;

    }

    public String getId() {
            return id;
        }

    public void setId(String id) {
            this.id = id;
        }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }

    public String getTicker() {
        return Ticker;
    }

    public void setTicker(String ticker) {
        this.Ticker = ticker;
    }

    public String getMarket_Cap() {
        return Market_Cap;
    }

    public void setMarket_Cap(String market_Cap) {
        this.Market_Cap = market_Cap;
    }

    public float getMarket_Cap_Billion() {
        return Market_Cap_Billion;
    }

    public void setMarket_Cap_Billion(float market_Cap_Billion) {
        this.Market_Cap_Billion = market_Cap_Billion;
    }

    public float getPE_Ratio() {
        return PE_Ratio;
    }

    public void setPE_Ratio(float PE_Ratio) {
        this.PE_Ratio = PE_Ratio;
    }

    @Override
    public String toString() {
            return String.format("(%s, %s, %s ,%s,%s, %s)", Ticker, Market_Cap,Sector,Market_Cap_Billion, PE_Ratio,Company);
        }
}

