package gr15.server;

public class Server {
    private String gameId;
    private int amountOfPlayers;
    private transient String gameState;

    public Server(int gameId){
        this.gameId = String.valueOf(gameId);
        this.amountOfPlayers = 1;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getGameId(){
        return gameId;
    }
}