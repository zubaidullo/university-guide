package educator.security;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordSecurityProvider implements SecurityProvider
{


    /**
     * Hashes the given value with MD5 digest
     *
     * @param value - value to hash
     *
     * @return hashed value
     */
    @Override
    public String hash( String value ) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance( "MD5" );

        byte[] bytes = md.digest( value.getBytes( Charset.forName( "UTF-8" )) );

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < bytes.length; i++ )
        {
            sb.append( Integer.toString( ( bytes[i] & 0xff ) + 0x100, 16 ).substring( 1 ) );
        }

        //Get complete hashed password in hex format
        return sb.toString();
    }
}
