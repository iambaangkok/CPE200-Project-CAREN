
const DEBUG = true;

class TextObject{

    canvas;
    context;
    text;
    font;
    position;
    align;
    color;


    constructor(text : string, font : string, x : number, y : number, color? : string|undefined, align? : string|undefined){
        this.canvas = document.querySelector('canvas');
        this.context = this.canvas!.getContext('2d');
        this.position = {
            x: x,
            y: y
        };
        
        this.text = text;
        this.font = font;

        if(color === undefined){
            this.color = "black";
        }else{
            this.color = color;
        }

        if(align === undefined){
            this.align = "left";
        }else{
            this.align = align;
        }
    }

    draw(){
        if(DEBUG) console.log("draw")
        this.context!.font = this.font;
        this.context!.fillStyle = this.color;
        this.context!.textAlign = this.align as CanvasTextAlign;
        this.context!.fillText(this.text, this.position.x, this.position.y);
    }

    update(){
        this.draw();
    }

}

export default TextObject;