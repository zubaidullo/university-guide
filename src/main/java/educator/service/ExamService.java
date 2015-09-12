package educator.service;


import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import educator.dao.ExamDao;
import educator.dao.UniversityDao;
import educator.dao.UserDao;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class ExamService
{

    @Inject
    UniversityDao universityDao;

    @Inject
    UserDao userDao;

    @Inject
    ExamDao examDao;

    public Map<String, Object> getUser(long id)
    {
        Map<String, Object> userMap = new HashMap<>();
        return userMap;
    }
}
