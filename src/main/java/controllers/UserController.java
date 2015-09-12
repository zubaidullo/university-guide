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


import com.google.inject.Inject;
import com.google.inject.Singleton;

import educator.dao.model.RegisterVerification;
import educator.security.SecurityUtil;
import educator.service.RegisterVerificationService;
import ninja.Result;
import ninja.Results;
import ninja.params.Param;


@Singleton
public class UserController
{
    @Inject
    private RegisterVerification registerVerification;

    @Inject
    private RegisterVerificationService registerVerificationService;

    public Result verificationPage()
    {
        return Results.html().template( "/views/UserController/verificationMessage.ftl.html" );
    }

    public Result sendVerification(@Param( "email" ) String email)
    {
        RegisterVerification registerVerification = new RegisterVerification();
        registerVerification.setEmail( email );
        registerVerification.setVerificationCode( SecurityUtil.generateRandomCode( 15 ) );
        registerVerificationService.sendVerificationMail( registerVerification );
        return Results.redirect( "/verification-message" );
    }

    public Result profile()
    {
        return Results.html().template( "/views/UserController/profile.ftl.html" );
    }
}
