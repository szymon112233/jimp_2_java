import java.io.*;


/**
 * Created by Szymon on 2016-05-16.
 */
public class Files {

    protected String fileName;
    protected String line;
    protected FileReader fileReader;
    protected BufferedReader bufferedReader;





    public Files(String fileName)
    {
        this.fileName=fileName;
        this.line = null;
        this.fileReader = null;
        this.bufferedReader =null;
    }
    public Files()
    {
        this.fileName=null;
        this.line = null;
        this.fileReader = null;
        this.bufferedReader =null;
    }

    void open()
    {
        //Virtual method
    }



}
