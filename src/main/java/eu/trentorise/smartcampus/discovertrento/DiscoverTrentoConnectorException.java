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

/**
 * Exception thrown by {@link DiscoverTrentoConnector}
 *
 */
public class DiscoverTrentoConnectorException extends Exception {

	private static final long serialVersionUID = -6682965816616260202L;

	public DiscoverTrentoConnectorException() {
		super();
	}

	public DiscoverTrentoConnectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public DiscoverTrentoConnectorException(String message) {
		super(message);
	}

	public DiscoverTrentoConnectorException(Throwable cause) {
		super(cause);
	}

}
