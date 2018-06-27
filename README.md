# Triangle Challenge
Take home challenge to determine the type of triangle. (EQUILATERAL / ISOSCELES / SCALENE )

[Instructions](#instructions)<br>
[Implementation Details](#implementation-details)<br>
[Tests Results / Code Coverage](#test-results)<br>


# Instructions

1. Git clone the repository.
2. mvn clean install - to generate target resources.
3. mvn spring-boot:run (default port 8000 - optionally specify your own port with : -Dserver.port=YOUR_PORT_NUMBER ).<br>
   <b>Note</b> : you can also run this as a java application using : java -jar target/Triangle-Challenge-0.0.1-SNAPSHOT.jar.
4. Once Application is up and running , you can access the API end points using you localhost and port number.
   Example : http://localhost:8000/swagger-ui.html  ( change port number if required )
5. Test API Results.
6. Included Jacoco dependency if you want to check code coverage metrics.
7. Also Included a Bash script to test rest end points , you can use that to run as bash script if required.

# Implementation Details

using Java + Spring boot to implement this challenge simply because spring boot is easy to setup and offers a wide variety of features for building services and web applications.

Application Exposes 2 APIs
- getTriangleType :
  takes an array of doubles and returns 
      EQUILATRAL / ISOCELES / SCALENE based on sides.
      INVALID if the given triangle does not satifies properties of a triangle
      Unsupported Shape Exception if size of sides array > 3.
      
-isValidTriangle
  takes an array of doubles and returns 
      true if valid triangle
      false if not.
      
If needed the solution can be easily extended to any shape by
 - Implementing the shape interface if any shape other than a polygn Eg: circle , ellipse etc.
 - Extending the Polygon Abstract class for any n-sided polygon Eg: square hexagon etc.
 
 ShapeFactory can be modified to support other shapes.
 PolygonFactory can be modified to support other polygons.
 
  


 




# Test Results

