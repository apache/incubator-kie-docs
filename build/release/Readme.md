# Tag and upload kie-docs (kogito-docs) to filemgmt  

To tag a required or desirable version of kogito-docs in kiegroup/kie-docs [main-kogito branch] there has been developed a new job [kie-docs-post-release](https://eng-jenkins-csb-business-automation.apps.ocp-c1.prod.psi.redhat.com/job/KIE/job/kogito/job/${branch}/job/release/job/kie-docs-post-release/) which replaces the known and until now used job [uploadKogitoDocs](https://eng-jenkins-csb-business-automation.apps.ocp-c1.prod.psi.redhat.com/job/KIE/job/kogito/job/kogito-docs/job/uploadKogitoDocs/). 

Each time a new branch is created, in it's folder Jenkins/KIE/kogito/${branch}/release will be displayed a job **kie-docs-post-release**. 

This job has three parameters to edit when running the job:

* KOGITO_DOCS_VERSION
* BUMP_UP (select box)
* KIE_VERSION

In most cases, there has only been edited the KOGITO_DOCS_VERSION (as Major.minor.micro i.e. **1.32.0**). From this version, the name of the tag is calculated (in this case **1.32.0-kogito**) as well as the new **-SNAPSHOT** version [org.kie.kogito.kogito-docs](https://github.com/kiegroup/kie-docs/blob/main-kogito/doc-content/kogito-docs/pom.xml#L14) will be upgraded to. 

In cases in the meantime has been released a new version of community kiegroup/... which can be seen at [main branch](https://github.com/kiegroup/kie-docs/blob/main/pom.xml#L23) we have to upgrade this version also in kie-docs main-kogito branch. Compared to [main-kogito branch](https://github.com/kiegroup/kie-docs/blob/main-kogito/pom.xml#L23) it can be seen if an upgrade is needed or not. In case it is, the **BUMP_UP** select box has to be selected and the new **KIE_VERSION** has to be specified (as Major.minor.micro-SNAPSHOT i.e. **7.75.0-SNAPSHOT**).

What does the job:

* updates the kogito-docs version in kie-docs (on main-kogito branch)
* creates a tag 
* does a build of kie-docs/doc-content/kogito-docs to check if all builds correctly
* pushed the tag to kie-docs
* uploads the kogito-docs to filemgmt.jboss.org []
* bumps up kogito-docs version to next **-SNAPSHOT** (and kie-version if it is needed)
* push all changes to kie-docs [main-kogito branch]
