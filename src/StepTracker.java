
public class StepTracker {
    private int purpose  = 10000;
    MonthData[] monthToData;

    void ChangePurpose(int purpose)
    {
        this.purpose = purpose;
        System.out.println("Новая цель по количеству шагов установлена : " + this.purpose + "!.");
    }
    void SetSteps(short month, short day, int new_steps )
    {
        monthToData[month-1].days[day-1] = new_steps;
        System.out.println("Успешно!");
    }
    void viewStatistic (short month)
    {   int sumStep=0;
        int bestSeries =0;
        int maxBest=0;
        Converter converter = new Converter();
        System.out.println("Cтатистика по дням : ");
        for (int x :monthToData[month-1].days)
        {
            sumStep = sumStep + x;
            System.out.print("1 день: " + x + ", ");
            if(x>=purpose)
            {
                bestSeries++;
            }
            else
            {
                if (maxBest < bestSeries)
                {
                    maxBest = bestSeries;
                }
                bestSeries=0;
            }
        }
        System.out.println("Общее количество шагов за месяц: " + sumStep );
        System.out.println("Среднее количество шагов за месяц: " + sumStep/30 );
        System.out.println("Пройденная дистанция за месяц (км): " + converter.convertToKMeters(sumStep));
        System.out.println("Количество сожженых Ккалорий: " + converter.convertToCCalories(sumStep));
        System.out.println("Лучшая серия: " + maxBest);


    }
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    class MonthData {
        int [] days = new int[30];

    }
}
     class Converter
{
    double convertToKMeters(int steps)
    {
        return (steps*0.75)/1000;
    }
    double convertToCCalories(int steps)
    {
        return (steps*50)/1000;
    }
}