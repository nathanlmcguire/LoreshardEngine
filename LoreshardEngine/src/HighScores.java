import java.io.*;
import java.util.ArrayList;

public class HighScores
	{
	private String name;
	private int score;
	private String ending;
	static ArrayList <HighScores> scores = new ArrayList<HighScores>();
	
	public HighScores(String n, int s, String e)
		{
		name = n;
		score = s;
		ending = e;
		}
	
	public static void addScore(String name, int score, String ending)
		{
		// The name of the file to open.
        String fileName = "HighScores.txt";

        try 
        	{
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            if(score > HighScores.scores.get(2).get)
            	{
            		
            	}
            HighScores.scores.add(new HighScores(name, score, ending));
            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("1: " + name + ",");
            bufferedWriter.write(" " + score + ", ");
            bufferedWriter.write(ending);
            bufferedWriter.newLine();
            bufferedWriter.write("2: " + name + ",");
            bufferedWriter.write(" " + score + ", ");
            bufferedWriter.write(ending);
            bufferedWriter.newLine();
            bufferedWriter.write("3: " + name + ",");
            bufferedWriter.write(" " + score + ", ");
            bufferedWriter.write(ending);

            // Always close files.
            bufferedWriter.close();
        	}
        catch(IOException ex) 
        	{
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        	}	
		}
	
	public static void printScore()
		{
		// The name of the file to open.
        String fileName = "HighScores.txt";

        // This will reference one line at a time
        String line = null;

        try 
        	{
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) 
            	{
                System.out.println(line);
            	}	

            // Always close files.
            bufferedReader.close();			
        	}
        catch(FileNotFoundException ex) 
        	{
            System.out.println("Unable to open file '" + fileName + "'");				
        	}
        catch(IOException ex) 
        	{
            System.out.println("Error reading file '" + fileName + "'");					
            // Or we could just do this: 
	        // ex.printStackTrace();
	        }	
		}
	}
