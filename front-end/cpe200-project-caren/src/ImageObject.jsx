class ImageObject{

    canvas;
    context;

    constructor(x, y, width, height, imagePath){
        this.canvas = document.querySelector('canvas');
        this.context = this.canvas.getContext('2d');

        this.position = {
            x: x,
            y: y
        };
        this.width = width;
        this.height = height;

        this.imagePath = imagePath;
        this.image = this.createImage(imagePath);
    }

    createImage(imagePath){
        console.log(imagePath)

        const image = new Image();
        image.onload = function(){
            console.log(image)
        }
        image.src = imagePath;
        return image;
    }

    draw(){
        console.log("draw")
        console.log(this.image.complete)
        this.context.drawImage(this.image, this.x, this.y, this.width, this.height);
    }

    update(){
        this.draw();
        // fetch here
    }

    

}


export default ImageObject;