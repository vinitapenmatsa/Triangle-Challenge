# Triangle Challenge
Take home challenge to determine the type of triangle. (EQUILATERAL / ISOSCELES / SCALENE )

[Instructions](#instructions)<br>
[Implementation Details](#implementation-details)<br>
[Tests Results / Code Coverage](#test-results)<br>


# Instructions

1. Git clone the repository.<br>
2. mvn clean install - to generate target resources.<br>
3. mvn spring-boot:run (default port 8000 - optionally specify your own port with : -Dserver.port=YOUR_PORT_NUMBER ).<br>
   <b>Note</b> : you can also run this as a java application using : java -jar target/Triangle-Challenge-0.0.1-SNAPSHOT.jar.
4. Once Application is up and running , you can access the API end points using you localhost and port number.
   Example : http://localhost:8000/swagger-ui.html  ( change port number if required )
5. Test API Results.
6. Included Jacoco dependency if you want to check code coverage metrics.
7. Also Included a Bash script to test rest end points , you can use that to run as bash script if required.

# Implementation Details

using Java + Spring boot to implement this challenge simply because spring boot is easy to setup and offers a wide variety of features for building services and web applications.<br>

Application Exposes 2 APIs<br>
- getTriangleType :<br>
  takes an array of doubles and returns <br>
      - EQUILATRAL / ISOCELES / SCALENE based on sides.<br>
      - INVALID if the given triangle does not satify properties of a triangle<br>
      - Unsupported Shape Exception if size of sides array > 3.<br>
      
- isValidTriangle<br>
  takes an array of doubles and returns <br>
      - true if valid triangle<br>
      - false if not.<br>
      - Unsupported Shape Exception if size of sides array > 3.<br>
      
If needed the solution can be easily extended to any shape by
 - Implementing the shape interface if any shape other than a polygon Eg: circle , ellipse etc.<br>
 - Extending the Polygon Abstract class for any other n-sided polygon Eg: square , hexagon etc.<br>
      * Certain common functions have been included in polygon abstract class Eg : getNumberOfSides , isEquilateral etc. More functions like isCyclic , isRectilinear can be added if required.
 
 - ShapeFactory can be modified to support other shapes.<br>
 - PolygonFactory can be modified to support other polygons.<br>
 
 For the sake of keeping it simple  , the following concepts have been considered out of scope.
 1. Rest API authentication
 2. Degenerate Triangles

# Test Results

Application includes jaCoCo dependency. After running mvm clean install , test coverage reports can be seen using /target/site/jacoco/index.html. Also including a screenshot of local test coverage results.

![image](https://user-images.githubusercontent.com/40624041/41991600-9c8f1b14-7a63-11e8-9919-7c7e695fdf58.png)

