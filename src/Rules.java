import java.io.*;
import java.util.*;

/**
 * Created by Szymon on 2016-05-17.
 */
public class Rules extends Files
{
    private List<String> names;


    @Override
    void open()
    {
        try
        {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();


            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

}
