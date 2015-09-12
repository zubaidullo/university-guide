package educator.dao.model;

public enum Gender
{
    MALE("Мужчина"),
    FEMALE("Женщина");

    private String orgTypeCode;
     Gender( final String type )
    {
        orgTypeCode = type;
    }

    public String getOrgTypeCode()
    {
        return orgTypeCode;
    }
}
