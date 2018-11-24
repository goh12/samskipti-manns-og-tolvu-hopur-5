package exceptions;
//
/**
 * @kennari  Ebba Thora Hvannberg
 * @nemendur Hopurinn Hazir
 * @namskeid Hugbunadarverkefni II
 *
 * @dagsetning 2012/Feb/26.
 *
 * Heimild:
 *
 * Moppurnar i OlsenOlsen fra
 * Snjolaugu, Hlinar, Bjarka og Nafna, sem
 * heitir is.OlsenOlsen.Exceptions
 *
 * OG
 *
 * Moppur fra Snjolaugu og Hlinar, sem
 * heitir is.OlsenOlsen.LangavitleysaKapall
 *
 */
@SuppressWarnings("serial")
public class EkkertStakFinnstException extends Throwable
{
        /**
         * Klasasmidurinn, sem gefur tenging og samband
         * vid skilaboda-thjonustuna, sem hlyzt af upp-a-komu
         * ut fra adgerdunum: try og catch i adalklasanum, sem
         * er "Driver" hluturinn af gangverkinu,
         * (i Android er Activity = Driver).
         *
         * Notkun ur timaskeid.d. "Model" hluta gangverksins svo sem
         * "GagnaVinnsla.java":
         * catch (EkkertStakException se) {return false};
         */
        public EkkertStakFinnstException()
        {
          // Tomur kassi her.
        } // Klasa-smidurinn endir her.
        //
        /**
         * Notkun ur timaskeid.d. "Driver" hluta gangverksins svo sem
         * "EitthvadActivity.java"
         *
         * Eitt daemi um notkun:
         *
         * try
         * {
         *    tilvisun.finnaAkvedidStak(vidfangsbreyta1, vidfangsbreyta2, . . . );
         * } // try
         * //
         * catch (EkkertStakFinnstException se)
         * {
         *      Toast.makeText(this, ge.toString(), Toast.LENGTH_LONG).show();
         * } // catch
         */
        public String toString()
        {
        	return "THE END POINT HERE!";
        } // toString()
    //
} // public class EkkertStakFinnstException extends Throwable
// Klasinn endar.

