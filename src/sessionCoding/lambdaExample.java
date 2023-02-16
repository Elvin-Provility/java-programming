package sessionCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class lambdaExample {
    static Map<String, List<Product>> groupByCategory(List<Product> products, Function<Product, String> classifier) {
        Map<String, List<Product>> groupedByObjects = new HashMap<>();

        for (Product product : products) {
            List groupedList = null;
            String classifierKey = classifier.apply(product);

            if (!groupedByObjects.containsKey(classifierKey)) {
                groupedByObjects.put(classifierKey, new ArrayList<>());
                groupedList = groupedByObjects.get(classifierKey);
            } else {
                groupedList = groupedByObjects.get(classifierKey);
            }
            groupedList.add(product);
        }

        return groupedByObjects;
    }


    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("11", "perfume", "fragrance", 13,true));
        products.add(new Product("12", "cereals muesli fruit nuts", "groceries", 50,true));
        products.add(new Product("13", "Hyaluronic Acid Serum", "skincare", 23,true));
        products.add(new Product("14", "Eau De Perfume Spray", "fragrance", 40,true));
        products.add(new Product("15", "Tree Oil 30ml", "skincare", 9,true));
        Map<String, List<Product>> groupedProducts = lambdaExample.groupByCategory(products, (product) -> product.category);
        System.out.println(groupedProducts);
    }
}
