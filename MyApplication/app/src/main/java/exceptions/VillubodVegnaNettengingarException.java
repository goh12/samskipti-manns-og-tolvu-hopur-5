package exceptions;
//
/**
 * @kennari  Ebba Thora Hvannberg
 * @nemendur Hopurinn Hazir
 * @namskeid Hugbunadarverkefni II
 *
 * @dagsetning 2012/Feb/26.
 * 
 * Snidid ad thorfum Isavia
 * @dagsetning 2012/Jun/15.
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
//
@SuppressWarnings("serial")
public class VillubodVegnaNettengingarException extends Throwable
{
        /**
         * Klasasmidurinn, sem gefur tenging og samband
         * vid skilaboda-thjonustuna, sem hlyzt af upp-a-komu
         * ut fra adgerdunum: try og catch i adalklasanum, sem
         * er "Driver" hluturinn af gangverkinu,
         * (i Android er Activity = Driver).
         *
         * Notkun ur timaskeid.d. "Model" hluta gangverksins svo sem
         * "RegisterActivity.java":
         * catch (EkkertSkjalException se) {return false};
         */
        public VillubodVegnaNettengingarException()
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
         *    tilvisun.finnaAkvedidSkjal(vidfangsbreyta1, vidfangsbreyta2, . . . );
         * } // try
         * //
         * catch (VillubodVegnaNettengingarException se)
         * {
         *      Toast.makeText(this, ge.toString(), Toast.LENGTH_LONG).show();
         * } // catch
         */
        public String toString()
        {
        	return "PLEASE CONNECT TO THE INTERNET!";
        } // toString()
    //
} // public class EkkertStakFinnstException extends Throwable
// Klasinn endar.


