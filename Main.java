import java.io.File;
import java.io.IOException;

public class Main
{
    /*
    Вариант 10:

    Создать информационную базу "Абитуриент", каждая запись которой содержит следующие сведения:
    регистрационный номер;
    фамилия, имя, отчество;
    год рождения;
    оценки вступительных экзаменов (3);
    средний балл аттестата (по 12-бальной системе).

    Предусмотреть:
    а) выдачу сведений об абитуриенте с указанной фамилией;
    б) добавление новой записи после записи с указанной фамилией.
    в) удаление записей со средним баллом аттестата ниже заданного;
    г) выдачу сведений о всех абитуриентах с отображением оценок в 100-бальной системе
    */

    public static String filePath = "base.txt";

    public static InfoBase infoBase = new InfoBase();
    public static File baseFile;

    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        ui.setVisible(true);

        //example enrolees
        int[] i = new int[] {102, 103, 101};
        infoBase.addEnrolee(19325, "John", "Smith", "J.", 1999, i, 2);
        infoBase.addEnrolee(29873, "Jack", "Shepherd", "K.", 2002, i, 3);
        infoBase.addEnrolee(43565, "Bill", "Gates", "L.", 1991, i, 10);
        infoBase.addEnrolee(78787, "Sarah", "Miles", "M.", 1998, i, 7);
    }

    private static void createFile()
    {
        try
        {
            baseFile = new File(filePath);
            if (baseFile.createNewFile())
            {
                System.out.println("File created: " + baseFile.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}