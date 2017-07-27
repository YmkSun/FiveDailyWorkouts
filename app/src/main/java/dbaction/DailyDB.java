package dbaction;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Daily;

/**
 * Created by Ymk Sun on 3/12/2016.
 */
public class DailyDB {

    private SQLiteDatabase db;

    private Daily [] dailyList = {
            new Daily(1, "Sunday", "false", "false", "false", "false", "false"),
            new Daily(2, "Monday", "false", "false", "false", "false", "false"),
            new Daily(3, "Tuesday", "false", "false", "false", "false", "false"),
            new Daily(4, "Wednesday", "false", "false", "false", "false", "false"),
            new Daily(5, "Thursday", "false", "false", "false", "false", "false"),
            new Daily(6, "Friday", "false", "false", "false", "false", "false"),
            new Daily(7, "Saturday", "false", "false", "false", "false", "false")

    };

    public DailyDB(){
        openDB();
        //dropTable();
        createTable();
        int num = count();
        if(num <= 0){
            for(Daily daily: dailyList){
                insert(daily);
            }
        }
        Log.i("Count table", "Amount of count"+num);
    }

    private void openDB() {
        String path="data/data/com.ymksun.android.fivedailyworkouts/mydb";
        try{
            db=SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        }
        catch(SQLiteException sqle){
            Log.e("OpenDB Error", "Error Opening DB");
        }
    }

    public boolean createTable(){
        db.beginTransaction();

        try{
            //dailyId, day, workoutOne, workOutTwo, workOutThree, workOutFour, workOutFive...
            db.execSQL("create table Daily("+"dailyId integer PRIMARY KEY,"+"day text,"
                    +"workoutOne text,"+"workOutTwo text, workOutThree text, workOutFour text, workOutFive text);");
            db.setTransactionSuccessful();
            return true;
        }
        catch(SQLiteException e){
            Log.e("CreateTable Error","Error Creating Table");
            return false;
        }
        finally{
            db.endTransaction();
        }
    }

    public void dropTable() {
        db.beginTransaction();

        try{
            db.execSQL("drop table Daily;");
            db.setTransactionSuccessful();
        }
        catch(SQLiteException e){
            //Toast.makeText(getApplicationContext(), e.getMessage(), 0).show();
        }
        finally{
            db.endTransaction();
        }
    }


    public boolean insert(Daily d){

        Daily daily=d;

        db.beginTransaction();

        try{

            //dailyId, day, workoutOne, workOutTwo, workOutThree, workOutFour, workOutFive...
            db.execSQL("insert into Daily (dailyId, day, workoutOne, workOutTwo, workOutThree, workOutFour, workOutFive) "
                    + "values ("+daily.getDailyId()+", '"+daily.getDay()+"', '" + daily.getWorkoutOne() + "', '" + daily.getWorkOutTwo() + "', '"
                    + daily.getWorkOutThree() + "', '" + daily.getWorkOutFour()+ "', '" + daily.getWorkOutFive() + "')");
            db.setTransactionSuccessful();
            return true;
        }
        catch(SQLiteException sqle){
            Log.e("InsertDB Error",sqle.getMessage());
            return false;
        }
        finally{
            db.endTransaction();
        }
    }

    public Daily view(int id){

        db.beginTransaction();

        try{
            Cursor c=db.rawQuery("select * from Daily where dailyId = "+id+";", null);

            int num=c.getCount();
            Daily daily=new Daily();

            //dailyId, day, workoutOne, workOutTwo, workOutThree, workOutFour, workOutFive...
            int idCol=c.getColumnIndex("dailyId");
            int dayCol=c.getColumnIndex("day");
            int woOneCol=c.getColumnIndex("workoutOne");
            int woTwoCol=c.getColumnIndex("workOutTwo");
            int woThreeCol=c.getColumnIndex("workOutThree");
            int woFourCol=c.getColumnIndex("workOutFour");
            int woFiveCol=c.getColumnIndex("workOutFive");

            if(num>0){

                while(c.moveToNext()){


                    daily.setDailyId(c.getInt(idCol));
                    daily.setDay(c.getString(dayCol));
                    daily.setWorkoutOne(c.getString(woOneCol));
                    daily.setWorkOutTwo(c.getString(woTwoCol));
                    daily.setWorkOutThree(c.getString(woThreeCol));
                    daily.setWorkOutFour(c.getString(woFourCol));
                    daily.setWorkOutFive(c.getString(woFiveCol));

                }

                db.setTransactionSuccessful();

            }
            else{
                daily = null;
            }
            return daily;
        }
        catch(SQLiteException e){
            Log.e("Update Error","Error Viewing DB");
            return null;
        }
        finally{
            db.endTransaction();
        }

    }

    public int update(Daily oldinfo, Daily newinfo){

        String[] whereArgs=new String[1];
        whereArgs[0]=String.valueOf(oldinfo.getDailyId());

        String whereClause="dailyId";
        whereClause+=" = ? ";

        db.beginTransaction();

        //dailyId, day, workoutOne, workOutTwo, workOutThree, workOutFour, workOutFive...
        try{

            int affected=0;

            if(!(oldinfo.getWorkoutOne().equals(newinfo.getWorkoutOne()))){
                ContentValues updValues=new ContentValues();
                updValues.put("workoutOne", newinfo.getWorkoutOne());
                affected+=db.update("Daily", updValues, whereClause, whereArgs);
            }
            if(!(oldinfo.getWorkOutTwo().equals(newinfo.getWorkOutTwo()))){
                ContentValues updValues=new ContentValues();
                updValues.put("workOutTwo", newinfo.getWorkOutTwo());
                affected+=db.update("Daily", updValues, whereClause, whereArgs);
            }
            if(!(oldinfo.getWorkOutThree().equals(newinfo.getWorkOutThree()))){
                ContentValues updValues=new ContentValues();
                updValues.put("workOutThree", newinfo.getWorkOutThree());
                affected+=db.update("Daily", updValues, whereClause, whereArgs);
            }
            if(!(oldinfo.getWorkOutFour().equals(newinfo.getWorkOutFour()))){
                ContentValues updValues=new ContentValues();
                updValues.put("workOutFour", newinfo.getWorkOutFour());
                affected+=db.update("Daily", updValues, whereClause, whereArgs);
            }
            if(!(oldinfo.getWorkOutFive().equals(newinfo.getWorkOutFive()))){
                ContentValues updValues=new ContentValues();
                updValues.put("workOutFive", newinfo.getWorkOutFive());
                affected+=db.update("Daily", updValues, whereClause, whereArgs);
            }


            db.setTransactionSuccessful();
            Log.e("Update Msg", "Successful");
            return affected;

        }
        catch(SQLiteException e){
            Log.e("Update Err Msg",e.getMessage());
            return 0;
        }
        finally{
            db.endTransaction();
        }
    }

    public boolean delete(int id){

        String[] whereArgs=new String[1];
        whereArgs[0]=String.valueOf(id);

        String whereClause="dailyId";
        whereClause+=" = ? ";

        db.beginTransaction();

        try{
            boolean b=false;

            int affected=db.delete("Daily", whereClause, whereArgs);

            if(affected>0){
                b=true;
            }
            db.setTransactionSuccessful();
            return b;


        }
        catch(SQLiteException e){
            return false;
        }
        finally{
            db.endTransaction();
        }
    }

    public int count(){

        db.beginTransaction();

        try{
            Cursor c=db.rawQuery("select * from Daily", null);
            int n=c.getCount();
            return n;
        }
        catch(SQLiteException sqle){
            return 0;

        }
        finally{
            db.endTransaction();
        }


    }

}
