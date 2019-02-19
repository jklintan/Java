package lab1;

public class Calandar {

    public String[][] data;
    public int counter;
    public int numbData = 5;

    //Constructor
    Calandar(int size) {
        data = new String[size][numbData];
        counter = 0;
    }

    public String addPerson(String inString){
        if (counter < data.length) {
            String[] arr = inString.split(" +");
            for(int i = 0; i < 5; i++){
                data[counter][i] = arr[i];
            }
            counter++;
            return "Person added at position " + counter;
        } else {
            return "Person added";
        }
    }

    public String[] getName(int entryNumber) {
        String[] name = new String[2];
        if(entryNumber >= -1 && entryNumber < counter){
            name[0] = data[entryNumber][0];
            name[1] = data[entryNumber][1];
        }else{
            name[0] = "John";
            name[1] = "Doe";
        }
        //System.out.println(name[0]);
        //System.out.println(name[1]);
        return name;
    }


    public Integer[] getBirthDate(int entryNumber) throws NumberFormatException{
        Integer[] res = new Integer[3];
        if (entryNumber >= -1 && entryNumber < counter) {
             res[0] = Integer.parseInt(data[entryNumber][3]);
             res[1] = Integer.parseInt(data[entryNumber][3]);
             res[2] = Integer.parseInt(data[entryNumber][4]);
         } else {
             res[0] = 1;
             res[1] = 1;
             res[2] = 1900;
        }
        //System.out.println(res[0]);
        //System.out.println(res[1]);
        //System.out.println(res[2]);
        return res;
    }

    public String writeName(int number){
        String output = "";
        String[] fullName = getName(number);
        output += fullName[0].toUpperCase() + " " + fullName[1] + " has birthday on ";
        Integer[] birthdate = getBirthDate(number);
        output += String.valueOf(birthdate[0]) + " " + getMonth(birthdate[1]) + " " + String.valueOf(birthdate[2]);              
        return output;
    }

    public void matchingSurname(String surname) {
        for(int i = 0; i < counter; i++){
            if(getName(i)[0].equalsIgnoreCase(surname)){
                System.out.println(writeName(i));
            }
        }
    }

    public void matchingYear(int year) {
        for (int i = 0; i < counter; i++) {
            if (getBirthDate(i)[2] == year) {
                System.out.println(writeName(i));
            }
        }
    }

    public String getMonth(int number) {
        String month = "";

        switch(number){
            case 1: month = "January"; break;
            case 2: month = "February"; break;
            case 3: month = "March"; break;
            case 4: month = "April"; break;
            case 5: month = "May"; break;
            case 6: month = "June"; break;
            case 7: month = "July"; break;
            case 8: month = "August"; break;
            case 9: month = "September"; break;
            case 10: month = "October"; break;
            case 11: month = "November"; break;
            case 12: month = "December"; break;
            default: month = ""; break;
        }

        return month;
    }

};
