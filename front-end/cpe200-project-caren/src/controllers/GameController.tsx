import axios from 'axios'

const baseURL = "http://localhost:8080"

class GameController {
  static async getArea(areaIndex : number){
    const url = baseURL + "/area/getarea" + (areaIndex);
    var area = await axios.get(url);

    return area.data;
  }

  static async getGameState() {
    var gameState = await axios.get(baseURL + "/game/state");
    console.log(gameState);

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