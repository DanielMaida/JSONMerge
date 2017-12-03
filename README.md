
JSONMerge
========

Copyright (c) 2016 by the Federal University of Pernambuco.

A semistructured merge tool for JSON files.

Contact Daniel Maida &lt;<dfm2@cin.ufpe.br>&gt;.

This project is based on the Guilherme Cavalcanti JFSTMerge tool.
(https://github.com/guilhermejccavalcanti/jFSTMerge/blob/master/build.gradle)

Compilation
-----------
This project uses Gradle to manage all dependencies and versioning. JAVA 8 is required.


#### Troubleshooting

If you face error while trying to build the project with gradle, just delete the lines from 10 to 13 of this [file](https://github.com/guilhermejccavalcanti/jFSTMerge/blob/master/build.gradle) .

Installation
-------------
#### Requisites

The instalation intregates the tool with GIT version control system. So, GIT must be installed and configured. Otherwise, you can run the tool [standalone](https://github.com/guilhermejccavalcanti/jFSTMerge#running-standalone).


#### Manual installation
1. Copy the [binary](https://github.com/DanielMaida/JSONMerge/blob/master/binary/jsons3m.jar) file to your `$HOME` folder
2. Add the following lines to your `.gitconfig` file (typically localized in the `$HOME` folder)
	```
    [core]
		attributesfile = ~/.gitattributes
	[merge "s3m"]
		name = semi_structured_3_way_merge_tool_for_java
		driver = java  -jar "\"$HOME/jsons3m.jar\"" -f %A %O %B -o %A -g
    ```
3. Add the following line to your `.gitattributes` file (also localized in the `$HOME` folder)
	
    `*.json merge=s3m`
    

Usage
-------------

Usage data (such as the number of detected conflicts, number of merged scenarios, and more useful details for studying the benefits and drawbacks of the tool) is stored in the `$HOME/.jfstmerge` folder.  A summary of collected statistics that might help one decide to continue using the tool is available in the `jfstmerge.summary` file.

#### Running with git

After installation, the tool is automatically integrated with git, with no need for further configuration. Then every time you invoke the `git merge` command, the tool is executed.
