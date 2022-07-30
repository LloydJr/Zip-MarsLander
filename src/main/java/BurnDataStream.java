public class BurnDataStream implements BurnStream {
    // these are the series of burns made each 10 secs by the lander.
    // change them to see if you can get the lander to make a soft landing.
    // burns are between 0 and 200. This burn array usually crashes.

    int burnArray[] = {200, 200, 200, 200, 200, 200, 200, 2000, 200, 200, 200, 200, 200, 200, 200};
    int burnIdx = -1;

    public BurnDataStream() { }
    public BurnDataStream(int[] burns) {
        this.burnArray = burns;
    }
    @Override
    public int getNextBurn(DescentEvent status) {
        if (burnIdx < burnArray.length) {
            burnIdx++;
            System.out.println(burnArray[burnIdx]); /*hack!*/
            return burnArray[burnIdx];
        }
        return 0;
    }
}


/**
 * Landing the ship tactic:
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 0		1000 		12000 		8000		200
 * 10		900 		11800 		7100		200
 * 20		800 		11600 		6300		200
 * 30		700 		11400 		5600		0
 * 40		800 		11400 		4800		200
 * 50		700 		11200 		4100		200
 * 60		600 		11000 		3500		200
 * 70		500 		10800 		3000		200
 * 80		400 		10600 		2600		200
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 90		300 		10400 		2300		200
 * 100		200 		10200 		2100		200
 * 110		100 		10000 		2000		0
 * 120		200 		10000 		1800		0
 * 130		300 		10000 		1500		200
 * 140		200 		9800 		1300		200
 * 150		100 		9600 		1200		0
 * 160		200 		9600 		1000		200
 * 170		100 		9400 		900		0
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 180		200 		9400 		700		200
 * 190		100 		9200 		600		200
 * 200		0 		9000 		600		0
 * 210		100 		9000 		500		200
 * 220		0 		8800 		500		0
 * 230		100 		8800 		400		200
 * 240		0 		8600 		400		0
 * 250		100 		8600 		300		200
 * 260		0 		8400 		300		0
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 270		100 		8400 		200		200
 * 280		0 		8200 		200		0
 * 290		100 		8200 		100		199
 * 300		1 		8001 		99		101
 * 310		0 		7900 		99		99
 * 320		1 		7801 		98		99
 * 330		2 		7702 		96		101
 * 340		1 		7601 		95		99
 * 350		2 		7502 		93		101
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 360		1 		7401 		92		99
 * 370		2 		7302 		90		99
 * 380		3 		7203 		87		99
 * 390		4 		7104 		83		99
 * 400		5 		7005 		78		99
 * 410		6 		6906 		72		101
 * 420		5 		6805 		67		101
 * 430		4 		6704 		63		101
 * 440		3 		6603 		60		101
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 450		2 		6502 		58		99
 * 460		3 		6403 		55		99
 * 470		4 		6304 		51		101
 * 480		3 		6203 		48		99
 * 490		4 		6104 		44		99
 * 500		5 		6005 		39		101
 * 510		4 		5904 		35		101
 * 520		3 		5803 		32		101
 * 530		2 		5702 		30		101
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 540		1 		5601 		29		101
 * 550		0 		5500 		29		99
 * 560		1 		5401 		28		101
 * 570		0 		5300 		28		99
 * 580		1 		5201 		27		101
 * 590		0 		5100 		27		101
 * 600		-1 		4999 		28		99
 * 610		0 		4900 		28		99
 * 620		1 		4801 		27		99
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 630		2 		4702 		25		99
 * 640		3 		4603 		22		101
 * 650		2 		4502 		20		101
 * 660		1 		4401 		19		99
 * 670		2 		4302 		17		99
 * 680		3 		4203 		14		99
 * 690		4 		4104 		10		101
 * 700		3 		4003 		7		101
 * 710		2 		3902 		5		101
 *
 * Time	Velocity		Fuel		Altitude		Burn
 * ----	-----		----		------		----
 * 720		1 		3801 		4		99
 * 730		2 		3702 		2		101
 * 740		1 		3601 		1		99
 *
 * You made it! Good job!
 * */
