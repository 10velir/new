
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


public class MatchTest {
    Worker worker = new Worker();
    Managment manager = new Managment();

    //Match match = new Match(participant,participant2);
    @BeforeClass
    public void setUp() throws Exception {
        Participant participant = new Participant("gkhjgkh",5);
        Participant participant2 = new Participant("gkhjgkh",5);
        worker.createMatch(participant,participant2,2);
    }

    @Test
    public void testRecalculationOfCoefficientsOfTheFirst() throws Exception {
        Participant participant = new Participant("gkhjgkh",5);
        Participant participant2 = new Participant("gkhjgkh",5);
        worker.createMatch(participant,participant2,2);
        worker.setPercents(60,40,2);
        worker.changeMargin(14,2);
        worker.RecalculationOfCoefficients(2);
        Assert.assertEquals(1.6666666666666667, worker.chooseMath(2).firstParticipant.getCoefficient(),0.1);
    }

    @Test
    public void testRecalculationOfCoefficientsOfTheSecond() throws Exception {
        Participant participant = new Participant("gkhjgkh",5);
        Participant participant2 = new Participant("gkhjgkh",5);
        worker.createMatch(participant,participant2,2);
        worker.setPercents(60,40,2);
        manager.chooseMargin(12,2,worker);
        worker.setMargin();
        worker.RecalculationOfCoefficients(2);
        Assert.assertEquals(1.9, worker.chooseMath(2).secondParticipant.getCoefficient(),0.1);
    }

    @Test
    public void testMakeARate() throws Exception {
    }

}