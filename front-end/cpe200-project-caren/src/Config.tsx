import Vector2 from "./Vector2";

class Config{
    public static SERVER_URL = "http://localhost:8080";

    public static COLOR_LIGHTBLUE = "#92E8C0";
    public static COLOR_CREAMWHITE = "#F5FFE8";
    public static COLOR_BRIGHTRED = "#E64539";

    public static FPS = 30;
    public static FETCH_INTERVAL_SECONDS = 1;

    public static SCREEN_WIDTH = 1920;
    public static SCREEN_HEIGHT = 1080;

    public static SCANNER_CENTER = {x: 605, y : 360} as Vector2
    public static SCANNER_RADIUS = 315;
    
    public static CANVAS_SCALE = 0.6666667; // scale relative to SCREEN_WIDTH, SCREEN_HEIGHT

    public static MAX_WAVE = 5;

    public static LOCALSTORAGE_KEY = "caren.client.game.key";

    public static DEBUG = false;
}

export default Config;



