package is.apisavia.isavia.myapplication;

public class Bless {
    public Bless()
    {
        // Tomur klasasmidur.
    }
    //
    public static void killApp(boolean killSafely)
    {
        if (killSafely)
        {
            /*
             * Eftirfarandi stef er fengid af netinu, samkvaemt
             * eftirfarandi vefsidu (birt i tveimum linum):
             * http://stackoverflow.com/questions/2092951/
             * how-to-close-android-application
             *
             * -    -    -    -    -    -    -    -    -    -    -    -
             *
             * Gefa merki til styrikerfisins um ad enda og safna oell atridi af
             * keyrzluforritinu og lata forritid haetta keyrzlu (thydd lauslega
             * ur heimasidunni, thadan sem thetta stef var fengid)
             */
            // Urelt 2015 Mars 02: System.runFinalizersOnExit(true);
            // System.runFinalizersOnExit(true);
            System.runFinalization();  // Reyna thetta svona.
            //
            // Nytt: THETTA NYJA KRASSAR FORRITID ALVEG.
    		/*
    		Runtime.getRuntime().addShutdownHook(new Thread()
    		{
    		    public void run()
    		    {
    		        // shutdown logic
    		    	// ??? System.exit(0);  // ???
    		    }
    		});
    		*/
            /*
             * Force the system to close the app down completely instead of
             * retaining it in the background. The virtual machine that runs the
             * app will be killed. The app will be completely created as a new
             * app in a new virtual machine running in a new process if the user
             * starts the app again.
             *
             *
             * Fa kerfid til thess ad sloekkva a keyrzlunni i stad thess ad forritid
             * sje ad afram i keyrzlu i bakgrunninum (thydd lauslega
             * ur heimasidunni, sem fyrr segir)
             */
            System.exit(0); // Hafa lika til oryggis.
        }
        else
        {
            /*
             *  Til vara er forritid latid haetta an thess ad vista oell
             *  naudsynleg atridi eda lata enda hugsanlegum adgerdum
             *  (thydd lauslega ur heimasidunni, sem fyrr segir)
             */
            android.os.Process.killProcess(android.os.Process.myPid());
        } // if (killSafely) else . . .
        //
    } // public static void killApp( . . . ).
    //
} // public class Bless
//.
