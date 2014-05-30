<h1> Federated Search Project </h1>

<h3> Author: Bianca Tesila </h3>

<h6> Requirements:</h6>
<ul>
	<li>JDK 1.7</li>
	<li>Maven</li>
	<li>MySQL- for caching purposes, run the createModel.sql script in order to get the used schema. </li>
</ul>

<h6>To run the application:</h6>
<li>Start the servers from the servers directory, following the instructions from the PDF files.</li>
<li> Open a browser and access localhost:8080/welcome</li>
<p> Pay attention to the fact that the search servers use the following ports:
<ul>
<li>localhost:8081</li>	
<li>localhost:8082</li>
<li>localhost:8083</li>
</ul>

<h6> Description: </h6>
This is kind of a federated search engine that receives users' queries related to tv series and forwards them to three different serves, merging the incoming results and displaying them to the user.

<h6> Implementation details:</h6>
<p>The application is developed using Spring MVC 3.0, thus following the MVC separation principle, JPA and Hibernate. From the point of view of the architectural analysis, I have chosen a layered design, packaging the sources according to the high cohesion and loose coupling standard development patterns. The layers communicates with each other through interfaces, fulfilling the OOP encapsulation principle.
</p>

<p>
	Whenever a user enters a search query, the MoviesController handles the get request with the query received as parameter and calls the search method of the SearchService interface, giving it as parameters the query and the user's session ID. Using threads allocated by the Spring Thread Pool Executor, the search service starts one thread for each server call and when it makes sure that there is no active thread, it merges the obtained result and gives it back to the controller, which sends them to the results view. All the results are stored in concurrent hash maps, using as keys the users' session IDs in order to not mix them up. Everytime the merged results are displayed to the corresponding user, all the results related to its session ID are deleted in order to not mix them up with further results during the same session.
</p>

<p>
For caching purposes, each time a new query arrives, the corresponding merged results are saved into a database. If, within a 15 minutes interval, another or the same user enters the same query, the results are not obtained by interrogating the servers again, but from the database records corresponding to that query. However, if the time interval exceeds 15 minutes, the servers are interrogated for recent results and the previous records corresponding to the query are removed, being replaced with the most recent ones.
</p>


<h6> What should be improved: </h6>
<p>
	First of all, even though I have chosen to cache the results into a relational database schema, I do not fulfill the normalization standards due to the various errors given by JPA. I am not content with the fact that each time I store results corresponding to a query, I may store duplicate tv series, genres, actors or episodes. I have tried to solve this matter, however I have encountered dependency issues as well as solutions  for them from which more problems have arosen.
</p>
<p>
	The response time really needs to be improved. Even though I use a thread pool, things get pretty messed up when there are a lot of server responses to be processed.
	</p>