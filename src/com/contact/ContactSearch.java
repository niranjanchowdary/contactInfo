package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class ContactSearch extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		// input from user to add contact
		String name = req.getParameter("name");
		if (name != null && name != "") {
			Entity e = ContactsStore.searchCon(name);
			if (e == null) {
				resp.sendError(420, "sorry contact is there");
			} else {
				out.println(e.getKey()+ " details are.....");
				Map<String, Object> values = e.getProperties();
				for (Map.Entry<String, Object> obj : values.entrySet()) {
					Object val = obj.getValue();
					out.println(obj.getKey() + "  details are  " + val.toString() + "<br>");
				}
			}
		} else {
			out.print("sorry please enter contact details ");
		}
	}

}
