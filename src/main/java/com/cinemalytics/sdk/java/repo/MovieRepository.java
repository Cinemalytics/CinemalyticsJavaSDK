/**
 * 
 */
package com.cinemalytics.sdk.java.repo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cinemalytics.sdk.java.data.model.Actor;
import com.cinemalytics.sdk.java.data.model.Director;
import com.cinemalytics.sdk.java.data.model.FilmingLocation;
import com.cinemalytics.sdk.java.data.model.Movie;
import com.cinemalytics.sdk.java.data.model.MovieExtendedWithLinks;
import com.cinemalytics.sdk.java.data.model.Song;
import com.cinemalytics.sdk.java.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Arjit
 *
 */
public class MovieRepository {

	private static MovieRepository instance;

	private static String authToken = null;

	private static final Gson gson = new Gson();
	
	private MovieRepository() {
	}

	static MovieRepository Instance() {
		if (instance == null) {
			instance = new MovieRepository();
		}
		return instance;
	}

	void SetAuthToken(String authToken) {
		if (MovieRepository.authToken == null || MovieRepository.authToken.isEmpty()) {
			MovieRepository.authToken = authToken;
		}
	}

	/**
	 * Gets movie by id
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public Movie GetMovieById(String movieId) throws Exception {
		String url = "http://api.cinemalytics.in/v2/movie/id/" + movieId + "?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<Movie>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movie by title
	 * @param title
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetMovieByTitle(String title) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/title/?value=" + title + "&auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movies by year (release year)
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetMoviesByYear(int year) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/year/" + year + "/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movies released this week
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetReleasedThisWeekMovies() throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/releasedthisweek/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movies getting released on next Thursday/Friday
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetNextChangeMovies() throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/nextchange/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movies getting released in future
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetUpcomingMovies() throws Exception {
		String url = " http://api.cinemalytics.in/v2//movie/upcoming/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {
		}.getType();
		return gson.fromJson(jsonResponse, type);
	}
	
	/**
	 * Gets all songs for the movie
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public List<Movie> GetLatestTrailers() throws Exception {
		
		List<Movie> latestTrailers = new ArrayList<Movie>();
		String url = " http://api.cinemalytics.in/v2//movie/upcoming/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		List<Movie> upcomingMovies = gson.fromJson(jsonResponse, type);
		
		for(Movie m : upcomingMovies)
        {
            if (m.getTrailerLink() != null && !m.getTrailerLink().isEmpty())
            {                
            	latestTrailers.add(m);
            }            
        }
		
		return latestTrailers;
	}

	/**
	 * Gets all actors who were casted in the movie
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public List<Actor> GetActorsForMovie(String movieId) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/" + movieId + "/actors/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Actor>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets all directors for the movie
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public List<Director> GetDirectorsForMovie(String movieId) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/" + movieId + "/directors/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Actor>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets all filming locations for the movie
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public List<FilmingLocation> GetFilmingLocationsForMovie(String movieId) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/" + movieId + "/locations/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<FilmingLocation>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets all songs for the movie
	 * @param movieId
	 * @return
	 * @throws Exception 
	 */
	public List<Song> GetSongsForMovie(String movieId) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/" + movieId + "/songs/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Song>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}	

	/**
	 * Gets all movies' details with full movie links information for the
	 * @param genre
	 * @return
	 * @throws Exception 
	 */
	public List<MovieExtendedWithLinks> GetMoviesWithLinks(String genre) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/fullmovies/?genre=" + genre + "&auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<MovieExtendedWithLinks>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets movie details with full movie links information
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public MovieExtendedWithLinks GetMovieWithLinks(String id) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/" + id + "/fullmovies/?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<MovieExtendedWithLinks>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Adds rating for the movie
	 * @param ratingMetaJson
	 * @return
	 * @throws Exception 
	 */
	public String AddRating(String ratingMetaJson) throws Exception {
		String url = " http://api.cinemalytics.in/v2/movie/addrating/?auth_token=" + authToken;
		return UrlUtil.MakePostCall(url, ratingMetaJson);
	}
}
