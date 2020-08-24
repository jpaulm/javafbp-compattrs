package com.jpaulmorrison.doclets;

import java.io.File;

/**
 * Main method is jist for debugging - this is normally run under javadoc command - see 
 *   javafbpcompattrs.bat in `dist` folder ...
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import com.sun.javadoc.*;
import com.sun.tools.javadoc.AnnotationDescImpl;


public class JavaFBPCompAttrs {
	public static boolean start(RootDoc root) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//System.out.println("Starting");
		PrintWriter writer = null;
		String user = System.getProperty("user.home");
		String fn = user + "/temp";
		int level = 0;      // can have three values: 0, 1 and 2
		File file = new File(fn);		
		file.mkdirs();		
		try {
		    file = new File(fn + "/JavaFBPCompAttrs.html");
			writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		ClassDoc[] classes = root.classes();
		//System.out.println("Count: " + classes.length);
		//System.out.println(classes);
		writer.println("<html> <body><h1>JavaFBP Component Attributes</h1> <p>");
		AnnotationDescImpl adi;
		String className = "";
		for (int i = 0; i < classes.length; ++i) {
			writer.println("</p>");
			int v = classes[i].toString().lastIndexOf(".");
			if (!(className.equals(classes[i].toString().substring(0, v)))) {
				className = classes[i].toString().substring(0, v);
				//if (level == 1)  
				//	writer.println("</ul>");					
				//if (level == 2)
					writer.println("</ul></ul>");
				writer.println("<h2>" + className + "</h2><p>");
				
				level = 0;
				writer.println("<ul>");
				level ++;
			}
			
			writer.println("<li>" + "<b>" +  classes[i].toString().substring(v + 1) + "</b>");
			//if (level == 2)	{			
			//	writer.println("</ul>");
			//	level --;
			//}
			writer.println("<ul>");
			level ++;
			//System.out.println(classes[i]);
			
			AnnotationDesc[] anns = classes[i].annotations();
			
			for (int j = 0; j < anns.length; ++j) {
				writer.println("<li>"); 
				adi = (AnnotationDescImpl) anns[j];
				//System.out.println(className + " " + adi);
				String s = adi.annotationType().toString();
				
				if (!(s.endsWith("InPorts") || s.endsWith("OutPorts"))) {	
					dispADI(adi, s, writer);
				}

				else {
					AnnotationDesc.ElementValuePair[] vp = adi.elementValues();
					for (int k = 0; k < vp.length; ++k) {						
						AnnotationDescImpl adi2;						
						AnnotationValue[] ava = (AnnotationValue[]) vp[k].value().value();
						for (AnnotationValue av : ava) {
							adi2 = (AnnotationDescImpl) av.value();
							String s2 = adi2.annotationType().toString();							
							dispADI(adi2, s2, writer);
						}
					}
				}
			}
 		writer.println("</ul>");
					 	level --;
		}
		writer.println("</ul>");
	 	level --;

		writer.println("</p></body></html>");
		writer.close();
		System.out.println("Javadoc written to \"" + file.getAbsolutePath() + "\"");
		return true;
	}

	static void dispADI(AnnotationDescImpl adi, String s, PrintWriter w) {

		String t = s.substring(s.lastIndexOf(".") + 1);
		//w.println("</p><h4>" + t +"</h4><p> ");
		t = t.trim();
		
		String port = "<p><i>" + t + "</i> ";
		AnnotationDesc.ElementValuePair[] vp = adi.elementValues();
		
		if (vp.length > 0)
			port += "<b>: </b>";

		for (int k = 0; k < vp.length; ++k) {
			if (k > 0)
				port += ", ";
			t = vp[k].element().toString();
			t = t.substring(s.length() + 1); // element() with annotationType
												// stripped off
			t = t.substring(0, t.lastIndexOf("()")); // strip off ()
			if (t.equals("value")) 
				//w.println("</p><p>" + vp[k].value());
				port += vp[k].value();
			else
				//w.println("</p><p>" + t + " - " + vp[k].value());
				port += t + " - " + vp[k].value();
		}
		w.println(port + "</p>");
	}

	
}
