import java.util.Date;

public class Result
{
    private String orgId;
    private String siteId;
    private Date date;
    private String characteristic;
    private Double concentration;
    private String concentrationUnit;
    private String provider;

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getCharacteristic()
    {
        return characteristic;
    }

    public void setCharacteristic(String characteristic)
    {
        this.characteristic = characteristic;
    }

    public Double getConcentration()
    {
        return concentration;
    }

    public void setConcentration(Double concentration)
    {
        this.concentration = concentration;
    }

    public String getConcentrationUnit()
    {
        return concentrationUnit;
    }

    public void setConcentrationUnit(String concentrationUnit)
    {
        this.concentrationUnit = concentrationUnit;
    }

    public String getProvider()
    {
        return provider;
    }

    public void setProvider(String provider)
    {
        this.provider = provider;
    }

    @Override
    public String toString()
    {
        return "Result{" +
                "orgId='" + orgId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", date=" + date +
                ", characteristic='" + characteristic + '\'' +
                ", concentration=" + concentration +
                ", concentrationUnit='" + concentrationUnit + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
