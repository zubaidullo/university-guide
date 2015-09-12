/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import educator.dao.ExamDao;
import educator.dao.UniversityDao;
import educator.dao.model.Exam;
import educator.dao.model.ExamType;
import educator.dao.model.University;
import educator.service.ExamService;
import ninja.Result;
import ninja.Results;
import ninja.params.Param;
import ninja.params.PathParam;


@Singleton
public class UniversityController
{
    @Inject
    private UniversityDao universityDao;

    @Inject
    private ExamService examService;

    @Inject
    private ExamDao examDao;

    public Result index()
    {

        return Results.html();

    }
    
    public Result getUniversities()
    {
        List<University> universityList = universityDao.findAll();
        return Results.html().template( "/views/UniversityController/list.ftl.html" )
                      .render( "universities", universityList );

    }

    public Result getUniversity(@PathParam( "univ-id" ) String univId)
    {
        University university = universityDao.find( Long.getLong( univId ) );
        return Results.html().template( "/views/UniversityController/view.ftl.html" )
                      .render( "university", university );

    }

    public Result searchUniversity(@Param( "examType" ) String examType, @Param( "test-score" ) String testScore)
    {
        List<University> universityList = examService.filterUniversityByExamScore( examType, testScore );
        return Results.html().template( "/views/UniversityController/list.ftl.html" )
                      .render( "universities", universityList );

    }

    public Result addUniversityView()
    {
        List<Map<String, Object>> examTypes = new ArrayList<>();
        for ( ExamType type : ExamType.values() )
        {
            Map<String, Object> map = new HashMap<>();
            map.put( "type", type.getOrgTypeCode() );
            map.put( "code", type );
            examTypes.add( map );
        }
        return Results.html().template( "/views/UniversityController/add.ftl.html" )
                .render( "examTypes", examTypes );
    }

    public Result addUniversity(@Param( "name" ) String name, @Param( "country" ) String country,
                                @Param( "deadline" ) String deadline, @Param( "scholarship" ) String scholarship,
                                @Param( "address" ) String address, @Param( "description" ) String description,
                                @Param( "imageUrl" ) String imageUrl, @Param( "sat" ) String sat)
    {
        University university = new University();
        university.setName( name );
        university.setCountry( country );
        university.setImageUrl( imageUrl );
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
        try
        {
            Date date = formatter.parse( deadline );
            university.setDeadline( date );
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }
        if (scholarship!=null)
        {
            university.setScholarshipOpp( true );
        }
        university.setAddress( address );
        university.setDescription( description );
        universityDao.save( university );
        Exam exam = new Exam();
        exam.setType( ExamType.SAT );
        exam.setUniversityId( university.getId() );
        exam.setMinRequirements( Double.valueOf( sat ) );
        examDao.save( exam );
        return Results.redirect( "/universities" );
    }
}
