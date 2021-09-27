package company;

import java.util.Scanner;

public class ParkingLot extends DisplayCurrentStatus{

    public static void main(String[] args) {
        NoofVehicles numv = new NoofVehicles();
        // Display part-----------------------------------------------------------------------------------
        int OccupiedCarSpot1 = numv.numberofvehbytype("CAR", 1);
        int OccupiedVanSpot1 = numv.numberofvehbytype("VAN", 1);
        int OccupiedBusSpot1 = numv.numberofvehbytype("BUS", 1);
        int OccupiedTruckSpot1 = numv.numberofvehbytype("TRUCK", 1);
        int OccupiedScooterSpot1 = numv.numberofvehbytype("SCOOTER", 1);
        int OccupiedMotorbikeSpot1 = numv.numberofvehbytype("MOTORBIKE", 1);
        int OccupiedE_bikeSpot1 = numv.numberofvehbytype("E_BIKE", 1);
        int OccupiedE_carSpot1 = numv.numberofvehbytype("E_CAR", 1);
        //------------------------------------------------------------------------------------------------
        int OccupiedCarSpot2 = numv.numberofvehbytype("CAR", 2);
        int OccupiedVanSpot2 = numv.numberofvehbytype("VAN", 2);
        int OccupiedBusSpot2 = numv.numberofvehbytype("BUS", 2);
        int OccupiedTruckSpot2 = numv.numberofvehbytype("TRUCK", 2);
        int OccupiedScooterSpot2 = numv.numberofvehbytype("SCOOTER", 2);
        int OccupiedMotorbikeSpot2 = numv.numberofvehbytype("MOTORBIKE", 2);
        int OccupiedE_bikeSpot2 = numv.numberofvehbytype("E_BIKE", 2);
        int OccupiedE_carSpot2 = numv.numberofvehbytype("E_CAR", 2);
        //-------------------------------------------------------------------------------------------------
        int OccupiedCarSpot3 = numv.numberofvehbytype("CAR", 3);
        int OccupiedVanSpot3 = numv.numberofvehbytype("VAN", 3);
        int OccupiedBusSpot3 = numv.numberofvehbytype("BUS", 3);
        int OccupiedTruckSpot3 = numv.numberofvehbytype("TRUCK", 3);
        int OccupiedScooterSpot3 = numv.numberofvehbytype("SCOOTER", 3);
        int OccupiedMotorbikeSpot3 = numv.numberofvehbytype("MOTORBIKE", 3);
        int OccupiedE_bikeSpot3 = numv.numberofvehbytype("E_BIKE", 3);
        int OccupiedE_carSpot3 = numv.numberofvehbytype("E_CAR", 3);
        //--------------------------------------------------------------------------------------------------------------
        byte Service;
        byte V_type;
        byte paymentService;
        int Total_TicketCount = 1;
        int user_ticketNo;
        byte paymentType;

        Scanner input = new Scanner(System.in);
        System.out.println("                          Welcome!");
        System.out.println("                     To the XYZ Parking");
        System.out.println();

        System.out.println();
        System.out.println("Select '1' for parking and Select '2' for unparking your vehicle, 3 for payment and 4th for exit  ");
        Service = input.nextByte();
        System.out.println();

        Ticket[] t = new Ticket[900];
        int tn = 0;

        while (Service != 4) {

            t[tn] = new Ticket();

            display(OccupiedCarSpot1,OccupiedVanSpot1, OccupiedBusSpot1, OccupiedTruckSpot1, OccupiedMotorbikeSpot1, OccupiedScooterSpot1, OccupiedE_bikeSpot1, OccupiedE_carSpot1,
                    OccupiedCarSpot2,OccupiedVanSpot2, OccupiedBusSpot2, OccupiedTruckSpot2, OccupiedMotorbikeSpot2, OccupiedScooterSpot2, OccupiedE_bikeSpot2, OccupiedE_carSpot2,
                    OccupiedCarSpot3,OccupiedVanSpot3, OccupiedBusSpot3, OccupiedTruckSpot3, OccupiedMotorbikeSpot3, OccupiedScooterSpot3, OccupiedE_bikeSpot3, OccupiedE_carSpot3);
            System.out.println();

//            display1(OccupiedCarSpot1, OccupiedVanSpot1, OccupiedBusSpot1, OccupiedTruckSpot1, OccupiedMotorbikeSpot1, OccupiedScooterSpot1, OccupiedE_bikeSpot1, OccupiedE_carSpot1);
//            System.out.println();
//            display2(OccupiedCarSpot2, OccupiedVanSpot2, OccupiedBusSpot2, OccupiedTruckSpot2, OccupiedMotorbikeSpot2, OccupiedScooterSpot2, OccupiedE_bikeSpot2, OccupiedE_carSpot2);
//            System.out.println();
//            display3(OccupiedCarSpot3, OccupiedVanSpot3, OccupiedBusSpot3, OccupiedTruckSpot3, OccupiedMotorbikeSpot3, OccupiedScooterSpot3, OccupiedE_bikeSpot3, OccupiedE_carSpot3);
//            System.out.println();

            if (Service == 1) {

                System.out.println("Please, Select any of the option given below:");
                System.out.println("1:Car 2:MotorBike 3:Scooter 4:Van 5:Bus 6:Truck 7:E_Bike 8:E_Car");
                V_type = input.nextByte();

                if (V_type == 1) {
                    t[tn].vehicle = VehicleType.CAR;
                    if (OccupiedCarSpot1 == maxCarSpot1) {
                        if (OccupiedCarSpot2 == maxCarSpot2) {
                            if (OccupiedCarSpot3 == maxCarSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedCarSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.COMPACT;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedCarSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.COMPACT;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedCarSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.COMPACT;
                    }
                } else if (V_type == 2) {
                    t[tn].vehicle = VehicleType.MOTORBIKE;
                    if (OccupiedMotorbikeSpot1 == maxMotorbikeSpot1) {
                        if (OccupiedMotorbikeSpot2 == maxMotorbikeSpot2) {
                            if (OccupiedMotorbikeSpot3 == maxMotorbikeSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedMotorbikeSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedMotorbikeSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedMotorbikeSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                    }
                } else if (V_type == 3) {
                    t[tn].vehicle = VehicleType.SCOOTER;
                    if (OccupiedScooterSpot1 == maxScooterSpot1) {
                        if (OccupiedScooterSpot2 == maxScooterSpot2) {
                            if (OccupiedScooterSpot3 == maxScooterSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedScooterSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedScooterSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedScooterSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.MOTORCYCLE;
                    }
                } else if (V_type == 4) {
                    t[tn].vehicle = VehicleType.VAN;
                    if (OccupiedVanSpot1 == maxVanSpot1) {
                        if (OccupiedVanSpot2 == maxVanSpot2) {
                            if (OccupiedVanSpot3 == maxVanSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedVanSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.COMPACT;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedVanSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.COMPACT;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedVanSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.COMPACT;
                    }
                } else if (V_type == 5) {
                    t[tn].vehicle = VehicleType.BUS;
                    if (OccupiedBusSpot1 == maxBusSpot1) {
                        if (OccupiedBusSpot2 == maxBusSpot2) {
                            if (OccupiedBusSpot3 == maxBusSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedBusSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.LARGE;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedBusSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.LARGE;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedBusSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.LARGE;
                    }
                } else if (V_type == 6) {
                    t[tn].vehicle = VehicleType.TRUCK;
                    if (OccupiedTruckSpot1 == maxTruckSpot1) {
                        if (OccupiedTruckSpot2 == maxTruckSpot2) {
                            if (OccupiedTruckSpot3 == maxTruckSpot3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedTruckSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.LARGE;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedTruckSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.LARGE;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedTruckSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.LARGE;
                    }
                } else if (V_type == 7) {
                    t[tn].vehicle = VehicleType.E_BIKE;
                    if (OccupiedE_bikeSpot1 == maxE_bike1) {
                        if (OccupiedE_bikeSpot2 == maxE_bike2) {
                            if (OccupiedE_bikeSpot3 == maxE_bike3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedE_bikeSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedE_bikeSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedE_bikeSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                    }
                } else if (V_type == 8) {
                    t[tn].vehicle = VehicleType.E_CAR;
                    if (OccupiedE_carSpot1 == maxE_car1) {
                        if (OccupiedE_carSpot2 == maxE_car2) {
                            if (OccupiedE_carSpot3 == maxE_car3) {
                                System.out.println("Sorry! Space is not available for parking");
                            } else {
                                t[tn].Floor_No = 3;
                                OccupiedE_carSpot3++;
                                t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                            }
                        } else {
                            t[tn].Floor_No = 2;
                            OccupiedE_carSpot2++;
                            t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                        }
                    } else {
                        t[tn].Floor_No = 1;
                        OccupiedE_carSpot1++;
                        t[tn].parkingSpot = ParkingSpotType.ELECTRIC;
                    }
                }

                // Here there will be some mechanism which will check
                // whether for given vehicle free spot is available or not

                // Now I am assuming that free spot is available

                /* User will decide the parking floor number------------------------------------------------------------
                System.out.println();
                System.out.println("In which floor you want to park your Vehicle :");
                System.out.println("'1'-First floor  '2'- Second floor  '3'-Third floor");
                floorNo = input.nextByte();
                t[tn].Floor_No = floorNo;*/

                // User will enter his/her Name-------------------------------------------------------------------------
                System.out.println();
                System.out.print("Enter your Name : ");
                t[tn].Name = input.next();

                // User will enter the Vehicle number-------------------------------------------------------------------
                System.out.print("Enter your Vehicle No : ");
                t[tn].Vehicle_No = input.next();

                // User will enter the License number-------------------------------------------------------------------
                System.out.print("Enter your Vehicle license No : ");
                t[tn].License_No = input.next();

                // Here, we will provide user a ticket through which he/she unpark his/her vehicle----------------------

                t[tn].Ticket_No = Total_TicketCount;
                Total_TicketCount++;

                System.out.println();
                System.out.println("Confirming your Detail :- ");
                System.out.println("Name : " + t[tn].Name);
                System.out.println("Vehicle type : " + t[tn].vehicle);
                System.out.println("ParkingSpot type : " + t[tn].parkingSpot);
                System.out.println("Vehicle No : " + t[tn].Vehicle_No);
                System.out.println("License No : " + t[tn].License_No);
                System.out.println("Floor No : " + t[tn].Floor_No);
                System.out.println("Your Ticket Number is " + t[tn].Ticket_No);

                dbentry obj1 = new dbentry(t[tn].Name, t[tn].vehicle.toString(), t[tn].parkingSpot.toString(), t[tn].Vehicle_No.toString(), t[tn].License_No.toString(), t[tn].Floor_No);
                obj1.displaydetails();
                boolean success = obj1.entryparkdetails();
                System.out.println();
                if (success)
                    System.out.println("Your Vehicle is successfully parked");
                else
                    System.out.println("sorry your request cannot be made");

                tn++;
            }

            if (Service == 2) {
                String[] veh = {"CAR", "MOTORBIKE", "SCOOTER", "VAN", "BUS", "TRUCK", "E_BIKE", "E_CAR"};
                String exitname;
                String exitvehicleno;
                String exitvehicletype;
                String exitlicenseno;
//                System.out.println("Please, Enter you ticket number : ");
//                user_ticketNo = input.nextInt();


                finalexit fnobj = new finalexit();

                while(true) {
                    System.out.println("please enter your name");
                    exitname = input.next();
                    System.out.println();
                    System.out.println("Please enter your vehicle number");
                    exitvehicleno = input.next();
                    System.out.println();
                    System.out.println("please enter your vehicle type");
                    System.out.println("1:Car 2:MotorBike 3:Scooter 4:Van 5:Bus 6:Truck 7:E_Bike 8:E_Car");
                    int inp = input.nextInt();
                    System.out.println();
                    exitvehicletype = veh[inp - 1];
                    System.out.println("please enter your license number");
                    exitlicenseno = input.next();
                    System.out.println();


                    int code = fnobj.finalexitcontrol(exitname, exitvehicleno, exitlicenseno);
//                    System.out.println(code);
//

                    if(code == 1){

                        break;
                    }
                    else if(code == 0){
                        System.out.println("incorrect credentials .. no such vehicle exists");
                    }
                    else{
                        System.out.println("error connecting .. please retry..");
                    }
                }

                fnobj.checkdetails();
                if(fnobj.haspaid() == false){
                    fnobj.finalizepayment();
                    System.out.println("How do you want to pay 1.Credit card  2. offine");
                    int process = input.nextInt();
                    System.out.println("processing your payement...");
                    System.out.println("Payement successfull..");
                }

                int delstatus = fnobj.finaldelete(exitname,exitvehicleno,exitlicenseno);
                while(delstatus == 0){
                    delstatus = fnobj.finaldelete(exitname,exitvehicleno,exitlicenseno);
                    System.out.println("db error cannot delete the car");
                }
                System.out.println("thank you for using our portal.. ");
                System.out.println("please visit again...");








                if(exitvehicletype == "CAR"){
                    OccupiedCarSpot1--;
                }
                else if(exitvehicletype == "VAN")
                    OccupiedVanSpot1--;
                else if(exitvehicletype == "TRUCK")
                    OccupiedTruckSpot1--;
                else if(exitvehicletype == "BUS")
                    OccupiedBusSpot1--;
                else if(exitvehicletype == "MOTORBIKE")
                    OccupiedMotorbikeSpot1--;
                else if(exitvehicletype == "SCOOTER")
                    OccupiedScooterSpot1--;
                else if(exitvehicletype == "E_BIKE")
                    OccupiedE_bikeSpot1--;
                else
                    OccupiedE_carSpot1--;
//                decrementing the values for local display


                System.out.println();
//                System.out.println("Select '1' for parking and Select '2' for unparking your vehicle '3' for paykment and 4 for exit ");
//                Service = input.nextByte();
            }

            if(Service == 3){
                String[] veh = {"CAR", "MOTORBIKE", "SCOOTER", "VAN", "BUS", "TRUCK", "E_BIKE", "E_CAR"};
                String exitname;
                String exitvehicleno;
                String exitvehicletype;
                String exitlicenseno;
                String finalexittime;
//                System.out.println("Please, Enter you ticket number : ");
//                user_ticketNo = input.nextInt();


                finalexit fnobj = new finalexit();
                System.out.println("    PORTAL FOR ONLINE PAYMENT");
                System.out.println("please fill your details");
                while(true) {
                    System.out.println("please enter your name");
                    exitname = input.next();
                    System.out.println();
                    System.out.println("Please enter your vehicle number");
                    exitvehicleno = input.next();
                    System.out.println();
                    System.out.println("please enter your vehicle type");
                    System.out.println("1:Car 2:MotorBike 3:Scooter 4:Van 5:Bus 6:Truck 7:E_Bike 8:E_Car");
                    int inp = input.nextInt();
                    System.out.println();
                    exitvehicletype = veh[inp - 1];
                    System.out.println("please enter your license number");
                    exitlicenseno = input.next();
                    System.out.println();

                    System.out.println("Please fill the date at which you will be unparking your vehicle");
                    System.out.println("time is strictly in \"dd-MM-yyyy\"");
                    String exitdate = input.next();
                    System.out.println();
                    System.out.println("please enter the time  \"HH:mm:ss\"");
                    String exittime = input.next();
                    finalexittime = exitdate+" "+exittime;


                    int code = fnobj.finalexitcontrol(exitname, exitvehicleno, exitlicenseno);
//                    System.out.println(code);
//

                    if(code == 1){

                        break;
                    }
                    else if(code == 0){
                        System.out.println("incorrect credentials .. no such vehicle exists");
                    }
                    else{
                        System.out.println("error connecting .. please retry..");
                    }
                }
                boolean customexitstatus = false;
                while(!customexitstatus){
                    customexitstatus = fnobj.setcustomexittime(finalexittime);
                }

                if(fnobj.haspaid() == false){
                    fnobj.finalizepayment();
                    System.out.println("How do you want to pay 1.Credit card  2. offine");
                    int process = input.nextInt();
                    System.out.println("processing your payment...");
                    System.out.println("Payment successfull..");
                    int status = fnobj.finalpaid(exitname,exitvehicleno,exitlicenseno);

                    while(status != 1){
                        status = fnobj.finalpaid(exitname,exitvehicleno,exitlicenseno);
                    }
                }
                System.out.println("Payement made! ad status updated");
                System.out.println("please ensure to pick the vehicle at correct time");






            }

            if(Service == 4){
                System.out.println("Thanks for using this session!");
                break;
            }
            System.out.println("Please enter 1 for parking,2 for unparking,3 for payment, 4 for exit");
            Service = input.nextByte();
        }
    }
}
