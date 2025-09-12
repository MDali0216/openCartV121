package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\TestData\\OpenCart_logindata.xlsx";//taking xl file from TestData
		
		ExcelUtility xlutil = new ExcelUtility(path);//creating object for xl utility file
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String [totalrows][totalcols];// creating two dimentional Array which can store rows and cols
		
		for(int r=1;r<=totalrows;r++)
		{
			for(int c=0;c<totalcols;c++)
			{
				loginData[r-1][c]=xlutil.getCellData("Sheet1", r, c);
			}
		}
		return loginData;// Returning two dimentional Array
	}
	

}
