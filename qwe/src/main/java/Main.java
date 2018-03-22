import Exeptions.WrongMarginExp;
import Exeptions.WrongSumPercentOfVictoryExp;

public class Main {
    public static void main(String args[]) {
        Worker worker = new Worker();          //создание рабочего
        Managment manager = new Managment();      //создание менеджера
        Participant firstParticipant = new Participant("firstTeam", 1); //создание первого участника
        Participant secondParticipant = new Participant("secondTeam", 2); // второго

        worker.createMatch(firstParticipant, secondParticipant, 2);     //рабочийсоздаёт матч между участниками


        try {
            worker.setPercents(60, 40, 2);      //рабочий устанавливает коэффициенты на матч
        } catch (WrongSumPercentOfVictoryExp exp) {
            exp.printStackTrace();
        }

        try {
            manager.chooseMargin(15,2, worker);          //менеджер выбирает маржу
        } catch (WrongMarginExp wrongMarginExp) {
            wrongMarginExp.printStackTrace();
        }
        worker.setMargin();                                             //рабочий устанавливает маржу на матч

        Clients client = new Clients("Jey", 2000);      //создание клиентов
        Clients client2 = new Clients("Tom", 5330);
        Clients client3 = new Clients("Dread", 12340);

        worker.showCoefficients(2);

        worker.chooseMath(2).MakeARate(client,200,firstParticipant);//Первый клиент ставит на первого участника матча с ID = 2
        worker.chooseMath(2).MakeARate(client2,400,secondParticipant);//Второй клиент ставит на второго участника мачта с ID = 2
        worker.chooseMath(2).MakeARate(client3,600,firstParticipant);

        try {
            worker.chooseMath(2).chooseWinner(2);                     //Выбор победителя для второго матча
        } catch (Exception e) {
            e.printStackTrace();
        }

        worker.chooseMath(2).distributionOfWinnnings();        //расчёт выигрышей для клиентов и разницы для руководства
    }
}
