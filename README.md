# GIS PROJECT AND PACKMAN GAME

# Description:
The project actually is about building gis infrastructure. 
The project includes some packages:

*Corods package - this package includes an interface class which called
"corods_convertor". Another class is MyCorods and it implements "corods_convertor".
Mycorod class is about converting points in space from meters to gps coordinates and back.
Some of the functions are:
Function that gets a number x and calculates the value of the
polynom at x.
Function that calcultae the distance in meters between two point.
Another function is: returning the azimuth of the point.
For more functions and explanations you are welcome to look at the
javadoc file which is attached to the project.


*GIS Package- this package contains 4 interfaces classes and 4 classes that inplement the interface classes.
--"GIS_element" interface: 
 This interface represents a GIS element with geometric representation and meta data such as:
 Orientation, color, string, timing...
 MyGisElement class implements "GIS_element" interface.
 --"GIS_layer" interface: 
 This interface  represent a collection of GisElements.
 This class has ArrayList of MyGisElements,  Data object and description of the layer.
 MyGisLayer class implements "GIS_layer" interface.
 For  functions and explanations you are welcome to look at the
javadoc file which is attached to the project.
--"GIS_project" interface: 
 This interface  represent a collection of GisLayers.
 This class has ArrayList of MyGislayers,  Data object and description of the layer.
 MyGisProject class implements "GIS_Project" interface.
 For  functions and explanations you are welcome to look at the
javadoc file which is attached to the project.
*JunitTest class that checks if the methos of the project are  corect.
--"Meta_Data" interface: 
 This interface  represent  meta-Data(information) about GIS objects
 This class has: utc - time-zone of GIS object,  utcName - time-zone location of GIS object (for example - Israel/jerusalem)
 and  ldt - correntTime  of GIS object.
 MetaData class implements "Meta_Data" interface.
 For  functions and explanations you are welcome to look at the
javadoc file which is attached to the project.
*JunitTest class that checks if the methos of the project are  corect.

# Explanations of assignment 3 (Packman game):
# Description:
The project actually is packman game that the the purpose of the game is the packmans will eat the fruit at the shortest time.
The project includes 3 main packages:
*Game Package: 
This package includes 6 classes:
1)Packman class- This class represent the object "packman". This object has speed, radius, location and etc. The goal of the packman is to eat all fruits in the shortest time.
2)Fruits class-This class represent the object "fruit". This object has location and id. The packman need to eat the fruit.
3)Csv To Game class- this class has to function talks about convertion csv file to list of fruit and packman.
4)Game class- this class contains two arraylist: list of packman and list of fruits. it represent game.
5)gameConverts class- this class is about converting object game to csv file and to kml file.
6)gameTest class- this class is junit tets class. it checks the correctness of the functions.

 *Gui package:
 1) Map class- This class  has two functions that converting pixeles cordinates to gps cordinates and gps cordinates to piexel cordinates.
 
 2)Gui class- This class is simply about showing the game in user graphic interface. The goal of the game is to eat all the packmans in the shortest time. You can run the game in 2 different ways. tou can add packmans and friut by clicking on the man and than you need to click "run game". The second option is to open the game from csv file by clicking on "Load file" and than click run.
 When you click run you can show the path each packman did to eat the fruits in the shortest time.
 Another option of the game is to export the game to kml file and to csv file by clicking "Export".
 There is another button calles "clear" that clear the screen.
 
 3)Main class- This is the class that runs the gui.

 




# Prerequisites:
Installation a workspace that works with java is needed.
You need to download the attached jar file called "jak".

# Running the tests:
A test file is attached to the project. You just need to run it.

# Built With:

Eclipse

# Authors:
Naor Eliav and Michael Garusi

# Acknowledgments:
In the project I used Wikipedia to write a number of functuations in
the class.
We used jak library for the converting to kml file.
We used wikipedia to understand what gis project is and sites like stackoverflow and and geeksforgeeks.
