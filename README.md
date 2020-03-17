# javafbp-compattrs

Function to build FBP-oriented Javadoc for JavaFBP components (JavaFBP is [Java implementation of Flow-Based Programming](https://github.com/jpaulm/javafbp)

The standard Javadoc output is not very helpful for people looking to use JavaFBP components - hopefully this will result in a more informative display...!

## Building Components Attributes List for selected component libraries

To build a Components Attributes List, run a `.bat` file referring to the program `JavaFBPCompAttrs`.  The jar file can either be found in `build\libs` or in Releases.  You will find a sample `.bat` file in the `dist` folder, as follows: 

    javadoc -doclet com.jpaulmorrison.doclets.JavaFBPCompAttrs -docletpath "build/libs/javafbp-compattrs-1.0.1.jar" -sourcepath  "C:/Users/Paul/Documents/GitHub/javafbp/src/main/java" com.jpaulmorrison.fbp.core.components.audio  com.jpaulmorrison.fbp.core.components.io  com.jpaulmorrison.fbp.core.components.misc  com.jpaulmorrison.fbp.core.components.routing  com.jpaulmorrison.fbp.core.components.swing  com.jpaulmorrison.fbp.core.components.text
    
The result will be in `<user>/temp/JavaFBPCompAttrs.html`. 

