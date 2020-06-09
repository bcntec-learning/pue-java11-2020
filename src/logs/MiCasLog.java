package logs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MiCasLog {
    Logger logger = Logger.getLogger("MI_CASE");

    public MiCasLog(){


        logger.fine(()->"paso por aca");

        if(logger.isLoggable(Level.FINE)){
            logger.fine("paso por aca");
        }

    }
}
