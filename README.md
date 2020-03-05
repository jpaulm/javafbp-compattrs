# javafbp-compattrs

Function to build FBP-oriented Javadoc for FBP components (FBP is Flow-Based Programming)

## Viewing Component Attributes List for JavaFBP

This function will build Javadoc-style listing of FBP attributes for selected components.
 
You can display the current JavaFBP components list by clicking on http://htmlpreview.github.io/?https://github.com/jpaulm/javafbp/blob/master/compList.html then `Edit/Find in This Page` (unfortunately you cannot click on the `compList.html` file directly on GitHub).  

## Building Components Attributes List for selected component libraries

To build a Components Attributes List, run a `.bat` file referring to the program `JavaFBPCompAttrs`.  You will find a sample `.bat` file in the `dist` folder, as follows: 

    javadoc -doclet com.jpaulmorrison.doclets.JavaFBPCompAttrs -docletpath "build/libs/javafbp-compattrs-1.0.1.jar" -sourcepath  "C:/Users/Paul/Documents/GitHub/javafbp/src/main/java" com.jpaulmorrison.fbp.core.components.audio  com.jpaulmorrison.fbp.core.components.io  com.jpaulmorrison.fbp.core.components.misc  com.jpaulmorrison.fbp.core.components.routing  com.jpaulmorrison.fbp.core.components.swing  com.jpaulmorrison.fbp.core.components.text  com.jpaulmorrison.fbp.core.components.audio

The result will be in `<user>/temp/JavaFBPCompAttrs.html`.

