# Eclipse XWT

## Project description

Eclipse XWT is a powerful declarative UI in XML for Eclipse. It is a thin layer
of markup language by unifying Eclipse SWT/JIFace and Eclipse JFace Databinding
in one. It simplifies the UI development in Eclipse and open a door to provide
more tools such as: Visual editing using Windows Builder Model Driven UI.
Papyrus uses XWT to generate the "Properties View" for UML model editing.

* https://projects.eclipse.org/projects/technology.xwt

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and/or testing purposes.

### Prerequisites

The things you need before installing the software.

* Select an update site from the [latest releases] (https://projects.eclipse.org/projects/modeling.mdt.papyrus/downloads).
* Choose the Eclipse IDE compatible with the selected relase from the [latest releases] (https://www.eclipse.org/eclipseide/). If you do not see the required release, you can select previous ones by clicking on 'other packages'.
* The latest compatible version of the Eclipse IDE (you can see the latest published release [here] (https://projects.eclipse.org/projects/technology.xwt).
* A current version of Java 1.5. Openjdk is preferable but not required. 

### Installation

In order to install the software you will have to open the downloaded IDE and install it via the integrated installer.

```
$ Open the Help menu of your selected IDE.
$ Go to Install New Software.
$ Enter the URL of the selected Papyrus update site in the 'Work with' field and select the features to install. The default one is Papyrus for UML that will give you access to the tool.
$ Click on Next; the installer will automatically compute the required dependencies from the urls available.
$ Accept the licences of the tools you want to install and click on finish. You will need to restart the IDE to finalize the installation.
```

## Compile

XWT is meant to be compiled with maven. To do so you will need to fetch the git repository. It can be found [here] (https://git.eclipse.org/r/plugins/gitiles/xwt/org.eclipse.xwt/)

### Usefull commands

```
$ mvn clean verify
```

## Contributing

You can contribute to the Eclipse XWT project via [Gerrit] (https://git.eclipse.org/r/q/project:xwt/org.eclipse.xwt). 
If you are interested, you can see a detailed sequence in [this page] (https://wiki.eclipse.org/Gerrit).
Contributions should be done based on the master branch in order to be automatically verified by its associated Jenkins job. 


## Additional Documentation and Acknowledgments

* Mailing list: https://dev.eclipse.org/mailman/listinfo/xwt-dev