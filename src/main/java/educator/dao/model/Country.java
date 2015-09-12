package educator.dao.model;

public enum Country
{
    BISHKEK("Бишкек"),
    OSH("Ош"),
    KYZYLKIYA("Кызыл-Кыя"),
    KARAKOL("Каракол");

    private String orgTypeCode;
     Country( final String type )
    {
        orgTypeCode = type;
    }

    public String getOrgTypeCode()
    {
        return orgTypeCode;
    }
}
