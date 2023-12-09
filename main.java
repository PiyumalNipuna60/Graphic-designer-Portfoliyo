import java.util.*;

 class Demo7{

    static Scanner input = new Scanner(System.in);

    static String USERNAME = "Voshadee";

    static String PASSWORD = "1234";

    static String[][] supplier = new String[0][2];

    static String[] category = new String[0];

    static String[][] item = new String[0][6];

    public static void loginPage() {

        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("|                           LOGIN PAGE                                    |");

        System.out.println("+------------------------------------------------------------------------+");

        System.out.println();

        String username;

        String password;

        do {

            System.out.print("User Name:");

            username = input.next();

            if (!username.equals(USERNAME)) {

                System.out.println("Username is invalid. Please try again!");

                System.out.println();

            }

        } while (!username.equals(USERNAME));

        System.out.println();

        do {

            System.out.print("Password:");

            password = input.next();

            if (!password.equals(PASSWORD)) {

                System.out.println("Password is incorrect. Please try again!");

                System.out.println();

            }

        } while (!password.equals(PASSWORD));

        clearConsole();

        homePage();

    }

    private final static void clearConsole() {

        final String os = System.getProperty("os.name");

        try {

            if (os.contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } else {

                System.out.print("\033[H\033[2J");

                System.out.flush();

            }

        } catch (final Exception e) {

            System.err.println(e.getMessage());

        }

    }

    public static void homePage() {

        System.out.println("+---------------------------------------------------------------------------+");

        System.out.println("|               WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                     |");

        System.out.println("+---------------------------------------------------------------------------|");

        System.out.println();

        System.out.println("[1] Change the Credentials\t[2] Supplier Manage");

        System.out.println("[3] Stock Manage\t\t[4] Log out");

        System.out.println("[5] Exit the system");

        System.out.println();

        System.out.print("Enter an option to continue>");

        int option = input.nextInt();

        switch (option) {

            case 1:

                clearConsole();

                changeCredentials();

                break;

            case 2:

                clearConsole();

                supplierManage();

                break;

            case 3:

                clearConsole();

                stockManage();

                break;

            case 4:

                clearConsole();

                loginPage();

                clearConsole();

                homePage();

                break;

            case 5:

                clearConsole();

                return;

            default:

                System.out.println("Invalid option. Please try again!");

                clearConsole();

                homePage();

                break;

        }

    }



    public static void changeCredentials() {

        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println("|                        CREDENTIAL MANAGE                                  |");

        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println();

        String currentUserName;

        String currentPassword;

        do {

            System.out.print("Please enter the user name to verify it's you:");

            currentUserName = input.next();

            if (!currentUserName.equals(USERNAME)) {

                System.out.println("invalid user name.try again!");

                System.out.println();

            }

        } while (!currentUserName.equals(USERNAME));

        System.out.println("Hey " + USERNAME);

        do {

            System.out.print("Enter your current password:");

            currentPassword = input.next();

            if (!currentPassword.equals(PASSWORD)) {

                System.out.println("incorrect password.try again!");

                System.out.println();

            }

        } while (!currentPassword.equals(PASSWORD));

        System.out.print("Enter your new password: ");

        PASSWORD = input.next();

        System.out.println();

        System.out.println("Password changed successfully!");

        System.out.print("Do you want to go to the home page (Y/N): ");

        char c = input.next().charAt(0);

        if (c == 'Y' || c == 'y') {

            clearConsole();

            homePage();

        } else if (c == 'N' || c == 'n') {

            clearConsole();

            return;

        }

    }



    public static void supplierManage() {

        boolean backToHomePage = false;



        System.out.println("+-----------------------------------------------------------------------------+");

        System.out.println("|                               SUPPLIER MANAGE                                |");

        System.out.println("+-----------------------------------------------------------------------------+");



        System.out.println();

        System.out.print("[1] Add supplier");

        System.out.println("\t\t[2] Update supplier");

        System.out.print("[3] Delete supplier");

        System.out.println("\t\t[4] View suppliers");

        System.out.print("[5] Search supplier");

        System.out.println("\t\t[6] Home page");

        System.out.println();



        System.out.print("Enter an option to continue>");

        int option = input.nextInt();



        switch (option){

            case 1:

                clearConsole();

                addSupplier();

                break;

            case 2:

                clearConsole();

                updateSupplier();

                break;

            case 3:

                clearConsole();

                deleteSupplier();

                break;

            case 4:

                clearConsole();

                viewSuppliers();

                break;

            case 5:

                clearConsole();

                searchSupplier();

                break;

            case 6:

                clearConsole();

                homePage();

                break;

            default:

                System.out.println("Invalid choice.Please try again!");

                clearConsole();

                supplierManage();

                break;

        }

    }





    public static void addSupplier(){



        System.out.println("+---------------------------------------------------------------------+");

        System.out.println("|                     ADD SUPPLIERS                                   |");

        System.out.println("+---------------------------------------------------------------------+");

        System.out.println();



        String id;

        boolean isDuplicate = false;

        do {

            System.out.print("Supplier ID: ");

            id = input.next();

            isDuplicate = isDuplicate(id);

            if (isDuplicate) {

                System.out.println("already exists. try another supplier id!");

                System.out.println();

            }

        } while (isDuplicate);

        System.out.print("Supplier Name: ");

        String name = input.next();

        grow();

        supplier[supplier.length - 1][0] = id;

        supplier[supplier.length - 1][1] = name;

        System.out.println();

        System.out.print("Supplier added successfully!");

        System.out.println();

        System.out.print("Do you want to add another supplier (Y/N)? ");

        char choice = input.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {

            clearConsole();

            addSupplier();

        } else if (choice == 'n' || choice == 'N') {

            clearConsole();

            supplierManage();

        }

    }

    public static void grow(){

        String[][]temp=new String[supplier.length+1][2];

        for(int i=0;i<supplier.length;i++){

            temp[i][0]=supplier[i][0];

            temp[i][1]=supplier[i][1];

        }

        supplier = temp;

    }



    public static boolean isDuplicate(String id){

        for(int i=0;i<supplier.length;i++){

            if(supplier[i][0].equals(id)){

                return true;

            }

        }

        return false;

    }





    public static void updateSupplier(){



        System.out.println("+-----------------------------------------------------------------------------------+");

        System.out.println("|                                UPDATE SUPPLIERS                                   |");

        System.out.println("+-----------------------------------------------------------------------------------+");



        System.out.print("Enter the supplier ID:");

        String supplierId = input.next();



        int supplierIndex = findSupplierIndex(supplierId);

        if(supplierIndex == -1){

            System.out.println("Supplier ID not found.Please enter a valid Supplier ID!");

            return;

        }

        String currentSupplierName = supplier[supplierIndex][1];

        System.out.println("Current Supplier Name:"+ currentSupplierName);



        System.out.print("Enter the new supplier name: ");

        String newSupplierName = input.next();



        supplier[supplierIndex][1] = newSupplierName;

        System.out.println("Supplier details updated successfully!");

        System.out.print("Do you want to update another supplier (Y/N)? ");

        char choice = input.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {

            updateSupplier();

        } else if (choice == 'n' || choice == 'N') {

            clearConsole();

            supplierManage();

        }



    }

    public static int findSupplierIndex(String id) {

        for (int i = 0; i < supplier.length; i++) {

            if (supplier[i][0].equals(id)) {

                return i;

            }

        }

        return -1;

    }





    public static void deleteSupplier(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------+");

        System.out.println("|                                   DELETE SUPPLIERS                             |");

        System.out.println("+--------------------------------------------------------------------------------+");



        System.out.print("Enter the supplier ID:");

        String supplierId=input.next();



        int supplierIndex=findSupplierIndex(supplierId);

        if(supplierIndex==-1){

            System.out.println("Supplier ID not found.Please enter a valid supplier ID!");

            return;

        }



        String supplierName = supplier[supplierIndex][1];

        System.out.println("Are you sure you want to delete the following supplier?");

        System.out.println("Supplier ID: " + supplierId);

        System.out.println("Supplier Name: " + supplierName);

        System.out.print("Confirm deletion (Y/N): ");

        char choice = input.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {

            deleteSupplierAtIndex(supplierIndex);

            System.out.println("Supplier deleted successfully!");

            supplierManage();

        } else if (choice == 'n' || choice == 'N') {

            clearConsole();

            supplierManage();

        }

    }

    public static void deleteSupplierAtIndex(int index) {

        String[][] temp = new String[supplier.length - 1][2];

        int count = 0;

        for (int i = 0; i < supplier.length; i++) {

            if (i != index) {

                temp[count++] = supplier[i];

            }

        }

        supplier = temp;



    }

    public static void viewSuppliers(){



        System.out.println("+---------------------------------------------------------------------------------+");

        System.out.println("|                                 VIEW SUPPLIERS                                  |");

        System.out.println("+---------------------------------------------------------------------------------+");





        System.out.println();

        if (supplier.length == 0) {

            System.out.println("No suppliers to display.");

        } else {

            System.out.println("Supplier ID\tSupplier Name");

            for (int i = 0; i < supplier.length; i++) {

                System.out.println(supplier[i][0] + "\t\t" + supplier[i][1]);

            }

        }

        System.out.println();

        System.out.print("Press enter to continue...");

        input.nextLine();

        input.nextLine();

        clearConsole();

        supplierManage();



    }

    public static void searchSupplier(){

        System.out.println("+--------------------------------------------------------------------------------+");

        System.out.println("|                                  SEARCH SUPPLIERS                              |");

        System.out.println("+--------------------------------------------------------------------------------+");



        System.out.print("Enter the supplier ID: ");

        String supplierId = input.next();

        int supplierIndex = findSupplierIndex(supplierId);

        if (supplierIndex == -1) {

            System.out.println("Supplier ID not found. Please enter a valid Supplier ID!");

        } else {

            String supplierName = supplier[supplierIndex][1];

            System.out.println("Supplier ID: " + supplierId);

            System.out.println("Supplier Name: " + supplierName);

        }

        System.out.println();

        System.out.print("Press enter to continue...");

        input.nextLine();

        input.nextLine();

        clearConsole();



        supplierManage();



    }

    public static void stockManage() {

        boolean backHomePage = false;

        int option = 0;



        while(option !=6){

            clearConsole();



            System.out.println("+-------------------------------------------------------------------------+");

            System.out.println("|                                  STOCK MANAGEMENT                       |");

            System.out.println("+-------------------------------------------------------------------------+");



            System.out.println();

            System.out.print("[1] Manage item categories");

            System.out.println("\t\t[2] Add Item");

            System.out.print("[3] Get item supplier wise");

            System.out.println("\t\t[4] Veiw items");

            System.out.print("[5] Rank item per unit price");

            System.out.println("\t\t[6] Home page");

            System.out.println();



            System.out.print("\nEnter your option: ");

            option = input.nextInt();

            switch (option) {

                case 1:

                    mangeItemCategories();

                    break;

                case 2:

                    addItem();

                    clearConsole();

                    break;

                case 3:

                    getItemSupplierWise();

                    clearConsole();

                    break;

                case 4:

                    clearConsole();

                    viewItems();

                    break;

                case 5:

                    rankItemPerUnitPrice();

                    break;

                case 6:

                    clearConsole();

                    homePage();

                    break;



                default:

                    clearConsole();

                    System.out.println("Invalid option. Please try again.\n");

            }

        }

    }



    public static void mangeItemCategories(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println("|                            MANAGE ITEM CATEGORY                          |");

        System.out.println("+--------------------------------------------------------------------------+");



        System.out.println();

        System.out.print("[1] Add New Item Category ");

        System.out.println(" \t\t[2] Update Item Category ");

        System.out.print("[3] Delete Item Category");

        System.out.println(" \t\t[4] Stock management   ");

        System.out.println();



        System.out.print("Enter your choice: ");

        int  choice = input.nextInt();





        switch (choice) {

            case 1:

                addNewItemcategory();

                clearConsole();

                break;

            case 2:

                updateItemCategory();

                break;

            case 3:

                deleteItemCategory();

                break;

            case 4:

                stockManage();

                break;

            default:

                clearConsole();

                System.out.println("Invalid choice! Please try again.");

        }



    }



    public static void addNewItemcategory(){

        System.out.println();

        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("|                                     ADD ITEM CATEGORY                  |");

        System.out.println("+------------------------------------------------------------------------+");



        boolean flag=false;

        L1:    while(true){

            System.out.println();

            System.out.print("enter the new item category : ");

            String items=input.next();

            for(int i=0;i<category.length;i++){



            }



            L2:

            grow1D();

            category[category.length - 1] = items;

            System.out.println("added successfully!");

            System.out.print("Do you want to add another item category (Y/N): ");

            char option = input.next().charAt(0);

            if (option == 'N' || option == 'n') {

                flag=true;

                clearConsole();

                stockManage() ;

            }

            else{

                continue L1;

            }

        }



    }

    public static void grow1D(){

        String[] temp = new String[category.length+1];

        for (int i= 0; i < category.length; i++) {

            temp[i]=category[i];

        }

        category=temp;

    }



    public static void deleteItemCategory(){



        System.out.println("+---------------------------------------------------------------------------+");

        System.out.println("|                                 DELETE ITEM CATEGORY                      |");

        System.out.println("+---------------------------------------------------------------------------+");



        boolean flag=false;

        l1 :    while(flag!=true){

            System.out.print("enter the item :");

            String itemn=input.next();

            for(int i=0;i<category.length;i++){

                if(itemn.equals(category[i])){

                    int num=i;

                    grow11D(num);

                    flag=true;

                    System.out.print("delete successfully do you want to try again  y/n        :");

                    char option = input.next().charAt(0);

                    if (option == 'N' || option == 'n') {

                        flag=true;

                        clearConsole();

                        stockManage();

                    }

                    else

                        continue l1;

                }

            }

            System.out.println("invalid item try again ");



        }

    }

    public static void grow11D(int num) {

        String[] temp = new String [category.length - 1];

        int tempIndex = 0;

        for (int i = 0; i < category.length; i++) {

            if (i == num) {

                continue;

            }

            temp[tempIndex] = category[i];

            tempIndex++;

        }

        category = temp;

    }

    public static void updateItemCategory(){

        System.out.println("+----------------------------------------------------------------------------+");

        System.out.println("|                                  UPDATE ITEM CATEGORY                      |");

        System.out.println("+----------------------------------------------------------------------------+");



        boolean flag=false;

        l1:    while(flag!=true){

            System.out.print("enter the item category  :");

            String id=input.next();

            for(int i=0;i<category.length;i++){

                if(id.equals(category[i])){

                    System.out.print("enter the item new  name   :");

                    String name=input.next();

                    category[i]=name;

                    System.out.print("added successfully do you want to try again  y/n        :");

                    char option = input.next().charAt(0);

                    if (option == 'N' || option == 'n') {

                        flag=true;

                        clearConsole();

                        stockManage();

                    } else{

                        updateItemCategory() ;

                    }

                }

            }

            System.out.print("can't find item try again ! \n :");

        }





    }





    public static void addItem(){



        System.out.println("+-------------------------------------------------------------------------------------------+");

        System.out.println("|                                       ADD ITEM                                            |");

        System.out.println("+-------------------------------------------------------------------------------------------+");

        System.out.println(" ");



        l3:  while (true) {

            System.out.print("item code : ");

            String itemCode = input.next();

            boolean flag=false;

            for (int i = 0; i <item.length; i++) {

                if (itemCode.equals(item[i][0])){

                    System.out.println("already exists.try another supplier id! ");

                    flag=true;

                }

            }

            if (flag==false){

                grow2();

                item[item.length-1][0]=itemCode;

                System.out.println("supplier list : ");

                System.out.println("+-----------------------  +-----------------------+---------------------------+");

                System.out.printf(" |%15s            |%15s            |%15s            |\n"," #","SUPPLIER NAME","SUPPLIER ID ");

                System.out.println("+-----------------------  +-----------------------+---------------------------+");

                for (int i=0;i< supplier.length;i++){

                    System.out.printf(" |%15s            |%15s            |%15s            |\n",(i+1),supplier[i][1],supplier[i][0]);

                    System.out.println("+-------------------------+-----------------------+---------------------------+");

                }

                System.out.print("Enter the supplier number : ");

                int supllierNo = input.nextInt();

                item[item.length - 1][1] = supplier[supllierNo-1][0];



                System.out.println("item categories : ");

                System.out.println(" +-------------------------+-----------------------+");

                System.out.printf("  |%15s            |%15s            |\n"," #","CATEGORY NAME");

                System.out.println(" +-------------------------+-----------------------+");

                for (int i=0;i< supplier.length;i++){

                    System.out.printf("  |%15s            |%15s            |\n",(i+1),category[i]);

                    System.out.println( "+-------------------------+-----------------------+");

                }

                System.out.print("Enter the category number : ");

                int categoryNo = input.nextInt();

                item[item.length - 1][2] = category[categoryNo-1];



                System.out.print("Description : ");

                String description = input.next();

                item[item.length - 1][3] = description;



                System.out.print("Unit price : ");

                String unitPrice = input.next();

                item[item.length - 1][4] = unitPrice;



                System.out.print("Qty on hand : ");

                String qty = input.next();

                item[item.length - 1][5] = qty;



                System.out.println(Arrays.deepToString(item));

            }

            System.out.print("Do you want to add another supplier (y/n) : ");

            char option = input.next().charAt(0);

            if (option=='n'){

                clearConsole();

                stockManage();

                break l3;

            }

        }

    }

    public static void grow2(){

        String[][] temp = new String[item.length+1][6];

        for (int i= 0; i < item.length; i++) {

            for (int j = 0; j < item[i].length; j++) {

                temp[i][j]=item[i][j];

            }

        }

        item=temp;

    }





    public static void getItemSupplierWise() {

        clearConsole();

        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");

        System.out.println("|                                                            SEARCH SUPPLIER                                                                            |");

        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");

        searchLoop: while (true) {

            System.out.print("Enter Supplier Id: ");

            String supplierId = input.next();

            for (int i = 0; i < supplier.length; i++) {

                if (supplierId.equals(supplier[i][0])) {

                    System.out.println("Supplier Name: " + supplier[i][1]);

                    break;

                }

            }

            System.out.println("+-------------------------+-------------------------+-----------------------+-----------------------+---------------------+");

            System.out.printf(" |%15s            |%15s            |%15s            |%15s            |%15s            |\n", "  ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");

            System.out.println("+-------------------------+-------------------------+-----------------------+-----------------------+---------------------+");

            for (int i = 0; i < item.length; i++) {

                if (supplierId.equals(item[i][1])) {

                    System.out.printf(" |%15s            |%15s            |%15s            |%15s            |%15s            |\n", item[i][0], item[i][3], item[i][4], item[i][5], item[i][2]);

                    System.out.println("+-------------------------+-------------------------+-----------------------+-----------------------+---------------------+");

                }

            }

            System.out.print("Search successful! Do you want to do another supplier search? (Y/N): ");

            String option = input.next();

            if (!option.equalsIgnoreCase("Y")) {

                supplierManage();

                break searchLoop;

            }

        }

    }

    public static void viewItems() {

        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

        System.out.println("|                                                              VIEW ITEMS                                                                                          |");

        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

        System.out.println();

        for (int i = 0; i < category.length; i++) {

            System.out.println(category[i] + " : ");

            System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------+%n");

            System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%n", "SID", "ICODE", "DISC", "PRICE", "QTY");

            System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------+%n");

            for (int j = 0; j < item.length; j++) {

                if (category[i].equals(item[j][2])) {

                    System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-10s|%n",

                            item[j][1], item[j][0], item[j][3], item[j][4], item[j][5]);

                    System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------+%n");

                }

            }

            System.out.println();

        }

        System.out.print("Do you want to go to the stock management page? (y/n): ");

        char response = input.next().charAt(0);

        if (response == 'y' || response == 'Y') {

            clearConsole();

            stockManage();

        } else {

            clearConsole();

            homePage();

        }

    }

    public static void rankItemPerUnitPrice(){

        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");

        System.out.println("|                                                         Rank Item Unit Price                                                                           |");

        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------+");



        int n = item.length;

        String price = "";

        String code = "";

        String sId = "";

        String category = "";

        String desc ="";

        String qty ="";

        for (int i = 0; i < item.length; i++){

            for (int j = i + 1; j < item.length; j++){

                if(Double.parseDouble(item[j-1][4]) > Double.parseDouble(item[j][4])){



                    code = item[j-1][0];

                    item[j-1][0] = item[j][0];

                    item[j][0] = code;

                    sId = item[j-1][1];

                    item[j-1][1] = item[j][1];

                    item[j][1] = sId;

                    category = item[j-1][2];

                    item[j-1][2] = item[j][2];

                    item[j][2] = category;

                    desc = item[j-1][3];

                    item[j-1][3] = item[j][3];

                    item[j][3] = desc;



                    price = item[j-1][4];

                    item[j-1][4] = item[j][4];

                    item[j][4] = price;

                    qty = item[j-1][5];

                    item[j-1][5] = item[j][5];

                    item[j][5] = qty;

                }

            }

        }

        System.out.println("---------------------------------------------------------------------------------------+");

        System.out.printf("|%-8s  | %-8s  | %-10s  | %-8s  | %-8s  | %-8s  | %n","SID","CODE","DESC","PRICE","QTY","CATEGORY");

        System.out.println("-----------------------------------------------------------------------------------------+");

        for (int i = 0; i < item.length; i++){

            System.out.printf("|%-8s  | %-8s  | %-10s  | %-8s  | %-8s  | %-8s  | %n",item[i][1],item[i][0],item[i][3],item[i][4],item[i][5],item[i][2]);



        }

        System.out.println("------------------------------------------------------------------------------------------+\n\n");



        System.out.println("Do you want to go stock manage page(Y/N)?");

        String want = input.next();



        if (want.equals("Y")||want.equals("y")){



            stockManage();

        }else{

            clearConsole();

            homePage();



        }



    }





    public static void main(String args[]) {

        loginPage();



    }

}
