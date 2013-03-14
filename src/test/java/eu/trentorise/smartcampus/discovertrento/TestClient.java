package eu.trentorise.smartcampus.discovertrento;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.trentorise.smartcampus.dt.model.EventObject;
import eu.trentorise.smartcampus.dt.model.ObjectFilter;
import eu.trentorise.smartcampus.dt.model.POIObject;
import eu.trentorise.smartcampus.dt.model.StoryObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestClient {

	private static final String POI_OBJECT = "eu.trentorise.smartcampus.dt.model.POIObject";
	private static final String AUTH_TOKEN = "";
	@Autowired
	private DiscoverTrentoConnector discoverTrentoConnector;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void test() throws Exception {

		{
			// get all events
			List<EventObject> results = discoverTrentoConnector.getEventObjects(AUTH_TOKEN);
			Assert.assertNotNull(results);
			Assert.assertNotSame(0, results.size());
			System.out.println(results.size());

			// get one event
			EventObject result = discoverTrentoConnector.getEventObject(results.get(0).getId(), AUTH_TOKEN);
			Assert.assertNotNull(result);
			System.out.println(result.getTitle());
		}

		{
			// get all poi
			List<POIObject> results = discoverTrentoConnector.getPOIObjects(AUTH_TOKEN);
			Assert.assertNotNull(results);
			Assert.assertNotSame(0, results.size());
			System.out.println(results.size());

			// get one poi
			POIObject result = discoverTrentoConnector.getPOIObject(results.get(0).getId(), AUTH_TOKEN);
			Assert.assertNotNull(result);
			System.out.println(result.getTitle());
			
			// get all pois by filter
			ObjectFilter filter = new ObjectFilter();
			filter.setClassName(POI_OBJECT);
			Map<String, List<?>> results2 = discoverTrentoConnector.getObjects(filter, AUTH_TOKEN);
			Assert.assertNotNull(results2);
			Assert.assertNotSame(0, results.size());
			Assert.assertEquals(results.size(), results2.get(POI_OBJECT).size());			
			
			
			// get all pois in a radius
			filter.setCenter(new double[] { 46.072516,11.121082} );
			filter.setRadius(0.005);
			Map<String, List<?>> results3 = discoverTrentoConnector.getObjects(filter, AUTH_TOKEN);
			Assert.assertNotNull(results3);
			Assert.assertNotSame(0, results3.size());
			Assert.assertNotSame(results2.get(POI_OBJECT).size(), results3.get(POI_OBJECT).size());			
			System.out.println(results2.get(POI_OBJECT).size() + " -> " + results3.get(POI_OBJECT).size());
			
			POIObject result2 = discoverTrentoConnector.getPOIObject(((POIObject)results2.get(POI_OBJECT).get(0)).getId(), AUTH_TOKEN);
			Assert.assertNotNull(result);
			Assert.assertEquals(result.getTitle(), result2.getTitle());
			System.out.println(result2.getTitle());			
			
		}

		{
			// get all stories
			List<StoryObject> results = discoverTrentoConnector.getStoryObjects(AUTH_TOKEN);
			Assert.assertNotNull(results);
			Assert.assertNotSame(0, results.size());
			System.out.println(results.size());

			// get one story
			StoryObject result = discoverTrentoConnector.getStoryObject(results.get(0).getId(), AUTH_TOKEN);
			Assert.assertNotNull(result);
			System.out.println(result.getTitle());
			
		}		
		
		{
			// get all objects
			Map<String, List<?>> results = discoverTrentoConnector.getObjects(AUTH_TOKEN);
			Assert.assertNotNull(results);
			Assert.assertNotSame(0, results.size());
			for (String key: results.keySet()) {
				System.out.println(key + ": " + results.get(key).size());
			}
		}
	}

}
