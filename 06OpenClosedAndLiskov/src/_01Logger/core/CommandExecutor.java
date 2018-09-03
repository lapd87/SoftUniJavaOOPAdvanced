package _01Logger.core;

import _01Logger.interfaces.Appender;
import _01Logger.interfaces.Layout;
import _01Logger.interfaces.Log;
import _01Logger.models.logs.LogImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 19:10 ч.
 */
class CommandExecutor {

    private static final String APPENDERS_CLASS_PATH = "_01Logger.models.appenders.";
    private static final String LAYOUTS_CLASS_PATH = "_01Logger.models.layouts.";

    CommandExecutor() {
    }

    Appender createAppender(String[] args) {

        Appender appender = null;

        try {
            Class<?> commandClass = Class.forName(APPENDERS_CLASS_PATH
                    + args[0]);
            Constructor<?> declaredConstructor = commandClass
                    .getDeclaredConstructor(Layout.class);
            declaredConstructor.setAccessible(true);

            Layout layout = createLayout(args[1]);

            appender = (Appender) declaredConstructor
                    .newInstance(layout);

            if (args.length == 3) {
                appender.setReportLevelThreshold(args[2]);
            }
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return appender;
    }

    private Layout createLayout(String layoutName) {
        Layout layout = null;

        try {
            Class<?> commandClass = Class.forName(LAYOUTS_CLASS_PATH
                    + layoutName);
            Constructor<?> declaredConstructor = commandClass
                    .getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            layout = (Layout) declaredConstructor
                    .newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        return layout;
    }


    Log createLog(String[] logData) {
        return new LogImpl(logData[0], logData[1], logData[2]);
    }
}