/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package eu.trentorise.smartcampus.discovertrento;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
	private static final String EVENT_OBJECT = "eu.trentorise.smartcampus.dt.model.EventObject";
	private static final String AUTH_TOKEN = "";
	@Autowired
	private DiscoverTrentoConnector discoverTrentoConnector;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void testPoisDistance() throws Exception {

		{
			ObjectFilter filter = new ObjectFilter();
			filter.setClassName(POI_OBJECT);
			// get all pois in a radius
			filter.setCenter(new double[] { 46.072516,11.121082} );
			filter.setRadius(0.005);
			Map<String, List<?>> results3 = discoverTrentoConnector.getObjects(filter, AUTH_TOKEN);
			Assert.assertNotNull(results3);
			Assert.assertNotSame(0, results3.size());
			Assert.assertNotSame(results3.get(POI_OBJECT).size(), results3.get(POI_OBJECT).size());			
			System.out.println(results3.get(POI_OBJECT).size() + " -> " + results3.get(POI_OBJECT).size());
			
			POIObject result2 = discoverTrentoConnector.getPOIObject(((POIObject)results3.get(POI_OBJECT).get(0)).getId(), AUTH_TOKEN);
			Assert.assertNotNull(result2);
			System.out.println(result2.getTitle());			
			
		}
	}

	@Test
	public void testSearchPois() throws Exception {
		// get all pois by filter
		ObjectFilter filter = new ObjectFilter();
		filter.setClassName(POI_OBJECT);
		Map<String, List<?>> results2 = discoverTrentoConnector.getObjects(filter, AUTH_TOKEN);
		Assert.assertNotNull(results2);
		Assert.assertNotSame(0, results2.size());
		Assert.assertEquals(results2.size(), results2.get(POI_OBJECT).size());			
	}
	
	public void testPois() throws Exception {
		// get all poi
		List<POIObject> results = discoverTrentoConnector.getPOIObjects(AUTH_TOKEN);
		Assert.assertNotNull(results);
		Assert.assertNotSame(0, results.size());
		System.out.println(results.size());

		// get one poi
		POIObject result = discoverTrentoConnector.getPOIObject(results.get(0).getId(), AUTH_TOKEN);
		Assert.assertNotNull(result);
		System.out.println(result.getTitle());

	}
	
	/**
	 * @throws DiscoverTrentoConnectorException
	 */
	public void testStories() throws DiscoverTrentoConnectorException {
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
	}

	@Test
	public void testAllObjects() throws DiscoverTrentoConnectorException {
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

	@Test
	public void testEvents() throws DiscoverTrentoConnectorException {
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

	@Test
	public void testSearchEventsByText() throws DiscoverTrentoConnectorException {
		ObjectFilter filter = new ObjectFilter();
		filter.setClassName(EVENT_OBJECT);
//		filter.setText("test");
		filter.setSkip(0);
		filter.setLimit(5);
		
		SortedMap<String,Integer> map = new TreeMap<String, Integer>(); 
		map.put("fromTime", 1);
		filter.setSort(map);
		filter.setCriteria(new HashMap<String, Object>());
		filter.setFromTime(System.currentTimeMillis());
		Map<String, List<?>> results2 = discoverTrentoConnector.getObjects(filter, AUTH_TOKEN);
		Assert.assertNotNull(results2);
		Assert.assertNotSame(0, results2.size());
		for (EventObject eo : (List<EventObject>)results2.get(EVENT_OBJECT)) {
			System.err.println(eo.getTitle()+":"+new Date(eo.getFromTime()));
		}
	}
}
