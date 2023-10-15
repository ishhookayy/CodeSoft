import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter No of Subjects: ");
        int noOfSubj = scanner.nextInt();

        //Error Validation For noOfSubj if it is 0 then no use of this program
        if (noOfSubj < 0) {
            System.out.println("Invalid number of subjects");
            return;
        }
        int [] MarkOfEachSubj = new int[noOfSubj];
        String [] SubjectName = new String[noOfSubj];
        for(int i=0;i<noOfSubj;i++){
            System.out.print("Enter the Subject name of "+ (i+1)+ " : ");
            SubjectName[i] = scanner.next();
        }
        for(int i=0;i<noOfSubj;i++){
            System.out.print("Enter the Mark of "+SubjectName[i] + ": ");
            MarkOfEachSubj[i] = scanner.nextInt();
        }
        Display(noOfSubj,SubjectName,MarkOfEachSubj);
        scanner.close();
    }
    public static String GradeAllocate(double Score) {
        // Validate the input
        if (Score < 0 || Score > 100) {
            return "Invalid Score";
        } else if (Score >= 90) {
            return "A++";
        } else if (Score >= 80) {
            return "A+";
        } else if (Score >= 70) {
            return "B++";
        } else if (Score >= 60) {
            return "B+";
        } else if (Score >= 50) {
            return "C";
        } else {
            return "Fail! (Re-appear)";
        }
    }
    public static void Display(int noOfSubj,String[] SubjectName,int[] MarkOfEachSubj){
        System.out.println("\t\t***Student Grade Calculator***");
        for(int i=0;i<noOfSubj;i++){
            String Grade = GradeAllocate(MarkOfEachSubj[i]);
            System.out.println(SubjectName[i] +":"+Grade);
        }
        int totalMark =TotalMark(noOfSubj,MarkOfEachSubj);
        System.out.println("Total Mark Obtained : " + totalMark +"/"+(noOfSubj*100));
        double avgMark = AvgMark(noOfSubj,totalMark);
        String Grade =GradeAllocate(avgMark);
        System.out.println("Average Percentage : " + avgMark);
        System.out.println("Overall Grade : "+Grade);

    }
    public static int TotalMark(int noOfSubj,int[] MarkOfEachSubj){
        int totalMark = 0;
        for(int i=0;i<noOfSubj;i++){
            totalMark=MarkOfEachSubj[i]+totalMark;
        }
        return totalMark;
    }
    public static double AvgMark(int noOfSubj,int totalMark){
        return (double) totalMark/noOfSubj;
    }

}