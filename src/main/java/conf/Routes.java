/**
 * Copyright (C) 2012 the original author or authors.
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

package conf;


import controllers.UniversityController;
import controllers.UserController;
import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.MainController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
        
        router.GET().route("/").with( MainController.class, "index");

        // University
        router.GET().route("/universities").with( UniversityController.class, "getUniversities");
        router.GET().route("/universities/add").with( UniversityController.class, "addUniversityView");
        router.POST().route("/universities/add").with( UniversityController.class, "addUniversity");
        router.GET().route("/universities/{univ-id}").with( UniversityController.class, "getUniversity");
        router.POST().route("/universities").with( UniversityController.class, "searchUniversity");


        // User
        router.GET().route("/profile").with( UserController.class, "profile");

        // Guide
        router.GET().route("/guide").with( MainController.class, "guide");

        // Tips & Advises
        router.GET().route("/tips-advises").with( MainController.class, "tipsAndAdvises");

        // About
        router.GET().route("/about").with( MainController.class, "about");

        // Register Verification
        router.GET().route("/verification-message").with( UserController.class, "verificationPage");
        router.POST().route("/registration/first").with( UserController.class, "sendVerification");
        router.GET().route("/registration").with( MainController.class, "registrationPage");
        router.GET().route("/about").with( MainController.class, "about");


        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/.*").with( MainController.class, "index");
    }

}
