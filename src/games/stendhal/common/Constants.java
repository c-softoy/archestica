/* $Id: Constants.java,v 1.10 2014/01/18 18:23:06 kiheru Exp $ */
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
package games.stendhal.common;

/**
 * Constants about slots
 */
public final class Constants {
	/**
	 * All the slots considered to be "with" the entity. Listed in priority
	 * order (i.e. bag first).
	 */
	// TODO: let the slots decide that themselves
	public static final String[] CARRYING_SLOTS = { "bag", "head", "rhand",
			"lhand", "armor", "finger", "cloak", "legs", "feet", "keyring", "back", "belt" };

}
