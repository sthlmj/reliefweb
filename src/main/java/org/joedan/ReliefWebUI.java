package org.joedan;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.joedan.client.ReliefWebClient;
import org.joedan.view.JobOverviewView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ReliefWebUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		layout.addComponent(new JobOverviewView());
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "WebServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ReliefWebUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	@WebServlet(urlPatterns = "/update", name = "UpdateServlet", asyncSupported = true)
	public static class UpdateServlet extends HttpServlet {

		protected void doGet(HttpServletRequest request,
							 HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			new ReliefWebClient().update(out);
		}
	}
}
