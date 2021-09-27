package company;

import com.mongodb.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbentry {
    String name;
    String vehicletype;
    String parkinglottype;
    String vehicleno;
    String licenseno;
    int floorno;
    String time;

    public dbentry(String name,String vehicletype,String parkinglottype,String vehicleno,String licenseno,int floorno ){
        this.name = name;
        this.vehicletype = vehicletype;
        this.parkinglottype = parkinglottype;
        this.vehicleno = vehicleno;
        this.licenseno= licenseno;
        this.floorno = floorno;

        // formatting the date
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date timenow = new Date();
        this.time = formatter.format(timenow).toString();


    }

    public void displaydetails(){
        System.out.println(name);
        System.out.println(vehicletype);
        System.out.println(parkinglottype);
        System.out.println(vehicleno);
        System.out.println(licenseno);
        System.out.println(floorno);
        System.out.println(time);
    }

    public boolean entryparkdetails(){
        boolean success = true;
        try{
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("garage");
            DBCollection collection = database.getCollection("vehicledetails");
            BasicDBObject document = new BasicDBObject();
            document.put("name", name);
            document.put("vehicletype",vehicletype);
            document.put("parkinglottype",parkinglottype);
            document.put("vehicleno",vehicleno);
            document.put("licenseno",licenseno);
            document.put("floorno",floorno);
            document.put("entrytime",time);
            document.put("payment",0);
            collection.insert(document);
        }
        catch (Exception e){
            success = false;
            System.out.println(e);
        }
        return success;
    }



}
// class for finding the availability of vehicles
class NoofVehicles{
    public int numberofvehbytype(String type, int floor){
        try{
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("garage");
            DBCollection collection = database.getCollection("vehicledetails");
            BasicDBObject document = new BasicDBObject();


            BasicDBObject searchQuery1 = new BasicDBObject();
            searchQuery1.put("vehicletype",type);
            searchQuery1.put("floorno",floor);
            DBCursor cursor = collection.find(searchQuery1);
            return cursor.count();
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }

    }

}

// class to find vehicle and print amount
class finalexit {
    String name;
    String vehicletype;
    String parkinglottype;
    String vehicleno;
    String licenseno;
    int floorno;
    String entrytime;
    String exittime;
    int payment;

    public void checkdetails(){
        System.out.println(this.name);
        System.out.println(this.entrytime);
        System.out.println(this.exittime);
        System.out.println(this.vehicleno);
        System.out.println(this.vehicletype);
    }


    public boolean haspaid(){
        System.out.println(payment);
//        return false;
        if(payment==0)
            return false;
        return true;
    }


    public void finalizepayment(){
        Payment pay = new Payment();
        pay.showbill(name, vehicleno, licenseno,floorno, entrytime,exittime, vehicletype);

    }

    public int finalpaid(String exitname, String exitvehicleno, String exitlicenseno){
        int status = 0;
        try {

            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("garage");
            DBCollection collection = database.getCollection("vehicledetails");
            BasicDBObject document = new BasicDBObject();


            BasicDBObject searchperson = new BasicDBObject();
            searchperson.put("name", exitname);
            searchperson.put("licenseno", exitlicenseno);
            searchperson.put("vehicleno", exitvehicleno);


            BasicDBObject updateperson = new BasicDBObject();
            updateperson.put("payment", 1);


            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", updateperson);

            collection.update(searchperson, updateObject);


            status = 1;
        }
        catch(Exception e){
            System.out.println(e);
        }

        return status;
    }

    public int finaldelete(String exitname, String exitvehicleno, String exitlicenseno){
        int status = 0;
        try {

            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("garage");
            DBCollection collection = database.getCollection("vehicledetails");
            BasicDBObject document = new BasicDBObject();


            BasicDBObject searchperson = new BasicDBObject();
            searchperson.put("name", exitname);
            searchperson.put("licenseno", exitlicenseno);
            searchperson.put("vehicleno", exitvehicleno);
            collection.remove(searchperson);
            status = 1;
        }
        catch(Exception e){
            System.out.println(e);
        }

        return status;
    }

    public boolean setcustomexittime(String timeinput){
        boolean status = false;
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
        try{
            Date dt = sdf.parse(timeinput);
            this.exittime = timeinput;
            status = true;
        }
        catch(Exception e){
            System.out.println(e);

        }
        return status;

    }


    public int finalexitcontrol(String exitname, String exitvehicleno, String exitlicenseno){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date timenow = new Date();
        this.exittime = formatter.format(timenow).toString();
        int returncode = -1;
        try{

            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("garage");
            DBCollection collection = database.getCollection("vehicledetails");
            BasicDBObject document = new BasicDBObject();


            BasicDBObject searchperson = new BasicDBObject();
            searchperson.put("name", exitname);
            searchperson.put("licenseno", exitlicenseno);
            searchperson.put("vehicleno", exitvehicleno);
            DBCursor cursor = collection.find(searchperson);

            returncode = 0;
            if(cursor.hasNext()) {
                returncode = 1;
                this.name = cursor.one().get("name").toString();
                this.vehicletype = cursor.one().get("vehicletype").toString();
                this.floorno = Integer.parseInt(cursor.one().get("floorno").toString());
                this.parkinglottype = cursor.one().get("parkinglottype").toString();
                this.licenseno = cursor.one().get("licenseno").toString();
                this.vehicleno = cursor.one().get("vehicleno").toString();
                this.entrytime = cursor.one().get("entrytime").toString();
                this.payment = Integer.parseInt(cursor.one().get("payment").toString());


            }


        }catch(Exception e){
            returncode = -1;
            System.out.println("cannot fill exit form");
            System.out.println(e);
        }

        return returncode;
    }
}
