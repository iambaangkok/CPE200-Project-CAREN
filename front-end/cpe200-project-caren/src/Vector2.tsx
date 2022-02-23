
class Vector2{
    x;
    y;

    constructor(x : number, y : number){
        this.x = x;
        this.y = y;
    }

    public static distanceBetweenPoint(p1 : Vector2, p2 : Vector2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y, 2))
    }

    public static scale(v : Vector2, scale : number){
        v.scale(scale);
    }
    
    public scale(scale : number){
        this.x *= scale;
        this.y *= scale;    
    }

    public static getCopy(v : Vector2){
        return new Vector2(v.x, v.y);
    }
}

export default Vector2;