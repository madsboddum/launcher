/***********************************************************************************
 * Copyright (C) 2018 /// Project SWG /// www.projectswg.com                       *
 *                                                                                 *
 * This file is part of the ProjectSWG Launcher.                                   *
 *                                                                                 *
 * This program is free software: you can redistribute it and/or modify            *
 * it under the terms of the GNU Affero General Public License as published by     *
 * the Free Software Foundation, either version 3 of the License, or               *
 * (at your option) any later version.                                             *
 *                                                                                 *
 * This program is distributed in the hope that it will be useful,                 *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of                  *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                   *
 * GNU Affero General Public License for more details.                             *
 *                                                                                 *
 * You should have received a copy of the GNU Affero General Public License        *
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.          *
 *                                                                                 *
 ***********************************************************************************/

package com.projectswg.launcher.core.resources.gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class CardContainer extends FlowPane {
	
	public CardContainer() {
		
	}
	
	public void clearCards() {
		getChildren().clear();
	}
	
	public void addCard(Card card) {
		widthProperty().addListener((obs, prev, next) -> card.setPrefWidth(createCardSize(next.doubleValue())));
		heightProperty().addListener((obs, prev, next) -> card.setPrefHeight(createCardSize(next.doubleValue())));
		card.setPrefWidth(createCardSize(getWidth()));
		card.setPrefHeight(createCardSize(getHeight()));
		getChildren().add(card);
		Platform.runLater(this::applyCss);	// Ensures CSS is applied for contained elements
	}
	
	private static double createCardSize(double max) {
		int count = (int) (max / 300);
		if (count <= 0)
			count = 1;
		return (int) ((max - (count-1)*10) / count - 0.5);
	}
	
}