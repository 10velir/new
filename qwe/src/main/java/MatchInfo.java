import java.util.*;

public abstract class MatchInfo {
    int id;
    double margin;
    protected double managmentMoney = 0;
    protected Participant firstParticipant;
    protected Participant secondParticipant;
    protected double percentVictoryOfFirstParticipant;
    protected double percentVictoryOfSecondParticipant;
    protected double coefficientOnFirstPlayer;
    protected double coefficientOnSecondPlayer;
    protected List<Clients> ClientsList = new ArrayList<>();
    protected List<Match> matchList = new ArrayList<>();
    protected Map<DataClients, Participant> DataClientsList = new HashMap<DataClients, Participant>();
}
