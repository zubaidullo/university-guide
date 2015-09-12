package educator.security;


import java.security.NoSuchAlgorithmException;


public interface SecurityProvider
{
    public String hash( String value ) throws NoSuchAlgorithmException;
}
