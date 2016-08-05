/**
 * 
 */
package com.cinemalytics.sdk.java.repo;

import java.lang.reflect.Type;
import java.util.List;

import com.cinemalytics.sdk.java.data.model.Director;
import com.cinemalytics.sdk.java.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Arjit
 *
 */
public class DirectorRepository {

	private static DirectorRepository instance;

	private static String authToken = null;

	private static final Gson gson = new Gson();
	
	private DirectorRepository() {
	}

	static DirectorRepository Instance() {
		if (instance == null) {
			instance = new DirectorRepository();
		}
		return instance;
	}

	void SetAuthToken(String authToken) {
		if (DirectorRepository.authToken == null || DirectorRepository.authToken.isEmpty()) {
			DirectorRepository.authToken = authToken;
		}
	}
	
	/**
	 * Gets actor by id
	 * @param directorId
	 * @return
	 * @throws Exception
	 */
    public Director GetDirectorById(String directorId) throws Exception {
    	
        String url = "http://api.cinemalytics.in/v2/director/id/" + directorId + "?auth_token=" + authToken;
        String jsonResponse = UrlUtil.MakeGetCall(url);

        Type type = new TypeToken<Director>() {}.getType();
		return gson.fromJson(jsonResponse, type);
    }

    /**
     * Gets actor by name
     * @param name
     * @return
     * @throws Exception
     */
    public Director GetDirectorByName(String name) throws Exception {
    	
        String url = "http://api.cinemalytics.in/v2/director/name/" + name + "?auth_token=" + authToken;
        String jsonResponse = UrlUtil.MakeGetCall(url);

        Type type = new TypeToken<Director>() {}.getType();
		return gson.fromJson(jsonResponse, type);
    }

    /**
     * Get all movies for directorId
     * @param directorId
     * @return
     * @throws Exception
     */
    public List<Director> GetMoviesForDirectorById(String directorId) throws Exception {
    	
        String url = "http://api.cinemalytics.in/v2/director/" + directorId + "/movies?auth_token=" + authToken;
        String jsonResponse = UrlUtil.MakeGetCall(url);

        Type type = new TypeToken<List<Director>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
    }
}