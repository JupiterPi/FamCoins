package jupiterpi.famcoins;

import java.util.*;
import java.io.*;

public class FileTool
{
	private String fileName;
	protected ArrayList<String> file = new ArrayList<String>();
	
	public FileTool (String fileName) throws FileNotFoundException, IOException
	{
		this.fileName = fileName;
		BufferedReader Reader = new BufferedReader (new FileReader (fileName));
		boolean fileEnd = false;
		
		while (!fileEnd)
		{
			String line = Reader.readLine();
			if (line == null) fileEnd = true;
			else file.add (line);
		}
		Reader.close();
	}
	
	public ArrayList<String> getFile ()
	{
		return file;
	}

	public String getFileForOutput ()
	{
		String returning = "";
		for (int i = 0; i < file.size(); i++)
		{
			if (i != file.size() - 1)
			{
				returning += file.get(i) + "\n";
			}
			else
			{
				returning += file.get(i);
			}
		}
		return returning;
	}

	public void setFile (ArrayList<String> newFile)
	{
		this.file = newFile;
	}
	
	public String getLine (int line)
	{
		return (String) file.get(line);
	}
	
	public void setLine (int line, String text)
	{
		file.set (line, text);
	}
	
	public void writeToLine (int line, String text)
	{
		this.setLine (line, this.getLine (line) + text);
	}
	
	public void saveFile () throws IOException
	{
		BufferedWriter Writer = new BufferedWriter (new FileWriter (fileName));
		for (int i = 0; i < file.size(); i++)
		{
			Writer.write (file.get (i) + "\r\n");
		}
		Writer.close();
	}

	public String getFileName ()
	{
		return this.fileName;
	}
}