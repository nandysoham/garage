package company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Payment {
    String[] veh = {"CAR", "MOTORBIKE", "SCOOTER", "VAN", "BUS", "TRUCK", "E_BIKE", "E_CAR"};
    double[] rates = {3.00, 1.00, 1.00, 5.00, 3.00, 5.00, 1.500, 3.500};
    long thisminutes;
    int vehtype ;
    long calculateMinutes(String startdate, String enddate){
        long minutes  =-1;
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");

        try{
            Date d1 = sdf.parse(startdate);
            Date d2 = sdf.parse(enddate);

            long difference_In_Time
                    = d2.getTime() - d1.getTime();
            System.out.println("difference in time is "+difference_In_Time);
            minutes
                    = (difference_In_Time
                    / (1000 * 60));


        }
        catch(Exception e){
            System.out.println(e);
        }
        this.thisminutes = minutes;
        return minutes;
    }


    double totalamount(String startdate, String enddate, String type){
        int vtype = 3;
        for(int i=0;i<8;i++){
            if(veh[i].equals(type)){
                vtype = i;
                break;
            }
        }

        this.vehtype = vtype;

        return calculateMinutes(startdate,enddate)*rates[vtype];
    }

    void showbill(String name, String vehicleno, String licenseno, int floor, String startdate, String enddate, String type){
        double amount = totalamount(startdate,enddate,type);
        System.out.println("            XYZ GARAGE");
        System.out.println();
        System.out.println("            FINAL BILL");
        System.out.println();
        System.out.println("NAME: " + name);
        System.out.println("VEHICLE NUMBER: " + vehicleno);
        System.out.println("LICENSE NO: " + licenseno);
        System.out.println();
        System.out.println("Car details -----------------");
        System.out.println("Floor: "+ floor);
        System.out.println("Entry date and time: " + startdate );
        System.out.println("Exit date and tiem: " + enddate);
        System.out.println();
        System.out.println();
        System.out.println("        BILL DETAILS");
        System.out.println("No of minutes: "+ thisminutes);
        System.out.println("Rate for your car type (Rs/min) " + rates[vehtype] );
        System.out.println("Net payable: "+ amount);



    }



}
