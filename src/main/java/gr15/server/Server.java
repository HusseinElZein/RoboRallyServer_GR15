package gr15.server;

public class Server {
    private String gameId;
    private String stateOfgame;
    private String wholeGame = "";

    public Server(int gameId){
        this.gameId = String.valueOf(gameId);
    }

    public String getGameState() {
        return stateOfgame;
    }

    public void setStateOfGame(String stateOfgame) {
        this.stateOfgame = stateOfgame;
    }

    public String getGameId(){
        return gameId;
    }

    public void setWholeGame(String wholeGame) {
        this.wholeGame = wholeGame;
    }

    public String getWholeGame() {
        return wholeGame;
    }
}