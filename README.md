# Kogito documentation

<p align="center"><img width=55% height=55% src="_images/logos/kogitoLogo.png"_></p>

Kogito is a cloud-native business automation technology for building cloud-ready business applications. Kogito includes components that are based on well-known business automation projects in the Knowledge Is Everything (KIE) community, specifically [Drools](https://drools.org), [jBPM](https://jbpm.org), and [OptaPlanner](https://optaplanner.org), to offer dependable, open source solutions for business rules, business processes, and constraint solving.

This `master-kogito` branch of the `kie-docs` repository contains the source of the Kogito documentation for both KIE community and Red Hat Business Automation enterprise publications. The latest version of the Kogito documentation for the KIE community is published at https://docs.jboss.org/kogito/release/latest/html_single/. 

As a Kogito user, developer, or technical writer, you can contribute to Kogito documentation by forking and cloning this repository, updating or adding content, and submitting a pull request for review.

>**NOTE**: The other branches in the `kie-docs` repository contain the source of the Drools, jBPM, and OptaPlanner documentation, which are the basis for [Red Hat Decision Manager](https://access.redhat.com/documentation/en-us/red_hat_decision_manager/) and [Red Hat Process Automation Manager](https://access.redhat.com/documentation/en-us/red_hat_process_automation_manager/).

>**IMPORTANT**: Kogito is currently available for Development Preview. Development Preview releases contain features and APIs that might not be fully tested and that might change in the final GA version. Users are discouraged from using Development Preview software in production or for business-critical workloads.  Because this is not production-ready software, users are not able to open support tickets. To learn more about Kogito, please contact your Red Hat representative or send an email to Kogito-earlyaccess@redhat.com. Red Hat will address reported issues at its own discretion.

Contents
=================

* [Required documentation tools](#required-documentation-tools)
* [File system layout of the `master-kogito` branch](#file-system-layout-of-the-master-kogito-branch)
* [Contributing to Kogito documentation](#contributing-to-kogito-documentation)
* [Contributing to Kogito software](#contributing-to-kogito-software)

# Required documentation tools

To work with the `kie-docs` documentation source, you need the following software:

* **Git**: Used for version control with this repository.

  To install Git on Fedora, CentOS, or RHEL, enter the following command in a command terminal (in Fedora, replace `yum` with `dnf`):
  ```
  # yum install git
  ```
  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Git documentation](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).

* **Asciidoctor (for AsciiDoc)**: Used for publishing content written in [AsciiDoc](http://asciidoc.org/) format, which is the format used in Kogito documentation files.

  To install Asciidoctor on Fedora, CentOS, or RHEL, enter the following command (in Fedora, replace `yum` with `dnf`):

  ```
  # yum install asciidoctor
  ```

  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Asciidoctor documentation](http://asciidoctor.org/#installation).

* **Atom (text editor)**: Used to edit Kogito documentation files. You can use another text editor of your choice or your existing integrated development environment (IDE), but Atom is recommended for optimal support of AsciiDoc and Asciidoctor and has many helpful add-on packages.

  To install Atom on Fedora, CentOS, or RHEL, go to the [Atom homepage](https://atom.io/), download the appropriate RPM version, navigate to the downloaded file in a command terminal, and enter the following command (in Fedora, replace `yum` with `dnf`):

  ```
  # yum install -y atom.x86_64.rpm
  ```

  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Atom documentation](http://flight-manual.atom.io/).

* **Apache Maven 3.5.4 or later**: Used for building the KIE community version of Kogito documentation. To install Maven on Fedora, CentOS, or RHEL, enter the following command in a command terminal (in Fedora, replace `yum` with `dnf`):

  ```
  # yum install maven
  ```

  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Maven documentation](http://maven.apache.org/).

# File system layout of the `master-kogito` branch

The files in the `master-kogito` branch of the `kie-docs` repository are organized in the following general structure:

```
├── _artifacts
├── _images
├── assemblies
    ├── assembly-kogito-creating-running
        ├── kog
            ├── master-docinfo.xml
            └── master.adoc
        └── main.adoc
    ├── ...
├── doc-content
    ├── kogito-docs
        └── src
            └── main
                └── asciidoc
                    ├── bpmn
                        ├──con-bpmn-elements.adoc
                        ├── ...
                    ├── dmn
                        ├── con-dmn-elements.adoc
                        ├── ...
                    ├── ...
                    ├── chap-kogito-configuring.adoc
                    ├── ...
                    └── index.adoc
        └── pom.xml
├── ...
├── pom.xml    
└── README.md
```

The file structure contains the following core folders:

* `_artifacts`: Directory with document attributes that render according to target output (community or enterprise).
* `_images`: Directory with all images used in the documentation, divided into sub-directories by subject matter.
* `assemblies`: (For Red Hat enterprise publications only) List of assembly folders used by the Red Hat Business Automation documentation team to build content for the Red Hat Customer Portal.
* `doc-content`: Directory with all ADOC content files, specifically in `doc-content/kogito-docs/src/main/asciidoc`. This directory contains the following types of ADOC files:

  * **Module files**: Topic files that are classified as concepts (prefix `con-`), references (prefix `ref-`), or procedures (prefix `proc-`), typically with a single heading per file. For example, the procedure `= Creating and editing DMN models in the Kogito DMN modeler` is written as a single ADOC file with an anchor ID `[id='proc-creating-dmn-models_{context}']` and file name `proc-creating-dmn-models.adoc`. The `_{context}` variable in the anchor ID enables the module file to be reused in multiple chapter files.

    For module file examples, explore the sub-directories in [`doc-content/../asciidoc`](https://github.com/kiegroup/kie-docs/tree/master-kogito/doc-content/kogito-docs/src/main/asciidoc). For more information about modular documentation conventions, see the Red Hat [`modular-docs`](https://github.com/redhat-documentation/modular-docs) repository in GitHub.

    If these specifics for module files are unclear to you, use an existing module file as a starting template and write what makes sense to you. The `kie-docs` documentation team can work with the content that you contribute.
  * **Chapter files**: Chapter files (prefix `chap-`) that list module files with `include` statements and contain any additional introductory content for that chapter.
  * **Index file**: Single index file (`index.adoc`) that lists chapter files with `include` statements and contains any additional introductory content for the Kogito documentation as a whole.

# Contributing to Kogito documentation

After you install the required documentation tools, you can begin contributing to Kogito documentation in the `master-kogito` branch of the `kie-docs` repository. The `kie-docs` documentation workflow follows the standard [GitHub flow](https://guides.github.com/introduction/flow/), which requires your own GitHub fork of the upstream source repository and a local clone of your fork.

The following is a high-level view of the content workflow between the upstream `kie-docs` GitHub repo, your GitHub fork of the repo, and your locally cloned copy of your fork:

<p align="center"><img width=65% height=65% src="_images/readme/github-content-overview.png"_></p>

**Prerequisites**
* You have installed the [required documentation tools](#required-documentation-tools).
* You have a basic understanding of [GitHub workflows](https://guides.github.com/introduction/flow/) and commands.
* You have a basic understanding of [AsciiDoc and Asciidoctor](https://asciidoctor.org/docs/) formatting and functionality.

**Procedure**

1. Fork the [`kie-docs`](https://github.com/kiegroup/kie-docs/tree/master-kogito) repository in GitHub, and in a command terminal, clone your forked repository to a local directory and add a remote for the `upstream` repository.

    Cloning your fork:
    ```
    $ cd PATH_TO_REPO_DIRECTORY
    $ git clone git@github.com:USER_NAME/kie-docs.git
    ```

    Adding and verifying the upstream remote:
    ```
    $ git remote add upstream https://github.com/kiegroup/kie-docs.git
    $ git remote -v
    origin git@github.com:jsmith/kie-docs.git (fetch)
    origin git@github.com:jsmith/kie-docs.git (push)
    upstream https://github.com/kiegroup/kie-docs.git (fetch)
    upstream https://github.com/kiegroup/kie-docs.git (push)
    ```

2. Check out the `master-kogito` branch from your upstream remote and create a working branch based on that branch to begin making changes. You can name your branch based on a JIRA ID, such as `KOGITO-1234` or `BXMSDOC-1234`, or another logical name if the branch is not JIRA-based, such as `Update-DMN-content`.

    Creating your work branch:
    ```
    $ git checkout --track upstream/master-kogito
    $ git checkout -b Branch-name
    ```

3. Open your Atom text editor (recommended) or other editor of your choice, and update or add content as needed according to the [file system layout](#file-system-layout-of-the-master-kogito-branch) requirements.

4. After you complete and save your changes in your working branch, navigate to the top-level `kie-docs` directory in your local repository and enter the following commands to build the documentation locally and verify the generated preview in a web browser.

    Building and verifying the documentation:
    ```
    $ cd ~/kie-docs
    $ mvn clean install -Dfull
    [Build output]
    $ google-chrome doc-content/kogito-docs/target/generated-docs/html_single/index.html
      ```
    Replace `google-chrome` with the browser of your choice.

5. After you build and verify your changes, commit and push your branch to your fork in GitHub.

    Committing and pushing to your fork:
    ```
    $ cd ~/kie-docs #Recommended to move back "up" in the directory to ensure all modified files are staged and committed.
    $ git add --all
    $ git commit -m "KOGITO-1234: Update section on DMN data types."
    $ git push -u origin KOGITO-1234 #For first-time push, subsequently just `git push`
    ```

6. In your `kie-docs` fork in GitHub, create a pull request to merge your work branch with the  `master-kogito` branch in the upstream `kie-docs` repository.

    In your pull request, include the following components:
    * **Description**: Summarize your changes and include any links to JIRA tasks or document previews, if available
    * **Reviewers**: Assign two reviewers: a developer from the KIE development team and a writer from the Red Hat Business Automation team. If you do not know who to assign, leave this field empty and the documentation team can assign the reviewers.  

# Contributing to Kogito software

To contribute to Kogito software, see the [`kogito-runtimes`](https://github.com/kiegroup/kogito-runtimes) repository in GitHub.
