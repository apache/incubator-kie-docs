import org.kie.jenkins.jobdsl.KogitoJobTemplate
import org.kie.jenkins.jobdsl.model.Folder
import org.kie.jenkins.jobdsl.KogitoJobUtils
import org.kie.jenkins.jobdsl.Utils

JENKINSFILE_PATH = '.ci/jenkins'

// Release
setupKogitoDocsJob()


/////////////////////////////////////////////////////////////////
// Methods
/////////////////////////////////////////////////////////////////

void setupKogitoDocsJob() {
    def jobParams = KogitoJobUtils.getBasicJobParams(this, 'kie-docs-post-release', Folder.RELEASE, "${JENKINSFILE_PATH}/Jenkinsfile.kie-kogito-post-release", "Update Kie Kogito docs")
    KogitoJobUtils.setupJobParamsDefaultMavenConfiguration(this, jobParams)
    jobParams.env.putAll([
            JENKINS_EMAIL_CREDS_ID: "${JENKINS_EMAIL_CREDS_ID}",
            GIT_AUTHOR: "${GIT_AUTHOR_NAME}",
            GIT_AUTHOR_CREDENTIALS_ID: "${GIT_AUTHOR_CREDENTIALS_ID}",
            SSH_KOGITO_DOCS_PATH: "kogito@filemgmt-prod.jboss.org:/docs_htdocs/kogito/release",
            RSYNC_KOGITO_DOCS_PATH: "kogito@filemgmt-prod-sync.jboss.org:/docs_htdocs/kogito/release",
            KIE_DOCS_BRANCH: "${GIT_MAIN_BRANCH}",
    ])
    KogitoJobTemplate.createPipelineJob(this, jobParams)?.with {
        parameters {
            stringParam('KOGITO_DOCS_VERSION', '', 'Kogito docs version to release in kie-docs as Major.minor.micro')
            booleanParam('BUMP_UP',false,'Is a new KIE version needed?')
            stringParam('KIE_VERSION','','KIE version to bump up to as Major.minor.micro-SNAPSHOT')
        }
    }
}