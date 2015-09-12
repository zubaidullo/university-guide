package educator.service;


/**
 * Created by ${Zubaidullo} on 6/26/15.
 */
public class PasswordStrengthService
{
    public String checkForPasswordStrength(String password)
    {
        if (password.length()<7) return "Минимальная длина пароля должен быть 6, полжалуйста проверьте длина пароля";
        else return "ok";
    }
}
