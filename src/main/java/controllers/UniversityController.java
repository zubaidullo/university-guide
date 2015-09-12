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


import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import educator.dao.UniversityDao;
import educator.dao.model.University;
import ninja.Result;
import ninja.Results;
import ninja.params.Param;
import ninja.params.PathParam;


@Singleton
public class UniversityController
{
    @Inject
    private UniversityDao universityDao;

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

        University university = universityDao.find( Long.getLong( univId ));
        return Results.html().template( "/views/UniversityController/view.ftl.html" )
                      .render( "university", university );

    }

    public Result searchUniversity(@Param( "examType" ) String examType)
    {
        List<University> universityList = universityDao.findAll();
        return Results.html().template( "/views/UniversityController/list.ftl.html" )
                      .render( "universities", universityList );

    }
    
    public static class SimplePojo {

        public String content;
        
    }
}
