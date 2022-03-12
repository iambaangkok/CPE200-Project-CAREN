import Config from "../Config";
import ImageObject from "./ImageObject";
import TextObject from "./TextObject";

const DEBUG = Config.DEBUG;

class WaveInfo{
    triangle: ImageObject;
    meleeIcon: ImageObject;
    rangedIcon: ImageObject;
    aoeIcon: ImageObject;
    meleeText: TextObject;
    rangedText: TextObject;
    aoeText: TextObject;

    constructor(triangle: ImageObject,
        meleeIcon: ImageObject, rangedIcon: ImageObject, aoeIcon: ImageObject,
        meleeText: TextObject, rangedText: TextObject, aoeText: TextObject){
        
        this.triangle = triangle;
        this.meleeIcon = meleeIcon;
        this.rangedIcon = rangedIcon;
        this.aoeIcon = aoeIcon;
        this.meleeText = meleeText;
        this.rangedText = rangedText;
        this.aoeText = aoeText;
    }

    public draw(){
        if(DEBUG) console.log("draw waveinfo")
        this.triangle.draw();
        this.meleeIcon.draw();
        this.rangedIcon.draw();
        this.aoeIcon.draw();
        this.meleeText.draw();
        this.rangedText.draw();
        this.aoeText.draw();
        
    }

    public setAllField(area : {total: number, melee: number, ranged: number, aoe: number}){
        this.meleeIcon.setState((area.melee > 0)? 1 : 0);
        this.rangedIcon.setState((area.ranged > 0)? 1 : 0);
        this.aoeIcon.setState((area.aoe > 0)? 1 : 0);
        this.meleeText.setText([area.melee.toString()]);
        this.rangedText.setText([area.ranged.toString()]);
        this.aoeText.setText([area.aoe.toString()]);
    }
}


export default WaveInfo;