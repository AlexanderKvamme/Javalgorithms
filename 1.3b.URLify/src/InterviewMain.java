public class InterviewMain {

    public static void main(String[] args){

        //Q 1.4
        String str = "Example String with spaces           ";
        replaceSpaces(str);
    }

    public static void replaceSpaces(String str){

        int trueLength = getTrueLength(str);

        char[] strChar = str.toCharArray();
        int spaceCount = 0;
        int finalLength;

        //count the number of spaces in the original string
        for (int i=0; i<trueLength; i++){
            if (strChar[i]== ' ')spaceCount++;
        }

        //get the length of final char array
        finalLength = trueLength + spaceCount*2;
        char[] finalArr = new char[finalLength];

        //update final array here
        int spaces = 0;
        char temp;
        int index;

        for (int i=0; i < trueLength; i++){
            temp = strChar[i];

            if (temp==' '){
                finalArr[getInsertIndex(i,spaces)]= '%';
                finalArr[getInsertIndex(i+1,spaces)] = '2';
                finalArr[getInsertIndex(i+2,spaces)] = '0';
                spaces++;
                continue;
            }

            index = getInsertIndex(i,spaces);
            finalArr[index] = temp;
        }

        //print results here
        for (int i=0; i < finalLength; i++){
            System.out.print(finalArr[i]);
        }
    }

    private static int getTrueLength(String str) {
        int count=0;
        int length = str.length();
        char[] strChar = str.toCharArray();

        //backtrack from end of string to count padding
        for (int i=length-1; i >=0; i--){
            if (strChar[i]!= ' ') break;
            count++;
        }
        return length-count;
    }

    private static int getInsertIndex(int i, int spaces){
        return (i + spaces*2);
    }
}