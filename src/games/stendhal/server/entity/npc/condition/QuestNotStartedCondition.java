/* $Id: QuestNotStartedCondition.java,v 1.19 2013/10/10 19:53:55 nhnb Exp $ */
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
package games.stendhal.server.entity.npc.condition;

import static com.google.common.base.Preconditions.checkNotNull;
import games.stendhal.common.parser.Sentence;
import games.stendhal.server.core.config.annotations.Dev;
import games.stendhal.server.core.config.annotations.Dev.Category;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.entity.npc.ChatCondition;
import games.stendhal.server.entity.player.Player;

/**
 * Was this quest not started yet?
 */
@Dev(category=Category.IGNORE, label="NotStarted?")
public class QuestNotStartedCondition implements ChatCondition {

	private final String questname;

	/**
	 * Creates a new QuestNotStartedCondtion.
	 *
	 * @param questname
	 *            name of quest slot
	 */
	public QuestNotStartedCondition(final String questname) {
		this.questname = checkNotNull(questname);
	}

	@Override
	public boolean fire(final Player player, final Sentence sentence, final Entity entity) {
		return (!player.hasQuest(questname) || "rejected".equals(player.getQuest(questname, 0)));
	}

	@Override
	public String toString() {
		return "QuestNotStarted <" + questname + ">";
	}

	@Override
	public int hashCode() {
		return 45853 * questname.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof QuestNotStartedCondition)) {
			return false;
		}
		QuestNotStartedCondition other = (QuestNotStartedCondition) obj;
		return questname.equals(other.questname);
	}
}
