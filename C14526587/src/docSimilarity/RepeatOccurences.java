package docSimilarity;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RepeatOccurences
{
	public static void repeats(String words1, String words2, String stopWords, boolean stopWordsOption, boolean saveFile, File saveLoc) throws IOException
	{
		stopWords = stopWords.toLowerCase();
		
		words1 = words1.toLowerCase();
		words1 = words1.replaceAll("[\",.()-;:%\n\r]", "");
		words1 = words1.replace("\\]", "");
		words1 = words1.replace("\\[", "");
		words1 = words1.replaceAll("[0-9]", "");
		
		words2 = words2.toLowerCase();
		words2 = words2.replaceAll("[\",.()-;:%\n\r]", "");
		words2 = words2.replaceAll("\\]", "");
		words2 = words2.replaceAll("\\[", "");
		words2 = words2.replaceAll("[0-9]", "");

		String[] stopWordList = stopWords.split("\r\n");
		String[] wordList1 = words1.split(" ");
		String[] wordList2 = words2.split(" ");
		
		String[] finalList1 = new String[wordList1.length];
		String[] finalList2 = new String[wordList2.length];
		
		if(stopWordsOption == true)
		{/*
			for( int i = 0 ; i < wordList1.length ; i ++ )
			{
				for ( int j = 0 ; j < stopWordList.length ; j ++ )
				{
					String temp = stopWordList[j];
					finalList1[i] = wordList1[i].replaceAll( temp, "" );
				}
			}
			for( int i = 0 ; i < wordList2.length ; i ++ )
			{
				for ( int j = 0 ; j < stopWordList.length ; j ++ )
				{
					String temp = stopWordList[j];
					finalList2[i] = wordList2[i].replaceAll( temp, "" );
				}
			}*/
			
			for( int i = 0, j = 0; i < wordList1.length ; i ++ )
			{
				if ( wordList1[i] != null && !wordList1[i].isEmpty())
				{
					finalList2[j] = wordList1[i];
					j ++;
				}
			}
			for( int i = 0, j = 0; i < wordList2.length ; i ++ )
			{
				if ( wordList2[i] != null && !wordList2[i].isEmpty())
				{
					finalList2[j] = wordList2[i];
					j ++;
				}
			}
		}
		else
		{
			finalList1 = wordList1 ;
			finalList2 = wordList2 ;
		}
		
		
		
		String[] occured1 = new String[wordList1.length];
		String[] occured2 = new String[wordList2.length];
		
		int[] countInt1 = new int[wordList1.length];
		int[] countInt2 = new int[wordList2.length];
		
		int[][] corolation;
		int[] top ;

		occured1[0] = finalList1[0];
		occured2[0] = finalList2[0];
		countInt1[0] = 1 ;
		countInt2[0] = 1 ;
		
		if(finalList1.length > 0)
		{
			for(int i = 1, l = 0 ; i < finalList1.length ; i ++)
			{
				boolean found = false;
				
				for (int j = 0 ; j < i ; j ++)
				{
					if (finalList1[i].equals(occured1[j]))
					{
						countInt1[j] ++ ;
						found = true;
					}
				}
				
				if (found == false)
				{
					l ++ ;
					occured1[l] = finalList1[i];
					countInt1[l] = 1;
				}
			}
		}
		
		if(finalList2.length > 0)
		{
			for(int i = 1, l = 0 ; i < finalList2.length ; i ++)
			{
				boolean found = false;
				
				for (int j = 0 ; j < i ; j ++)
				{
					if (finalList2[i].equals(occured2[j]))
					{
						countInt2[j] ++ ;
						found = true;
					}
				}
				
				if (found == false)
				{
					l ++ ;
					occured2[l] = finalList2[i];
					countInt2[l] = 1;
				}
			}
		}
		
		int end1 = 0;
		int end2 = 0;
		
		for(int i = 0 ; i < occured1.length ; i ++ )
		{
			if (occured1[i] == null)
			{
				end1 = i ;
				break;
			}
		}
		for(int i = 0 ; i < occured2.length ; i ++ )
		{
			if (occured2[i] == null)
			{
				end2 = i ;
				break;
			}
		}
		
		String[] temp1 = new String[end1];
		String[] temp2 = new String[end2];
		
		for (int i = 0 ; i < occured1.length ; i ++ )
		{
			if(occured1[i] != null && i < end1)
			{
				temp1[i] = occured1[i];
			}
		}
		
		for (int i = 0 ; i < occured2.length ; i ++ )
		{
			if(occured2[i] != null && i < end2)
			{
				temp2[i] = occured2[i];
			}
		}
		
		int max = 0 ;
		
		if (temp1.length > temp2.length)
		{
			corolation = new int[temp1.length][4];
			int l = 0;
			
			if(temp1.length > 0 && temp2.length > 0)
			{
				for(int i = 0 ; i < temp1.length ; i ++)
				{					
					for (int j = 0 ; j < temp2.length ; j ++)
					{
						if (temp1[i].equals(temp2[j]))
						{
							corolation[l][0] = i;
							corolation[l][1] = j;
							corolation[l][2] = countInt1[i];
							corolation[l][3] = countInt2[j];
							l ++;
							break;
						}
					}
				}
				max = (l - 1) ;
			}
		}
		else
		{
			corolation = new int[temp2.length][4];
			int l = 0;
			
			if(temp1.length > 0 && temp2.length > 0)
			{
				for(int i = 0 ; i < temp2.length ; i ++)
				{					
					for (int j = 0 ; j < temp1.length ; j ++)
					{
						if (temp2[i].equals(temp1[j]))
						{
							corolation[l][0] = j;
							corolation[l][1] = i;
							corolation[l][2] = countInt1[j];
							corolation[l][3] = countInt2[i];
							l ++;
							break;
						}
					}
				}
				max = (l - 1) ;
			}
		}
		
		top = topTen(corolation, max);
		
		
		System.out.println("The top ten words common to both files:");
		System.out.printf("%-17s %5s %5s\n", "Word", "File 1", "File 2");
		for( int i = 0 ; i < 10 ; i ++ )
		{
			System.out.printf( "%-12s %6d %6d\n", occured1[ corolation[ top[ i ] ] [0] ], corolation[top[i]][2], corolation[top[i]][3] );
		}
		
		if (saveFile == true)
		{
			Save.saveTopList( corolation, top, occured1, saveLoc);
		}
		
		JFrame window = new JFrame("Top 10 words common to both");
		JOptionPane.showMessageDialog( window, "Word        File 1    File 2\n" 
										+ occured1[ corolation[ top[ 0 ] ] [0] ] + "      " + corolation[top[0]][2] + "   " + corolation[top[0]][3] + "\n"
										+ occured1[ corolation[ top[ 1 ] ] [0] ] + "      " + corolation[top[1]][2] + "   " + corolation[top[1]][3] + "\n"
										+ occured1[ corolation[ top[ 2 ] ] [0] ] + "      " + corolation[top[2]][2] + "   " + corolation[top[2]][3] + "\n"
										+ occured1[ corolation[ top[ 3 ] ] [0] ] + "      " + corolation[top[3]][2] + "   " + corolation[top[3]][3] + "\n"
										+ occured1[ corolation[ top[ 4 ] ] [0] ] + "      " + corolation[top[4]][2] + "   " + corolation[top[4]][3] + "\n"
										+ occured1[ corolation[ top[ 5 ] ] [0] ] + "      " + corolation[top[5]][2] + "   " + corolation[top[5]][3] + "\n"
										+ occured1[ corolation[ top[ 6 ] ] [0] ] + "      " + corolation[top[6]][2] + "   " + corolation[top[6]][3] + "\n"
										+ occured1[ corolation[ top[ 7 ] ] [0] ] + "      " + corolation[top[7]][2] + "   " + corolation[top[7]][3] + "\n"
										+ occured1[ corolation[ top[ 8 ] ] [0] ] + "      " + corolation[top[8]][2] + "   " + corolation[top[8]][3] + "\n"
										+ occured1[ corolation[ top[ 9 ] ] [0] ] + "      " + corolation[top[9]][2] + "   " + corolation[top[9]][3]	) ;
	}
	
	private static int[] topTen(int[][] corolation, int max)
	{
		int[] highest = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
		int[] highLocations = {0,0,0,0,0,0,0,0,0,0};
		int tally = 0 ;
		
		boolean flag = false ;
		
		for ( int i = 0, j = 0 ; i < max ; i ++ )
		{
			tally = ( corolation[i][2] + corolation[i][3] );
			
			if ( !flag )
			{
				for (  ; j < 10 ;  )
				{
					if (highest[j] == -1)
					{
						highest[i] = tally;
						highLocations[i] = i;
						j ++ ;
						if (j == 10)
						{
							flag = true;
						}
						break;
					}
				}
			}
			else if( flag )
			{
				int smallest = highest[0];
				int tracer = 0;
				boolean found = false;
				
				for ( j = 0 ; j < 10 ; j ++ )
				{
					if (tally == highest[j] )
					{
						found = true;
					}
					
					if ( highest[j] < smallest )
					{
						smallest = highest[j];
						tracer = j;
					}
				}
				
				if ( tally > smallest && (found == false))
				{
					highest[tracer] = tally ;
					highLocations[tracer] = tracer;
				}
			}
			
			
			
		}
		
		return highLocations;
	}
}
