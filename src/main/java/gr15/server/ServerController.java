package gr15.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServerController {

    @Autowired
    private IRoboRallyService RoboRallyService;

    //host Game
    @PostMapping(value = "/game")
    public ResponseEntity<String> createGame(){
        String newServerID = RoboRallyService.hostServer();
        if (newServerID == null)
            return ResponseEntity.internalServerError().body("Server couldn't start");
        return ResponseEntity.ok().body(newServerID);
    }

    @GetMapping(value = "/gameState/{id}")
    public ResponseEntity<String> getGameState(@PathVariable String id)
    {
        return ResponseEntity.ok().body(RoboRallyService.getGameState(id));
    }

    @PutMapping(value = "/gameState/{id}")
    public ResponseEntity<String> setGameState(@PathVariable String id, @RequestBody String g)
    {
        RoboRallyService.updateGame(id,g);
        return ResponseEntity.ok().body("ok");
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