package com.room618.Thedounblechromosphere;

import java.util.LinkedList;

class Sort{
	static int[] red = new int [6];
	static int blue;
	static LinkedList sevenSame;
	static LinkedList sixSame;
	static LinkedList fiveSame;
	static LinkedList fourSame;
	static ChrData chrData;
	static String output = null;

	protected static void sort() {
		getNumber();

		for(int counter1 = 0; counter1 < 6; counter1 ++) {
			for(int counter2 = 5; counter2 > counter1; counter2 --) {
				if(red[counter2] < red[counter2 - 1]) {
					int temp = red[counter2];
					red[counter2] = red[counter2 - 1];
					red[counter2 - 1] = red[counter2];
				}
			}
		}
		
		for(int counter = 0; counter < 6; counter ++) {
			System.out.println(red[counter]);
		}
		System.out.println(blue);

		CompareChromosphere ccs = new CompareChromosphere(red,blue);

		sevenSame = ccs.getSevenSame();
		sixSame = ccs.getSixSame();
		fiveSame = ccs.getFiveSame();
		fourSame = ccs.getFourSame();

		output();
	}

	private static void getNumber() {
		int[] number = Main.ui.getNumber();
		for(int counter = 0; counter < 6; counter ++) {
			red[counter]  = number[counter] ;
		}
	 	blue = number[6];
	}

	private static void output() {
		if (sixSame.size() == 0) {
			output = "没有六个红球都相同的\n";
		} else {
			output = "六个红球都相同的有" + sixSame.size() + "个\n";
			for (int counter = 0; counter < sixSame.size(); counter ++) {
				chrData = (ChrData) sixSame.get(counter);
				for(int counter2 = 0; counter2 < 6; counter2 ++ ) {
					output = output + chrData.getRed()[counter2] + " ";
				}
				output = output + "| ";
				output = output + chrData.getBlue() + " | ";
				output = output + chrData.getIssue() + "\n";
			}
		}
		
		if (fiveSame.size() == 0) {
			output = output + "没有有五个红球相同的\n";
		} else {
			output = output + "有五个红球相同的有" + fiveSame.size() + "个\n";
			for (int counter = 0; counter < fiveSame.size(); counter ++) {
				chrData = (ChrData) fiveSame.get(counter);
				for(int counter2 = 0; counter2 < 6; counter2 ++ ) {
					output = output + chrData.getRed()[counter2] + " ";
				}
				output = output + "| ";
				output = output + chrData.getBlue() + " | ";
				output = output + chrData.getIssue() + "\n";
			}
		}

		if (fourSame.size() == 0) {
			output = output + "没有有四个红球相同的\n";
		} else {
			output = output + "有四个红球相同的有" + fourSame.size() + "个\n";
			for (int counter = 0; counter < fourSame.size(); counter ++) {
				chrData = (ChrData) fourSame.get(counter);
				for(int counter2 = 0; counter2 < 6; counter2 ++ ) {
					output = output + chrData.getRed()[counter2] + " ";
				}
				output = output + "| ";
				output = output + chrData.getBlue() + " | ";
				output = output + chrData.getIssue() + "\n";
			}
		}

//		if (fourSame.size() == 0) {
//			output = output + "没有有三个红球相同的\n";
//		} else {
//			output = output + "有三个红球相同的有" + fourSame.size() + "个\n";
//			for (int counter = 0; counter < fourSame.size(); counter ++) {
//				chrDate = (ChrData) fourSame.get(counter);
//				for(int counter2 = 0; counter2 < 6; counter2 ++ ) {
//					output = output + chrDate.getRed()[counter2] + " ";
//				}
//				output = output + chrDate.getBlue() + " ";
//				output = output + chrDate.getIssue() + "\n";
//			}
//		}
//		System.out.println(output);
		Main.ui.setTextArea(output);
	}
}
