/* $Id: Outfits.java,v 1.8 2013/07/10 19:21:44 nhnb Exp $ */
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
 * class to store the max outfit numbers for player available outfits.
 * @author kymara
 */
public class Outfits {

	/*
	 * Edit these fields to add new outfits.
	 * Note: Outfits are numbered starting at 0 and these
	 * variables are the total number of outfits.
	 */

	/** number of player selectable heads */
	public static final int HEAD_OUTFITS = 21;

	/** number of player selectable dresses */
	public static final int CLOTHES_OUTFITS = 57;

	/** number of player selectable hair styles */
	public static final int HAIR_OUTFITS = 44;

	/** number of player selectable body shapes */
	public static final int BODY_OUTFITS = 15;
}
