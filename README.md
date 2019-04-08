# Object Oriented Software Design
## Boom Sum - Assignment 1

[Our Game Rules](https://docs.google.com/document/d/1_wMhFzSuaV6x1I3Z5ugPdOIbmNKR9TzG59vx2J-8ob8/edit?usp=sharing)

[Java 11 SDK Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

#### Model
* Player
* BasePiece
  * ApplePiece
  * MicrosoftPiece
#### View
* MainScreen
* Board?
#### Controller
* Application
* Game

![alt text](https://koenig-media.raywenderlich.com/uploads/2016/06/MVC-feature.png "MVC")

#### Java
/usr/libexec/java_home

<!-- ![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/1024px-MVC-Process.svg.png "MVC2") -->

sam can push

#### Testing build commands:
* complile -> javac -d out src/game/Test.java src/game/Game.java src/game/board/Board.java src/game/board/cell/Cell.java src/game/board/cell/product/*.java 
* run      -> java -cp out game.Test

#### JDK versions
```shell
cd /Library/Java/JavaVirtualMachines/
ls
# set path
nano ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home
```

#### Compile
```shell
java -version
javac -version
# 11 or 12
```
```
# from root
cd OOSD
sudo chmod +x ./run.sh
./run.sh
```
