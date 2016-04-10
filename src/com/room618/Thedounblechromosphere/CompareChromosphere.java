package com.room618.Thedounblechromosphere;

import java.util.LinkedList;

class CompareChromosphere {	
//	public static void main(String[] args){
//		new InputData();
//		int[] x = {8,13,15,20,21,25};
//		new CompareChromosphere(x,12);
//	}
	
	private static LinkedList<ChrData> sevenSame;   //锟斤拷锟竭革拷锟斤拷锟斤拷锟斤拷同锟斤拷锟斤拷锟斤拷
	private static LinkedList<ChrData> sixSame;     //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵拷锟斤拷锟斤拷锟�?
	private static LinkedList<ChrData> fiveSame;	   //锟斤拷锟侥革拷锟斤拷锟斤拷锟斤拷同锟斤拷锟斤拷锟斤拷
	private static LinkedList<ChrData> fourSame;    //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷同锟斤拷锟斤拷锟斤拷
	private static int [] redBall;    
	private static int  blueBall;
	private LinkedList<?> chrDataList;
	
	/*  
	 *    锟斤拷锟斤拷锟斤拷装锟斤�?  chrData  
	 *   */
	CompareChromosphere(int [] redBall,int blueBall)
	{
		this.redBall = redBall;
		this.blueBall = blueBall;
		chrDataList = InputData.chrDataList;
		for(int counter = 0; counter < 6; counter ++) {
			System.out.println(this.redBall[counter]);
		}
		System.out.println(this.blueBall);
		startCompare();
	}
	
	void startCompare()
	{
		sevenSame = new LinkedList();
		sixSame = new LinkedList();
		fiveSame = new LinkedList(); 
		fourSame = new LinkedList();
		
		int numOfSeven = 0;
		int numOfSix = 0;
		int numOfFive = 0;
		int numOfFour = 0;
		System.out.println(chrDataList.size());
		for(int i =0; i<chrDataList.size(); i++ )
		{
			int num = 0;
			ChrData tempData = (ChrData)chrDataList.get(i);
//			if(tempData.getBlue() == blueBall)   //锟斤拷锟斤拷锟斤拷斜榷锟�?
//				num++;
			int [] red = tempData.getRed();
			int k =0;
			for(int j=0; j<red.length; j++)    //锟斤拷锟斤拷锟斤拷斜榷锟�?
			{
				while(k<red.length)
				{
					if(red[j]==redBall[k]){
						num++;
						k++;
						break;
					}
					else if(red[j]<redBall[k]){
						break;
					}
					else
						k++;
				}
				
			}
			if(num==7)                       //锟斤拷锟斤拷锟斤拷锟接︼拷锟斤拷锟�
				sevenSame.add(tempData);
			else if(num==6)
				sixSame.add(tempData);
			else if(num==5)
				fiveSame.add(tempData);
			else if(num==4)
				fourSame.add(tempData);
		}
		
	}

	LinkedList getSevenSame()   //锟斤拷锟斤拷锟竭革拷锟斤拷同锟斤拷锟斤拷锟斤�?
	{
		return sevenSame;
	}
	
	LinkedList getSixSame()
	{
		return sixSame;
	}
	
	LinkedList getFiveSame()
	{
		return fiveSame;
	}
	
	LinkedList getFourSame()
	{
		return fourSame;
	}
	
 
 }
