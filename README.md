# javafbp-compattrs

Function to build FBP-oriented Javadoc for JavaFBP components (JavaFBP is [Java implementation of Flow-Based Programming](https://github.com/jpaulm/javafbp)

## Building Components Attributes List for selected component libraries

To build a Components Attributes List, run a `.bat` file referring to the program `JavaFBPCompAttrs`.  You will find a sample `.bat` file in the `dist` folder, as follows: 

    javadoc -doclet com.jpaulmorrison.doclets.JavaFBPCompAttrs -docletpath "build/libs/javafbp-compattrs-1.0.1.jar" -sourcepath  "C:/Users/Paul/Documents/GitHub/javafbp/src/main/java" com.jpaulmorrison.fbp.core.components.audio  com.jpaulmorrison.fbp.core.components.io  com.jpaulmorrison.fbp.core.components.misc  com.jpaulmorrison.fbp.core.components.routing  com.jpaulmorrison.fbp.core.components.swing  com.jpaulmorrison.fbp.core.components.text  com.jpaulmorrison.fbp.core.components.audio

The result will be in `<user>/temp/JavaFBPCompAttrs.html`. At present, it is not very elegant, but work is underway on imporoving it in the near future!

