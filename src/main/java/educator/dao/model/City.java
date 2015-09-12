package educator.dao.model;

public enum City
{
    BISHKEK("Бишкек"),
    OSH("Ош"),
    KYZYLKIYA("Кызыл-Кыя"),
    KARAKOL("Каракол");

    private String orgTypeCode;
     City( final String type )
    {
        orgTypeCode = type;
    }

    public String getOrgTypeCode()
    {
        return orgTypeCode;
    }
}
