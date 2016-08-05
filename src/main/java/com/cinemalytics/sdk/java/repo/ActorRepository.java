/**
 * 
 */
package com.cinemalytics.sdk.java.repo;

import java.lang.reflect.Type;
import java.util.List;

import com.cinemalytics.sdk.java.data.model.Actor;
import com.cinemalytics.sdk.java.data.model.Movie;
import com.cinemalytics.sdk.java.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Arjit
 *
 */
public class ActorRepository {

	private static ActorRepository instance;
	private static String authToken = null;

	private static final Gson gson = new Gson();

	private ActorRepository() {
	}

	public static ActorRepository Instance() {
		if (instance == null) {
			instance = new ActorRepository();
		}
		return instance;
	}

	void SetAuthToken(String authToken) {
		if (ActorRepository.authToken == null || ActorRepository.authToken.isEmpty()) {
			ActorRepository.authToken = authToken;
		}
	}

	/**
	 * Gets actor by id
	 * @param actorId
	 * @return
	 * @throws Exception
	 */
	public Actor GetActorById(String actorId) throws Exception {

		String url = "http://api.cinemalytics.in/v2/actor/id/" + actorId + "?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<Actor>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets actor by name
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Actor GetActorByName(String name) throws Exception {
		String url = "http://api.cinemalytics.in/v2/actor/name/" + name + "?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<Actor>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Get all movies for actorId
	 * @param actorId
	 * @return
	 * @throws Exception
	 */
	public List<Movie> GetMoviesForActorById(String actorId) throws Exception {
		String url = "http://api.cinemalytics.in/v2/actor/" + actorId + "/movies?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}
}
