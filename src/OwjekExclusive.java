/**
 * Created by Izzan Fakhril Islam (1606875806)
 * Kelas    : DDP 2 - A
 * Project  : TugasPemrograman3
 * Date     : 21/05/2017
 * Time     : 16:28 PM
 *
 * Class yang digunakan untuk membentuk Layanan Owjek Exclusive (diturunkan dari class OwjekService)
 */

public class OwjekExclusive extends OwjekService {
    private static final String SERVICE_TYPE = "Exclusive";
    private static final double COST_PER_KM = 5000;
    private static final double FIXED_COST = 10000;
    private static final double PROMO_RATE = 0.5;
    private static final double PROTECTION_RATE = 0.05;
    private String startCoordinate, finishCoordinate;
    private Map peta;
    private double promoCost, protectionCost;
    private int distance;

    /**
     * Main Constructor dari kelas OwjekExclusive
     * Fungsi: Untuk membentuk sebuah layanan Owjek Exclusive dengan Koordinat perjalanan dan Peta yang sudah ditentukan
     * @param startCoordinate Koordinat awal perjalanan
     * @param finishCoordinate Koordinat akhir perjalanan
     * @param peta objek Peta yang akan dihitung
     */

    public OwjekExclusive(String startCoordinate, String finishCoordinate, Map peta){
        super();
        super.setServiceType(SERVICE_TYPE);
        super.setCostPerKm(COST_PER_KM);
        super.setFixedCost(FIXED_COST);
        super.setPromoRate(PROMO_RATE);
        super.setMinYearAllowed(2016);
        super.setMinCc(500);
        this.startCoordinate = startCoordinate;
        this.finishCoordinate = finishCoordinate;
        this.peta = peta;
    }

    /**
     * Menghitung total biaya perjalanan per KM dengan biaya Rp5.000 per KM
     * @param from Titik awal keberangkatan
     * @param to Titik akhir keberangkatan
     * @return Harga perjalanan
     */

    @Override
    public double calculateTotalCostPerKm(int from, int to){
        return COST_PER_KM*(to-from);
    }

    /**
     * Menghitung total Promo yang diberikan dalam sebuah perjalanan
     * @return Harga Promo dari perjalanan
     */

    @Override
    public double calculatePromoCost(){
        distance = OwjekService.shortestPath(this.startCoordinate, this.finishCoordinate, this.peta);
        promoCost = (1-PROMO_RATE)*(FIXED_COST+calculateTotalCostPerKm(0, distance));
        return promoCost;
    }

    /**
     * Menghitung total biaya Proteksi yang diberikan dalam sebuah perjalanan
     * @return biaya Proteksi dari perjalanan
     */

    @Override
    public double calculateProtectionCost(){
        protectionCost = PROTECTION_RATE*(FIXED_COST+calculateTotalCostPerKm(0, distance));
        return protectionCost;
    }

    /**
     * Menghitung Total Biaya Perjalanan (setelah dipotong Promo dan ditambah Protection Cost)
     * @return Total ongkos perjalanan
     */

    @Override
    public double calculateTotalCost(){
        return FIXED_COST + (calculateTotalCostPerKm(0,distance)*0.1) + calculateProtectionCost() - (calculatePromoCost()*0.1);
    }

    /**
     * Mencetak Ringkasan (Summary) dari perjalanan yang telah dilakukan
     */

    @Override
    public String printTripText(){
        String summary = "";
        summary += "Terimakasih telah melakukan perjalanan dengan OW-JEK.\n";
        summary += "[Jarak] "+String.format("%.2f", distance*0.1)+" KM\n";
        summary += "[TipeO] "+SERVICE_TYPE+"\n";
        summary += "[Fixed] Rp "+FIXED_COST+" (+)\n";
        summary += "[KMSel] Rp "+(calculateTotalCostPerKm(50,distance)*0.1)+" (+)\n";
        summary += "[Promo] Rp "+(calculatePromoCost()*0.1)+" (-)\n";
        summary += "[Prtks] Rp "+calculateProtectionCost()+" (+)\n";
        summary += "[TOTAL] Rp "+calculateTotalCost()+"\n";
        return summary;
    }
}