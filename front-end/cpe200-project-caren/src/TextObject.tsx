import { throws } from "assert";

const DEBUG = true;

class TextObject{

    canvas;
    context;
    text;
    size;
    font;
    position;
    color;
    align;
    baseline;

    constructor(text : string[], size : number, font : string, x : number, y : number, color? : string|undefined, align? : string|undefined, baseline? : string|undefined){
        this.canvas = document.querySelector('canvas');
        this.context = this.canvas!.getContext('2d');
        this.position = {
            x: x,
            y: y
        };
        
        this.text = text;
        this.size = size;
        this.font = font;

        if(color === undefined){
            this.color = "white";
        }else{
            this.color = color;
        }

        if(align === undefined){
            this.align = "start";
        }else{
            this.align = align;
        }

        if(baseline === undefined){
            this.baseline = "top";
        }else{
            this.baseline = baseline;
        }
    }

    draw(){
        if(DEBUG) console.log("draw text")
        this.context!.font = this.size + "px " + this.font;
        this.context!.fillStyle = this.color;
        this.context!.textAlign = this.align as CanvasTextAlign;
        this.context!.textBaseline = this.baseline as CanvasTextBaseline;
        for(var i = 0 ; i < this.text.length; ++i){
            this.context!.fillText(this.text[i], this.position.x, this.position.y + i*(this.size)*2);
        }
    }

    update(){
        this.draw();
    }

}

export default TextObject;