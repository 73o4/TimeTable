import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private int action = 0;

    public int whatDoYouWantDo () {
        System.out.println("Choose action:" + "\n" +
                "Open the list of tasks - write 1" + "\n" +
                "Add new task - write 2" + "\n" +
                "Change the task - write 3");
        Scanner scanner = new Scanner(System.in);

        //проверка того, что пользователь ввел одно из возможных чисел
        try
        {
            action = scanner.nextInt();
        }
        catch (InputMismatchException exp) {
            //System.out.println(exp.getMessage());
            System.out.println("Choose from 1, 2, 3");
            scanner = new Scanner(System.in);
            action = scanner.nextInt();
        }
        while (action != 1 && action != 2 && action != 3) {
            System.out.println("Choose from 1, 2, 3");
            scanner = new Scanner(System.in);
            action = scanner.nextInt();
        }
        return action;
    }

    public TaskData addInformation() {
        System.out.println("Write the task name:");
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        TaskData element = new TaskData(task);
        System.out.println("Do you want any else data? Write 0, if u don't want, or words description, deadline, if want");
        int digitAnswer = 1;
        int deadlineAnswer = 0;
        String stringAnswer = null;
        try
        {
            digitAnswer = scanner.nextInt();
            deadlineAnswer = digitAnswer;
        }
        catch (InputMismatchException exp) {
            System.out.println("Write it: description OR deadline in format ddmm");
            scanner = new Scanner(System.in);
            try
            {
                deadlineAnswer = scanner.nextInt();
            }
            catch (InputMismatchException exp1) {
                stringAnswer = scanner.nextLine();
            }
        }
        if (digitAnswer != 0) {
            element = new TaskData(task, stringAnswer, deadlineAnswer);
        }
        return element;
    }

    public int chooseChangingLine() {
        System.out.println("Write number of changing string:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int chooseChangingInformation () {
        int usersChoice = 0;
            System.out.println("Write what do u want to change:\n" +
                    "1: Task name\n" +
                    "2: Description\n" +
                    "3: Deadline\n" +
                    "4: Importance\n" +
                    "5: Status\n" +
                    "6: Kill this task\n" +
                    "0: Nothing");

            Scanner scanner = new Scanner(System.in);
            try {
                usersChoice = scanner.nextInt();
            } catch (InputMismatchException exp) {
                System.out.println("Choose number from range!");
                usersChoice = scanner.nextInt();
            }
        return usersChoice;
    }

    public String importString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int importInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }



}
