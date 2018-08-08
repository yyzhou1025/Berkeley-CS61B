package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 60;

    //in order to create random land
    private static final Random RANDOM = new Random();

    //create small hexagon
    public static void addHexagon(TETile[][] tiles, TETile type, int px, int py, int side){
        int hight = side * 2;
        int upperPy = py - hight + 1;
        int eachWidth = side;
        for(int i = 0; i < side; i ++){
            addLine(tiles, type, px, py, eachWidth);
            addLine(tiles,type, px, upperPy,  eachWidth);
            py -= 1;
            upperPy += 1;
            px -=1;
            eachWidth +=2;
        }

    }

    //create small line
    public static void addLine(TETile[][] tiles, TETile type, int px, int py, int side){
        for(int i = 0; i < side; i++){
            tiles[px][py]=type;
            px += 1;
        }
    }

    //random land
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(7);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            case 3: return  Tileset.GRASS;
            case 4: return Tileset.MOUNTAIN;
            case 5: return Tileset.SAND;
            case 6: return  Tileset.WATER;
            default: return Tileset.FLOWER;
        }
    }

    //create  oblique  random hexagons line
    public static void  obHexagons(TETile[][] tiles, int px, int py, int side, int hexagon){
        for(int i = 0; i < hexagon; i++){
            addHexagon(tiles, randomTile() ,px, py, side);
            px += (side*2 - 1);
            py -= side;
        }
    }

    //create hexagon world
    public static void hexagonWorld(TETile[][] tiles, int px, int py, int side, int hexagonSide){
        int hexagon =hexagonSide;
        for(int i = 0; i < hexagonSide; i++){
            obHexagons(tiles, px, py,side, hexagon);
            px -= (side*2 - 1);
            py -= side;
            hexagon += 1;
        }
        hexagon -= 1;
        px+=(side*2 - 1);
        py-=side;

        for(int j = 0; j < hexagonSide-1; j++){
            hexagon -= 1;
            obHexagons(tiles, px, py,side, hexagon);
            px -= 0;
            py -= (side*2) ;
        }
    }

    public static void main(String[] args){
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        hexagonWorld(world, 60,50,3, 3);
        ter.renderFrame(world);

    }

}