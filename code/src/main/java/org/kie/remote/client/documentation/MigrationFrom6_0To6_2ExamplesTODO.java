/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.kie.remote.client.documentation;

import java.net.MalformedURLException;
import java.net.URL;

import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.remote.client.api.RemoteRuntimeEngineFactory;

//TODO: changed, add to documentation
public class MigrationFrom6_0To6_2ExamplesTODO {

    /**
     * In the 6.0.x code, we did this: 
     * 
     *  // Setup remote JMS runtime engine factory
     *  RemoteJmsRuntimeEngineFactory remoteJmsFactory 
     *      = new RemoteJmsRuntimeEngineFactory(deploymentId, serverUrl, user, password);
     *
     *  // Create runtime engine
     *  RuntimeEngine engine = remoteJmsFactory.newRuntimeEngine();
     */
    public void createJmsRuntimeEngine(String deploymentId, URL serverUrl, String user, String password) { 
        // Now we just do this: 
        RuntimeEngine engine = RemoteRuntimeEngineFactory.newJmsBuilder()
                .addDeploymentId(deploymentId)
                .addJbossServerHostName(serverUrl.getHost())
                .addUserName(user)
                .addPassword(password)
                .build();
    }
   
    /**
     * With the introduction of the fluent/builder API in 6.2.x, we could do this: 
     * 
     *   RemoteRestRuntimeEngineFactory factory = 
     *          RemoteRestRuntimeEngineFactory.newBuilder()
     *          .addUserName("user")
     *          .addPassword("pass")
     *          .addUrl(new URL("http://localhost:8080/business-central"))
     *          .build();
     *  
     *   RuntimeEngine runtimeEngine = factory.newRuntimeEngine();
     *   
     * With the 6.0.x code, we built a factory, that we then used to create the runtime.. 
     * 
     * Why not just build the runtime immediately? :)
     */
    public void createRestRuntimeEngineWithBuilder() throws MalformedURLException { 
        // unfortunately, this breaks backward compatibility, but the improvement and clarity in the API is worth the risk
        RuntimeEngine runtimeEngine = 
               RemoteRuntimeEngineFactory.newRestBuilder()
               .addUserName("user")
               .addPassword("pass")
               .addUrl(new URL("http://localhost:8080/business-central"))
               .build();
       
    }
}
// END
