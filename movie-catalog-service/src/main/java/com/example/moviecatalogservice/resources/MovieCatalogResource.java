package com.example.moviecatalogservice.resources;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		/*
		 * this works the same way as @RequestBody in spring api
		 * binds data to method in this case it binds json data to model
		 */
		RestTemplate restTemplate = new RestTemplate();
		
		
		List<Rating> ratings = Arrays.asList(
					new Rating("1",3),
					new Rating("2",5),
					new Rating("3",1)
				);
		
		return ratings.stream().map(rating -> {
			/*
			 * this is synchronous
			 * if you want to make it async you need to make everythin async
			 */
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/", Movie.class);
			/*
			 * this is using the resttemplate to map data for now this is hardcoded in
			 */
			return new CatalogItem(movie.getName(), "This is a show with 1 season", rating.getRating());
		
		})
				.collect(Collectors.toList());

	}

}
