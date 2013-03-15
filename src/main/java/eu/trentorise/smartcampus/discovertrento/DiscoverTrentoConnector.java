package eu.trentorise.smartcampus.discovertrento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

import eu.trentorise.smartcampus.discovertrento.util.HTTPConnector;
import eu.trentorise.smartcampus.discovertrento.util.HttpMethod;
import eu.trentorise.smartcampus.dt.model.EventObject;
import eu.trentorise.smartcampus.dt.model.ObjectFilter;
import eu.trentorise.smartcampus.dt.model.POIObject;
import eu.trentorise.smartcampus.dt.model.StoryObject;

/**
 * Class used to connect with the discover trento service.
 * 
 */
public class DiscoverTrentoConnector {

	private String discoverTrentoURL;

	private static final String DISCOVERTRENTOSERVICE = "/smartcampus.vas.discovertrento.web/";

	private static final String SEARCH_FILTER_PARAM = "filter";

	/**
	 * 
	 * @param serverURL
	 *          address of the server to connect to
	 */
	public DiscoverTrentoConnector(String serverURL) {
		this.discoverTrentoURL = serverURL + DISCOVERTRENTOSERVICE;
	}

	/**
	 * Return a list of all the events
	 * 
	 * @param token
	 *          an authorization token
	 * @return a list of events
	 * @throws DiscoverTrentoConnectorException
	 */
	public List<EventObject> getEventObjects(String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.EventObject/";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			List list = mapper.readValue(resp, List.class);
			List<EventObject> result = new ArrayList<EventObject>();
			for (Object o : list) {
				EventObject event = mapper.convertValue(o, EventObject.class);
				result.add(event);
			}

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return an event given its id
	 * 
	 * @param id
	 *          id of the event
	 * @param token
	 *          an authorization token
	 * @return an event
	 * @throws DiscoverTrentoConnectorException
	 */
	public EventObject getEventObject(String id, String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.EventObject/" + id;
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			EventObject result = mapper.readValue(resp, EventObject.class);

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return a list of all the POI
	 * 
	 * @param token
	 *          an authorization token
	 * @return a list of POI
	 * @throws DiscoverTrentoConnectorException
	 */
	public List<POIObject> getPOIObjects(String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.POIObject/";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			List list = mapper.readValue(resp, List.class);
			List<POIObject> result = new ArrayList<POIObject>();
			for (Object o : list) {
				POIObject event = mapper.convertValue(o, POIObject.class);
				result.add(event);
			}

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return a POI given its id
	 * 
	 * @param id
	 *          the id of POI
	 * @param token
	 *          an authorization token
	 * @return a POI
	 * @throws DiscoverTrentoConnectorException
	 */
	public POIObject getPOIObject(String id, String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.POIObject/" + id;
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			POIObject result = mapper.readValue(resp, POIObject.class);

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return a list of all the stories
	 * 
	 * @param token
	 *          an authorization token
	 * @return a list of stories
	 * @throws DiscoverTrentoConnectorException
	 */
	public List<StoryObject> getStoryObjects(String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.StoryObject/";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			List list = mapper.readValue(resp, List.class);
			List<StoryObject> result = new ArrayList<StoryObject>();
			for (Object o : list) {
				StoryObject event = mapper.convertValue(o, StoryObject.class);
				result.add(event);
			}

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return a story given its id
	 * 
	 * @param id
	 *          the story id
	 * @param token
	 *          an authorization token
	 * @return a story
	 * @throws DiscoverTrentoConnectorException
	 */
	public StoryObject getStoryObject(String id, String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "eu.trentorise.smartcampus.dt.model.StoryObject/" + id;
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			StoryObject result = mapper.readValue(resp, StoryObject.class);

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return some object, filtered 
	 * @param filter the filter to be applied
	 * @param token an authorization token
	 * @return a map, whose key are class names and whose values are lists of objects (events, poi, stories) of the class corresponding to the key
	 * @throws DiscoverTrentoConnectorException
	 */
	public Map<String, List<?>> getObjects(ObjectFilter filter, String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "objects/";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String filters = mapper.writeValueAsString(filter);
			// Map<String, Object> reqMap = mapper.convertValue(filter, Map.class);
			Map<String, String> reqMap = new TreeMap<String, String>();
			reqMap.put(SEARCH_FILTER_PARAM, filters);

			String resp = HTTPConnector.doGet(url, reqMap, "application/json", "application/json", token, "UTF-8");

			Map<String, List<?>> map = mapper.readValue(resp, Map.class);
			Map<String, List<?>> result = new TreeMap<String, List<?>>();
			for (String key : map.keySet()) {
				Class clazz = Thread.currentThread().getContextClassLoader().loadClass(key);
				List conv = new ArrayList();
				for (Object o : map.get(key)) {
					Object obj = mapper.convertValue(o, clazz);
					conv.add(obj);
				}
				result.put(key, conv);
			}

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

	/**
	 * Return all the objects
	 * @param token an authorization token
	 * @return a map, whose key are class names and whose values are lists of objects (events, poi, stories) of the class corresponding to the key
	 * @throws DiscoverTrentoConnectorException
	 */
	public Map<String, List<?>> getObjects(String token) throws DiscoverTrentoConnectorException {
		try {
			String url = discoverTrentoURL + "objects/simple";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = HTTPConnector.doGet(url, null, "application/json", "application/json", token, "UTF-8");

			Map<String, List<?>> map = mapper.readValue(resp, Map.class);
			Map<String, List<?>> result = new TreeMap<String, List<?>>();
			for (String key : map.keySet()) {
				Class clazz = Thread.currentThread().getContextClassLoader().loadClass(key);
				List conv = new ArrayList();
				for (Object o : map.get(key)) {
					Object obj = mapper.convertValue(o, clazz);
					conv.add(obj);
				}
				result.put(key, conv);
			}

			return result;
		} catch (Exception e) {
			throw new DiscoverTrentoConnectorException(e);
		}
	}

}
