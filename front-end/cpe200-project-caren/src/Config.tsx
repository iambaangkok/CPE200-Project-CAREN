import Vector2 from "./classes/Vector2";

class Config{
    public static SERVER_URL = "http://localhost:8080";

    public static COLOR_LIGHTBLUE = "#92E8C0";
    public static COLOR_CREAMWHITE = "#F5FFE8";
    public static COLOR_BRIGHTRED = "#E64539";
    public static COLOR_MIDNIGHTBLACK = "#181d33";
    public static COLOR_BONEWHITE = "#dfe0e8";
    public static COLOR_MIDGRAYBLUE = "#686f99";
    public static COLOR_MEDIUMDIMMEDBLUE = "#4c6885";

    public static FPS = 30;
    public static FETCH_INTERVAL_SECONDS = 1;

    public static SCREEN_WIDTH = 1920;
    public static SCREEN_HEIGHT = 1080;

    public static SCANNER_CENTER = {x: 605, y : 360} as Vector2
    public static SCANNER_RADIUS = 315;

    public static ZOOM_MIN_SCALE = 1;
    public static ZOOM_MAX_SCALE = 3;
    public static ZOOM_SCALE_STEP = 0.002;
    
    public static CANVAS_SCALE = 0.6666667; // scale relative to SCREEN_WIDTH, SCREEN_HEIGHT

    public static MAX_WAVE = 5;

    public static LOCALSTORAGE_KEY = "caren.client.game.key";

    public static DEBUG = false;
}

export default Config;



