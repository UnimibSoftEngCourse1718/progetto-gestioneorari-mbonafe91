
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import java.util.*;
import org.openxava.util.*;
import org.openxava.application.meta.*;
import org.openxava.generators.*;

/**
 * Program Generator created by TL2Java
 * @version Thu Nov 09 12:33:39 CET 2017
 */
public class Jetspeed2FolderPG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.print("\n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->");
    
    String applicationName = properties.getProperty("arg3");
    String folder = properties.getProperty("arg4");
    MetaApplication application = MetaApplications.getMetaApplication(applicationName);
    String title = Is.emptyString(folder)?application.getLabel():application.getFolderLabel(folder);
    title = Strings.toCharSet(title, "UTF-8");
    String group = Is.emptyString(folder)?applicationName:applicationName + "." + Strings.change(folder, "/", ".");
    
    Collection locales = Generators.getAvailableLocales("../" + applicationName + "/i18n");
    
    out.print(" \n<folder>\n\t<title>");
    out.print(title);
    out.print("</title>");
    	
    for (Iterator it=locales.iterator(); it.hasNext();) {
    	Locale locale = (Locale) it.next();
    	String i18nTitle = Is.emptyString(folder)?application.getLabel(locale):application.getFolderLabel(locale, folder);
    	i18nTitle = Strings.toCharSet(i18nTitle, "UTF-8");
    
    out.print("     \n\t<metadata name=\"title\" xml:lang=\"");
    out.print(locale);
    out.print("\">");
    out.print(i18nTitle);
    out.print("</metadata>");
    
    }
    
    	
    for (Iterator it=application.getModulesNamesByFolder(folder).iterator(); it.hasNext();) {
    
    out.print("     \n\t<document-order>");
    out.print(it.next());
    out.print(".psml</document-order>");
    
    }
    
    out.print(" \n\n\t<security-constraints>\n\t\t<security-constraint>\n\t\t\t<groups>");
    out.print(group);
    out.print("</groups>\n\t\t\t<permissions>view, edit</permissions>\n\t\t</security-constraint>\n\t</security-constraints>\n  \n</folder>");
    
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * A program generator is typically (but not always) invoked
     * with a command line with arguments for the XML input file
     * and output file.
     */    
    public static void main(String[] args) {
        try {
            ProgramWriter out = args.length>=2
                ?new ProgramWriter(new FileOutputStream(args[1]))
                :new ProgramWriter(System.out);
            Jetspeed2FolderPG pg = new Jetspeed2FolderPG();
            for (int j=1; j<=args.length; ++j) {
                pg.properties.put("arg"+j, args[j-1]);
            }
            pg.generate(new XPathContext(args[0]), out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This array provides program generator development history
     */
    public String[][] history = {
        { "Thu Nov 09 12:33:39 CET 2017", // date this file was generated
             "F:\\java\\workspaces\\workspace_openxava\\OpenXava\\generator\\jetspeed2folder.xml", // input file
             "F:\\java\\workspaces\\workspace_openxava\\OpenXava\\generator\\Jetspeed2FolderPG.java" }, // output file
        {"Mon Apr 09 16:45:30 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:39:37 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:37:21 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:49:11 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:30:24 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 11:13:01 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 10:57:04 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Wed Apr 26 11:15:41 EDT 2000", "..\\input\\TL2Java.xml", "TL2Java1.java", }, 
        {"April 2000", "hand coded", "TL2Java1.java", }, 

    };
}