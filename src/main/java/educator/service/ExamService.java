package educator.service;


import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import educator.dao.ExamDao;
import educator.dao.UniversityDao;
import educator.dao.model.Exam;
import educator.dao.model.ExamType;
import educator.dao.model.University;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class ExamService
{

    @Inject
    UniversityDao universityDao;

    @Inject
    ExamDao examDao;

    public List<University> filterUniversityByExamScore( String type, String score )
    {
        List<Exam> exams = examDao.findScoreAndType( ExamType.valueOf( type ), Double.valueOf( score ) );
        List<University> universities = new ArrayList<>();
        for (Exam exam: exams)
        {
            universities.add( universityDao.find( exam.getUniversityId() ) );
        }
        return universities;
    }
}
