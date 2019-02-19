package lab1;

public class DataBase {
    private String rawData;
    private String defaultString = "Noah  Smith 27 12 1945,Emma Jones 30 11 1986,Liam   Williams 1 2 2001,Olivia  Taylos 28 3 1952,Ethan Brown 7 6 2008,Ava Davies 12 12 1941,Mason   Evans 18 6 1978,Sophia Wilson 19 8 1999,Lucas  Thomas 5 4 1988,Isabella Johnson 1 1 2011";

	public DataBase() { // The constructor
        rawData = defaultString;
	}

    public String toString () {
        return this.rawData;
    }
}