import axios from 'axios'
import Config from '../Config';

const baseURL = Config.SERVER_URL;

const DEBUG = false;

class GameController {

  static async getMoney(){
    // const url = baseURL + "/money";
    // var money = await axios.get(url);

    // return money.data;
    return 1200;
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