import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.IOException;
public class main
{
	public static void main(String[] args)  
	{
		try
		{
			String fi=args[0];
			File z=new File(fi);
			if (!fi.endsWith(".arxml")) 
			{
                throw new NotVaildAutosarFileException("Invalid file extension!");
            }
			if(z.length()==0)
			{
				throw new EmptyAutosarFileException("Empty file!");
			}
			FileInputStream file=new FileInputStream(fi);
			int data;
			StringBuilder x=new StringBuilder();
			while((data = file.read())!=-1)
			{
				x.append((char)data);
			}
			String d=x.toString();
			Scanner p = new Scanner(d);
			ArrayList<container> c=new ArrayList<>();
			while(p.hasNextLine())
			{
                String a=p.nextLine();
				if(a.contains("<CONTAINER UUID="))
				{
					String Id=a.substring(a.indexOf("<CONTAINER UUID=")+16,a.indexOf(">"));
					a=p.nextLine();
					String Sh=a.substring(a.indexOf("<SHORT-NAME>")+12,a.indexOf("</SHORT-NAME>"));
					a=p.nextLine();
					String Lo=a.substring(a.indexOf("<LONG-NAME>")+11,a.indexOf("</LONG-NAME>"));
					a=p.nextLine();
				    container k=new container();
			        k.setid(Id);
                    k.setsh_name(Sh);
                    k.setlon_name(Lo);
                    c.add(k);
				}
			}
			Collections.sort(c);
			String Out=fi.substring(0,fi.indexOf("."))+"_mod.arxml";
			FileOutputStream Out_File=new FileOutputStream(Out);
			Out_File.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
			Out_File.write("<AUTOSAR>\n".getBytes());
			for(int r=0;r<c.size();r++)
			{
				Out_File.write(c.get(r).toString().getBytes());
			}
			Out_File.write("</AUTOSAR>\n".getBytes());
		}
		catch(FileNotFoundException e)
		{
			e=new FileNotFoundException("File Not Found!");
		}
		catch(IOException e)
		{
			e=new IOException("IO Exception");
		}
		catch (NotVaildAutosarFileException e)
		{
			e=new NotVaildAutosarFileException("Invalid file extention!");
		}
	}
}
