package docSimilarity;

import java.awt.EventQueue;

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					@SuppressWarnings("unused")
					Gui window = new Gui();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}
