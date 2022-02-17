import ImageObject from "./ImageObject";

const DEBUG = true;

class ButtonObject extends ImageObject{

    toggle;
    hover;
    clicked;


    constructor(imagePath : string[], x : number, y : number, scale?: number|undefined, width?: number|undefined, height?: number|undefined){
        super(imagePath, x, y, scale, width, height);

        this.toggle = false;
        this.hover = false;
        this.clicked = false;
    }


    public draw(){
        if(DEBUG) console.log("draw button")
        if(DEBUG) console.log("instance of array: " + (this.image instanceof Array ) + " && " + ((this.image as HTMLImageElement[] ).length));
        if(this.image instanceof Array && this.image.length >= 3){
            if(this.clicked && this.hover){
                this.state = 2;
            }else if(this.clicked){
                this.state = 2;
            }else if(this.hover){
                this.state = 1;
            }else{
                this.state = 0;
            }
            this.context!.drawImage(this.image[this.state], this.position.x, this.position.y, this.width, this.height);
        }else{
            if(DEBUG) console.log("button have only one image")
        }
    }

    public mouseDown(){
        this.setClicked(true);
    }

    public mouseUp(){
        this.setClicked(false);
    }

    public setToggle(toggle : boolean){
        this.toggle = toggle;
    }

    public isToggle(){
        return this.toggle;
    }

    public setHover(hover : boolean){
        this.hover = hover;
    }

    public isHover(){
        return this.hover;
    }

    public setClicked(clicked : boolean){
        this.clicked = clicked;
    }

    public isClicked(){
        return this.clicked;
    }

}

    


export default ButtonObject;