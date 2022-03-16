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
    public static FETCH_INTERVAL_SECONDS = 0.1;

    public static SCREEN_WIDTH = 1920;
    public static SCREEN_HEIGHT = 1080;

    public static SCANNER_CENTER = {x: 605, y : 360} as Vector2
    public static SCANNER_RADIUS = 315;

    public static ZOOM_MIN_SCALE = 1;
    public static ZOOM_MAX_SCALE = 3;
    public static ZOOM_SCALE_STEP = 0.002;
    
    public static CANVAS_SCALE = 0.6666667; // scale relative to SCREEN_WIDTH, SCREEN_HEIGHT

    public static MAX_WAVE = 10;

    public static LOCALSTORAGE_KEY_GAMEID = "caren.client.game.key";

    public static DEBUG = false;

    

    public static DEFAULTGENETICCODE_MELEE = 
`t = t + 1
virusLoc = virus
if (virusLoc / 10 - 1)
then
if (virusLoc % 10 - 7) then move upleft
else if (virusLoc % 10 - 6) then move left
else if (virusLoc % 10 - 5) then move downleft
else if (virusLoc % 10 - 4) then move down
else if (virusLoc % 10 - 3) then move downright
else if (virusLoc % 10 - 2) then move right
else if (virusLoc % 10 - 1) then move upright
else move up
else if (virusLoc)
then
if (virusLoc % 10 - 7) then shoot upleft
else if (virusLoc % 10 - 6) then shoot left
else if (virusLoc % 10 - 5) then shoot downleft
else if (virusLoc % 10 - 4) then shoot down
else if (virusLoc % 10 - 3) then shoot downright
else if (virusLoc % 10 - 2) then shoot right
else if (virusLoc % 10 - 1) then shoot upright
else shoot up
else
{
dir = random % 8
if (dir - 6) then move upleft
else if (dir - 5) then move left
else if (dir - 4) then move downleft
else if (dir - 3) then move down
else if (dir - 2) then move downright
else if (dir - 1) then move right
else if (dir) then move upright
else move up
}`;


}

export default Config;



