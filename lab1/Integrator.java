package lab1;

public class Integrator {
	  public static void main(String[] args) {
	    // task1();
	    //task2();
	    //task3();
	    task4();
	  }

	  public static double getIntegral (int pieces) {
	      double step = 2.0 / pieces;
	      double area = 0;
	      for (double i = 1; i < pieces + 1; i++) {
	        area += Math.pow((step*i), 2) * step;
	      }
	      double error = (area - (8.0 / 3.0)) / (8.0 / 3.0);
	      int intError = (int)(error*100.0);
	      System.out.println("The result is " + Math.round((area * 100))/100.0 + " and the error is " + Integer.toString(intError) + " percent");
	      return error;
	  }

	  public static void task1 () {
	      getIntegral(4);
	  }

	  public static void task2 () {
	      int limit = 1;
	      double inError;
	      int N = 0;
	      do {
	        N += 1;
	        inError = getIntegral(N);
	      } while (inError*100 > limit);
	  }

	  public static void task3 () {
	    DataBase theDataBase = new DataBase();
	    System.out.println(theDataBase.toString());
	  }

	  public static void task4 () {
	    // System.out.println(Integer.parseInt("9"));
	    DataBase theDataBase = new DataBase();
	    String dataBase = theDataBase.toString();
	    Calandar cal = new Calandar(dataBase.length());
	    String []dataArr = dataBase.split("[ ,]+");
	    String res = "";
	    for (int i = 0; i < dataArr.length; i++) {
	        res += dataArr[i];
	        if((i != 0) && (i+1)%5 == 0){
	            System.out.println(cal.addPerson(res));
	            res = "";
	        }else{
	            res+= " ";
	        }
	    }
	    //System.out.println(cal.writeName(0)); //Test writeName
	    cal.matchingSurname("Emma");
	    cal.getName(0);
	    cal.getBirthDate(0);
	    cal.matchingYear(2008);
	  }
	}
