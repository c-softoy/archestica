/* $Id: Blood2DView.java,v 1.29 2013/05/15 22:18:42 kiheru Exp $ */
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
package games.stendhal.client.gui.j2d.entity;

import games.stendhal.client.IGameScreen;
import games.stendhal.client.ZoneInfo;
import games.stendhal.client.entity.Blood;
import games.stendhal.client.entity.IEntity;
import games.stendhal.client.gui.styled.cursor.StendhalCursor;
import games.stendhal.client.sprite.Sprite;
import games.stendhal.client.sprite.SpriteStore;

import java.util.Map;

/**
 * The 2D view of blood.
 */
class Blood2DView extends StateEntity2DView<IEntity> {

	//
	// StateEntity2DView
	//

	/**
	 * Populate named state sprites.
	 * 
	 * @param entity
	 * @param map
	 *            The map to populate.
	 */
	@Override
	protected void buildSprites(IEntity entity, final Map<Object, Sprite> map) {
		final SpriteStore store = SpriteStore.get();
		ZoneInfo info = ZoneInfo.get();
		final Sprite tiles = store.getModifiedSprite("data/sprites/combat/blood_red.png",
				info.getZoneColor(), info.getColorMethod());

		final int theight = tiles.getHeight();
		int i = 0;

		for (int y = 0; y < theight; y += IGameScreen.SIZE_UNIT_PIXELS) {
			map.put(Integer.valueOf(i++), store.getTile(tiles, 0, y,
					IGameScreen.SIZE_UNIT_PIXELS,
					IGameScreen.SIZE_UNIT_PIXELS));
		}
	}

	/**
	 * Get the current entity state.
	 * 
	 * @param entity
	 * @return The current state.
	 */
	@Override
	protected Object getState(IEntity entity) {
		return ((Blood) entity).getAmount();
	}

	//
	// Entity2DView
	//

	/**
	 * Determines on top of which other entities this entity should be drawn.
	 * Entities with a high Z index will be drawn on top of ones with a lower Z
	 * index.
	 * 
	 * Also, players can only interact with the topmost entity.
	 * 
	 * @return The drawing index.
	 */
	@Override
	public int getZIndex() {
		return 2000;
	}

	@Override
	public boolean isInteractive() {
		return false;
	}

	@Override
	void entityChanged(final Object property) {
		super.entityChanged(property);

		if (property == Blood.PROP_AMOUNT) {
			proceedChangedState(entity);
		}
	}

	@Override
	public StendhalCursor getCursor() {
		return StendhalCursor.WALK;
	}
}
