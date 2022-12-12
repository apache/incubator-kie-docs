#!/usr/bin/env bash
set -eo pipefail

sshPath=$1
rsyncPath=$2
kogitoDocsVersion=$3
 
touch upload_version
echo "mkdir ${kogitoDocsVersion} > upload_version"
chmod +x upload_version
# creates a folder on filemgmt.jboss.org:docs_htdocs/release/ uploading via sftp the created file upload_version.txt [created in pipeliline for uploding kie-kogito-docs] which contains the recent version [kogitoDocsVersion]
sftp -b upload_version ${sshPath}
rm -rf upload_version
# upload of the kie-docs/docs-contents/kogito-docs/target/html-single to filemgmt-prod-sync.jboss.orgfilemgmt.jboss.org:docs_htdocs/release/${kogitoDocsVersion}
rsync -Pavqr -e "ssh -p 2222" --protocol=28 --delete-after target/generated-docs/html_single ${rsyncPath}/${kogitoDocsVersion}
# upload latest links so that user will be forwarded to the correct version when clicking on latest
mkdir filemgmt_link 
cd filemgmt_link
touch ${kogitoDocsVersion}
ln -s ${kogitoDocsVersion} latest
rsync -a -e "ssh -p 2222" --protocol=28 latest ${rsyncPath}
echo "symbolic links uploaded"
cd ..
rm -rf filemgmt_link
