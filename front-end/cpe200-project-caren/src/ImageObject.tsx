
const DEBUG = true;

class ImageObject{

    canvas;
    context;
    position;
    imagePath;
    image;
    width;
    height;


    constructor(imagePath : string, x : number, y : number, width?: number|undefined, height?: number|undefined){
        this.canvas = document.querySelector('canvas');
        this.context = this.canvas!.getContext('2d');

        this.position = {
            x: x,
            y: y
        };
        
        this.imagePath = imagePath;
        this.image = this.createImage(imagePath);
        if(width === undefined || height === undefined){
            this.width = this.image.width;
            this.height = this.image.height;
        }else{
            this.width = width;
            this.height = height;
        }
    }

    createImage(imagePath : string){
        console.log(imagePath)

        const image = new Image();
        image.onload = function(){
            console.log(image)
        }
        image.src = imagePath;
        return image;
    }

    draw(){
        if(DEBUG) console.log("draw")
        this.context!.drawImage(this.image, this.position.x, this.position.y, this.width, this.height);
    }

    update(){
        this.draw();
        // fetch here
    }
}


export default ImageObject;