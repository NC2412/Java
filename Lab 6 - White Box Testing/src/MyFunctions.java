public class MyFunctions implements TestingFunctions {
	@Override
	public int greatestCommonDivisor(int a, int b) {

		if (GCDNegativeCase(a, b) == true) 
			return -1;
		else if (GCD0Case(a, b) == true) {
			if ( a == 0)
				return b;
			else 
				return a;
		}
		else
			return greatestCommonDivisor(b , a % b);
	}
	
	public boolean GCD0Case(int a, int b) {
		if (a == 0)
			return true;
		else if (b == 0)
			return true;
		else 
			return false;
	}
	
	public boolean GCDNegativeCase(int a, int b) {
		for (int i = -1; i >= ((a < b) ? a : b); i--) {
			if (a == i || b == i)
				return true;
		}
		
		return false;
	}

	@Override
	public void reverseWindow(int[] arr, int index1, int index2) throws IndexOutOfBoundsException {
		int times = 0;
		int temp = 0;

		if (index1 > index2) {
			temp = index2;
			index2 = index1;
			index1 = temp;
		}
		
		times = (index2 - index1) / 2;
		for (int i = 0; i < times; i++) {
			temp = arr[index2 - i - 1];
			arr[index2 - i - 1] = arr[index1 + i];
			arr[index1 + i] = temp;
		}
	}
}