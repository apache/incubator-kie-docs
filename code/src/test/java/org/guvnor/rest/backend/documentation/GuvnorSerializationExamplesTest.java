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

package org.guvnor.rest.backend.documentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.rest.client.ProjectResponse;
import org.guvnor.rest.client.Space;
import org.guvnor.rest.client.UpdateOrganizationalUnit;
import org.junit.Test;

public class GuvnorSerializationExamplesTest {

    @Test
    public void getProjectsJsonExample() throws JsonGenerationException, JsonMappingException, IOException {

        List<ProjectResponse> projectRequests = new ArrayList<ProjectResponse>(2);

        ProjectResponse projectReq = new ProjectResponse();
        GAV projectGAV = new GAV("com.acme", "my-project-artifact-id", "1.0");
        projectReq.setGroupId(projectGAV.getGroupId());
        projectReq.setName(projectGAV.getArtifactId());
        projectReq.setVersion(projectGAV.getVersion());
        projectReq.setName("my-project-name");
        projectReq.setDescription("Project to illustrate REST output");
        projectRequests.add(projectReq);

        projectReq = new ProjectResponse();
        projectGAV = new GAV("com.acme", "yap", "2.2.1");
        projectReq.setGroupId(projectGAV.getGroupId());
        projectReq.setName(projectGAV.getArtifactId());
        projectReq.setVersion(projectGAV.getVersion());
        projectReq.setName("yet-another-project-name");
        projectReq.setDescription("Yet Another Project to illustrate REST output");
        projectRequests.add(projectReq);

        ObjectMapper om = new ObjectMapper();
//        System.out.println( om.writerWithDefaultPrettyPrinter().writeValueAsString(projectRequests) );
    }

    @Test
    public void getOrganizationalUnitsExample() throws JsonGenerationException, JsonMappingException, IOException {
        List<Space> orgUnits = new ArrayList<Space>();

        Space space = new Space();
        space.setName("EmployeeWage");
        space.setOwner("Employee");
        space.setDefaultGroupId("org.bpms");
        List<String> repoNames = new ArrayList<String>();
        repoNames.add("EmployeeRepo");
        repoNames.add("OtherRepo");
        space.setProjects(repoNames);
        orgUnits.add(space);

        space = new Space();
        space.setName("SpaceName");
        space.setOwner("SpaceOwner");
        space.setDefaultGroupId("org.group.id");
        repoNames = new ArrayList<String>();
        repoNames.add("repository-name-1");
        repoNames.add("repository-name-2");
        space.setProjects(repoNames);
        orgUnits.add(space);

        ObjectMapper om = new ObjectMapper();
        // System.out.println( om.writerWithDefaultPrettyPrinter().writeValueAsString(orgUnits) );
    }

    @Test
    public void updateOrganizationalUnitExample() throws JsonGenerationException, JsonMappingException, IOException {

        UpdateOrganizationalUnit updateOrgUnit = new UpdateOrganizationalUnit();

        // use owner in existing Space if post owner is null
        updateOrgUnit.setOwner("NewOwner");
        updateOrgUnit.setDefaultGroupId("org.new.default.group.id");

        ObjectMapper om = new ObjectMapper();
        // System.out.println( om.writerWithDefaultPrettyPrinter().writeValueAsString(updateOrgUnit) );

        String jsonStr = "{ \"name\" : null,  \"owner\" : \"NewOwner\",  \"defaultGroupId\" : \"org.new.default.group.id\" }";
        updateOrgUnit = om.readValue(jsonStr, UpdateOrganizationalUnit.class);
        String name = updateOrgUnit.getClass().getName();
    }
}
