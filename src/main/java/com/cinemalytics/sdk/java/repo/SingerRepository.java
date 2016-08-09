/**
 * 
 */
package com.cinemalytics.sdk.java.repo;

import java.lang.reflect.Type;

import com.cinemalytics.sdk.java.data.model.Singer;
import com.cinemalytics.sdk.java.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author arjit
 *
 */
public class SingerRepository {

	private static SingerRepository instance;

	private static String authToken = null;

	private static final Gson gson = new Gson();
	
	private SingerRepository() {
	}

	static SingerRepository Instance() {
		if (instance == null) {
			instance = new SingerRepository();
		}
		return instance;
	}

	void SetAuthToken(String authToken) {
		if (SingerRepository.authToken == null || SingerRepository.authToken.isEmpty()) {
			SingerRepository.authToken = authToken;
		}
	}
	
    /**
     * Gets singer by id
     * @param singerId
     * @return
     * @throws Exception 
     */
    public Singer GetSingerById(String singerId) throws Exception {
    	
        String url = "http://api.cinemalytics.in/v2/singer/id/" + singerId + "?auth_token=" + authToken;
        String jsonResponse = UrlUtil.MakeGetCall(url);

        Type type = new TypeToken<Singer>() {}.getType();
		return gson.fromJson(jsonResponse, type);
    }
    
    /**
     * Gets singer by id
     * @param singerId
     * @return
     * @throws Exception 
     */
    public Singer GetSingerByName(String name) throws Exception {
    	
        String url = "http://api.cinemalytics.in/v2/singer/name/" + name + "?auth_token=" + authToken;
        String jsonResponse = UrlUtil.MakeGetCall(url);

        Type type = new TypeToken<Singer>() {}.getType();
		return gson.fromJson(jsonResponse, type);
    }
}
