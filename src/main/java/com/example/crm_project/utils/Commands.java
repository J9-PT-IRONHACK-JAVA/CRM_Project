package com.example.crm_project.utils;


public class Commands {
    // 🔴🟠🟡🟢🔵🟣🟤⚫ => Don't delete :D
    public static String InitialHelpMessage =
            /*ConsoleColors.BLUE_BOLD_BRIGHT + "Welcome to your favorite CRM system. How can I help you today?" + ConsoleColors.RESET + "\n" +
            "\n" +*/
            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
            "\n" +

            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 New SalesRep " + ConsoleColors.RESET +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 New Lead " + ConsoleColors.RESET +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Show SalesRep" +
//                    "" +
//                    "➡️ " + ConsoleColors.RESET + "Display a " +
//            "list of " +
//            "available SalesRep" + "\n" +
//
//            "   Existing SalesRep in our System: " + 15 +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Show Leads" +
//                    "➡️ " + ConsoleColors.RESET + "Display a list" +
//            " " +
//            "of available " +
//            "Leads" + "\n" +
//
//            "   Existing Leads in our System: " + 5 +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Lookup Lead" +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Convert" +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 close-lost" +
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 close-won"+
            "\n" +
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 report" +
            "\n" + "\n"+
            ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 exit" +
            "\n" + "\n"
            //ConsoleColors.CYAN_BOLD_BRIGHT + " 🤔 What do you wanna do? 🤔" + ConsoleColors.RESET;
 ;


    public static String mainReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 sales rep " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 product " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 country" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 city" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 industry" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 EmployeeCount States" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Quantity States" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Opportunity States\n"+
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String salesReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Report Lead by SalesRep " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report Opportunity by SalesRep" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Report CLOSED-WON by SalesRep" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report CLOSED-LOST by SalesRep" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report OPEN by SalesRep" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String OppByProductReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Report Opportunity by the product " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Report CLOSED-WON by the product " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report CLOSED-LOST by the product" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Report OPEN by the product" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String OppByCountryReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Report Opportunity by Country " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Report CLOSED-WON by Country " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report CLOSED-LOST by Country" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Report OPEN by Country" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";
    public static String OppByCityReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Report Opportunity by City " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Report CLOSED-WON by City " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report CLOSED-LOST by City" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Report OPEN by City" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String OppByIndustryReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Report Opportunity by Industry " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Report CLOSED-WON by Industry " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Report CLOSED-LOST by Industry" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE2 Report OPEN by Industry" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String employeeCountReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Median EmployeeCount " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Max EmployeeCount " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Min EmployeeCount" +
                    "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";

    public static String productCountReportMessage =

            ConsoleColors.PURPLE_BOLD_BRIGHT + "Available commands:" + ConsoleColors.RESET + "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDD35 Media Quantity " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE1 Max Quantity " + ConsoleColors.RESET +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 Min Quantity " +
                    "\n" +
                    "\n" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + " \uD83D\uDFE0 back\n\n";
}






