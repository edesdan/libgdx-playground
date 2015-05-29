package com.libgdx.playground.desktop.utils;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;


public class PackAssets {
	private static boolean drawDebugOutline = false;

	private static final String filename = "game-ui-pack";
	private static final String filenameMenuUi = "menu-ui-pack";

	private static final boolean PACK_MENU_UI = true;
	private static final boolean PACK_GAME_UI = false;

	// private static final String dirSeparator = "/";

	/**
	 * Note: When loading files from the classpath, Eclipse usually will not reflect changes to files that are updated externally. 
	 * The project with the changed files must be manually refreshed in Eclipse. 
	 * During development files can be loaded through the filesystem instead, where this is not an issue.
	 * @param args
	 */
	public static void main(String[] args) {

		Settings settings = new Settings();
		settings.maxWidth = 2048;
		settings.maxHeight = 2048;
		settings.debug = drawDebugOutline;

		try {
			if (PACK_GAME_UI) {
				System.out.println("Packing game objects...");
				TexturePacker.process(settings, "assets-raw/ui_game/", "../android/assets/data/images/", filename);
			}
			if (PACK_MENU_UI) {
				System.out.println("Packing menu ui...");
				TexturePacker.process(settings, "assets-raw/ui_menu/", "../android/assets/data/images/", filenameMenuUi);
			}

		} catch (Exception e) {
			System.out.println("Exception!!!! " + e.getMessage());
		}
		System.out.println("Done!");

	}
}
