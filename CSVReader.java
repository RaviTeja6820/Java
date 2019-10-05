import java.util.*;
public class CSVReader
{
    File file;
    public CSVReader(){
        String fileName=" ";
        file = new File(fileName);
    }
    public CSVReader(String fileName){
        file = new File(fileName);
    }
    public void initialize(){
        Scanner inputStream = new Scanner(file);
        try{
            while(inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}