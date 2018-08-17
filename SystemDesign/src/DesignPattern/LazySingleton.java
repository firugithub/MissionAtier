package DesignPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

//SingletonSerializationIssue 

public class LazySingleton implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazySingleton() {
	}

	private static class Singleton {

		private static final LazySingleton INSTANCE = new LazySingleton();
	}

	public static LazySingleton getInstance() {
		return Singleton.INSTANCE;
	}

	// if we remove this then we will get 2 different objects
	// readresolve returns INSTANCE after deserialization
	private Object readResolve() throws ObjectStreamException {
		System.out.println("Executing readResolve");
		return Singleton.INSTANCE;
	}
}

class SerializedSingletonClient {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		LazySingleton singletonInstance = LazySingleton.getInstance();
		// Serialize singleton object
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.ser"))) {
			out.writeObject(singletonInstance);
		}
		System.out.println("Serialization stage :singletonInstance hashCode=" + singletonInstance.hashCode());

		// Deserialize singleton object
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("file.ser"))) {
			singletonInstance = (LazySingleton) in.readObject();
		}
		System.out.println("Deserialization stage :singletonInstance hashCode=" + singletonInstance.hashCode());

	}
}