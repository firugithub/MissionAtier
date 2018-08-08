package interfacedefaultandstaticmethods;

/*
 * If we make the interface method from static to default, we will get following output.


Impl Null Check
MyData Print::
Impl Null Check
 */

/*
 * Java interface static method is visible to interface methods only, if we remove the isNull() method from the MyDataImpl class, we won’t be able to use it for the MyDataImpl object. However like other static methods, we can use interface static methods using class name. For example, a valid statement will be:


boolean result = MyData.isNull("abc");
 */
public class MyDataImpl implements MyData {

	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}

	public static void main(String args[]) {
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		obj.isNull("abc");
	}
}