package educator.service;


import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import educator.dao.RegisterVerificationDao;
import educator.dao.model.RegisterVerification;
import educator.security.SecurityUtil;
import educator.security.StreamHelpers;


@Singleton
public class RegisterVerificationService
{

    private static final Logger LOGGER = LoggerFactory.getLogger( RegisterVerificationService.class );

    @Inject
    RegisterVerificationDao registerVerificationDao;

    @Inject
    MailService mailService;

    public boolean checkCodeWithHashed( String code, String hashedCode )
    {
        String hashCode = null;
        try
        {
            hashCode = SecurityUtil.hash( code );
        }
        catch ( NullPointerException e )
        {
            LOGGER.error("code equals NULL", e);
        }

        return hashCode != null && hashCode.equalsIgnoreCase( hashedCode );
    }


    public boolean sendVerificationMail( RegisterVerification registerVerification )
    {

        registerVerificationDao.save( registerVerification );
        String body;
        try ( InputStream is = ClassLoader.getSystemResourceAsStream( "verification.mail" ) )
        {
            body = StreamHelpers.readAsString( is );
        }
        catch ( IOException ex )
        {
            LOGGER.error( "IO Exception", ex );
            return false;
        }

        //This is for Temporary use
        body = body.replace( "{name}", "FLIP.kg User" );

        body = body.replace( "{link}", generateLink( registerVerification ) );
        body = body.replace( "{code}", "HERE WILL BE INFORMATION" );

        return mailService.send( registerVerification.getEmail(), "FLIP.kg Registration", body );
    }

    private CharSequence generateLink( RegisterVerification ver )
    {
        // TODO: host and port
        return "http://localhost:8080/registration/" + ver.getVerificationCode() + "/verify";
    }
}

