package gr15.server;

public interface IRoboRallyService {
    Server findServer(String serverId);
    void updateGame(String id, String gameState);
    String getGameState(String gameId);
    String hostServer();
}
