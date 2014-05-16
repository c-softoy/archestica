/* $Id: BareBonesBrowserLaunchCommandsFactory.java,v 1.10 2013/04/22 22:22:23 kiheru Exp $ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.client.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Factory to create all known {@link SlashAction}s that open a specified URL in the browser
 * 
 * @author madmetzger
 */
class BareBonesBrowserLaunchCommandsFactory {
	
	private static Map<String, String> commandsAndUrls;
	
	private static void initialize() {
		commandsAndUrls = new HashMap<String, String>();
		commandsAndUrls.put("beginnersguide", "https://archestica.net/beginner_guide");
		commandsAndUrls.put("faq", "https://archestica.net/FAQ");
		commandsAndUrls.put("manual", "https://archestica.net/manual");
		commandsAndUrls.put("rules", "https://archestica.net/rules");
		commandsAndUrls.put("changepassword", "https://archestica.net/?id=content/account/changepassword");
		commandsAndUrls.put("loginhistory", "https://archestica.net/?id=content/account/loginhistory");
		commandsAndUrls.put("merge", "https://archestica.net/?id=content/account/merge");
		commandsAndUrls.put("halloffame", "https://archestica.net/?id=content/halloffame&filter=active&detail=overview");
	}

	/**
	 * creates {@link SlashAction}s for all in initialize specified values
	 * 
	 * @return map of the created actions
	 */
	static Map<String, SlashAction> createBrowserCommands() {
		initialize();
		Map<String, SlashAction> commandsMap = new HashMap<String, SlashAction>();
		for(Entry<String, String> entry : commandsAndUrls.entrySet()) {
			commandsMap.put(entry.getKey(), new BareBonesBrowserLaunchCommand(entry.getValue()));
		}
		return commandsMap;
	}

}
