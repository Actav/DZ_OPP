package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final String LOG_FILE_PATH = "actionLog.log";
    private static List<String> logBuffer = new ArrayList<>();

    public static void writeToLog(String message) {
        logBuffer.add(message);

        if (logBuffer.size() >= 10) {
            flushBuffer();
        }
    }

    protected static synchronized void flushBuffer() {
        try {
            FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String message : logBuffer) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            logBuffer.clear();
            boolean bufferFull = false;

            System.out.println("Сообщения записаны в лог-файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
