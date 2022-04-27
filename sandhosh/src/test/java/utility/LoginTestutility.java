package utility;

import java.util.ArrayList;
import com.excel.lib.util.Xls_Reader;;

public class LoginTestutility {
	static Xls_Reader reader;
public static ArrayList<Object[]> getDataFromExcel1() {
	// TODO Auto-generated method stub
	ArrayList<Object[]> mydata=new ArrayList<Object[]>();
	try {
	reader=new Xls_Reader("E:\\MedeilAutomation\\MedeilLogin\\src\\test\\java\\utility\\testdata.xlsx");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	int rowcount=reader.getRowCount("USER_LOGIN");
	for(int rowNum=2;rowNum<=rowcount;rowNum++) {
		String username=reader.getCellData("USER_LOGIN", "username", rowNum);
		String password=reader.getCellData("USER_LOGIN", "password", rowNum);
		
	     Object[] ob= {username,password};
	     mydata.add(ob);
	}
	return mydata;
}
}

