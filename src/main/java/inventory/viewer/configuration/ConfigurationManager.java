package inventory.viewer.configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import inventory.viewer.InventoryViewer;

public class ConfigurationManager {
    private static String minecraftResourcePathString = InventoryViewer.mc.gameDirectory.getPath();
    public static void init() {
        registerConfigFile();
    }
    public static void registerConfigFile() {
        try {
            boolean resourcePathExists = new File(minecraftResourcePathString + "/inventoryviewer/coords.txt").exists();
            if(resourcePathExists) {
                System.out.println("File path exists, not creating.");
            } else {
                Path folder = Path.of(minecraftResourcePathString + "/inventoryviewer");
                Files.createDirectory(folder);
                Path config = folder.resolve("coords.txt");
                Files.writeString(config, "x:150\ny:150");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Integer> getPosCoords() {
        List<Integer> coordinates = new ArrayList<>();
        try {
            boolean resourcePathExists = new File(minecraftResourcePathString + "/inventoryviewer/coords.txt").exists();
            if(resourcePathExists) {
                Path config = Path.of(minecraftResourcePathString + "/inventoryviewer/coords.txt");
                List<String> lines = Files.readAllLines(config);
                int xCoordinate = Integer.parseInt(lines.get(0).replace("x:", ""));
                int yCoordinate = Integer.parseInt(lines.get(1).replace("y:", ""));
                coordinates.add(xCoordinate);
                coordinates.add(yCoordinate);
                // System.out.println(lines);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }
}
