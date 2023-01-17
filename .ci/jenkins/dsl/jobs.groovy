import org.kie.jenkins.jobdsl.model.JobType
import org.kie.jenkins.jobdsl.utils.JobParamsUtils
import org.kie.jenkins.jobdsl.KogitoJobTemplate

JENKINSFILE_PATH = '.ci/jenkins'

// Release
setupKogitoDocsJob()


/////////////////////////////////////////////////////////////////
// Methods
/////////////////////////////////////////////////////////////////

void setupKogitoDocsJob() {
    def jobParams = JobParamsUtils.getBasicJobParams(this, 'kie-docs-post-release', JobType.TOOLS, "${JENKINSFILE_PATH}/Jenkinsfile.kie-kogito-post-release", "Update Kie Kogito docs")
    JobParamsUtils.setupJobParamsDefaultMavenConfiguration(this, jobParams)
    jobParams.env.putAll([
            JENKINS_EMAIL_CREDS_ID: "${JENKINS_EMAIL_CREDS_ID}",
            GIT_AUTHOR: "${GIT_AUTHOR_NAME}",
            GIT_AUTHOR_CREDENTIALS_ID: "${GIT_AUTHOR_CREDENTIALS_ID}",
            SSH_KOGITO_DOCS_PATH: "kogito@filemgmt-prod.jboss.org:/docs_htdocs/kogito/release",
            RSYNC_KOGITO_DOCS_PATH: "kogito@filemgmt-prod-sync.jboss.org:/docs_htdocs/kogito/release",
            KIE_DOCS_BRANCH: 'main-kogito',
    ])
    KogitoJobTemplate.createPipelineJob(this, jobParams)?.with {
        parameters {
            stringParam('KOGITO_DOCS_VERSION', '', 'Kogito docs version to release in kie-docs as Major.minor.micro')
            booleanParam('BUMP_UP' , false, 'Is a new KIE version needed?')
            stringParam('KIE_VERSION' , '', 'KIE version to bump up to as Major.minor.micro-SNAPSHOT')
        }
    }
}