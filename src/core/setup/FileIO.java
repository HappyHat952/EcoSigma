package core.setup;

import java.io.*;

public class FileIO {

    private static final String SAVE_FILE = "output.txt";
    private static final int LEVEL_COUNT = 4;
    private boolean[] levelStatus = new boolean[LEVEL_COUNT];

    // NEW FILE
    public void createNewFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            for (int i = 1; i <= LEVEL_COUNT; i++) {
                writer.write("level " + i + ": not completed");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // READ FILE AND UPDATE LEVELS
    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line;
            int levelIndex = 0;

            while ((line = reader.readLine()) != null && levelIndex < LEVEL_COUNT) {
                String[] sections = line.split(": ");
                if (sections.length == 2) {
                    levelStatus[levelIndex] = sections[1].equals("completed");
                }
                levelIndex++;
            }
        } catch (FileNotFoundException e) {
            // MAKE A NEW FILE IF THERE ISN'T ONE
            createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CHANGES A LEVEL
    public void updateFile(int level) {
        levelStatus[level - 1] = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            for (int i = 0; i < LEVEL_COUNT; i++) {
                String status;
                if (levelStatus[i]) {
                    status = "completed";
                } else {
                    status = "not completed";
                }
                writer.write("level " + (i + 1) + ": " + status);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isEmpty() {
        for (boolean status : levelStatus) {
            if (status) {
                return false;
            }
        }
        return true;
    }

    public boolean isLevelCompleted(int level) {
        return levelStatus[level - 1];
    }
}
