package gr15.server;

public interface IRoboRallyService {

    Server findServerById(String serverId);

    void updateGame(String id, String gameState);

    String getGameState(String serverId);

    String hostServer();
}
