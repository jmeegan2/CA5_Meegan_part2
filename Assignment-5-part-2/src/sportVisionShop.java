/*
Write an abstract method of calCharges() to calculate the charges for both subclasses
Assume bellow coding being defined :
//consist of both subclasses objects sportVisionShop[] S = new sportVisionShop[10]

Write a program to determine and display the number of customer who buy cycling and swimming glass from the sportVisionShop
Write a program to calculate the total charges for all customers who bought “Retro” goggle at
the sportVisionShop outlet.
Write a program to list the deposit paid by the customer who bought transition cycling glass from this shop.
 */
public abstract class sportVisionShop {
    // instance variabes
    String custOrderNo;
    String custOrderDate;
    float depositAmount;
    //default constructor
    public sportVisionShop() {
    }

    public sportVisionShop(String custOrderNo, String custOrderDate, float depositAmount) {
        this.custOrderNo = custOrderNo;
        this.custOrderDate = custOrderDate;
        this.depositAmount = depositAmount;
    }

    // abstract method
    public abstract double calCharges();

}
class cyclingGlass extends sportVisionShop {
    // instance variables
    char type_glass;
    boolean uvProtection;
    float depositAmount;

    //default constructor
    public cyclingGlass() {

    }

    public cyclingGlass(String custOrderNo, String custOrderDate, float depositAmount, char type_glass,
                        boolean uvProtection, float depositPymt) {
        super(custOrderNo, custOrderDate, depositAmount);
        this.type_glass = type_glass;
        this.uvProtection = uvProtection;
        this.depositAmount = depositAmount;
    }

    @Override
    public double calCharges() {
        // check type is transition then return 300
        if (type_glass == 'T') {
            return 300;

        } else if (type_glass == 'P') {// check type is Polarized then return 350
            return 350;

        } else if (type_glass == 'I') {// check type is Iridium then return 400
            return 400;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "cyclingGlass [type_glass=" + type_glass + ", uvProtection=" + uvProtection + ", depositAmount="
                + depositAmount + "]";
    }

}
class swimmingGlass extends sportVisionShop {
    // instance variables
    char Type;
    String style;

    //default constructor
    public swimmingGlass() {
    }

    public swimmingGlass(String custOrderNo, String custOrderDate, float depositAmount, char type_glass, String style) {
        super(custOrderNo, custOrderDate, depositAmount);
        this.Type = type_glass;
        this.style = style;
    }

    @Override
    public double calCharges() {
        // check type is 'A' then set price as 150
        if (Type == 'A') {
            // if style is Retro then discount 7%

            if (style.equals("Retro")) {
                return 150 - ((150 * 7) / 100);

            } else if (style.equals("Warrior")) {
                // if style is Warrior then discount 30%
                return 150 - ((150 * 30) / 100);

            } else if (style.equals("Modern")) {
                // if style is Modern then discount 10%
                return 150 - ((150 * 10) / 100);
            } else {
                return 150;
            }
        } else if (Type == 'S') {
            if (style.equals("Retro")) {
                // if style is Retro then discount 7%
                return 250 - ((250 * 7) / 100);

            } else if (style.equals("Warrior")) {
                // if style is Warrior then discount 30%
                return 250 - ((250 * 30) / 100);

            } else if (style.equals("Modern")) {
                // if style is Modern then discount 10%
                return 250 - ((250 * 10) / 100);
            } else {
                return 250;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "swimmingGlass [type_glass=" + Type + ", style=" + style + "]";
    }

}
class Main {

    public static void main(String[] args) {
        // Create array of sportVisionShop with size 10
        //consist of both subclasses objects sportVisionShop[] S = new sportVisionShop[10]
        sportVisionShop[] S = new sportVisionShop[10];
        // add cyclingGlass to array S
        S[0] = new cyclingGlass("CS1", "07/01/2020", 500, 'T', true, 500);
        S[1] = new cyclingGlass("CS2", "07/02/2020", 600, 'T', true, 600);
        S[2] = new cyclingGlass("CS3", "07/03/2020", 700, 'P', true, 200);
        S[3] = new cyclingGlass("CS4", "07/04/2020", 800, 'I', true, 200);
        S[4] = new cyclingGlass("CS5", "07/05/2020", 900, 'T', true, 100);
        // add swimmingGlass to array S
        S[5] = new swimmingGlass("CS6", "08/01/2021", 500, 'A', "Retro");
        S[6] = new swimmingGlass("CS7", "08/02/2021", 400, 'A', "Warrior");
        S[7] = new swimmingGlass("CS8", "08/03/2021", 300, 'S', "Retro");
        S[8] = new swimmingGlass("CS9", "08/04/2021", 200, 'A', "Warrior");
        S[9] = new swimmingGlass("CS10", "08/05/2021", 100, 'S', "Retro");

        int swimmingCount = 0;
        int cyclingCount = 0;
        // iterate the array
        for (sportVisionShop obj : S) {
            // check obj is type of swimmingGlass, then increment the count

            if (obj instanceof swimmingGlass) {
                swimmingCount++;
            }
            if (obj instanceof cyclingGlass) {
                cyclingCount++;
            }
        }
        System.out.println("Number of customers who buying cycling glass: " + cyclingCount);
        System.out.println("Number of customers who buying swimming glass: " + swimmingCount);
        // c) calculate Total charges for all customers who buy Retro type glass
        // iterate array
        double retroTotalCharges = 0;
        for (sportVisionShop obj : S) {
            // check obj is type of swimmingGlass, then increment count
            if (obj instanceof swimmingGlass) {
                swimmingGlass swimm = (swimmingGlass) obj;
                if (swimm.style.equals("Retro")) {
                    retroTotalCharges = retroTotalCharges + swimm.calCharges();
                }
            }
        }
        System.out.println("Total charges for all customers who buy Retro stype glass: " + retroTotalCharges);

        // iterate array
        //deposit paid by the customer who bought transition cycling glass from this shop.
        System.out.println();
        System.out.println("List of deposit paid by the customers who bought Transition Type");
        for (sportVisionShop obj : S) {
            if (obj instanceof cyclingGlass) {
                cyclingGlass cyGlass = (cyclingGlass) obj;
                if (cyGlass.type_glass == 'T') {
                    System.out.println(cyGlass.depositAmount);
                }
            }
        }

    }

}



