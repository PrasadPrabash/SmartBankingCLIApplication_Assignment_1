import java.util.Scanner;

public class Bank_App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        final String clear = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[1;34m";
        final String COLOR_YELLOW_BOLD = "\033[1;33m";
        final String COLOR_RESER = "\033[0m";
        final String COLOR_RED = "\033[31m";
        int[] account = new int[0];
        String[] customId = new String[0];
        String[] name = new String[0];
        String id = "";
       

        final String DASHBOARD = "Welcome Smart Banking App";
        final String OPEN_NEW_ACC = "Open New Account";
        final String REMOVE_ACCOUNT = "Drop Existing Account";
        final String CHECK_ACC_BALANCE = "Check Account Balance";
        final String DEPOSIT= "Deposit Money";
        final String WITHDRAW= "Withdraw Money";
        final String TRANSFER= "Transfer Money";
        String screen = DASHBOARD;

mainloop:
        do{
            final String Apptitle = String.format(" %s%s%s \n", COLOR_BLUE_BOLD,screen,COLOR_RESER );
            System.out.println(clear);
            System.out.printf("-".repeat(55).concat("\n"));
            System.out.printf(" ".repeat(12).concat(Apptitle));
            System.out.printf("-".repeat(55).concat("\n"));
            switch(screen){
                case DASHBOARD:
                    System.out.println("\t[1] Open New Account");
                    System.out.println("\t[2] Deposit Money");
                    System.out.println("\t[3] Withdraw Money");
                    System.out.println("\t[4] Transfer Money");
                    System.out.println("\t[5] Check Account Balance");
                    System.out.println("\t[6] Drop Existing Account");
                    System.out.println("\t[7] Exit");
                    System.out.printf("-".repeat(55).concat("\n"));
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option){
                        case 1: screen = OPEN_NEW_ACC; break;
                        case 2: screen = DEPOSIT; break;
                        case 3: screen = WITHDRAW; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = CHECK_ACC_BALANCE; break;
                        case 6: screen = REMOVE_ACCOUNT; break;
                        case 7: System.exit(0);
                        default: continue;
                    }
                    break;


                case OPEN_NEW_ACC :
                    System.out.printf("Account Number: SDB-%05d \n",(account.length +1));
                    // for (int i = 0; i < customId.length; i++) {
                    //     String id = String.format("SDB-%05d ",(i+1));
                        
                        
                    // }

                    boolean valid = true;
                    String accname;
                    double iniaccbal;

                    do{
                        valid = true;
                        System.out.print("Enter Customer Name: ");
                    
                    accname = scanner.nextLine().strip();
                    if(accname.isBlank()){
                        System.out.printf("%sNames Can't be Empty%s \n",COLOR_RED,COLOR_RESER);
                        valid = false;
                        continue;
                    }

                    for (int i = 0; i < accname.length(); i++) {
                        if(!(Character.isLetter(accname.charAt(i))|| Character.isSpaceChar(accname.charAt(i)))){
                            System.out.printf("%sInvalid Name%s \n",COLOR_RED,COLOR_RESER);
                            valid = false;
                            break;

                        }
                    }
                    boolean index = true;
                    do{
                        
                    System.out.printf("Enter Initial Deposit Amount: Rs.");
                    iniaccbal = scanner.nextDouble();
                    scanner.nextLine();
                    if(!(iniaccbal>5000) ){
                        System.out.printf("%sShould be Deposit more than Rs.5000.00%s \n",COLOR_RED,COLOR_RESER);
                        index = false;
                        valid = false;
                        continue;}
                    else{
                        index = true;
                    }
                    String str = String.valueOf(iniaccbal);
                    int strval = str.length();
                    }while(!index);

                    double[] newAcc = new double[account.length +1];
                    String[] newCustomers = new String[name.length + 1];
                    String[] newCustomID = new String[customId.length + 1];
                    for (int i = 0; i < name.length; i++) {
                        id = String.format("SDB-%05d ",(i+1));
                        newCustomers[i] = name[i];
                        newCustomID[i]= customId[i];
                        newAcc[i] = account[i];
                    }
                    newAcc[newAcc.length - 1] = iniaccbal;
                    newCustomID[newCustomID.length -1] = id;
                    newCustomers[newCustomers.length-1] = accname;
                    customId = newCustomID;
                    name = newCustomers;

                    System.out.printf("\033[1;32m%s\033[0m\033[32m your acoount Add Successfully!.\nInitial amount is Rs.%,12.2f\n\033[0mDo you need to add another name [Y/n]?",accname,iniaccbal);
                    if(scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                



                }while(!valid);
            }






















        }while(true);
        
    }
}