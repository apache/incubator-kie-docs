# Apache KIE Kogito documentation

<p align="center"><img width=55% height=55% src="_images/logos/kogitoLogo.png"_></p>

Kogito is a cloud-native business automation technology for building cloud-ready business applications. Kogito includes components that are based on well-known business automation projects in the Knowledge Is Everything (KIE) community, specifically [Drools](https://drools.org), [jBPM](https://jbpm.org), and [OptaPlanner](https://optaplanner.org), to offer dependable, open source solutions for business rules, business processes, and constraint solving.

As a Kogito user, developer, or technical writer, you can contribute to Kogito documentation by forking and cloning this repository, updating or adding content, and submitting a pull request for review.

Contents
=================

* [Required documentation tools](#required-documentation-tools)
* [File system layout of the `main-kogito` branch](#file-system-layout-of-the-main-kogito-branch)
* [Contributing to Kogito documentation](#contributing-to-kogito-documentation)
* [Contributing to Kogito software](#contributing-to-kogito-software)

# Required documentation tools

To work with the `apache/incubator-kie-docs` documentation source, you need the following software:

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

* **Apache Maven 3.9.6**: Used for building the KIE Apache (incubating) Kogito documentation. To install Maven on Fedora, CentOS, or RHEL, enter the following command in a command terminal (in Fedora, replace `yum` with `dnf`):

  ```
  # yum install maven
  ```

  For Windows, Mac OS X, and other Linux distributions, follow the instructions in the [Maven documentation](http://maven.apache.org/).

# File system layout of the `main` branch

The files in the `main` branch of the `apache/incubator-kie-docs` repository are organized in the following general structure:

```
├── _artifacts
├── _images
├── doc-content
    ├── apache-kie-kogito
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

## Summary of KIE documentation changes

# Contributing to Kogito documentation

For more information about these documentation changes or about contributing to this `incubator-kie-docs` documentation repository, see [community](https://kie.apache.org/docs/community/) information on our [kie.apache.org](https://kie.apache.org).

# Developing KIE Apache (incubating) Kogito documentation

For guidelines on contributing to a `KIE Apache (incubating)` development project, see [community](https://kie.apache.org/docs/community/) information on our [kie.apache.org](https://kie.apache.org).

**Prerequisites**
* You have installed the [required documentation tools](#required-documentation-tools).
* You have a basic understanding of [GitHub workflows](https://guides.github.com/introduction/flow/) and commands.
* You have a basic understanding of [AsciiDoc and Asciidoctor](https://asciidoctor.org/docs/) formatting and functionality.

**Procedure**

1. Fork the [`incubator-kie-docs`](https://github.com/apache/incubator-kie-docs/tree/main) repository in GitHub, and in a command terminal, clone your forked repository to a local directory and add a remote for the `upstream` repository.

    Cloning your fork:
    ```
    $ cd PATH_TO_REPO_DIRECTORY
    $ git clone git@github.com:USER_NAME/incubator-kie-docs.git
    ```

    Adding and verifying the upstream remote:
    ```
    $ git remote add upstream https://github.com/apache/incubator-kie-docs.git
    $ git remote -v
    origin git@github.com:jsmith/incubator-kie-docs.git (fetch)
    origin git@github.com:jsmith/incbuator-kie-docs.git (push)
    upstream https://github.com/apache/incubator-kie-docs.git (fetch)
    upstream https://github.com/apache/incubator-kie-docs.git (push)
    ```

2. Check out the `main` branch from your upstream remote and create a working branch based on that branch to begin making changes. You can name your branch based on a Github Issue that is related to this change.

    Creating your work branch:
    ```
    $ git checkout --track upstream/main
    $ git checkout -b Branch-name
    ```

3. Open your favourite text editor and update or add content as needed according to the [file system layout](#file-system-layout-of-the-main-branch) requirements.

4. After you complete and save your changes in your working branch, navigate to the top-level `incubator-kie-docs` directory in your local repository and enter the following commands to build the documentation locally and verify the generated preview in a web browser.

    Building and verifying the documentation:
    ```
    $ cd ~/incubator-kie-docs
    $ mvn clean install -Dfull
    [Build output]
    $ google-chrome doc-content/kogito-docs/target/generated-docs/html_single/index.html
      ```
    Replace `google-chrome` with the browser of your choice.

5. After you build and verify your changes, commit and push your branch to your fork in GitHub.

    Committing and pushing to your fork:
    ```
    $ cd ~/incubator-kie-docs #Recommended to move back "up" in the directory to ensure all modified files are staged and committed.
    $ git add --all
    $ git commit -m "kie-issues-444: Update section on DMN data types."
    $ git push -u origin kie-issues-444 #For first-time push, subsequently just `git push`
    ```

6. In your `incubator-kie-docs` fork in GitHub, create a pull request to merge your work branch with the  `main` branch in the upstream `incubator-kie-docs` repository.

    In your pull request, include the following components:
    * **Description**: Summarize your changes and include any links to JIRA tasks or document previews, if available
    * **Reviewers**: Assign two reviewers from the Apache KIE community. If you do not know who to assign ask on Zulip channels.

# Contributing to Apache KIE Kogito software

To contribute to Kogito runtime software & engine related code, see the [`incubator-kie-kogito-runtimes`](https://github.com/apache/incubator-kie-kogito-runtimes) repository in GitHub.

To contribute to Kogito applications, see the [`incubator-kie-kogito-apps`](https://github.com/apache/incubator-kie-kogito-apps) repository in GitHub.

To contribute to Kogito examples with no UI components, see the [`incubator-kie-kogito-examples`](https://github.com/apache/incubator-kie-kogito-examples).

To contribute to Kogito example featuring UI components, see the [`examples`](https://github.com/apache/incubator-kie-tools/tree/main/examples) at [incubator-kie-tools](https://github.com/apache/incubator-kie-tools/) repository in GitHub.
