package core;

import java.io.*;


public class Parser{	
	public static double[][] getData() {
		double i[][] = {{0,0,1},{1,10,0},{0,0,1}};
		return i;
	}
	
	public static double[][] parse() {
		String fileLocation = "/home/lvuser/source.txt"; //TODO make this better
		double data[][] = new double[10][3];  //TODO make this smart and not hard coded
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = -1;
			}
		}
		
		int lineCounter = 0;
		
		try {
			FileInputStream fis = new FileInputStream(new File(fileLocation));
//			ClassLoader cs = Thread.currentThread().getContextClassLoader();
			//DataInputStream in =  cs.getResourceAsStream("source.txt"); 
			DataInputStream in = new DataInputStream(fis);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader bis = new BufferedReader(isr); 
			String input;
			
			
			input = bis.readLine();
			do{
				System.out.print(input + "\n");
				System.out.print(" " + lineCounter + '\n');
				String words[] = input.split(",");

				data[lineCounter][0] = Steps.getStep(Type.valueOf(words[0].toUpperCase())); 
				
				for(int i = 1; i<words.length; i++) {
					data[lineCounter][i] = Double.parseDouble(words[i]);
				}
				lineCounter++;
				input = bis.readLine();
			}
			while(input != null);
				
			
//			System.out.println(bis.readLine());
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		for (int i = 0; i < data.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "\t");

			}
		}
		
		return data;
	}
	
}
