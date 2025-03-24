### The drools contents are only for drools 7.x and no longer maintained in this repository.
### The current drools docs content is maintained in subproject *drools-docs* here https://github.com/apache/incubator-kie-drools/

___



![Quality sync checks master](https://github.com/kiegroup/kie-docs/workflows/Quality%20sync%20checks/badge.svg?branch=master)
![Quality sync checks master-kogito](https://github.com/kiegroup/kie-docs/workflows/Quality%20sync%20checks/badge.svg?branch=master-kogito)

If either of the two badges above are not green, please get in contact with engineering: some document might no longer be aligned.

# Apache KIE Kogito documentation

On August 31, 2018, this `kie-docs` repository that contains KIE community and Red Hat Business Automation documentation was updated to enable shared content between KIE community and Red Hat Business Automation enterprise documentation, to remove obsolete content, and to prepare for an improved content building tool coming soon (Aura).

Kogito is a cloud-native business automation technology for building cloud-ready business applications. Kogito includes components that are based on well-known business automation projects in the Knowledge Is Everything (KIE) community, specifically [Drools](https://drools.org), [jBPM](https://jbpm.org), and [OptaPlanner](https://optaplanner.org), to offer dependable, open source solutions for business rules, business processes, and constraint solving.

As a Kogito user, developer, or technical writer, you can contribute to Kogito documentation by forking and cloning this repository, updating or adding content, and submitting a pull request for review.

Contents
=================

* [Required documentation tools](#required-documentation-tools)
* [File system layout of the `main-kogito` branch](#file-system-layout-of-the-main-kogito-branch)
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

* **Apache Maven 3.9.6**: Used for building the KIE community version of Kogito documentation. To install Maven on Fedora, CentOS, or RHEL, enter the following command in a command terminal (in Fedora, replace `yum` with `dnf`):

  ```
  # yum install maven
  ```

  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Maven documentation](http://maven.apache.org/).

# File system layout of the `main-kogito` branch

The files in the `main-kogito` branch of the `kie-docs` repository are organized in the following general structure:

```
├── _artifacts
├── _images
├── doc-content
    ├── kogito-docs
        └── src
            └── main
                └── asciidoc
                    ├── bpmn
                        ├──chap-kogito-developing-process-services.adoc
                        ├── ...
                    ├── configuration
                        ├── chap-kogito-configuring.adoc
                        ├── ...
                    ├── ...
                    └── index.adoc
        └── pom.xml
├── ...
├── pom.xml    
└── README.md
```

**WARNING:** Do not rebase your existing master branch against `kie-docs` master branch to get the latest updates. The new master is substantially restructured, so rebasing creates extensive conflicts that, even when resolved, can introduce errors into the new structure.

**To access legacy content from the former master branch,** use the branch `backup-master-2018.08.31`.

## Summary of KIE documentation changes

# Contributing to Kogito documentation

For more information about these documentation changes or about contributing to this `kie-docs` documentation repository, see [Contributing to KIE documentation](https://redhat-documentation.github.io/doc-guidelines/bpm/).

# Developing Drools and jBPM

For guidelines on contributing to a `kiegroup` development project, see [droolsjbpm-build-bootstrap/README.md](https://github.com/kiegroup/droolsjbpm-build-bootstrap/blob/master/README.md).

**Prerequisites**
* You have installed the [required documentation tools](#required-documentation-tools).
* You have a basic understanding of [GitHub workflows](https://guides.github.com/introduction/flow/) and commands.
* You have a basic understanding of [AsciiDoc and Asciidoctor](https://asciidoctor.org/docs/) formatting and functionality.

**Procedure**

1. Fork the [`kie-docs`](https://github.com/apache/incubator-kie-docs/tree/main-kogito) repository in GitHub, and in a command terminal, clone your forked repository to a local directory and add a remote for the `upstream` repository.

    Cloning your fork:
    ```
    $ cd PATH_TO_REPO_DIRECTORY
    $ git clone git@github.com:USER_NAME/kie-docs.git
    ```

    Adding and verifying the upstream remote:
    ```
    $ git remote add upstream https://github.com/apache/incubator-kie-docs.git
    $ git remote -v
    origin git@github.com:jsmith/kie-docs.git (fetch)
    origin git@github.com:jsmith/kie-docs.git (push)
    upstream https://github.com/apache/incubator-kie-docs.git (fetch)
    upstream https://github.com/apache/incubator-kie-docs.git (push)
    ```

2. Check out the `main-kogito` branch from your upstream remote and create a working branch based on that branch to begin making changes. You can name your branch based on a JIRA ID, such as `KOGITO-1234` or `BXMSDOC-1234`, or another logical name if the branch is not JIRA-based, such as `Update-DMN-content`.

    Creating your work branch:
    ```
    $ git checkout --track upstream/main-kogito
    $ git checkout -b Branch-name
    ```

3. Open your Atom text editor (recommended) or other editor of your choice, and update or add content as needed according to the [file system layout](#file-system-layout-of-the-main-kogito-branch) requirements.

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

6. In your `kie-docs` fork in GitHub, create a pull request to merge your work branch with the  `main-kogito` branch in the upstream `kie-docs` repository.

    In your pull request, include the following components:
    * **Description**: Summarize your changes and include any links to JIRA tasks or document previews, if available
    * **Reviewers**: Assign two reviewers from the Apache KIE community. If you do not know who to assign ask on Zulip channels.

# Contributing to Apache KIE Kogito software

To contribute to Kogito software, see the [`incubator-kie-kogito-runtimes`](https://github.com/apache/incubator-kie-kogito-runtimes) repository in GitHub.
