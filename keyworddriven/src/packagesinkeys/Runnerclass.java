package packagesinkeys;

import java.io.File;
import java.lang.reflect.Method;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Runnerclass 
{

	
	public static void main(String[] args) throws Exception 
	{
		//Open excel file for reading
				File f=new File("keyworddriven2016excel.xls");
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet rsh1=rwb.getSheet(0);
				int not=rsh1.getRows();
				Sheet rsh2=rwb.getSheet(1);
				int nos=rsh2.getRows();
				int nouc=rsh2.getColumns();
				//Open excel file for writing
				WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
				WritableSheet wsh=wwb.getSheet(1);
				//create obj to methods class
				Gmailmethods gm=new Gmailmethods();
				//Collect methods information in to an array
				Method m[]=gm.getClass().getMethods();
				//calling methods
				for(int i=1;i<not;i++)
				{
					String tid=rsh1.getCell(0,i).getContents();
					String mode=rsh1.getCell(2,i).getContents();
					if(mode.equalsIgnoreCase("yes"))
					{
						for(int j=1;j<nos;j++)
						{
							String sid=rsh2.getCell(0,j).getContents();
							if(tid.equalsIgnoreCase(sid))
							{
								String mn=rsh2.getCell(2,j).getContents();
								String o=rsh2.getCell(3,j).getContents();
								String d=rsh2.getCell(4,j).getContents();
								String c=rsh2.getCell(5,j).getContents();
								System.out.println(mn+" "+o+" "+d+" "+c);
								for(int k=0;k<m.length;k++)
								{
									if(m[k].getName().equals(mn))
									{
										String r=(String) m[k].invoke(gm, o,d,c);
										Label l=new Label(nouc,j,r);
										wsh.addCell(l);
									}
								}
							}
						}
					}
				}
				//save and close excel
				wwb.write();
				wwb.close();
				rwb.close();
				

		
	}

}
