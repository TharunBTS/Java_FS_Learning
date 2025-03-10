package mphasis.test;



import java.util.Date;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class myTag extends TagSupport{
	
	@Override
	public int doStartTag()
	{
		JspWriter out = null;
		
		try
		{
			out = pageContext.getOut();
			Date date = new Date();
			out.println("Current System Date : "+ date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SKIP_BODY;
		
	}
	

}
