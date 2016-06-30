/**
 * 
 */
package com.cinemalytics.sdk.java;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cinemalytics.sdk.java.data.model.Movie;
import com.cinemalytics.sdk.java.repo.Cinemalytics;

/**
 * @author Arjit
 *
 */
public class MovieRepositoryTest extends TestCase {

	private final String testMovieId = "3b8b23f0";
	
	private final String testToken = "A97AB577D11D30C2EDF8274F16CD5B80";
	
	public void testGetMovieById() throws Exception {
		
		Cinemalytics cm = new Cinemalytics(testToken);
		Movie movie = cm.GetMovieRepositoryInstance().GetMovieById(testMovieId);		
		Assert.assertNotNull(movie);
		Assert.assertEquals(movie.getId(), testMovieId);
	}
}
