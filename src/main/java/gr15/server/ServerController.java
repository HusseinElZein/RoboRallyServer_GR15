package gr15.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServerController {

    @Autowired
    private IRoboRallyService RoboRallyService;

    @PostMapping(value = "/game")
    public ResponseEntity<String> createGame(){
        String newServer = RoboRallyService.hostServer();
        if (newServer == null)
            return ResponseEntity.internalServerError().body("There is an error with hosting a server!");
        return ResponseEntity.ok().body(newServer);
    }

    String jsonUpdate;

    @PostMapping(value = "/stateOfGame")
    public void updateStateOfGame(@RequestBody String jsonUpdate){
        this.jsonUpdate = jsonUpdate;
        RoboRallyService.updateGame("0", jsonUpdate);
    }

    @GetMapping(value = "/stateOfGame")
    public String getJsonUpdate(){
        return jsonUpdate;
    }


    String jsonBoard = "";

    @PostMapping(value = "/board")
    public void setWholeGame(@RequestBody String jsonBoard){
        this.jsonBoard = jsonBoard;
    }

    @GetMapping(value = "/board")
    public String getWholeGame(){
        if(jsonBoard.equals("")){
            return "Board is empty, you have not yet changed anything in play!";
        }else{
            return jsonBoard;
        }
    }
}