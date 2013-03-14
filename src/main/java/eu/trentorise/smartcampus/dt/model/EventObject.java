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
package eu.trentorise.smartcampus.dt.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventObject extends BaseDTObject {

	/**
	 * Id of POI
	 */
	private String poiId;

	/**
	 * List containing the user id if attending, empty otherwise
	 */
	private List<String> attending = new ArrayList<String>();
	
	/**
	 * Number of attendees
	 */
	private Integer attendees = 0;
	
	public EventObject() {
		super();
	}

	public String getPoiId() {
		return poiId;
	}

	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}

	public List<String> getAttending() {
		return attending;
	}

	public void setAttending(List<String> attending) {
		this.attending = attending;
	}

	public Integer getAttendees() {
		return attendees;
	}

	public void setAttendees(Integer attendees) {
		this.attendees = attendees;
	}

	public static void filterUserData(EventObject event, String userId) {
		List<String> attending = event.getAttending();
		if (attending == null || attending.isEmpty()) return;
		if (attending.contains(userId)) event.setAttending(Collections.singletonList(userId));
		else event.setAttending(Collections.<String>emptyList());
	}

	public static void filterUserData(List<EventObject> events, String userId) {
		for (EventObject event : events) {
			filterUserData(event, userId);
		}
	}

}
