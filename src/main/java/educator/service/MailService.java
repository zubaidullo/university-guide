package educator.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import ninja.postoffice.Mail;
import ninja.postoffice.Postoffice;


@Singleton
public class MailService
{

    private static final Logger LOGGER = LoggerFactory.getLogger( MailService.class );

    @Inject
    Provider<Mail> mailProvider;

    @Inject
    Postoffice postOffice;

    private String fromAddress = "NOREPLY@ug.kg";


    @Inject
    public MailService( @Named( "smtp.field.from" ) String fromAddress )
    {
        if ( fromAddress != null && !fromAddress.isEmpty() )
        {
            this.fromAddress = fromAddress;
        }
    }


    public boolean send( String email, String subject, String body )
    {
        return send( email, subject, body, false );
    }

    public boolean send( String email, String subject, String body, boolean html )
    {
        Mail mail = mailProvider.get();

        mail.setSubject( subject );
        mail.setFrom( fromAddress );
        mail.addTo( email );
        mail.setCharset( "utf-8" );

        if ( html )
        {
            mail.setBodyHtml( body );
        }
        else
        {
            mail.setBodyText( body );
        }

        try
        {
            postOffice.send( mail );
            return true;
        }
        catch ( Exception e )
        {
            LOGGER.error( "Failed to send email", e );
        }
        return false;
    }

}

