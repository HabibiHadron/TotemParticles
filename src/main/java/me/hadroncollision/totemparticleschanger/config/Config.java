package me.hadroncollision.totemparticleschanger.config;

public class Config
{
    boolean doubleColor = true;
    int red1 = 0;
    int green1 = 0;
    int blue1 = 0;
    int red2 = 255;
    int green2 = 255;
    int blue2 = 255;

    public static Config instance = JsonOperations.loadConfigFromFile();

    public static boolean doubleColor() {
        return instance.doubleColor;
    }

    public static int getRed1Value() {
        return instance.red1;
    }

    public static int getGreen1Value() {
        return instance.green1;
    }

    public static int getBlue1Value() {
        return instance.blue1;
    }

    public static int getRed2Value() {
        return instance.red2;
    }

    public static int getGreen2Value() {
        return instance.green2;
    }

    public static int getBlue2Value() {
        return instance.blue2;
    }

}
