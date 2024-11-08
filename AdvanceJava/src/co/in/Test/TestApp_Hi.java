package co.in.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp_Hi {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("co.in.bundle.app", new Locale("hi"));
		ResourceBundle rb1 = ResourceBundle.getBundle("co.in.bundle.app", new Locale("sp"));
		System.out.println("Greeeting = " + rb.getString("greeting"));
		System.out.println("Greeting =  " + rb1.getString("greeting"));
	}
}