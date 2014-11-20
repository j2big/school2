/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author jafolabi
 */
public class schoolLog {

    Logger schlog = Logger.getLogger("schlog");
    FileHandler fh;

    public void log() {
        try {
            fh = new FileHandler("database/school2.txt");
            schlog.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException se) {
            se.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void logInfo(String info_message) {
        schlog.info(info_message);
    }

    public void logSevere(String severe_message) {
        schlog.severe(severe_message);
    }

    public void logWarning(String warning_message) {
        schlog.severe(warning_message);
    }

    public void logConfig(String config_message) {
        schlog.severe(config_message);
    }

    public void logFine(String fine_message) {
        schlog.severe(fine_message);
    }

    public void logFiner(String finer_message) {
        schlog.severe(finer_message);
    }

    public void logFinest(String finest_message) {
        schlog.severe(finest_message);
    }

}
