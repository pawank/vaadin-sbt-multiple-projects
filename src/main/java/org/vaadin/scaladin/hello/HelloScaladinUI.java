package org.vaadin.scaladin.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.annotations.VaadinServletConfiguration;
import vaadin.scala.*;
import vaadin.scala.server.ScaladinRequest;
import vaadin.scala.internal.UriFragmentChangedListener;
import vaadin.scala.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;


@SuppressWarnings("serial")
public class HelloScaladinUI extends UI {
  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = HelloScaladinUI.class)
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
    //content = Button("Click me ", Notification.show("Hello, Scaladin 2"))
    VerticalLayout view = new VerticalLayout();
    view.addComponent(new Label("Hello Vaadin!"));
    setContent(view);
  }
}
