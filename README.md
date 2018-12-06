# GIS PROJECT

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
