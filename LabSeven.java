import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LabSeven{
	public static void main(String[] args){
		File imageFile = new File("image.txt");
		
		int imageHeight = countFileLines("image.txt");

		String[] image1D = scanImage(imageHeight,"image.txt");

		int imageWidth = findImageWidth(image1D,"image.txt");

		char[][] image2D = renderImage(image1D, imageHeight, imageWidth,"image.txt");
		
		System.out.println("Original image:");
		printImage(image2D);

		System.out.println();
		char[][] flippedImage = flipImageLeftToRight(image2D);

		System.out.println("Flipped image:");
		printImage(flippedImage);

	}
 	public static int countFileLines(String fileName) {
 		int amountLines = 0;
		try{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine()){
				amountLines++;
				fileReader.nextLine();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return amountLines;
	}

	public static String[] scanImage(int height,String fileName) {
		String [] image = new String[height];
		int index = 0;
		try{
			Scanner fileReader = new Scanner(new File(fileName));
			for(int i=0;i<height;i++){
			String line = fileReader.nextLine();
			image[i]=line;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return image;
	}

	public static int findImageWidth(String[] image,String fileName) {
		int maxWidth = Integer.MIN_VALUE;
		int index = 0;
		try{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				if(maxWidth<line.length()){
					maxWidth=line.length();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return maxWidth;
	}

	public static char[][] renderImage(String[] image1D, int height, int width, String fileName) {
		char [][] charArr = new char[height][width];
		try{
			Scanner fileReader = new Scanner(new File(fileName));
			for(int i=0;i<width;i++){
				for(int j=0;j< image1D[i].length();j++){
					char iChar = image1D[i].charAt(j);
					charArr[i][j]=iChar;
				}
				for(int j = image1D[i].length();j<width;j++){
					charArr[i][j]=' ';
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return charArr;
	}

	public static char[][] flipImageLeftToRight(char[][] original) {
		int height = original.length;
		int width = original[0].length;
		char [][] flippedArr = new char[height][width];

		for(int i=0;i<height;i++){
			for(int j =0;j<width;j++){
				flippedArr[i][width-j-1]=original[i][j];
			}
		}
		return flippedArr;
	}

	public static void printImage(char[][] image) {
		for(int i=0;i<image.length;i++){
			for(int j=0;j<image[i].length;j++){
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
	}


}
