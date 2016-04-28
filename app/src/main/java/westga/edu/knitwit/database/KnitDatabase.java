package westga.edu.knitwit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import westga.edu.knitwit.model.Gauge;
import westga.edu.knitwit.model.Pattern;
import westga.edu.knitwit.model.Progress;
import westga.edu.knitwit.model.Project;


/**
 * KnitDatabase Class
 * Created by Kaleigh on 4/26/2016.
 */
public class KnitDatabase extends SQLiteOpenHelper {

    private Gauge theGauge = new Gauge();
    private Pattern thePattern = new Pattern();
    private Project theProject = new Project();
    private Progress theProgress = new Progress();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KnitWitDB.db";

    public static final String TABLE_PROJECTS = "projects";
    public static final String COLUMN_PROJECTID = "pid";
    public static final String COLUMN_PROJECTNAME = "projectName";
    public static final String COLUMN_YARN = "yarn";
    public static final String COLUMN_NEEDLE = "needle";
    public static final String COLUMN_PROJECT_GAUGE = "gaugeID";
    public static final String COLUMN_PROJECT_PATTERN = "patternID";
    public static final String COLUMN_PROJECT_PROGRESS = "progressID";

    public static final String TABLE_PROGRESS = "progress";
    public static final String COLUMN_PROGRESSID = "pgid";
    public static final String COLUMN_ROWSCOMPLETE = "rowsComplete";
    public static final String COLUMN_PATTERNROWSCOMPLETE = "patternRowsCompleted";
    public static final String COLUMN_PATTERNREPEATSCOMPLETED = "patternRepeatsCompleted";

    public static final String TABLE_PATTERN = "pattern";
    public static final String COLUMN_PATTERNID = "ptid";
    public static final String COLUMN_REPEATROWS = "repeatRows";
    public static final String COLUMN_PATTERNREPEATS = "patternRepeats";

    public static final String TABLE_GAUGE = "gauge";
    public static final String COLUMN_GAUGEID = "gid";
    public static final String COLUMN_SWATCHWIDTH = "swatchWidth";
    public static final String COLUMN_SWATCHHEIGHT = "swatchHeight";
    public static final String COLUMN_STITCHESPERROW = "stitchesPerRow";
    public static final String COLUMN_ROWSPERUNIT = "rowsPerUnit";
    public static final String COLUMN_UNIT = "unit";


    /**
     * Constructor
     * @param context the  context.
     * @param name the name.
     * @param factory the factory.
     * @param version the version.
     */
    public KnitDatabase(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    public void addGaugeToDB(Gauge theGauge){
        Log.i("TAG:: gauge:", ""+theGauge.toString());
        ContentValues values = new ContentValues();
        values.put(COLUMN_SWATCHWIDTH, theGauge.getSwatchWidth());
        values.put(COLUMN_SWATCHHEIGHT, theGauge.getSwatchHeight());
        values.put(COLUMN_STITCHESPERROW, theGauge.getStitchesPerRow());
        values.put(COLUMN_ROWSPERUNIT, theGauge.getRowsPerUnit());
        values.put(COLUMN_UNIT, theGauge.getUnit());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_GAUGE, null, values);
        db.close();
    }

    public void addPatternToDB(Pattern thePattern){
        ContentValues values = new ContentValues();
        values.put(COLUMN_REPEATROWS, thePattern.getRepeatRows());
        values.put(COLUMN_PATTERNREPEATS, thePattern.getPatternRepeats());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PATTERN, null, values);
        db.close();
    }

    public void addProgressToDB(Progress theProgress){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROWSCOMPLETE, theProgress.getRowsCompleted());
        values.put(COLUMN_PATTERNROWSCOMPLETE, theProgress.getPatternRowsCompleted());
        values.put(COLUMN_PATTERNREPEATSCOMPLETED, theProgress.getPatternRepeatsCompleted());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PROGRESS, null, values);
        db.close();

    }
    public void addProjectToDB(Project theProject){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PROJECTNAME, theProject.getProjectName());
        values.put(COLUMN_YARN, theProject.getYarn());
        values.put(COLUMN_NEEDLE , theProject.getNeedleSize());
        values.put(COLUMN_PROJECT_GAUGE , theProject.getProjectName());
        values.put(COLUMN_PROJECT_PATTERN , theProject.getPatternID());
        values.put(COLUMN_PROJECT_PROGRESS , theProject.getProgressID());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PROJECTS, null, values);
        db.close();

    }

    public Gauge getGaugeFromDB(int recordID){
        String query="SELECT "+
                COLUMN_GAUGEID+", "+
                COLUMN_STITCHESPERROW+", " +
                COLUMN_ROWSPERUNIT+", " +
                COLUMN_SWATCHWIDTH+", " +
                COLUMN_SWATCHHEIGHT+", " +
                COLUMN_UNIT+" FROM "+TABLE_GAUGE+" WHERE "+COLUMN_GAUGEID+"= "+recordID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            this.theGauge.setGaugeID(cursor.getInt(0));
            this.theGauge.setStitchesPerRow(cursor.getInt(1));
            this.theGauge.setRowsPerUnit(cursor.getInt(2));
            this.theGauge.setSwatchWidth(cursor.getInt(3));
            this.theGauge.setSwatchHeight(cursor.getInt(4));
            this.theGauge.setUnit(cursor.getString(5));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        Log.i("TAG:: gauge:", "" + this.theGauge.toString());
        return this.theGauge;
    }

    public Pattern getPatternFromDB(int recordID){
        String query="SELECT "+
                COLUMN_PATTERNID+", "+
                COLUMN_REPEATROWS+","+
                COLUMN_PATTERNREPEATS+"FROM "+TABLE_PATTERN+" WHERE "+COLUMN_PATTERNID+"= "+recordID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            this.thePattern.setPatternID(cursor.getInt(0));
            this.thePattern.setRepeatRows(cursor.getInt(1));
            this.thePattern.setPatternRepeats(cursor.getInt(2));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return this.thePattern;
    }

    public Progress getProgressFromDB(int recordID) {
        String query="SELECT +" +
                COLUMN_PROGRESSID+", "+
                COLUMN_ROWSCOMPLETE+", " +
                COLUMN_PATTERNROWSCOMPLETE+", "+
                COLUMN_PATTERNREPEATSCOMPLETED+" FROM "+TABLE_PROGRESS+" WHERE "+COLUMN_PROGRESSID+"= "+recordID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            this.theProgress.setProgressID(cursor.getInt(0));
            this.theProgress.setRowsCompleted(cursor.getInt(1));
            this.theProgress.setPatternRowsCompleted(cursor.getInt(2));
            this.theProgress.setPatternRepeatsCompleted(cursor.getInt(3));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return this.theProgress;
    }

    public Project getProjectFromDB(int recordID) {
        String query="SELECT "+
                COLUMN_PROJECTID+", "+
                COLUMN_PROJECTNAME+", " +
                COLUMN_YARN+", "+
                COLUMN_NEEDLE+", "+
                COLUMN_PROJECT_GAUGE+", "+
                COLUMN_PROJECT_PATTERN+", "+
                COLUMN_PROJECT_PROGRESS+" FROM "+TABLE_PROJECTS+" WHERE "+COLUMN_PROJECTID+"= "+recordID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            this.theProject.setProjectID(cursor.getInt(0));
            this.theProject.setProjectName(cursor.getString(1));
            this.theProject.setYarn(cursor.getString(2));
            this.theProject.setNeedleSize(cursor.getInt(3));
            this.theProject.setGaugeID(cursor.getInt(4));
            this.theProject.setPatternID(cursor.getInt(5));
            this.theProject.setProgressID(cursor.getInt(6));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return this.theProject;
    }

    public int getRecordID(Gauge myGauge){
        int result=0;
        String query = "Select "+COLUMN_GAUGEID+
                " FROM " + TABLE_GAUGE +
                " WHERE "+COLUMN_STITCHESPERROW+"=  \"" +myGauge.getStitchesPerRow() + "\""+
                "AND "+COLUMN_ROWSPERUNIT+"=  \"" +myGauge.getRowsPerUnit() + "\""+
                "AND "+COLUMN_SWATCHWIDTH+"=  \"" +myGauge.getSwatchWidth() + "\""+
                "AND "+COLUMN_SWATCHHEIGHT+"=  \"" +myGauge.getSwatchHeight() + "\""+
                "AND "+COLUMN_UNIT+"=  \"" +myGauge.getUnit() + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            result = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return result;
    }

    public int getRecordID(Pattern myPattern){
        int result=0;
        String query = "Select "+COLUMN_PATTERNID+
                " FROM " + TABLE_PATTERN +
                " WHERE "+ COLUMN_REPEATROWS+"=  \"" +myPattern.getRepeatRows() + "\""+
                "AND "+COLUMN_PATTERNREPEATS+"=  \"" +myPattern.getPatternRepeats()+ "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            result = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return result;
    }

    public int getRecordID(Progress myProgress){
        int result=0;
        String query = "Select "+COLUMN_PROGRESSID+
                " FROM " + TABLE_PROGRESS +
                " WHERE "+COLUMN_ROWSCOMPLETE+"=  \"" +myProgress.getRowsCompleted() + "\""+
                "AND "+COLUMN_PATTERNROWSCOMPLETE+"=  \"" +myProgress.getPatternRowsCompleted() + "\""+
                "AND "+COLUMN_PATTERNREPEATSCOMPLETED+"=  \"" +myProgress.getPatternRepeatsCompleted() + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            result = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return result;
    }

    public int getRecordID(Project myProject){
        int result=0;
        String query = "Select "+COLUMN_PROJECTID+
                " FROM " + TABLE_PROJECTS +
                " WHERE "+COLUMN_PROJECTNAME+"=  \"" +myProject.getProjectName() + "\""+
                "AND "+COLUMN_YARN +"=  \"" +myProject.getYarn() + "\""+
                "AND "+COLUMN_NEEDLE+"=  \"" +myProject.getNeedleSize()+"\""+
                "AND "+COLUMN_PROJECT_GAUGE+"=  \"" +myProject.getGaugeID() + "\""+
                "AND "+COLUMN_PROJECT_PATTERN +"=  \"" +myProject.getPatternID() + "\""+
                "AND "+COLUMN_PROJECT_PROGRESS+"=  \"" +myProject.getProgressID() + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            result = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return result;
    }

    /**
     * Creates the database.
     * @param db the database object.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROJECT_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_PROJECTS + "("
                + COLUMN_PROJECTID + " INTEGER PRIMARY KEY,"
                + COLUMN_PROJECTNAME + " VARCHAR,"
                + COLUMN_YARN + " VARCHAR,"
                + COLUMN_NEEDLE + " INTEGER,"
                + COLUMN_PROJECT_GAUGE +" INTEGER,"
                + COLUMN_PROJECT_PATTERN +" INTEGER,"
                + COLUMN_PROJECT_PROGRESS+" INTEGER )";
        String CREATE_PROGRESS_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_PROGRESS + "("
                + COLUMN_PROGRESSID+ " INTEGER PRIMARY KEY,"
                + COLUMN_ROWSCOMPLETE + " INTEGER,"
                + COLUMN_PATTERNROWSCOMPLETE + " INTEGER,"
                + COLUMN_PATTERNREPEATSCOMPLETED + " INTEGER )";
        String CREATE_PATTERN_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_PATTERN + "("
                + COLUMN_PATTERNID + " INTEGER PRIMARY KEY,"
                + COLUMN_REPEATROWS + " INTEGER,"
                + COLUMN_PATTERNREPEATS + " INTEGER )";
        String CREATE_GAUGE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_GAUGE + "("
                + COLUMN_GAUGEID + " INTEGER PRIMARY KEY,"
                + COLUMN_SWATCHWIDTH + " INTEGER,"
                + COLUMN_SWATCHHEIGHT + " INTEGER,"
                + COLUMN_STITCHESPERROW + " INTEGER,"
                + COLUMN_ROWSPERUNIT + " INTEGER,"
                + COLUMN_UNIT + " VARCHAR )";

        db.execSQL(CREATE_PROJECT_TABLE);
        db.execSQL(CREATE_PROGRESS_TABLE);
        db.execSQL(CREATE_PATTERN_TABLE);
        db.execSQL(CREATE_GAUGE_TABLE);
    }

    /**
     * Drops the table if it exists in the database.
     * @param db the database.
     * @param oldVersion the old version of the database.
     * @param newVersion the new version of the database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROGRESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATTERN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAUGE);
        onCreate(db);
    }

}
