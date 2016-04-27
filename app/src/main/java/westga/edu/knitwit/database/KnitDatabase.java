package westga.edu.knitwit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import westga.edu.knitwit.model.Gauge;
import westga.edu.knitwit.model.Pattern;
import westga.edu.knitwit.model.Progress;
import westga.edu.knitwit.model.Project;

/**
 * KnitDatabase Class
 * Created by Kaleigh on 4/26/2016.
 */
public class KnitDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KnitWitDB.db";
    public static final String TABLE_PROJECTS = "projects";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PROJECTNAME = "projectname";
    public static final String COLUMN_YARN = "yarn";
    public static final String COLUMN_NEEDLE = "needle";
    public static final String COLUMN_REPEATROWS = "repeatrows";
    public static final String COLUMN_PATTERNREPEATS = "patternrepeats";
    public static final String COLUMN_ROWSTITCHES = "rowstitches";
    public static final String COLUMN_UNIT = "unit";
    public static final String COLUMN_ROWSCOMPLETE = "rowscomplete";
    public static final String COLUMN_REPEATSCOMPLETE = "repeatscomplete";

    //TODO :: Add height and width.

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
        //TODO :: Add Gauge Values to DB Record

    }

    public void addPatternToDB(Pattern thePattern){
        //TODO :: Add Pattern Values to DB Record

    }

    public void addProgressToDB(Progress theProgress){
        //TODO :: Add Progress Values to DB Record

    }
    public void addProjectToDB(Project theProject){
        //TODO :: Add Project Values to DB Record

    }

    /**
     * Creates the database.
     * @param db the database object.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_PROJECTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_PROJECTNAME + " TEXT,"
                + COLUMN_YARN + " TEXT,"
                + COLUMN_NEEDLE + " DOUBLE, "
                + COLUMN_REPEATROWS + " INTEGER, "
                + COLUMN_PATTERNREPEATS + " INTEGER, "
                + COLUMN_ROWSTITCHES + " INTEGER, "
                + COLUMN_UNIT + " INTEGER, "
                + COLUMN_ROWSCOMPLETE + " INTEGER, "
                + COLUMN_REPEATSCOMPLETE + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        //TODO :: Add height and width.
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
        onCreate(db);
    }

}
