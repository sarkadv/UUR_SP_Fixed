package view;

import java.util.ArrayList;
import java.util.List;
import controller.MainWindowController;
import javafx.scene.layout.GridPane;
import model.Tile;
import util.TilePicker;

public class TileMenu extends GridPane {
	
	private ImageButton upBtn;
	private ImageButton downBtn;
	
	private ImageButton tileBtn1;
	private Tile tile1;
	private ImageButton tileBtn2;
	private Tile tile2;
	private ImageButton tileBtn3;
	private Tile tile3;
	
	private List<Tile> allTiles;
	private MainWindowController controller;
	private final int BTN_SIZE = 150;
	private boolean darkMode;
	private int currentFirst;
	private int activePlanet;
	
	public TileMenu(MainWindowController controller, ImageButton upBtn, ImageButton downBtn, int activePlanet) {
		this.upBtn = upBtn;
		this.downBtn = downBtn;
		
		this.darkMode = false;
		this.currentFirst = 3;
		this.activePlanet = activePlanet;
		
		this.controller = controller;
		
		if(this.darkMode == false) {
			this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapDay(activePlanet).values());
			this.allTiles.remove(TilePicker.getTile(80* activePlanet, activePlanet));
		}
		else {
			this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapNight(activePlanet).values());
			this.allTiles.remove(TilePicker.getTile(80 * activePlanet + 1, activePlanet));
		}
		
		tile1 = this.allTiles.get(currentFirst);
		tileBtn1 = new ImageButton(BTN_SIZE, BTN_SIZE, tile1.name, tile1.image);
		this.add(tileBtn1, 0, 0);
		
		tile2 = this.allTiles.get(currentFirst + 1);
		tileBtn2 = new ImageButton(BTN_SIZE, BTN_SIZE, tile2.name, tile2.image);
		this.add(tileBtn2, 0, 1);
		
		tile3 = this.allTiles.get(currentFirst + 2);
		tileBtn3 = new ImageButton(BTN_SIZE, BTN_SIZE, tile3.name, tile3.image);
		this.add(tileBtn3, 0, 2);
		
		this.init(currentFirst);
		
	}
	
	public void updateChoice() {
		removeHighlight();
		handleHighlight();
	}
	
	private void init(int currentFirst) {

		tile1 = this.allTiles.get(currentFirst);
		tileBtn1.setImage(tile1.image);
		tileBtn1.setName(tile1.name);
		
		tile2 = this.allTiles.get(currentFirst + 1);
		tileBtn2.setImage(tile2.image);
		tileBtn2.setName(tile2.name);
		
		tile3 = this.allTiles.get(currentFirst + 2);
		tileBtn3.setImage(tile3.image);
		tileBtn3.setName(tile3.name);
		
		this.handleHighlight();
		
		tileBtn1.setOnAction(e -> {
			controller.changeCurrentTile(e, tile1);
			this.handleHighlight();
		});
		
		tileBtn2.setOnAction(e -> {
			controller.changeCurrentTile(e, tile2);
			this.handleHighlight();
		});
		
		tileBtn3.setOnAction(e -> {
			controller.changeCurrentTile(e, tile3);
			this.handleHighlight();
		});
		
	}

	public void moveUp() {
		if(currentFirst > 0) {
			this.currentFirst--;
			init(currentFirst);
			
			if(!(currentFirst > 0)){
				upBtn.setDisable(true);
			}
			
			downBtn.setDisable(false);
		}
	}
	
	public void moveDown() {
		if(currentFirst < this.allTiles.size() - 3) {
			this.currentFirst++;
			init(currentFirst);
			
			if(!(currentFirst < this.allTiles.size() - 3)){
				downBtn.setDisable(true);
			}
			
			upBtn.setDisable(false);
		}
	}
	
	private void handleHighlight() {
		if(controller.getCurrentTile() != null) {
			if(controller.getCurrentTile().name.equals(this.tileBtn1.getName())) {
				tileBtn1.highlightImage();
				tileBtn2.imageBackToNormal();
				tileBtn3.imageBackToNormal();
			}
			else if(controller.getCurrentTile().name.equals(this.tileBtn2.getName())) {
				tileBtn2.highlightImage();
				tileBtn1.imageBackToNormal();
				tileBtn3.imageBackToNormal();
			}
			else if(controller.getCurrentTile().name.equals(this.tileBtn3.getName())) {
				tileBtn3.highlightImage();
				tileBtn1.imageBackToNormal();
				tileBtn2.imageBackToNormal();
			}
		}

	}
	
	private void removeHighlight() {
		tileBtn1.imageBackToNormal();
		tileBtn2.imageBackToNormal();
		tileBtn3.imageBackToNormal();
	}
	
	public void setDarkMode(boolean darkMode) {
		this.darkMode = darkMode;
		
		if(this.darkMode == false) {
			this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapDay(activePlanet).values());
			this.allTiles.remove(TilePicker.getTile(80* activePlanet, activePlanet));
		}
		else {
			this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapNight(activePlanet).values());
			this.allTiles.remove(TilePicker.getTile(80* activePlanet + 1, activePlanet));
		}
		
		this.init(currentFirst);
	}
	
	public void changePlanet(int newPlanet) {
		if(newPlanet != this.activePlanet) {
			if(this.darkMode == false) {
				this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapDay(newPlanet).values());
				this.allTiles.remove(TilePicker.getTile(80* newPlanet, newPlanet));
			}
			else {
				this.allTiles = new ArrayList<Tile>(TilePicker.getTileMapNight(newPlanet).values());
				this.allTiles.remove(TilePicker.getTile(80 * newPlanet + 1, newPlanet));
			}
			
			tile1 = this.allTiles.get(currentFirst);
			tileBtn1 = new ImageButton(BTN_SIZE, BTN_SIZE, tile1.name, tile1.image);
			this.add(tileBtn1, 0, 0);
			
			tile2 = this.allTiles.get(currentFirst + 1);
			tileBtn2 = new ImageButton(BTN_SIZE, BTN_SIZE, tile2.name, tile2.image);
			this.add(tileBtn2, 0, 1);
			
			tile3 = this.allTiles.get(currentFirst + 2);
			tileBtn3 = new ImageButton(BTN_SIZE, BTN_SIZE, tile3.name, tile3.image);
			this.add(tileBtn3, 0, 2);
			
			this.init(currentFirst);
			this.activePlanet = newPlanet;
		}
	}

}
