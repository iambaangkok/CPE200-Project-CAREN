
const DEBUG = false;

class ImageObject{

    canvas;
    context;
    position;
    imagePath;
    image;
    width;
    height;
    scale;

    // multi state support
    isMultiState;
    maxState;
    state;

    constructor(imagePath : string|string[], x : number, y : number, scale?: number|undefined, width?: number|undefined, height?: number|undefined){
        this.canvas = document.querySelector('canvas');
        this.context = this.canvas!.getContext('2d');

        this.position = {
            x: x,
            y: y
        };
        
        this.imagePath = imagePath;

        if(imagePath instanceof Array){
            this.isMultiState = true;
            this.maxState = imagePath.length;
            this.image = this.createImageArray(imagePath);
        }else{
            this.isMultiState = false;
            this.maxState = 1;
            this.image = this.createImage(imagePath!);
        }
        this.state = 0;

        if(scale === undefined){
            this.scale = 0.6666667;
        }else{
            this.scale = scale;
        }

        if(width === undefined || height === undefined){
            if(this.image instanceof Array){
                this.width = (this.image[0]).width;
                this.height = (this.image[0]).height;
            }else{
                this.width = this.image.width;
                this.height = this.image.height;
            }
        }else{
            this.width = width;
            this.height = height;
        }
    }

    protected createImageArray(imagePaths : string[]){
        var images: HTMLImageElement[] = [];
        imagePaths.forEach(x =>{
            images.push(this.createImage(x));
        })
        return images;
    }

    protected createImage(imagePath : string){
        console.log(imagePath)

        const image = new Image();
        image.onload = function(){
            console.log(image)
        }
        image.src = imagePath;
        return image;
    }

    public draw(){
        if(DEBUG) console.log("draw image")
        if(this.image instanceof Array){
            this.context!.drawImage(this.image[this.state], this.position.x, this.position.y, this.width, this.height);
        }else{
            this.context!.drawImage(this.image, this.position.x, this.position.y, this.width, this.height);
        }
    }

    protected update(){
        this.draw();
        // fetch here
    }

    public mouseInside(mousePos : {x : number, y : number}){
        return (mousePos.x >= (this.position.x)*this.scale && mousePos.x <= (this.position.x+this.width)*this.scale
            && mousePos.y >= (this.position.y)*this.scale && mousePos.y <= (this.position.y+this.height)*this.scale);
    }

    public nextState(){
        if(this.image instanceof Array){
            this.state = (this.state+1) % this.maxState!;
        }
    }

    public setState(state : number){
        if(this.image instanceof Array){
            this.state = (state) % this.maxState!;
        }
    }
}


export default ImageObject;