/**
 * 
 */
package de.hybris.platform.productsellingservices.service;

import de.hybris.platform.spring.security.CoreUserDetails;


/**
 * @author VJA
 * 
 */
public interface ProductSellingUserService
{
	CoreUserDetails loadUserByUsername(final String username);
}
