package educator.dao.model;

public enum ExamType
{
    SAT("SAT");

    private String orgTypeCode;
     ExamType( final String type )
    {
        orgTypeCode = type;
    }

    public String getOrgTypeCode()
    {
        return orgTypeCode;
    }
}
