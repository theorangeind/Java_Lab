import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoBase
{
    private List<Enrolee> list;

    public InfoBase()
    {
        this.list = new ArrayList<Enrolee>();
    }

    public int getListSize()
    {
        return list.size();
    }

    public void addEnrolee(Enrolee enrolee)
    {
        this.list.add(enrolee);
    }

    public void addEnrolee(int regNum, String fname, String sname, String lname, int birthYear, int[] exams, int averageMark)
    {
        System.out.println("New Enrolee has been added");
        this.list.add(new Enrolee(regNum, fname, sname, lname, birthYear, exams, averageMark));
    }

    public Enrolee getEnrolee(int index)
    {
        if(list.isEmpty()) return null;
        if(index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    public int getEnroleeIndex(String surname, int startIndex)
    {
        if(list.isEmpty())
        {
            return -2;
        }
        if(startIndex >= list.size())
        {
            return -2;
        }
        for(int i = startIndex; i < list.size(); i++)
        {
            if(list.get(i).getMiddleName().equals(surname))
            {
                return i;
            }
        }
        return -2;
    }

    public int deleteLowGrades(int threshold)
    {
        int deletedCount = 0;
        List<Enrolee> newList = new ArrayList<Enrolee>();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getAverageMark() >= threshold)
            {
                newList.add(list.get(i));
            }
            else
            {
                deletedCount++;
            }
        }
        list = newList;
        return deletedCount;
    }

    public int getEnroleeIndex(String surname)
    {
        return getEnroleeIndex(surname, 0);
    }

    public boolean insertEnrolee(Enrolee enrolee, int index)
    {
        if(index > list.size()) return false;
        list.add(index, enrolee);
        return true;
    }

    public void exportList()
    {
        try
        {
            FileWriter myWriter = new FileWriter(Main.filePath);
            myWriter.write("");
            myWriter.close();
            System.out.println("File saved");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void importList()
    {

    }
}
