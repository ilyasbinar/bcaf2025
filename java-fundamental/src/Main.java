import models.Goods;
import models.GoodsAlt;

import java.util.ArrayList;
import java.util.List;

//https://github.com/ilyasbinar/bcaf2025
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Goods blueMarker = new Goods("Spidol Biru");
        blueMarker.setWeight(100.5);

        Goods redMarker = new Goods();
        redMarker.setName("Spidol Merah");
        redMarker.setWeight(100.5);

        Goods pointer = new Goods();
        pointer.setName("Pointer");
        pointer.setWeight(90);`

        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(redMarker);
        goodsList.add(pointer);

        for(Goods g:goodsList){
            g.print();
        }

        GoodsAlt redMarkerAlt = new GoodsAlt();
        redMarkerAlt.name = "Spidol Merah";
        redMarkerAlt.weight = 100.5;

        GoodsAlt pointerAlt = new GoodsAlt();
        pointerAlt.name ="Pointer";
        pointerAlt.weight = 90;
    }
}