package py.consultores.utils;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
//import javax.persistence.EntityManager;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
/**
 *
 * @author cbustamante
 */
public class LoggerGx
{
   
   public static Logger logger = Logger.getLogger("logvideoclub");
    public LoggerGx()         
    {
             
        Properties log4jProperties = new Properties();
        log4jProperties.setProperty("log4j.rootLogger", "ERROR, gxlogs");
        log4jProperties.setProperty("log4j.rootLogger", "INFO, gxlogs");
        log4jProperties.setProperty("log4j.appender.gxlogs", "org.apache.log4j.DailyRollingFileAppender");
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        log4jProperties.setProperty("log4j.appender.gxlogs.File", "/opt/logs/logs.log");
        log4jProperties.setProperty("log4j.appender.gxlogs.DatePattern", ".yyyy-MM-dd");
        //log4jProperties.setProperty("log4j.appender.gxlogs.DatePattern", "drv/'.'mtsnpi.log");
        //log4jProperties.setProperty("log4j.appender.gxlogs.ImmediateFlush", "true");
        //log4jProperties.setProperty("log4j.appender.gxlogs.Threshold", "debug");
        //log4jProperties.setProperty("log4j.appender.gxlogs.Append", "true");
        log4jProperties.setProperty("log4j.appender.gxlogs.layout", "org.apache.log4j.PatternLayout");
        log4jProperties.setProperty("log4j.appender.gxlogs.layout.ConversionPattern", "%d|%-5p|%m%n");        
        log4jProperties.setProperty("log4j.appender.gxlogs.rollingFile.File", "%d{yyyy-MM-dd}_logs.log.gz");
        log4jProperties.setProperty("log4j.appender.gxlogs.rollingFile.MaxFileSize", "2MB");
        //log4j.appender.FILE.ImmediateFlush=true
        //log4jProperties.setProperty("log4j.rootLogger", "INFO, gxlogs");
       
      
        PropertyConfigurator.configure(log4jProperties);
       

        logger.debug("debug message");
        logger.info(" Inicio de actividades en log");
       //  LoggerGx  test = new LoggerGx();
       //test.makeLog();
    }  
    public static void log(String log)
    {
        logger.info("INF |"+ log);
    }
}
