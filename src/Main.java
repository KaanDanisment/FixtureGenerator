import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);

        ArrayList<String> matchs = new ArrayList<>();
        ArrayList<String> matchs2 = new ArrayList<>();
        ArrayList<String> matchs1 = new ArrayList<>();
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> defaultTeams = new ArrayList<>();


        String match1;
        String match2;
        int r1, r2;

        boolean status = true;

        System.out.print("How many clubs will there be in the league: ");
        int howManyTeam = scan.nextInt();


        while (teams.size() < howManyTeam) {
            System.out.println("Enter the Club Name: ");
            String clubName = scan.next() + scan.nextLine();
            teams.add(clubName);
        }

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        for (int i = 1; i < teams.size() ; i++) {

            defaultTeams.clear();
            int matchQuantity = 0;
            matchs1.add("Week " + i);
            matchs2.add("Week " + (i + (teams.size() - 1)));


            while (matchQuantity < teams.size()/2){
                r1 = r.nextInt(0,teams.size());
                r2 = r.nextInt(0,teams.size());

                if (r1 != r2) {
                    match1 = (teams.get(r1) + " vs " + teams.get(r2));
                    match2 = (teams.get(r2) + " vs " + teams.get(r1));

                    if (!(matchs.contains(match1)) && !(matchs.contains(match2))) {

                        if (!(defaultTeams.contains(teams.get(r1))) && !(defaultTeams.contains(teams.get(r2)))){

                            defaultTeams.add(teams.get(r1));
                            defaultTeams.add(teams.get(r2));


                            matchs1.add(match1);
                            matchs2.add(match2);

                            matchs.add(match1);
                            matchs.add(match2);


                            matchQuantity++;
                        }
                    }
                }
            }
        }

        for (String m1 : matchs1) {
            System.out.println(m1);
        }
        for (String m2 : matchs2) {
            System.out.println(m2);
        }
    }
}