package docSimilarity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile
{
	public static void read(File myFile1, File myFile2, File myStopWords, boolean stopWordOption, boolean saveFile, File saveLoc)
	{
		try
		{
			FileInputStream in1 = new FileInputStream(myFile1);
			FileInputStream in2 = new FileInputStream(myFile2);
			
			byte[] txtDoc1 = new byte [(int) myFile1.length()];
			byte[] txtDoc2 = new byte [(int) myFile2.length()];
			
			in1.read(txtDoc1);
			in2.read(txtDoc2);
			
			in1.close();
			in2.close();
			
			String doc1 = new String(txtDoc1, "UTF-8");
			String doc2 = new String(txtDoc2, "UTF-8");
			String doc3 = new String("UTF-8");
			
			if(stopWordOption == true)
			{
				FileInputStream in3 = new FileInputStream(myStopWords);
				byte[] txtDoc3 = new byte [(int) myStopWords.length()];
				in3.read(txtDoc3);
				in3.close();
				doc3 = new String(txtDoc3, "UTF-8");
			}
			
			RepeatOccurences.repeats(doc1, doc2, doc3, stopWordOption, saveFile, saveLoc);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
