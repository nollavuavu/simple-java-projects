package yo;

public class bin {
	public static void main(String[] args) {

	    while (true) {
	        String thething = NirajTools.getInput("Give me a calculation or number bro").replace(" ", "");

	        if (thething.contains("+")) {
	            String[] ab = thething.split("\\+");
	            int a = Integer.parseInt(ab[0]);
	            int b = Integer.parseInt(ab[1]);

	            Binary(a + b);
	        }
	        else if (thething.contains("*")) {
	            String[] ab = thething.split("\\*");
	            int a = Integer.parseInt(ab[0]);
	            int b = Integer.parseInt(ab[1]);

	            Binary(a * b);
	        }
	        else if (thething.contains("/")) {
	            String[] ab = thething.split("/");
	            int a = Integer.parseInt(ab[0]);
	            int b = Integer.parseInt(ab[1]);

	            Binary(a / b);
	        }
	        else if (thething.contains("-")) {
	            String[] ab = thething.split("-");
	            int a = Integer.parseInt(ab[0]);
	            int b = Integer.parseInt(ab[1]);

	            Binary(a - b);
	        }
	        else if (thething.equals("e")) {
	            break;
	        }
	        else {
	            Binary(Integer.parseInt(thething));
	        }
	    }
	}

	public static void Binary(int decimal) {
	    if (decimal == 0) {
	        System.out.println("The result is: 0");
	    }

	    String binary = "";
	    while (decimal > 0) {
	        binary = (decimal % 2) + binary;
	        decimal = decimal / 2;
	    }

	    if (decimal < 0) {
	        binary = "-" + binary;
	    }

	    System.out.println("The result is: " + binary);
	}
}
