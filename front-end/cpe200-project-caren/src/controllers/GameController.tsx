import axios from 'axios'
import Config from '../Config';

const baseURL = Config.SERVER_URL;

const DEBUG = false;

class GameController {

  static async getUnitCost(){
    // const url = baseURL + "/unitCost";
    // var resp = await axios.get(url);

    // return resp.data;
    return {melee: 100, ranged: 150, aoe: 250};
  }

  static async getMoney(){
    // const url = baseURL + "/money";
    // var resp = await axios.get(url);

    // return resp.data;
    return 1200;
  }

  static async getWave(){
    // const url = baseURL + "/wave";
    // var resp = await axios.get(url);

    // return resp.data;
    return {
      waveNumber: 1, 
      area1: {total: 6, melee: 5, ranged: 1, aoe: 0},
      area2: {total: 1, melee: 1, ranged: 0, aoe: 0},
      area3: {total: 1, melee: 1, ranged: 0, aoe: 0}
    };
  }

  static async getSpeedMultiplier(){
    // const url = baseURL + "/wave";
    // var resp = await axios.get(url);

    // return resp.data;
    return {type: "play", multiplier: 1};
  }

  static async setSpeedMultiplier(type : string) {
    // await axios({
    //   method: 'post',
    //   url: baseURL + "/time/speedmultiplier/set",
    //   headers: {},
    //   data: {
    //     type: type,
    //   }
    // });
  }

  static async buyUnit(type: string) {
    // await axios({
    //   method: 'post',
    //   url: baseURL + "/shop/buyUnit",
    //   headers: {},
    //   data: {
    //     type: type,
    //   }
    // });
  }

  static async getArea(areaIndex : number){
    const url = baseURL + "/area/getarea" + (areaIndex);
    var area = await axios.get(url);

    return area.data;
  }

  static async getGameState() {
    var gameState = await axios.get(baseURL + "/game/state");
    if(DEBUG) console.log(gameState);

    return gameState.data.state;
  }

  static async setGameState(gameState: number) {
    await axios({
      method: 'post',
      url: baseURL + "/game/setState",//baseUrl + 'applications/' + appName + '/dataexport/plantypes' + plan,
      headers: {},
      data: {
        gameState: gameState, // This is the body part
      }
    });
  }
}


export default GameController;