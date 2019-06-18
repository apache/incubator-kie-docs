# Important update: August 31, 2018

On August 31, 2018, this `kie-docs` repository that contains KIE community and Red Hat Business Automation documentation was updated to enable shared content between KIE community and Red Hat Business Automation enterprise documentation, to remove obsolete content, and to prepare for an improved content building tool coming soon (Aura).

**To get the latest changes made to this `kie-docs` repository,** delete your local `kie-docs` master branch, pull the new `kie-docs` master to your cloned repository, and force push to your fork:

```
$ cd ~/kie-docs/
$ git checkout <branch-other-than-master>
$ git branch -d master
$ git fetch --all
$ git checkout --track <upstream-repo-name>/master
$ git push --set-upstream <fork-name> master
```

**WARNING:** Do not rebase your existing master branch against `kie-docs` master branch to get the latest updates. The new master is substantially restructured, so rebasing creates extensive conflicts that, even when resolved, can introduce errors into the new structure.

**To access legacy content from the former master branch,** use the branch `backup-master-2018.08.31`.

## Summary of KIE documentation changes

Note the following changes that apply to KIE community documentation as a result of the repository update:

* **New `kie-docs` repository structure:** The `kie-docs` repository has been restructured to prepare for an improved content building tool coming soon (Aura) and to enable shared content between KIE community and Red Hat Business Automation enterprise documentation. Within the `doc-content` directory, the community `drools-docs`, `jbpm-docs`, and `optaplanner-wb-es-docs` folders continue to be in a Maven structure as before that supports a `mvn clean install -Dfull` build. All content files in community folders are or can now be used in enterprise assembly builds from the `assemblies` folder for the Red Hat Customer Portal. Content files in the `enterprise-only` folder either apply only to Red Hat Business Automation products or are files that have not yet been reconciled with community content. Each content folder contains sub-directories divided roughly by subject matter.
* **Centralized `_images` directory:** Going forward, save all new images to only the central `kie-docs/_images` directory instead of in separate sub-directories within the community content folders. Existing images have been moved already, or deleted if unused. Any images that you save outside of that central images folder will not be rendered in the output.
* **Removed `:imagesdir:` declaration in modules:** Going forward, do not specify an `:imagesdir:` declaration in any module files or in any KIE community `index.adoc` assembly files. The images directory specification is now configured globally in the KIE community project `pom.xml` settings, and directs to the central `kie-docs/_images` directory. Only Red Hat Business Automation `main.adoc` assembly files require an `:imagesdir:` specification.

For more information about these documentation changes or about contributing to this `kie-docs` documentation repository, see [Contributing to KIE documentation](https://redhat-documentation.github.io/doc-guidelines/bpm/).

# Developing Drools and jBPM

For guidelines on contributing to a `kiegroup` development project, see [droolsjbpm-build-bootstrap/README.md](https://github.com/kiegroup/droolsjbpm-build-bootstrap/blob/master/README.md).

For guidelines on contributing to this `kie-docs` documentation repository, see [Contributing to KIE documentation](https://redhat-documentation.github.io/doc-guidelines/bpm/).
