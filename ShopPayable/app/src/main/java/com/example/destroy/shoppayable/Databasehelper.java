package com.example.destroy.shoppayable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Databasehelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="shopledgerandjournal";
    private static final String TABLE_NAME="shopdue";
    private static final int DATABASE_VERSION=1;

    //properties of table
    public static final String id="id";
    public static final String name="name";
    public static final String email="email";
    public static final String phpne="phone";

    //
    private Context context;
  private static final String CREATIONTABLE="create table "+TABLE_NAME+"( "+id+" integer primary key,"+name+" text,"+email+" text,"+phpne+" text );";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context, "on create is called ", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATIONTABLE);

        }catch (Exception e){
            Toast.makeText(context, "error is "+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "on upgrade is called ", Toast.LENGTH_SHORT).show();
            db.execSQL("drop table if exists "+TABLE_NAME);
            onCreate(db);

        }catch (Exception e){

            Toast.makeText(context, "error is "+e, Toast.LENGTH_SHORT).show();

        }

    }

    public long insertdata(String gname, String gemail, String gphone) {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(name,gname);
        contentValues.put(email,gemail);
        contentValues.put(phpne,gphone);

        long rowid=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;
    }

    public Cursor displayalldata() {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public CustomerDetail getSingleDetails(int id) {
        CustomerDetail customerDetail=null;

        String selectQuery="select * from "+TABLE_NAME+" where id="+id;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            String names=cursor.getString(cursor.getColumnIndex(name));
            String phone=cursor.getString(cursor.getColumnIndex(phpne));
            String emaols=cursor.getString(cursor.getColumnIndex(email));
             customerDetail=new CustomerDetail(id,names,emaols,phone);
        }
        sqLiteDatabase.close();
        return customerDetail;
    }

    public long UpdatepersonInfformation(CustomerDetail cusupdt) {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(name,cusupdt.getCname());
        contentValues.put(phpne,cusupdt.getCphone());
        contentValues.put(email,cusupdt.getEmail());

        long update=sqLiteDatabase.update(TABLE_NAME,contentValues,id+" =?",new String[]{String.valueOf(cusupdt.getId())});
       sqLiteDatabase.close();
        return update;
    }


    public long Customerdelete(CustomerDetail cusudel) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long deletes=sqLiteDatabase.delete(TABLE_NAME,id+" =?",new String[]{String.valueOf(cusudel.getId())});
       sqLiteDatabase.close();
        return deletes;
    }
}
