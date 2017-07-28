package com.contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ContactsAdd extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		// input from user to add contact
		String name = req.getParameter("name");
		String phno =req.getParameter("phno1");
		String phno1 = req.getParameter("phno2");
		String email = req.getParameter("email");
		String email1 = req.getParameter("email1");
		String address = req.getParameter("address");
		Long phno_1=Long.parseLong(phno);
		Long phno_2=Long.parseLong(phno1);
		
		// sending data to persist
		if (name != null && name != "") {
			if (email.equals(null))
				email = "";
			if (email1.equals(null))
				email1 = "";
			if (address.equals(null))
				address = "";
			if (ContactsStore.addContact(name, phno, phno1, email, email1, address)) {
				System.out.println("successfully done");
				out.print("contact added successfully");
			} else {
				out.println("contact already there...");
				System.out.println("not done");
			}
		}
		// invalid contact
		else {
			resp.sendError(403, "name with empty not allowed");
			out.println("<a href='/about.jsp' ><button type='button'>Home</button></a>");

		}

	}
}
