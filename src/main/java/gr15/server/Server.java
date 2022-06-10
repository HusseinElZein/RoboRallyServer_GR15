package gr15.server;

/**
 * This is the server class. It is created everytime a new game is initiated, and it has the
 * remembrance of the String wholeGame.
 * **/
public class Server {
    private String gameId;
    private String stateOfgame;
    private String wholeGame = "";

    /**This constructor is called whenever a new server is created with its own unique gameId**/
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
    /**This one is important, look in the ServerController to understand it. This string is set
     * to be the whole board that comes from LoadBoard.saveBoard**/
    public void setWholeGame(String wholeGame) {
        this.wholeGame = wholeGame;
    }

    public String getWholeGame() {
        return wholeGame;
    }
}