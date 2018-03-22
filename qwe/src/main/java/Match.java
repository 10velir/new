
import Exeptions.WrongSumPercentOfVictoryExp;

import java.util.Iterator;
import java.util.Map;

public class Match extends MatchInfo {

    public Match() {
        this.margin = 0;
        percentVictoryOfFirstParticipant = 0.0;
        percentVictoryOfSecondParticipant = 0.0;
    }

    public Match(Participant firstPartisipant, Participant secondPartisipant, int matchId) {
        id = matchId;
        this.firstParticipant = firstPartisipant;
        this.secondParticipant = secondPartisipant;
    }

    public double getCoeff1() {
        return coefficientOnFirstPlayer;
    }

    public double getCoeff2() {
        return coefficientOnSecondPlayer;
    }

    public void RecalculationOfCoefficients(int matchID) {   //Перерасчет коэффициентов для определённого матча
        chooseMath(matchID).firstParticipant.setCoefficient(100 / (chooseMath(matchID).percentVictoryOfFirstParticipant + chooseMath(matchID).margin));
        chooseMath(matchID).secondParticipant.setCoefficient(100 / (chooseMath(matchID).percentVictoryOfSecondParticipant + chooseMath(matchID).margin));
    }

    public void MakeARate(Clients clients, double rateOfClient, Participant participant) {//Клиент делает свою ставку на участника
        if (rateOfClient > clients.getAmountOfMoney()) {
            System.out.println("Недостаточно денег");
        } else if (percentVictoryOfFirstParticipant + percentVictoryOfSecondParticipant != 100) {
            System.out.println("суммарный шанс на победу не равен 100%");               //Нельзя ставить на такой матч
        } else {
            clients.decrease(rateOfClient);             //Списывание средств со счёта клиента
            DataClientsList.put(new DataClients(clients, rateOfClient), participant);//Ставка и информация и клиенте заносится в систему
        }
    }

    public boolean existenceOfTheMatch(int id) {            //Проверка на существование матча по ID
        int counter = 0;
        for (Match aMatchList : matchList) {
            if (aMatchList.id == id) {
                counter++;
            }
        }
        return counter != 0;
    }

    public Match chooseMath(int idOfMatch) {             //Получение матча по его ID
        Iterator<Match> itr = matchList.iterator();
        Match match = itr.next();
        while (itr.hasNext()) {
            if (match.id == idOfMatch) {
                return match;
            }
        }
        return match;
    }

    public void chooseWinner(int number) throws Exception {           //Выбор победителя
        if(number!= 1 & number !=2) {
            throw new Exception("Wrong number of participant!");
        }
        if (number == 1) {
            firstParticipant.setWinFlag(true);
        } else if (number == 2) {
            secondParticipant.setWinFlag(true);
        }
    }

    public void setPercents(double firstPercent, double secondPercent, int matchID) throws WrongSumPercentOfVictoryExp {//Задание процентов на победу для матча по его ID
        if (!existenceOfTheMatch(matchID)) {
            throw new NullPointerException("Match is not found ");
        } else {
            if (firstPercent + secondPercent != 100) {
                throw new WrongSumPercentOfVictoryExp("Wrong summ of percents");
            }
            chooseMath(matchID).percentVictoryOfFirstParticipant = firstPercent;
            chooseMath(matchID).percentVictoryOfSecondParticipant = secondPercent;
            RecalculationOfCoefficients(matchID);           //Перерасчет коэффициентов на матч по его ID

        }
    }

    public void grabTheMoney() {        //Подсчет всех поставленных денег на матч
        for (Map.Entry<DataClients, Participant> entry : DataClientsList.entrySet()) {
            managmentMoney += entry.getKey().getRateOfClient();
        }
    }


    public void distributionOfWinnnings() {         //Распределение выигрыша между клиентами поставившими на победителя
        grabTheMoney();
        for (Map.Entry<DataClients, Participant> entry : DataClientsList.entrySet()) {
            if (entry.getValue().isWinFlag()) {
                System.out.print(entry.getKey().getClintName() + " \t | Rate: " + entry.getKey().getRateOfClient() + " | coefficient: " + entry.getValue().getCoefficient()
                        + " | Amount of winnings: " + entry.getValue().getCoefficient() * entry.getKey().getRateOfClient() + "\n");
                entry.getValue();
                entry.getKey().client.addMoney(entry.getValue().getCoefficient() * entry.getKey().getRateOfClient());

                managmentMoney -= entry.getValue().getCoefficient() * entry.getKey().getRateOfClient();
            }
        }
        System.out.println("Руководству достаётся " + managmentMoney);
    }
}
