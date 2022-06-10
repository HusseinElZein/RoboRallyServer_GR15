package gr15.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**This is the server rest controller. This is everything in the server that the user
 * is able to post and get from and to the whole server itself**/
@RestController
public class ServerController {

    @Autowired
    private IRoboRallyService RoboRallyService;

    /**This method starts hosting the game**/
    @PostMapping(value = "/game")
    public ResponseEntity<String> createGame() {
        String newServer = RoboRallyService.hostServer();
        if (newServer == null)
            return ResponseEntity.internalServerError().body("There is an error with hosting a server!");
        return ResponseEntity.ok().body(newServer);
    }

    String jsonUpdate;

    /**
     * This is to show that we have understood the concept of postmapping anyhing. This saves a String that
     * is created in GameBoard
     * @param jsonUpdate this is eventuallu the Json file that will be updated every time a new move
     * by a player is performed
     */
    @PostMapping(value = "/stateOfGame")
    public void updateStateOfGame(@RequestBody String jsonUpdate) {
        this.jsonUpdate = jsonUpdate;
        RoboRallyService.updateGame("0", jsonUpdate);
    }

    @GetMapping(value = "/stateOfGame")
    public String getJsonUpdate() {
        return jsonUpdate;
    }

    /**
     * This saves the whole board as a string and saves it in the chosen Server that is found by serverId
     * @param jsonBoard This is the whole board that will we saved from the GameBoard class in
     *                  roborally
     */
    @PostMapping(value = "/board")
    public void setWholeGame(@RequestBody String jsonBoard) {
        RoboRallyService.findServerById("0").setWholeGame(jsonBoard);
    }


    /**
     * This is a getMapping
     * @return This either returns a message that the board is empty, or the newest board of the game
     */
    @GetMapping(value = "/board")
    public String getWholeGame() {
        if (RoboRallyService.findServerById("0").getWholeGame().equals("")) {
            return "Board is empty, you have not yet changed anything in play!";
        } else {
            return RoboRallyService.findServerById("0").getWholeGame();
        }
    }
}