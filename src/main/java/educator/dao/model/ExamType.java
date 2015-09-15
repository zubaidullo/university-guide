package educator.dao.model;

public enum ExamType
{
    SAT("SAT"),
    TOEFL("TOEFL"),
    ORT("ORT");

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
