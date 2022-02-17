import ImageObject from "./ImageObject";

const DEBUG = true;

class ButtonObject extends ImageObject{

    isToggle;
    isHover;
    isClicked;


    constructor(imagePath : string[], x : number, y : number, scale?: number|undefined, width?: number|undefined, height?: number|undefined){
        super(imagePath, x, y, scale, width, height);

        this.isToggle = false;
        this.isHover = false;
        this.isClicked = false;
    }


    public draw(){
        if(DEBUG) console.log("draw button")
        if(DEBUG) console.log("instance of array: " + (this.image instanceof Array ) + " && " + ((this.image as HTMLImageElement[] ).length));
        if(this.image instanceof Array && this.image.length >= 3){
            if(this.isClicked && this.isHover){
                this.state = 2;
            }else if(this.isClicked){
                this.state = 2;
            }else if(this.isHover){
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

    public setToggle(isToggle : boolean){
        this.isToggle = isToggle;
    }

    public setHover(isHover : boolean){
        this.isHover = isHover;
    }

    public setClicked(isClicked : boolean){
        this.isClicked = isClicked;
    }

}

    


export default ButtonObject;