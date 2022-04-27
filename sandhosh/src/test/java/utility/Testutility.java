package utility;

import java.util.ArrayList;
import com.excel.lib.util.Xls_Reader;;

public class Testutility {
	static Xls_Reader reader;
public static ArrayList<Object[]> getDataFromExcel() {
	// TODO Auto-generated method stub
	ArrayList<Object[]> mydata=new ArrayList<Object[]>();
	try {
	reader=new Xls_Reader("E:\\MedeilAutomation\\MedeilLogin\\src\\test\\java\\utility\\testdata.xlsx");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	int rowcount=reader.getRowCount("CRM_ADD_PATIENT");
	for(int rowNum=2;rowNum<=rowcount;rowNum++) {
		String patientname=reader.getCellData("CRM_ADD_PATIENT", "PatientFirstName", rowNum);
		String PatientLastName=reader.getCellData("CRM_ADD_PATIENT", "PatientLastName", rowNum);
		String Gender=reader.getCellData("CRM_ADD_PATIENT", "Gender", rowNum);
		String dob=reader.getCellData("CRM_ADD_PATIENT", "dob", rowNum);
		String VATGST=reader.getCellData("CRM_ADD_PATIENT", "VATGST", rowNum);
		String Category=reader.getCellData("CRM_ADD_PATIENT", "Category", rowNum);
		String patienttype=reader.getCellData("CRM_ADD_PATIENT", "patienttype", rowNum);
		String Address1=reader.getCellData("CRM_ADD_PATIENT", "Address1", rowNum);
		String Address2=reader.getCellData("CRM_ADD_PATIENT", "Address2", rowNum);
		String PINCode=reader.getCellData("CRM_ADD_PATIENT", "PINCode", rowNum);
		String Country=reader.getCellData("CRM_ADD_PATIENT", "Country", rowNum);
		String State=reader.getCellData("CRM_ADD_PATIENT", "State", rowNum);
		String City=reader.getCellData("CRM_ADD_PATIENT", "City", rowNum);
		String MobileNumber=reader.getCellData("CRM_ADD_PATIENT", "MobileNumber", rowNum);
		String EmailId=reader.getCellData("CRM_ADD_PATIENT", "EmailId", rowNum);
		String PhoneNumber=reader.getCellData("CRM_ADD_PATIENT", "PhoneNumber", rowNum);
	     Object[] ob= {patientname,PatientLastName,Gender,dob,VATGST,Category,patienttype,Address1,Address2,PINCode,Country,State,City,MobileNumber,EmailId,PhoneNumber};
	     mydata.add(ob);
	}
	return mydata;
}
}

