import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Привет,друг!" +"\n"+"Это твой Счетчик Калорий V0.1");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        short command = 0;
        while(true) {
            printMenu();
            try {
                command = scanner.nextShort();
                switch (command) {
                    case 1:

                        System.out.println("Введите номер месяца,дня ,а затем " +
                                "количество шагов " + "для сохранения информации, " +
                                "\n" + "где 1 - Январь, 2 - Февраль, 3 - Март и так далее");
                        System.out.println("Месяц: ");
                        short month = scanner.nextShort();
                        System.out.println("День: ");
                        short day = scanner.nextShort();
                        System.out.println("Количество шагов: ");
                        int steps = scanner.nextInt();
                        if(month<1||steps<1||day<1)
                        {
                            System.out.println("Числа должны быть больше нуля.Возврат в основное меню");
                            break;
                        }
                        else stepTracker.SetSteps(month,day,steps);



                        break;
                    case 2:
                        System.out.println("Введите номер месяца что бы увидеть статистику, "+
                                "\n" + "где 1 - Январь, 2 - Февраль, 3 - Март и так далее");
                        System.out.println("Месяц: ");
                        short month2 = scanner.nextShort();
                        if(month2<1)
                        {
                            System.out.println("Число должно быть больше нуля.Возврат в основное меню");
                            break;
                        }
                        else stepTracker.viewStatistic(month2);
                        break;
                    case 3:
                    {System.out.println("Установите новую цель по количеству шагов день : ");
                        int newpurpose = scanner.nextInt();
                            if(newpurpose >0) {
                                stepTracker.ChangePurpose(newpurpose);
                            }
                            else System.out.println("Новое число должно быть больше 0. Возврат в основное меню");
                        break;}
                    case 0:
                    {System.out.println("Всего хорошего! До свидания!");
                        return;}
                    default:
                    {System.out.println("Такой команды еще не добавлено в мой функционал");
                        break;}

                }
            }
            catch (InputMismatchException e){
                System.err.println("Неправильный формат комманды или значений ." +
                        "Возврат в основное меню");
                scanner.next();
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите пункт меню:");
        System.out.println("1.Ввести количество шагов за определенный месяц/день");
        System.out.println("2.Напечатать статистику за определенный месяц");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("0.Выйти из приложения");
    }
}


// основный цикл
// пишем методы и классы
// проверяем
// покрываем юнит тестами.. впрочем нафиг)