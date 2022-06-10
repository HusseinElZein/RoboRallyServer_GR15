package gr15.server;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

/**To ensure not to have too many logical things in ServerController, this class is needed*/
@Service
public class RoboRallyService implements IRoboRallyService {
    ArrayList<Server> servers = new ArrayList<>();
    private int id = 0;

    /**
     * This searches for each server and returns the one that is searched for. This is done so the
     * user later on can have multiple servers running at the same time
     * @param serverId This searches for each attribute server by server Id
     * @return returns the one that is searched for
     */
    @Override
    public Server findServerById(String serverId){
        for (Server server : servers) {
            if (Objects.equals(server.getGameId(), serverId)) {
                return server;
            }
        }
        return null;
    }

    @Override
    public void updateGame(String id, String gameState) {
        Server server = findServerById(id);
        server.setStateOfGame(gameState);
    }

    @Override
    public String getGameState(String serverId) {
        return (findServerById(serverId).getGameState());
    }

    /**This initializes a new server and gives it a new Id*/
    @Override
    public String hostServer() {
        servers.add(new Server(id));
        String newServerId = String.valueOf(id);
        id++;
        return newServerId;
    }
}