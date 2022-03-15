import axios from 'axios'
import Config from '../Config';

const baseURL = Config.SERVER_URL;

const DEBUG = Config.DEBUG;

class GameController {

  static async uploadGeneticCode(id : string, type : "melee" | "ranged" | "aoe"){
    var textBox : HTMLTextAreaElement | null;
    var geneticCode : string | null | undefined;

    textBox = document.getElementById(`${type}GeneticCode`) as HTMLTextAreaElement;
    geneticCode = textBox?.value;

    console.log(textBox)
    console.log(textBox.value)

    var resp = await axios({
      method: 'post',
      url: baseURL + `/game/uploadgeneticcode`,
      headers: {},
      data: {
        id: id,
        type: type,
        geneticCode: geneticCode,
      }
    });

    console.log("post response");

    if(resp.data.compiledResult === "success"){
      alert(`saved succesfully`)
    } else{
      alert(`there are error(s) in the genetic code at token ${resp.data.errorToken}`)
    }

    resp.data.geneticCode = geneticCode;

    return resp.data;
  }

  static async checkId(id : string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/gamehandler/checkid",
      headers: {},
      data: {
        id: id,
      }
    });

    // if have backend have key, good! return the one that was sent.
    // if backend have no key, generate a new one and return it.

    return resp.data;
  }

  static async runGame(id : string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/gamehandler/rungame",
      headers: {},
      data: {
        id: id,
      }
    });
  }

  static async pickUpUnit(id: string, name : string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/inventory/storeunit",
      headers: {},
      data: {
        id,
        name,
      }
    });
    console.log(resp.data);
  }

  static async placeUnit(id: string, type : string, areaIndex : number, position : {x : number, y : number}){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/inventory/pickupunit",
      headers: {},
      data: {
        id,
        type: type,
        area : areaIndex,
        positionX: position.x,
        positionY: position.y,
      }
    });
  }

  static async getInventory(id: string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/inventory/getinventory",
      headers: {},
      data: {
        id,
      }
    });
    return resp.data;
  }

  static async getShop(id: string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/shop/getshop",
      headers: {},
      data: {
        id,
      }
    });
    return resp.data;
  }

  static async getWave(id: string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/wavemanager/getwavenumberandnumberofvirus",
      headers: {},
      data: {
        id,
      }
    });
    return resp.data
  }

  static async getSpeedMultiplier(id: string){
    var resp = await axios({
      method: 'post',
      url: baseURL + "/timemanager/getspeedmultiplier",
      headers: {},
      data: {
        id,
      }
    });
    var returnData = resp.data;
    if(resp.data.type !== "pause" && resp.data.type !== "fastforward" && resp.data.type !== "slowdown"){
      returnData.type = "play";
    }
    return returnData;
  }

  static async setSpeedMultiplier(id: string, type : string) {
    var resp = await axios({
      method: 'post',
      url: baseURL + "/timemanager/setspeedmultiplier",
      headers: {},
      data: {
        id,
        type
      }
    });
  }

  static async buyUnit(id: string, type: string) {
    var resp = await axios({
      method: 'post',
      url: baseURL + "/shop/buyunit",
      headers: {},
      data: {
        id,
        type
      }
    });
  }

  static async getArea(id: string, areaIndex : number){

    var resp = await axios({
      method: 'post',
      url: baseURL + ("/area/getarea" + (areaIndex)),
      headers: {},
      data: {
        id,
      }
    });

    // if(areaIndex === 1){
    //   return {
    //     units: [{position : new Vector2(20,0), type: "melee"}, {position : new Vector2(40,0), type: "ranged"}, {position : new Vector2(0,0), type: "aoe"}],
    //     viruses: [{position : new Vector2(20,0), type: "melee"}, {position : new Vector2(40,0), type: "ranged"}],
    //     antibodies: [{position : new Vector2(0,0), type: "aoe"}],
    //     name: "gg",
    //     radius: 100,
    //     taken: false,
    //     alertLevel: 1,
    //   };
    // }

    return resp.data;
  }

  static async getGameState(id: string) {
    var resp = await axios({
      method: 'post',
      url: baseURL + "/game/state",
      headers: {},
      data: {
        id,
      }
    });

    return resp.data;
  }

  static async setGameState(id: string, gameState: number) {
    var resp = await axios({
      method: 'post',
      url: baseURL + "/game/setstate",//baseUrl + 'applications/' + appName + '/dataexport/plantypes' + plan,
      headers: {},
      data: {
        id,
        gameState: gameState, // This is the body part
      }
    });
    return resp.data;
  }
}


export default GameController;