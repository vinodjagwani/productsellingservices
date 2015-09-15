
package de.hybris.platform.productsellingservices;

import org.apache.log4j.Logger;


/**
 * Simple test class to demonstrate how to include utility classes to your webmodule.
 */
public class ProductsellingservicesWebHelper
{
	/** Edit the local|project.properties to change logging behavior (properties log4j.*). */
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ProductsellingservicesWebHelper.class.getName());

	public static final String getTestOutput()
	{
		return "testoutput";
	}
}
