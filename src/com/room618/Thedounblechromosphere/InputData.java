package com.room618.Thedounblechromosphere;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;


public class InputData {
	static LinkedList<ChrData> chrDataList;
	
	public InputData() {
		 chrDataList = new LinkedList<ChrData>();
		 String path = UI.path;
		 File folder = new File(path);
		 File data[] = folder.listFiles();
		 if (data == null)
		 		return;
		 	else{
		 		for (int i = 0; i < data.length; i++) {
		 			File file_inlist = data[i];
		 			openFile(file_inlist.toString());
		 		}
		 	}
	}
	
	private static void openFile(String fileName){
		try{
			BufferedReader bf = new BufferedReader(new FileReader(fileName));
			String line = null;
			String issue = null;
			while (!(line=bf.readLine()).equals("")){
				String data = line.substring(11, 31);
				issue = line.substring(0,7);
				int[] red = new int[6];
				int blue = 0;
				for (int i=0;i<7;i++){
					if (i<6){
						red[i] = Integer.parseInt(data.substring(i*3, i*3+2));
					}
					else {
						blue = Integer.parseInt(data.substring(i*3, i*3+2));
					}
				}
				chrDataList.add(new ChrData(red,blue,issue));
			}
			bf.close();
		}
		catch(Exception e){
		}
	}
}
