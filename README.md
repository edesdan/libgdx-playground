# libgdx-playground
libgdx-playground allows you getting started with [ libGDX framework ] (https://github.com/libgdx/libgdx).
It can be used also as **template** to start developing a game.

The base project structure has been created with [ gdx-setup.jar UI ] (https://github.com/libgdx/libgdx/wiki/Project-Setup-Gradle).

After download/clone you can import it into your IDE ([Eclipse, Intellij IDEA, NetBeans, Commandline](https://github.com/libgdx/libgdx/wiki/Setting-up-your-Development-Environment-%28Eclipse%2C-Intellij-IDEA%2C-NetBeans%29)) :

 - To import in Eclipse: File -> Import -> Gradle -> Gradle Project
 - To import to Intellij IDEA: File -> Open -> build.gradle
 - To import to NetBeans: File -> Open Project...


Structure of the **core** project:

```

`-- src
    |-- com
    |   `-- libgdx
    |       `-- playground
    |           |-- Assets.java
    |           |-- PlaygroundMain.java
    |           `-- screens
    |               |-- AbstractGameScreen.java
    |               |-- DirectedGame.java
    |               |-- objects
    |               |   |-- AbstractGameObject.java
    |               |   |-- AbstractGameObjectWithPhysicsBody.java
    |               |   |-- LibgdxLogo.java
    |               |   `-- WaitingAnimation.java
    |               |-- PlaygroundScreen.java
    |               |-- transitions
    |               |   |-- ScreenTransitionFade.java
    |               |   |-- ScreenTransition.java
    |               |   |-- ScreenTransitionSlice.java
    |               |   `-- ScreenTransitionSlide.java
    |               `-- WaitingScreen.java


```

**PlaygroundMain.java** is the main class and it used as entry point for all projects (android,iOS,html,Desktop).
**PlagroundScreen.java** is the main screen and illustrate the use of the **AbstractGameScreen** class.
**WaitingScreen.java** is an example of a screen used to show a progress animation on the screen.
**LibgdxLogo.java** illustrate the use of the **AbstractGameObject** class. 
**Assets** is usefull to manage all assets (textures, sounds, music, skin files, ecc..): it handle loading, retrieving and disposing of your resources. 

## What's inside

Here are the list of feature, more will be added in the future:

 - a set of Screens that you can use in your game
 - 3 different kind of animation transitions between screens: *slice*, *fade*, *slide*
 - a sample screen (PlaygroundScreen) that demonstrate the use of objects, screen and transitions.
 - a pre-define Texture Packer that you can modify/extends in order to easily pack your image assets
 - an asset manager (Assets) used to loads and stores assets like textures, bitmapfonts, tile maps, sounds, music and so on.

## Contribute

If you want to request a specific feature you can open an issue, it will be evaluated and maybe implemented or you can submit a pull request.

If you want to collaborate to this project just let me know.
