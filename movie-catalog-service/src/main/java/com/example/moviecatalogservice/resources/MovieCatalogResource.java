package com.example.moviecatalogservice.resources;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	@Autowired
	private WebClient.Builder webClientBuilder;*/
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		/*
		 * similar to restTemplate with builder
		 */
		//WebClient.Builder builder = WebClient.builder();
		
		/*
		 * this works the same way as @RequestBody in spring api
		 * binds data to method in this case it binds json data to model
		 */
		
		// dont hard code urls, find out how to not do that later
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
		
		// now unwrap it with stream
		return ratings.getUserRating().stream().map(rating -> {
			/*
			 * this is synchronous
			 * if you want to make it async you need to make everythin async
			 */
			// this is removed when using builder, used with restTempalte
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
				
			return new CatalogItem(movie.getName(), "This is a show with 1 season", rating.getRating());
		
		}).collect(Collectors.toList());

	}

}



// this is what RestTemplate is being replaced with in the coming future
/*Movie movie = webClientBuilder.build()
.get()
.uri("http://localhost:8082/movies/" + rating.getMovieId())
.retrieve()
.bodyToMono(Movie.class) // what body paas in convert to this class, async promise 
.block();*/

/*
 * this is using the resttemplate to map data for now this is hardcoded in
 */