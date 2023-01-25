# kagraph

A graph library. 

Original purpose is to renew acquaintance with Java programming.  

State as of 25.01.2023

Defines the following basic types

   * __Vertex__ - any node that can fit into a graph, hold a type and connect with other vertices holding a similar type.  Edges to other vertexes are stored as a Set in each Vertex instance. 
   * __Graph__ - A collection of vertices.  
   * __Grid__ - a two dimensional graph where vertices have edges to nearest neighbors in both dimensions. Note that implementations of other graph structures (cylinder, cube, etc.) are possible.  
   * __Cell__ - Something that can transform itself for a vertex to hold.
   * __VertexCell__ - Cell with a reference to the Vertex that contains it. Useful in transformations based on neighboring states. 
   * __Factories__ - to help instantiate and manage the above. 

### TODO

   * Refactor so that... 
      * Remove unused resources
       
   * Scripts for building and joining the two projects
   * Scripts for continuous testing. 
   * Clean everything up
   * More and better tests
   
## Maven

Basic lifecycle phases are supported. 

   * `mvn test` - runs the unit tests
   * `mvn compile` - build to `target` directory   
   * `mvn package` - make `kagraph-0.0.1-SNAPSHOT.jar` . 
   * `mvn install` - install the jar file to the local maven repo.  
   
