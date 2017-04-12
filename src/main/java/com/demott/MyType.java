package com.demott;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyType implements Serializable {

	private static final long serialVersionUID = -8737842418024012979L;

	@Override
	public String toString() {
		return "This is a MyType";
	}

	public static void main(String[] args) {
		/** Notice the odd syntax here **/
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("myType.ser"))) {
			System.out.println("Writing myType.ser to this project serialized");
			outStream.writeObject(new MyType());
			outStream.flush();
			System.out.println("Done");
			System.out.println(
					"Once ran if you do a refresh on your project you'll see a file named myType.ser that was serialized and written out");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		/** with this syntax you no longer need to close your resource **/
		/** As soon as you break scope, the resource is automatically closed **/
		/** This is excellent when you want to help reduce accidental **/
		/** resource leaks **/
	}
}