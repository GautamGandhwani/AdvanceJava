package co.in.Test;

import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("co.in.bundle.app");
		System.out.println("Greeting = " + rb.getString("greeting"));
	}
}
